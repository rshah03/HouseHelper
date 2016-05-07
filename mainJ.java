import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;

public class mainJ extends JFrame implements ActionListener
{
	JFrame frame1;
	JButton manageButton;
	JButton exitButton;
	public int xBound = 200;
	public int yBound = 200;
	
	public mainJ(String title)
	{
		
		super(title);
		
		manageButton = new JButton("START MANAGING");
		exitButton = new JButton("EXIT");
		
		manageButton.addActionListener(this);
		exitButton.addActionListener(this);
		
		GridLayout grd1 = new GridLayout(2,2,10,40);
		setLayout(grd1); 
		add(manageButton);
		add(exitButton);
		this.setBackground(Color.cyan);
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getActionCommand().equals("START MANAGING"))
		{
			//place manage method/class here
			//create a manage object here
			ManageRec1 rec = new ManageRec1("Manage Records");
			rec.setBounds(xBound+50,yBound+50,400,75);
			setResizable(false);
			rec.setVisible(true);
			
			/*frame1 = new JFrame();
			JPanel panel1 = new JPanel();
			frame1.add(panel1);
			frame1.setSize(300,200);
			frame1.setVisible(true);
			repaint();*/
		}

		if(evt.getActionCommand().equals("EXIT"))
		{
			System.exit(0);
		}
		
			
		repaint();
			
	}
}



