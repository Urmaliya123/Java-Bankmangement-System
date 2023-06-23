import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String pinnumber;

    JButton deposit,back;
    JTextField amount;
    Deposit(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon a1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image a2=a1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon a3=new ImageIcon(a2);
        JLabel image=new JLabel(a3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("Enter the amount you want to deposit");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);

        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);

        deposit=new JButton("Deposit");
        deposit.setBounds(355,485,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);






        image.setBounds(0,0,900,900);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposit){
           String number=amount.getText();
            Date date= new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount to deposit");
            }
            else {

            try

            {
                Conn conn =new Conn();
                String query1 ="insert into banks values('"+pinnumber+"','"+date+"','Deposit','"+number +"')";
                conn.s.executeUpdate(query1);
                JOptionPane.showMessageDialog(null,"RS" +number+"Deposit Amount Successfully");
                 setVisible(false);
                 new Transection(pinnumber).setVisible(true);
            }catch (Exception e) {
                System.out.println(e);
            }   }
        } else if (ae.getSource() == back) {
           setVisible(false);
          new Transection(pinnumber).setVisible(true);
        }
    }

    public static void main (String[]args){
        new Deposit("");
    }
}
