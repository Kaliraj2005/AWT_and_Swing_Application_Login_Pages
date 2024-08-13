import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class User_Payment_Page extends JFrame implements WindowListener
{
    public User_Payment_Page()
    {
        setTitle("Payment Billing System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        addLabel("Customer Name : ", 0, 0, gbc);
        JTextField nameField = addTextField(1, 0, gbc);

        addLabel("Email : ", 0, 1, gbc);
        JTextField emailField = addTextField(1, 1, gbc);

        addLabel("Amount :", 0, 2, gbc);
        JTextField amountField = addTextField(1, 2, gbc);

        addLabel("Payment Method :", 0, 3, gbc);
        String[] paymentMethods = {"Credit Card", "Debit Card", "PayPal"};
        JComboBox<String> paymentMethodComboBox = new JComboBox<>(paymentMethods);
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(paymentMethodComboBox, gbc);

        JButton processButton = new JButton("Process Payment");
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        add(processButton, gbc);

        processButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String name = nameField.getText();
                String email = emailField.getText();
                String amount = amountField.getText();
                String paymentMethod = (String) paymentMethodComboBox.getSelectedItem();

                JOptionPane.showMessageDialog(null, "Processing payment for:\n" +
                        "Name: " + name + "\n" +
                        "Email: " + email + "\n" +
                        "Amount: " + amount + "\n" +
                        "Payment Method: " + paymentMethod);
            }
        });
    }
    private void addLabel(String text, int x, int y, GridBagConstraints gbc)
    {
        gbc.gridx = x;
        gbc.gridy = y;
        JLabel label = new JLabel(text);
        add(label, gbc);
    }
    private JTextField addTextField(int x, int y, GridBagConstraints gbc)
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
            new User_Payment_Page().setVisible(true);
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

