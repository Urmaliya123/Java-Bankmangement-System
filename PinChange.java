import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PinChange  extends JFrame implements ActionListener {
    JButton change, back;
    JPasswordField pin, repin;
    String pinnumber;


    PinChange(String pinnumber) {
this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon a1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image a2 = a1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon a3 = new ImageIcon(a2);
        JLabel image = new JLabel(a3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(260, 290, 400, 20);
        image.add(text);

        JLabel pintext = new JLabel("NEW PIN :");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(165, 320, 180, 25);
        image.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(330, 320, 180, 25);
        image.add(pin);

        JLabel repintext = new JLabel("Re-Enter New PIN :");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setBounds(165, 360, 180, 25);
        image.add(repintext);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(330, 360, 180, 25);
        image.add(repin);

        change = new JButton("CHANGE");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);


        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {

        try {
            String npin = pin.getText();
            String rpin = repin.getText();

            if (!npin.equals(rpin)) {
                JOptionPane.showMessageDialog(null, "Enter pin does not match");
                return;

            }
            if (npin.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter New PIN");
                 return;
            }
            if (rpin.equals("")){
                JOptionPane.showMessageDialog(null,"Please Renter PIN");
                return;
            }
            Conn conn=new Conn();
            String query1="update banks set pin ='"+rpin+"' where pin='"+pinnumber+"'";
            String query2="update Loginup set pin ='"+rpin+"' where pin='"+pinnumber+"'";
            String query3="update login set pin ='"+rpin+"' where pin='"+pinnumber+"'";






            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
            conn.s.executeUpdate(query3);





            JOptionPane.showMessageDialog(null," PIN Changed Successfully");

            setVisible(false);
            new Transection(rpin).setVisible(true);


        } catch (Exception e) {
            System.out.println(e);
        }
    }
        else {
            setVisible(false);
            new Transection(pinnumber).setVisible(true);
        }

}


    public static void main(String[]args){
        new PinChange("");
    }
}


