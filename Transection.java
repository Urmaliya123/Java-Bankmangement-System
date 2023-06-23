import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transection extends JFrame implements ActionListener {
    String pinnumber;

    JButton deposit, withdrawl,pinchange,fastcash,balanceenquire,exit,ministatement;
    Transection(String pinnumber){
        this.pinnumber=pinnumber;
       setLayout(null);

        ImageIcon a1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image a2=a1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon a3=new ImageIcon(a2);
        JLabel image=new JLabel(a3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("Please Select Your Transaction");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

         deposit=new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl=new JButton("Cash Withdrawal");
        withdrawl.setBounds(355,415,150,30);
     withdrawl.addActionListener(this);
        image.add(withdrawl);

         fastcash=new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
     fastcash.addActionListener(this);
        image.add(fastcash);

         ministatement=new JButton("Mini Statement");
        ministatement.setBounds(355,450,150,30);
     ministatement.addActionListener(this);
        image.add(ministatement);

         pinchange=new JButton("Pin Change");
        pinchange.setBounds(170,485,150,30);
     ministatement.addActionListener(this);
        image.add(pinchange);

      balanceenquire=new JButton("Balance Enquire");
     balanceenquire.setBounds(355,485,150,30);
     balanceenquire.addActionListener(this);
     image.add(balanceenquire);

      exit=new JButton("Exit");
     exit.setBounds(355,520,150,30);
     exit.addActionListener(this);
     image.add(exit);






     setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
     if(ae.getSource() == exit){
      System.exit(0);
     } else if (ae.getSource()==deposit) {
         setVisible(false);
         new Deposit(pinnumber).setVisible(true);
     } else if (ae.getSource()==withdrawl) {
         setVisible(false);
         new Withdrawal(pinnumber).setVisible(true);
     } else if (ae.getSource()== fastcash) {
         setVisible(false);
         new FastCash(pinnumber).setVisible(true);
     }  else if (ae.getSource()==balanceenquire) {
         setVisible(false);
         new BalanceEnquiry(pinnumber).setVisible(true);
     }
     else if (ae.getSource()==ministatement) {
         setVisible(false);
         new BalanceEnquiry(pinnumber).setVisible(true);
     }
     else if (ae.getSource() == pinchange) {
         setVisible(false);
         new PinChange(pinnumber).setVisible(true);
     }
    }

    public static void main(String[]args){
        new Transection("");
    }
}
