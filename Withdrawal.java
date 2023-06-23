import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {

    String pinnumber;

    JButton withdrawal,back;
    JTextField amount;
    Withdrawal(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon a1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image a2=a1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon a3=new ImageIcon(a2);
        JLabel image=new JLabel(a3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("Enter the amount you want to withdrawal");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);

        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);

        withdrawal=new JButton("Withdrawal");
        withdrawal.setBounds(355,485,150,30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

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
        if(ae.getSource()==withdrawal){
            String number=amount.getText();
            Date date= new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount to withdrawal");
            }
            else {

                try

                {
                    Conn conn =new Conn();
                    String query1 ="insert into banks values('"+pinnumber+"','"+date+"','Withdrawal','"+number +"')";
                    conn.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null,"RS" +number+"Withdrawal Amount Successfully");
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
        new Withdrawal("");
    }
}


