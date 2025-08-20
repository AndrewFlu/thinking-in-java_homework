//package chapters.gui.jnlp;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.ByteArrayInputStream;
//import javax.jnlp.*;
//
//public class JNLPFileChooser extends JFrame {
//
//    private JTextField textField = new JTextField();
//    private JButton
//            open = new JButton("Open"),
//            save = new JButton("Save");
//    private JEditorPane editorPane = new JEditorPane();
//    private JScrollPane scrollPane = new JScrollPane();
//    private FileContents fileContents;
//
//    public JNLPFileChooser() throws HeadlessException {
//        JPanel panel = new JPanel();
//        open.addActionListener(new OpneL());
//        panel.add(open);
//        save.addActionListener(new SaveL());
//        panel.add(save);
//        scrollPane.getViewport().add(editorPane);
//
//        add(scrollPane, BorderLayout.CENTER);
//        add(panel, BorderLayout.SOUTH);
//
//        textField.setEditable(false);
//
//        panel = new JPanel();
//        panel.setLayout(new GridLayout(2, 1));
//        panel.add(textField);
//        add(panel, BorderLayout.NORTH);
//
//        editorPane.setContentType("text");
//        save.setEnabled(false);
//    }
//
//    class OpenL implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            FileOpenService fs = null;
//            try {
//                fs = (FileOpenService) ServiceManager.lookup("javax.jnlp.FileOpenService");
//            } catch (UnavailableServiceException use) {
//                throw new RuntimeException(use);
//            }
//            if (fs != null) {
//                try {
//                    fileContents = fs.openFileDialog(".", new String[]{"txt", "*"});
//                    if (fileContents == null)
//                        return;
//                    textField.setText(fileContents.getName());
//                    editorPane.read(fileContents.getInputStream(), null);
//                } catch (Exception ex) {
//                    throw new RuntimeException(ex);
//                }
//                save.setEnabled(true);
//            }
//        }
//    }
//
//    class SaveL implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            FileSaveService fs = null;
//            try {
//                fs = (FileSaveService) ServiceManager.lookup("javax.jnlp.FileSaveService");
//            } catch (UnavailableServiceException use) {
//                throw new RuntimeException(use);
//            }
//            if (fs != null) {
//                try {
//                    fileContents = fs.saveFileDialog(
//                            ".",
//                            new String[]{"txt"},
//                            new ByteArrayInputStream(editorPane.getText().getBytes()),
//                            fileContents.getName()
//                    );
//                    if (fileContents == null)
//                        return;
//                    textField.setText(fileContents.getName());
//                } catch (Exception exc) {
//                    throw new RuntimeException(exc);
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        JNLPFileChooser fileChooser = new JNLPFileChooser();
//        fileChooser.setSize(400, 300);
//        fileChooser.setVisible(true);
//    }
//}
