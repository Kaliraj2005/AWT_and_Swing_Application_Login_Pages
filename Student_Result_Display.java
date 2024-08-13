import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Student_Result_Display extends JFrame
{
    public JTextField nameField;
    public JTextField rollNumberField;
    public JTextField subjectField;
    public JTextField marksField;
    public JTextArea resultArea;

    public Student_Result_Display()
    {
        setTitle("Student Result Display");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        addLabel("Student Name : ", 0, 0, gbc);
        nameField = addTextField(1, 0, gbc);

        addLabel("Roll Number : ", 0, 1, gbc);
        rollNumberField = addTextField(1, 1, gbc);

        addLabel("Subject : ", 0, 2, gbc);
        subjectField = addTextField(1, 2, gbc);

        addLabel("Marks : ", 0, 3, gbc);
        marksField = addTextField(1, 3, gbc);

        JButton showResultButton = new JButton("Show Result");
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        add(showResultButton, gbc);

        resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        add(scrollPane, gbc);

        showResultButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String name = nameField.getText();
                String rollNumber = rollNumberField.getText();
                String subject = subjectField.getText();
                String marks = marksField.getText();

                if (name.isEmpty() || rollNumber.isEmpty() || subject.isEmpty() || marks.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please fill all fields");
                    return;
                }
                resultArea.setText("Student Result\n" +
                        "Name: " + name + "\n" +
                        "Roll Number: " + rollNumber + "\n" +
                        "Subject: " + subject + "\n" +
                        "Marks: " + marks + "\n");
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
            new Student_Result_Display().setVisible(true);
        });
    }
}

