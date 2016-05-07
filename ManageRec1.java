import java.awt.*; 
import java.awt.event.*;
import java.io.*;

import javax.swing.*;


public class ManageRec1 extends JFrame implements ActionListener
{

	JFrame frame1;
	JPanel panel1;
	JButton genOps,explorer,back;
	
	public ManageRec1(String title)
	{
		super(title);
		
		frame1 = new JFrame();
		panel1 = new JPanel();
		genOps = new JButton("GENERAL");
		explorer = new JButton("CHOOSE FILE");
		back = new JButton("BACK");
		
		genOps.addActionListener(this);
		explorer.addActionListener(this);
		back.addActionListener(this);
		
		setLayout(new FlowLayout());
		add(genOps);
		add(explorer);
		add(back);
		frame1.add(panel1);
		this.setBackground(Color.blue);
		this.setVisible(true);
		setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	private File getFile()
	{
		JFileChooser fc = new JFileChooser();
		int result = fc.showOpenDialog(frame1);
		File file = null;
		if(result == JFileChooser.APPROVE_OPTION)
			file = fc.getSelectedFile();
			
		return file;
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getActionCommand().equals("GENERAL"))
		{
			addRecFrames newRec = new addRecFrames("GENERAL");
		}
		
		if(evt.getActionCommand().equals("CHOOSE FILE"))
		{
			getFile();		
		}
		
		
		if(evt.getActionCommand().equals("BACK"))
		{
			dispose();
		}
	}

}

