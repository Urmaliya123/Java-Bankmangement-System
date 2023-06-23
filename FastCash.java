import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;


public class FastCash  extends JFrame implements ActionListener {


    String pinnumber;

    JButton deposit, withdrawl,pinchange,fastcash,balanceenquire,exit,ministatement;
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon a1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image a2=a1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon a3=new ImageIcon(a2);
        JLabel image=new JLabel(a3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposit=new JButton("Rs 100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl=new JButton("Rs 500");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash=new JButton("Rs 1000");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement=new JButton("Rs 2000");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange=new JButton("Rs 5000");
        pinchange.setBounds(170,485,150,30);
        ministatement.addActionListener(this);
        image.add(pinchange);

        balanceenquire=new JButton("Rs 10000");
        balanceenquire.setBounds(355,485,150,30);
        balanceenquire.addActionListener(this);
        image.add(balanceenquire);

        exit=new JButton("BACK");
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
            setVisible(false);
            new Transection(pinnumber).setVisible(true);
        } else {
            String amount =((JButton)ae.getSource()).getText().substring(3);
            Conn c=new Conn();
            try {
                ResultSet rs=c.s.executeQuery("select * from banks where pin ='"+pinnumber+"'");
                int balance=0;
                while(rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else {
                        balance -=Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource()!= exit && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }

                Date date=new Date();
                String query="insert into banks values('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs"+ amount +"Debited  Successfully");
                setVisible(false);
                new Transection(pinnumber).setVisible(true);

            }catch (Exception e){
                System.out.println(e);
            }
        }
        }


    public static void main(String[]args){
        new FastCash("");
    }
}


