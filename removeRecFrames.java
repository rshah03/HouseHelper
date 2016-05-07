import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class removeRecFrames extends JFrame implements ActionListener
{
	JFrame removeFrame;
	JPanel removePanel;
	JButton okay,back;
	JLabel lab1,lab2,lab3;
	JTextField txtPr,txtSq,txtBr;
	public int pr,sq,br;
	public int[] houseAtts = new int[3];
	public File f;
	
	public removeRecFrames(String title)
	{
		removeFrame = new JFrame();
		removePanel = new JPanel();
		
		lab1 = new JLabel("PRICE:");
		lab2 = new JLabel("SQ FOOTAGE:");
		lab3 = new JLabel("BEDROOMS:");
		
		txtPr = new JTextField(15);
		txtSq = new JTextField(15);
		txtBr = new JTextField(15);
		
		okay = new JButton("OKAY");
		back = new JButton("BACK");
		
		okay.addActionListener(this);
		back.addActionListener(this);
		
		setLayout(new FlowLayout());
		
		removePanel.add(lab1);
		removePanel.add(txtPr);
		removePanel.add(lab2);
		removePanel.add(txtSq);
		removePanel.add(lab3);
		removePanel.add(txtBr);
		removePanel.add(okay);
		removePanel.add(back);
		removeFrame.add(removePanel);
		removeFrame.setVisible(true);
		removeFrame.setBounds(300,300,500,400);
		removeFrame.setBackground(Color.green);
		removeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getActionCommand().equals("OKAY"))
		{
			//NEED TO GET FILE WORKING IN ORDER TO COMEPLETE THIS***
			//	using the array, search the contents of the file until the data is found and then remove it,
			//	rewrite data without removed data
		
		}
		
		if(evt.getActionCommand().equals("BACK"))
		{
			removeFrame.dispose();
		}
	}
	
}
 
