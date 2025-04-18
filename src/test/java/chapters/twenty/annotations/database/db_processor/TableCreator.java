package chapters.twenty.annotations.database.db_processor;

import chapters.twenty.annotations.database.Constraints;
import chapters.twenty.annotations.database.DBTable;
import chapters.twenty.annotations.database.SQLInteger;
import chapters.twenty.annotations.database.SQLString;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// {Args: chapters.twenty.annotations.database.Member}
public class TableCreator {
    public static void main(String[] args) throws ClassNotFoundException {
        if (args.length < 1) {
            System.out.println("Arguments: annotated classes");
            System.exit(0);
        }
        for (String className : args) {
            Class<?> aClass = Class.forName(className);
            DBTable dbTable = aClass.getAnnotation(DBTable.class);
            if (dbTable == null) {
                System.out.println("No DBTable annotation in class " + className);
            }
            String tableName = dbTable.name();
            // Если имя не задано — использовать имя Class
            if (tableName.length() < 1)
                tableName = aClass.getName().toUpperCase();
            List<String> columnDefs = new ArrayList<>();
            for (Field field : aClass.getDeclaredFields()) {
                String columnName = null;
                Annotation[] anns = field.getDeclaredAnnotations();

                if (anns.length < 1)
                    continue; // Не является столбцом таблицы базы данных
                if (anns[0] instanceof SQLInteger) {
                    SQLInteger sInt = (SQLInteger) anns[0];
                    // Использовать имя поля, если имя не указано
                    if (sInt.name().length() < 1)
                        columnName = field.getName().toUpperCase();
                    else
                        columnName = sInt.name();
                    columnDefs.add(columnName + " INT" + getConstraints(sInt.constraints()));
                }

                if (anns[0] instanceof SQLString) {
                    SQLString sString = (SQLString) anns[0];
                    // Использовать имя поля, если имя не указано
                    if (sString.name().length() < 1)
                        columnName = field.getName().toUpperCase();
                    else
                        columnName = sString.name();
                    columnDefs.add(columnName + " VARCHAR(" + sString.value() + ")" + getConstraints(sString.constraints()));
                }

                StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tableName + "(");
                for (String columnDef : columnDefs)
                    createCommand.append("\n " + columnDef + ",");
                // Удалить завершающую запятую
                String tableCreate = createCommand.substring(
                        0, createCommand.length() - 1) + ");";
                System.out.println("Table creation SQL for " +
                        className + " is :\n" + tableCreate);
            }
        }
    }

    private static String getConstraints(Constraints cons) {
        String constraints = "";
        if (!cons.allowNull())
            constraints += " NOT NULL";
        if (cons.primaryKey())
            constraints += " PRIMARY KEY";
        if (cons.unique())
            constraints += "UNIQUE";

        return constraints;
    }
}
