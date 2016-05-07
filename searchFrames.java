import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class searchFrames extends JFrame implements ActionListener
{
	JFrame searchFrame;
	JPanel searchPanel;
	JButton sPr,sSq,sBr,back,help;
	JTextField search;
	JLabel lSearch;
	
	public searchFrames(String title) 
	{
		searchFrame = new JFrame();
		searchPanel = new JPanel();
		
		sPr = new JButton("Search by Price");
		sSq = new JButton("Search by Sq. Footage");
		sBr = new JButton("Search by Bedrooms");
		back = new JButton("BACK");
		help = new JButton("HELP");
		
		search = new JTextField(15);
		
		lSearch = new JLabel("Enter quantity here:");
		
		sPr.addActionListener(this);
		sSq.addActionListener(this);
		sBr.addActionListener(this);
		back.addActionListener(this);
		help.addActionListener(this);
	
		searchPanel.add(help);
		searchPanel.add(lSearch);
		searchPanel.add(search);
		searchPanel.add(sPr);
		searchPanel.add(sSq);
		searchPanel.add(sBr);
		searchPanel.add(back);
		searchFrame.add(searchPanel);
		searchFrame.setBackground(Color.green);
		searchFrame.setVisible(true);
		searchFrame.setBounds(300,300,195,250);
		setResizable(false);
		searchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getActionCommand().equals("Search by Price"))
		{
			//Take the value stored in JTextField search and run a 
			//linear search in the main file for indexes with matching values
			//and then display those that are found in a table
		}
		
		if(evt.getActionCommand().equals("Search by Sq. Footage"))
		{
			//Take the value stored in JTextField search and run a 
			//linear search in the main file for indexes with matching values
			//and then display those that are found in a table
		}
		
		if(evt.getActionCommand().equals("Search by Bedrooms"))
		{
			//Take the value stored in JTextField search and run a 
			//linear search in the main file for indexes with matching values
			//and then display those that are found in a table
		}
		
		if(evt.getActionCommand().equals("HELP"))
		{
			JOptionPane.showMessageDialog(searchFrame, "Input a value of that corresponds to\n"
					+ "the quanity of whichever index you\n"
					+ "wish yo search the master file with.");
		}
		
		if(evt.getActionCommand().equals("BACK"))
		{
			searchFrame.dispose();
		}
	}

}
