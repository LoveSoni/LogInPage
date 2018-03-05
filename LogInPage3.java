import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
class LogInPage3 extends JFrame implements ActionListener
{
	ImageIcon img,img1;
	JLabel pic,pic1;
	private JLabel lb1,lb2,lb3;
    private JTextField tft,tft1;
	private JPasswordField jp;
	private JButton btn;
	LogInPage3()
	{
		img=new ImageIcon("1.jpg");
		img1=new ImageIcon("name.jpeg");
		pic1=new JLabel(img1);
		pic=new JLabel(img);
		lb1=new JLabel("Enter FullName  ");
		lb1.setForeground(new Color(204,0,102));
		tft=new JTextField();

		lb2=new JLabel("Enter New UserName  ");
		tft1=new JTextField();
		lb2.setForeground(new Color(204,0,102));
		
		lb3=new JLabel("Enter a Strong Password :");
		jp=new JPasswordField();
		lb3.setForeground(new Color(204,0,102));

		btn=new JButton("SignUp");
		pic1.setBounds(50,5,224,85);add(pic1);
		pic.setBounds(0,0,400,400);
		lb1.setBounds(20,80,140,50);add(lb1);
		tft.setBounds(180,94,130,30);add(tft);
		lb2.setBounds(20,140,140,55);add(lb2);
		tft1.setBounds(180,154,130,30);add(tft1);
		lb3.setBounds(20,200,140,55);add(lb3);
		jp.setBounds(180,210,130,30);add(jp);
        btn.setBounds(110,260,80,40);add(btn);
		btn.addActionListener(this);add(pic);
		setLayout(null);
		setVisible(true);
		setSize(340,350);
		setLocation(300,100);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		JButton temp=(JButton)e.getSource();
		if(temp==btn)
		{try{
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver load");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			System.out.println("Connection established");	
			Statement st=con.createStatement();	
			//st.executeUpdate("create table Login(name char(10),username char(20),password char(8))");
			ResultSet res=st.executeQuery("select * from login");
			while(res.next())
			{
					String username=res.getString("username");
					if(username.trim().equals(tft1.getText()) )
					{
						JOptionPane.showMessageDialog(this,"Accound Already Exist ");
					break;
					}
					else
					{
						if(tft.getText().equals("")){JOptionPane.showMessageDialog(this,"Enter Your Full Name");break;}
						if(tft1.getText().equals("")){JOptionPane.showMessageDialog(this,"Enter UseName");break;}
						if(jp.getText().equals("")){JOptionPane.showMessageDialog(this,"You need to Enter Password for Safety");break;}
						else{
						st.executeUpdate("insert into login values('"+tft.getText()+"','"+tft1.getText()+"','"+jp.getText()+"')");
						JOptionPane.showMessageDialog(this,"Your Account Successfully Created");
						//try{Thread.sleep(1000);}catch(InterruptedException eb){}
						new LogInPage2();
						}
					}
			}
				
		
		}catch(ClassNotFoundException ee)
		{
			System.out.println("Driver not load");
		}
		catch(SQLException eee)
		{
			eee.printStackTrace();
		}
		}
	}

}