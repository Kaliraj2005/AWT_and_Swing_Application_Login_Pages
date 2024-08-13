import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Attendance_Management_System extends JFrame implements WindowListener
{
    public JTextField ID_Field;
    public JTextField Name_Field;
    public JTextField Date_Field;
    public JTextArea Attendance_Login;

    public Attendance_Management_System()
    {
        setTitle("Attendance Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        addLabel("Employee ID:", 0, 0, gbc);
        ID_Field = addTextField(1, 0, gbc);

        addLabel("Employee Name:", 0, 1, gbc);
        Name_Field = addTextField(1, 1, gbc);

        addLabel("Date (YYYY-MM-DD):", 0, 2, gbc);
        Date_Field = addTextField(1, 2, gbc);

        JButton recordButton = new JButton("Record Attendance");
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        add(recordButton, gbc);

        JButton viewButton = new JButton("View Attendance");
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(viewButton, gbc);

        Attendance_Login = new JTextArea(5, 30);
        Attendance_Login.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(Attendance_Login);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        add(scrollPane, gbc);

        recordButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String id = ID_Field.getText();
                String name = Name_Field.getText();
                String date = Date_Field.getText();
                if (id.isEmpty() || name.isEmpty() || date.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please fill all fields");
                    return;
                }
                Attendance_Login.append("Recorded: ID: " + id + ", Name: " + name + ", Date: " + date + "\n");
                ID_Field.setText("");
                Name_Field.setText("");
                Date_Field.setText("");

//                viewButton.addActionListener(new ActionListener()
//                {
//                    @Override
//                    public void actionPerformed(ActionEvent e)
//                    {
//                        System.out.println("Clicked -> View Button !!!");
//                        System.out.println("Employee ID  :  "+ID_Field);
//                        System.out.println("Name ID      :  "+Name_Field);
//                        System.out.println("Date ID      :  "+ Date_Field);
//                    }
//                });
//                recordButton.addActionListener(new ActionListener()
//                {
//                    @Override
//                    public void actionPerformed(ActionEvent e)
//                    {
//                        System.out.println("Clicked -> Record Button !!!");
//                        System.out.println("Employee ID  :  "+ID_Field);
//                        System.out.println("Name ID      :  "+Name_Field);
//                        System.out.println("Date ID      :  "+ Date_Field);
//                    }
//                });

            }
        });
        viewButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(null, new JScrollPane(Attendance_Login),
                        "Attendance Log", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
    public void addLabel(String text, int x, int y, GridBagConstraints gbc)
    {
        gbc.gridx = x;
        gbc.gridy = y;
        JLabel label = new JLabel(text);
        add(label, gbc);
    }
    public JTextField addTextField(int x, int y, GridBagConstraints gbc)
    {
        gbc.gridx = x;
        gbc.gridy = y;
        JTextField textField = new JTextField(15);
        add(textField, gbc);
        return textField;
    }
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() ->
        {
            new Attendance_Management_System().setVisible(true);
        });
    }
    @Override
    public void windowOpened(WindowEvent e)
    {
        System.out.println("Window is Opened Now !!!");
    }
    @Override
    public void windowClosing(WindowEvent e)
    {
        System.out.println("Window is Closed Now !!!");
    }
    @Override
    public void windowClosed(WindowEvent e)
    {
        System.out.println("You are Exited Now !!!");
    }
    @Override
    public void windowIconified(WindowEvent e) {}
    @Override
    public void windowDeiconified(WindowEvent e) {}
    @Override
    public void windowActivated(WindowEvent e)
    {
        System.out.println("Window is Actively Now !!!");
    }
    @Override
    public void windowDeactivated(WindowEvent e) {}
}

