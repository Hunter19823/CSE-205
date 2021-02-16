package projects.week7;


import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankPanel extends JPanel {
    private JLabel name, number, balance, status, amount;
    private JTextField aname, anumber, abalance, astatus, aamount;
    private JButton deposit, create, withdraw;
    private BankAccount newAccount;

    public BankPanel()
    {
        // Setup Components
        name  = new JLabel("Account name: ");
        number  = new JLabel("Account number: ");
        status  = new JLabel("Account status: ");
        amount  = new JLabel("Account amount: ");
        balance  = new JLabel("Account balance: ");

        aname = new JTextField(10);
        anumber = new JTextField(10);
        astatus = new JTextField(10);
        aamount = new JTextField(10);
        abalance = new JTextField(10);

        deposit = new JButton("Deposit");
        withdraw = new JButton("Withdraw");
        create = new JButton("Create New Account");

        // Create listeners.
        deposit.addActionListener(new ButtonListener());
        withdraw.addActionListener(new ButtonListener());
        create.addActionListener(new ButtonListener());

        add(name);
        add(aname);
        add(number);
        add(anumber);
        add(balance);
        add(abalance);
        add(status);
        add(astatus);
        add(create);
        add(deposit);
        add(withdraw);
        add(amount);
        add(aamount);

        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(225,300));
    }

    private class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            Object source = event.getSource();
            if (create == (source)) {
                newAccount = new BankAccount(
                        Integer.parseInt(anumber.getText()),
                        Double.parseDouble(abalance.getText()),
                        aname.getText()
                        );
            } else if (deposit == (source)) {
                newAccount.deposit(Double.parseDouble(aamount.getText()));
            } else if (withdraw == (source)) {
                newAccount.withdraw(Double.parseDouble(aamount.getText()));
            }
            abalance.setText(Double.toString(newAccount.getBalance()));
        }
    }




}
