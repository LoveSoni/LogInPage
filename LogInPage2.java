import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class LogInPage2  extends JFrame implements ActionListener
{

	ImageIcon img,img1;
	JLabel pic,pic1;
	JLabel lb1,lb2;
    JTextField tft;
	JPasswordField jp;
	JButton btn;
	LogInPage2()
	{
		img=new ImageIcon("2.jpg");
		img1=new ImageIcon("name.jpeg");
		pic1=new JLabel(img1);
		pic=new JLabel(img);
		//
		lb1=new JLabel("Enter UserName : ");lb1.setForeground(Color.BLUE);lb1.setBackground(new Color(250,100,0));
		tft=new JTextField();
		lb2=new JLabel("Enter Password : ");lb2.setForeground(Color.BLUE);
		jp=new JPasswordField();
		btn=new JButton("Login");
		lb1.setBounds(20,90,140,50);add(lb1);
		tft.setBounds(180,104,130,30);add(tft);
		lb2.setBounds(20,150,140,50);add(lb2);
		jp.setBounds(180,160,130,30);add(jp);
		btn.setBounds(110,230,80,40);add(btn);
		pic1.setBounds(60,5,224,85);add(pic1);
		btn.addActionListener(this);add(pic);
		setLayout(null);
		setVisible(true);
		setSize(340,350);
		setLocation(300,100);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		try{boolean count=false;
       Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver load");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			System.out.println("Connection established");
			Statement st=con.createStatement();	
    		ResultSet res=st.executeQuery("select * from login");
    		while(res.next())
    		{
    			
    			if((tft.getText().equalsIgnoreCase(res.getString("username").trim())) && (jp.getText().equals(res.getString("password").trim())))
    			{
    				JOptionPane.showMessageDialog(this,"welcome you are good to go");
    				count=false;break;   
    			}
    			else
    			{
    				count=true;
    			}
    			
    		}
    		if(count)
    		{
    			JOptionPane.showMessageDialog(this,"UserName or Password is Incorrect");
    		}
    		
    }catch(ClassNotFoundException ee)
    {
    	ee.printStackTrace();
    }
	catch(SQLException eee)
	{
		eee.printStackTrace();
	}
	}

}