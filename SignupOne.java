

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SignupOne extends JFrame implements ActionListener {

    long random;


    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes,eyes,sno,eno;


    JComboBox religion,category,occupation,education,income;

    String formno;



    SignupOne(String formno)

    {
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM");




        JLabel additionalDetail=new JLabel("Page 2: Additional Details " );
        additionalDetail.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetail.setBounds(290,70,400,30);
        add(additionalDetail);

        String valcategory[]={"Genral","SC","ST","OBC","OTHER"};
         category=new JComboBox(valcategory);
        category.setBounds(300,180,400,30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel categorys=new JLabel("Category: " );
        categorys.setFont(new Font("Raleway",Font.BOLD,22));
        categorys.setBounds(100,178,220,30);
        add(categorys);

        JLabel incomes=new JLabel("Income: " );
        incomes.setFont(new Font("Raleway",Font.BOLD,22));
        incomes.setBounds(100,220,190,30);
        add(incomes);

        String incomecategory[]={"Null","< 1,50,000","< 2,50,000","< 5,00,0000","Upto 10,00,000"};
         income =new JComboBox(incomecategory);
        income.setBounds(300,220,400,30);
        income.setBackground(Color.WHITE);
        add(income);







        JLabel occupations=new JLabel("Occupation : " );
        occupations.setFont(new Font("Raleway",Font.BOLD,22));
        occupations.setBounds(100,340,190,30);
        add(occupations);

        String occupationValues[]={"Salaried","Self Employ","Business","Student","Retaired","OTHER"};
        occupation=new JComboBox(occupationValues);
        occupation.setBounds(300,330,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);


        JLabel pannumber=new JLabel("PAN Number: " );
        pannumber.setFont(new Font("Raleway",Font.BOLD,22));
        pannumber.setBounds(100,390,190,30);
        add(pannumber);

        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,390,400,30);
        add(pan);




        JLabel seniorcitizen=new JLabel("Senior Citizen: " );
        seniorcitizen.setFont(new Font("Raleway",Font.BOLD,22));
        seniorcitizen.setBounds(100,470,190,30);
        add(seniorcitizen);

        syes =new JRadioButton("Yes");
        syes.setBounds(300,470,90,30);
        syes.setBackground(Color.white);
        add(syes);

        sno =new JRadioButton("No");
        sno.setBounds(450,470,90,30);
        sno.setBackground(Color.white);
        add(sno);

        ButtonGroup seniorcitizengroup=new ButtonGroup();
        seniorcitizengroup.add(syes);
        seniorcitizengroup.add(sno);





        JLabel aadharno=new JLabel("Aadhar Number: " );
        aadharno.setFont(new Font("Raleway",Font.BOLD,22));
        aadharno.setBounds(100,430,190,30);
        add(aadharno);

        aadhar =new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(300,430,400,30);
        add(aadhar);



        JLabel existingaccount=new JLabel("Existing Account: " );
        existingaccount.setFont(new Font("Raleway",Font.BOLD,22));
        existingaccount.setBounds(100,510,200,30);
        add(existingaccount);

        eyes =new JRadioButton("Yes");
        eyes.setBounds(300,510,90,30);
        eyes.setBackground(Color.white);
        add(eyes);

        eno =new JRadioButton("No");
        eno.setBounds(450,510,90,30);
        eno.setBackground(Color.white);
        add(eno);

        ButtonGroup existingaccountGroup =new ButtonGroup();
        existingaccountGroup.add(eyes);
        existingaccountGroup.add(eno);


        JLabel qualification=new JLabel("Qualification: " );
        qualification.setFont(new Font("Raleway",Font.BOLD,22));
        qualification.setBounds(100,260,190,30);
        add(qualification);

        String educationValues[]={" Non Graduation","Graduation","Post Graduation","Doctrate","OTHER"};
         education=new JComboBox(educationValues);
        education.setBounds(300,260,400,30);
        education.setBackground(Color.WHITE);
        add(education);






        JLabel educational=new JLabel("Educational" );
        educational.setFont(new Font("Raleway",Font.BOLD,22));
        educational.setBounds(100,320,190,30);
        add(educational);



        JLabel religinality=new JLabel("Religion: " );
        religinality.setFont(new Font("Raleway",Font.BOLD,22));
        religinality.setBounds(100,140,120,30);
        add(religinality);

        String valReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
         religion=new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);

        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.cyan);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String formno = "",random;
        String sreligion = (String) religion.getSelectedItem();
        String scategory= (String) category.getSelectedItem();
        String sincome=(String) income.getSelectedItem();
        String seducation=(String)  education.getSelectedItem();
        String soccupation=(String) occupation.getSelectedItem();
        String seneiorcitizen=null;
        if (syes.isSelected()){
            seneiorcitizen="Yes";
        } else if (sno.isSelected()) {
            seneiorcitizen="No";

        }

        String  existingaccount=null;
        if (eyes.isSelected()){
            existingaccount="Yes";
        } else if (eno.isSelected()) {
            existingaccount="No";

        }

        String span=pan.getText();
        String saadhar=aadhar.getText();

        try {

                Conn c = new Conn();
                String query = "insert into single values('" + formno + "','" + sreligion+ "','" + scategory + "','" + sincome + "','" + seducation + "','" + soccupation + "','" + span + "','" + saadhar+ "','" +seneiorcitizen  + "','" + existingaccount + "')";
                c.s.executeUpdate(query);

                setVisible(false);
                new Login(formno).setVisible(true);


        } catch (Exception e) {
            System.out.println(e);
        }

    }






    public static void main(String[]args)
    {
        new SignupOne("");
    }

}



