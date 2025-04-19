package chapters.twenty.annotations.apt.visitor;

import chapters.twenty.annotations.database.Constraints;
import chapters.twenty.annotations.database.DBTable;
import chapters.twenty.annotations.database.SQLInteger;
import chapters.twenty.annotations.database.SQLString;
import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.apt.AnnotationProcessorFactory;
import com.sun.mirror.declaration.AnnotationTypeDeclaration;
import com.sun.mirror.declaration.ClassDeclaration;
import com.sun.mirror.declaration.FieldDeclaration;
import com.sun.mirror.declaration.TypeDeclaration;
import com.sun.mirror.util.SimpleDeclarationVisitor;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static com.sun.mirror.util.DeclarationVisitors.NO_OP;
import static com.sun.mirror.util.DeclarationVisitors.getDeclarationScanner;

public class TableCreationProcessorFactory implements AnnotationProcessorFactory {

    @Override
    public Collection<String> supportedOptions() {
        return Collections.emptySet();
    }

    @Override
    public Collection<String> supportedAnnotationTypes() {
        return List.of(
                "annotations.database.DBTable",
                "annotations.database.Constraints",
                "annotations.database.SQLString",
                "annotations.database.SQLInteger"
        );
    }

    @Override
    public AnnotationProcessor getProcessorFor(Set<AnnotationTypeDeclaration> set, AnnotationProcessorEnvironment annotationProcessorEnvironment) {
        return new TableCreationProcessor(annotationProcessorEnvironment);
    }

    private static class TableCreationProcessor implements AnnotationProcessor {
        private final AnnotationProcessorEnvironment env;
        private String sql = "";

        public TableCreationProcessor(AnnotationProcessorEnvironment env) {
            this.env = env;
        }

        @Override
        public void process() {
            for (TypeDeclaration typeDecl : env.getSpecifiedTypeDeclarations()) {
                typeDecl.accept(getDeclarationScanner(new TableCreationVisitor(), NO_OP));
                sql = sql.substring(0, sql.length() - 1) + ");";
                System.out.println("Creation SQL is: \n" + sql);
            }
        }

        private class TableCreationVisitor extends SimpleDeclarationVisitor {
            public void visitClassDeclaration(ClassDeclaration d) {
                DBTable dbTable = d.getAnnotation(DBTable.class);
                if (dbTable != null) {
                    sql += "CREATE TABLE ";
                    sql += (dbTable.name().length() < 1)
                            ? d.getSimpleName().toUpperCase()
                            : dbTable.name();
                    sql += " (";
                }
            }

            public void visitFieldDeclaration(FieldDeclaration d) {
                String columnName = "";
                if (d.getAnnotation(SQLInteger.class) != null) {
                    SQLInteger sIng = d.getAnnotation(SQLInteger.class);
                    // Использовать имя поля, если имя не задано
                    if (sIng.name().length() < 1)
                        columnName = d.getSimpleName().toUpperCase();
                    else
                        columnName = sIng.name();
                    sql += "\n    " + columnName + " INT" + getConstraints(sIng.constraints()) + ",";
                    if (d.getAnnotation(SQLString.class) != null) {
                        SQLString sString = d.getAnnotation(SQLString.class);
                        // Использовать имя поля, если имя не задано
                        if (sIng.name().length() < 1)
                            columnName = d.getSimpleName().toUpperCase();
                        else
                            columnName = sString.name();
                        sql += "\n    " + columnName + " VARCHAR(" + sString.value() + ")" + getConstraints(sString.constraints()) + ",";
                    }
                }
            }

            private String getConstraints(Constraints con) {
                String constraints = "";
                if (!con.allowNull())
                    constraints += " NOT NULL";
                if (con.primaryKey())
                    constraints += " PRIMARy KEY";
                if (con.unique())
                    constraints += " UNIQUE";

                return constraints;
            }
        }
    }
}
