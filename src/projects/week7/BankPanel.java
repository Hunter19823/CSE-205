package projects.week7;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankPanel extends JPanel {
    private JLabel name, number, balance, status, amount;
    private JTextField aname, anumber, abalance, astatus, aamount;
    private JButton deposit, create, withdraw;
    private BankAccount newAccount;
    //private int counter = 0;
    private JTextArea textArea;
    private Bank bofj; // Bank of Java. Snare Snare Symbol

    public BankPanel()
    {
        // Setup Components

        // JLabels
        name  = new JLabel("Account name: ");
        number  = new JLabel("Account number: ");
        status  = new JLabel("Account status: ");
        amount  = new JLabel("Account amount: ");
        balance  = new JLabel("Account balance: ");

        // JTextFields
        aname = new JTextField(20);
        anumber = new JTextField(20);
        astatus = new JTextField(20);
        aamount = new JTextField(20);
        abalance = new JTextField(20);

        // JButtons
        deposit = new JButton("Deposit");
        withdraw = new JButton("Withdraw");
        create = new JButton("Create New Account");
        // JTextAreas
        textArea = new JTextArea(15,20);
        // JScrollPanes
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Create listeners.
        deposit.addActionListener(new ButtonListener());
        withdraw.addActionListener(new ButtonListener());
        create.addActionListener(new ButtonListener());

        // Change Editable Status
        astatus.setEditable(false);
        textArea.setEditable(false);



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
        add(textArea);
        add(scrollPane);

        bofj = new Bank();
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(225,700));
    }

    private class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            Object source = event.getSource();
            newAccount = new BankAccount(
                    Integer.parseInt(anumber.getText()),
                    Double.parseDouble(abalance.getText()),
                    aname.getText()
            );
            setBackground(Color.CYAN);
            int existingBankLocation = bofj.find(Integer.parseInt(anumber.getText()));

            if (create == (source)) {
                if(existingBankLocation == -1)
                {
                    bofj.addAccount(newAccount);
                    if(Double.parseDouble(abalance.getText()) >= 0)
                    {
                        astatus.setText("Good");
                    }else{
                        astatus.setText("No Good");
                        setBackground(Color.RED);
                    }
                }
            } else if (deposit == (source)) {
                bofj.depositToBank(Double.parseDouble(aamount.getText()),existingBankLocation);
                if(bofj.checkBalance(existingBankLocation))
                {
                    astatus.setText("Good");
                }else{
                    astatus.setText("No Good");
                    setBackground(Color.RED);
                }
            } else if (withdraw == (source)) {
                newAccount.withdraw(Double.parseDouble(aamount.getText()));
                if(bofj.checkBalance(existingBankLocation))
                {
                    astatus.setText("Good");
                }else{
                    astatus.setText("No Good");
                    setBackground(Color.RED);
                }
            }
            printAccounts();
        }

        public void printAccounts()
        {
            textArea.setText("");
            textArea.append("Name\tNum\tBal\n");
            textArea.append("-".repeat(15)+"\n");
            textArea.append(bofj.toString());
        }
    }




}
