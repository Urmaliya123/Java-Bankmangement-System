import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import static java.awt.Font.BOLD;

public class Bank extends JFrame implements ActionListener {
    String pinnumber;
    JButton New,signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Bank(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setTitle("AUTOMATIC TELLER MACHINE");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/a.jpg"));
        Image i2= i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel lable =new JLabel(i3);
        lable.setBounds(70,10,100,100);
        add(lable);

        JLabel text =new JLabel("Welcome to ATM");
        text.setFont(new Font("onward", BOLD,30));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel cardno =new JLabel("Card No:");
        cardno.setFont(new Font("Railway", BOLD,20));
        cardno.setBounds(120,150,250,40);
        add(cardno);

        cardTextField=new JFormattedTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial", BOLD,14));

        add(cardTextField);

        New=new JButton("SIGN IN");
        New.setBounds(300,270,100,30);
        New.setBackground(Color.BLACK);
        New.setForeground(Color.white);
        New.addActionListener(this);
        add(New);

        clear=new JButton("CLEAR");
        clear.setBounds(430,270,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signup=new JButton("SIGN UP");
        signup.setBounds(300,320,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);


        JLabel pin =new JLabel("PIN:");
        pin.setFont(new Font("Railway", BOLD,20));
        pin.setBounds(120,220,230,40);
        add(pin);

         pinTextField =new JPasswordField ();
        pinTextField.setBounds(300,220,230,30);
        add(pinTextField);

        getContentPane().setBackground(Color.white);
        setSize(800,400);
        setVisible(true);
        setLocation(350,200);

    }

    public void actionPerformed (ActionEvent ae){

      if (ae.getSource() == clear)
        {
            cardTextField.setText("");
            pinTextField.setText("");
        }
      else if(ae.getSource() ==New){
           Conn conn=new Conn();
           String cardnumber=cardTextField.getText();
           String pinnumber=pinTextField.getText();
           String query="select * from login where cardnumber ='"+cardnumber+"'and pin = '"+pinnumber+"'";
           try{
              ResultSet rs= conn.s.executeQuery(query);
              if (rs.next()){
                  setVisible(false);
                  new Transection(pinnumber).setVisible(true);
              }
              else {
                  JOptionPane.showMessageDialog(null,"Incorrect Card Number or pin");
              }
           }catch (Exception e){
               System.out.println(e);
          }

        } else if (ae.getSource()  == signup)
        {
           setVisible(false);
           new SignUp().setVisible(true);
        }
    }

    public static void main(String[]args)
    {
        new Bank("");
    }


}
