import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
class LogInPage extends JFrame implements ActionListener
{
	ImageIcon img;
	JLabel pic;
	JButton btn1,btn2;
	LogInPage()
	{
		img=new ImageIcon("11.gif");
		pic=new JLabel(img);
		btn1=new JButton("Login");
		btn2=new JButton("Signup");
		pic.setBounds(0,0,500,400);
		btn1.setBounds(80,100,150,80);
		btn2.setBounds(80,200,150,80);
		add(btn2);btn1.addActionListener(this);
		add(btn1);btn2.addActionListener(this);
		add(pic);
		setBackground(new Color(121,121,0));

		setLayout(null);
		setVisible(true);setSize(340,350);
		setLocation(300,100);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		JButton temp=(JButton)e.getSource();
		if(temp==btn1)
		{System.out.println("click");
			new LogInPage2();
			dispose();
		}
		else if(temp==btn2)
		{
			System.out.println("click1");
			new LogInPage3();
			dispose();
		}
	}
	public static void main(String args[])
	{
		new LogInPage();
	}
}