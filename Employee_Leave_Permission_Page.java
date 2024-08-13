import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Employee_Leave_Permission_Page implements WindowListener
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Leave Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        frame.setLayout(new BorderLayout());

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel nameLabel = new JLabel("Employee Name :");
        JTextField nameField = new JTextField();

        JLabel leaveTypeLabel = new JLabel("Leave Classifications :");
        String[] leaveTypes = {"1.Day-by-Day Leave","2.Weekly Leave","3.Vacation Leave","4.Exam Leave","5.Festival Leave"};

        JComboBox<String> leaveTypeCombo = new JComboBox<>(leaveTypes);

        JLabel startDateLabel = new JLabel("Start Date :");
        JTextField startDateField = new JTextField("Year-Month-Date");

        JLabel endDateLabel = new JLabel("End-Date :");
        JTextField endDateField = new JTextField("Year-Month-Day");

        JLabel reasonLabel = new JLabel("Reasons :");
        JTextArea reasonArea = new JTextArea(3, 20);

        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(leaveTypeLabel);
        formPanel.add(leaveTypeCombo);
        formPanel.add(startDateLabel);
        formPanel.add(startDateField);
        formPanel.add(endDateLabel);
        formPanel.add(endDateField);
        formPanel.add(reasonLabel);
        formPanel.add(new JScrollPane(reasonArea));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton submitButton = new JButton("Submit Leave Request");
        JButton resetButton = new JButton("Reset");

        buttonPanel.add(submitButton);
        buttonPanel.add(resetButton);

        frame.add(formPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);

        submitButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String name = nameField.getText();
                String leaveType = (String) leaveTypeCombo.getSelectedItem();
                String startDate = startDateField.getText();
                String endDate = endDateField.getText();
                String reason = reasonArea.getText();

                System.out.println("Leave Request Submitted : ");
                System.out.println("Name : " + name);
                System.out.println("Leave Type : " + leaveType);
                System.out.println("Start Date : " + startDate);
                System.out.println("End Date : " + endDate);
                System.out.println("Reason : " + reason);
                System.out.println();
            }
        });
        resetButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                nameField.setText("");
                leaveTypeCombo.setSelectedIndex(0);
                startDateField.setText("Year-Month-Date");
                endDateField.setText("Year-Month-Day");
                reasonArea.setText("");
            }
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
    public void windowActivated(WindowEvent e) {}
    @Override
    public void windowDeactivated(WindowEvent e) {}
}

