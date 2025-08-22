package chapters.gui.swing.java_bean;

import chapters.gui.swing.utils.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.*;
import java.lang.reflect.Method;

public class BeanDumper extends JFrame {

    private JTextField query = new JTextField(20);
    private JTextArea results = new JTextArea();

    public BeanDumper() throws HeadlessException {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Qualified bean name:"));
        panel.add(query);
        add(BorderLayout.NORTH, panel);
        add(new JScrollPane(results));
        Dumper dumper = new Dumper();
        query.addActionListener(dumper);
//        query.setText("src.test.java.chapters.gui.swing.java_bean.Frog");
        query.setText("chapters.gui.swing.java_bean.Frog");
        // Программный запуск события
        dumper.actionPerformed(new ActionEvent(dumper, 0, ""));
    }

    public void print(String s) {
        results.append(s + "\n");
    }

    public void dump(Class<?> bean) {
        results.setText("");
        BeanInfo beanInfo = null;
        try {
            beanInfo = Introspector.getBeanInfo(bean, Object.class);
        } catch (IntrospectionException e) {
            print("Couldn't introspect " + bean.getName());
            return;
        }
        for (PropertyDescriptor d : beanInfo.getPropertyDescriptors()) {
            Class<?> p = d.getPropertyType();
            if (p == null) continue;
            print("Property type: \n" + d.getName());
            Method readMethod = d.getReadMethod();
            if (readMethod != null)
                print("Read method: \n" + readMethod);
            Method writeMethod = d.getWriteMethod();
            if (writeMethod != null)
                print("Write method: \n" + readMethod);
            print("============================");
        }
        print("Public methods:");
        for (MethodDescriptor m : beanInfo.getMethodDescriptors())
            print(m.getMethod().toString());
        print("============================");
        print("Event support:");
        for (EventSetDescriptor e : beanInfo.getEventSetDescriptors()) {
            print("Listener type:\n" + e.getListenerType().getName());
            for (Method lm : e.getListenerMethods())
                print("Listener method: " + lm.getName());
            for (MethodDescriptor lmd : e.getListenerMethodDescriptors())
                print("Method descriptor:\n" + lmd.getMethod());

            Method addListener = e.getAddListenerMethod();
            print("Add Listener Method:\n" + addListener);

            Method removeListener = e.getRemoveListenerMethod();
            print("Remove Listener Method:\n" + removeListener);
            print("============================");
        }
    }

    // inner classes
    class Dumper implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = query.getText();
            Class<?> c = null;
            try {
                c = Class.forName(name);
            } catch (ClassNotFoundException ex) {
                results.setText("Couldn't find " + name);
                return;
            }
            dump(c);
        }
    }


    public static void main(String[] args) {
        SwingConsole.run(new BeanDumper(), 650, 600);
    }
}
