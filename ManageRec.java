import java.awt.*; 
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class ManageRec extends JFrame implements ActionListener
{
	public JFrame frame2, frame3;
	public JPanel panel2, panel3;
	public JButton add,remove,search;
	public JButton a1,a2,a3;
	public JButton confirm = new JButton("CONFIRM");
	public JButton back,back1;
	public JLabel label;
	public JTextField text;
	public String[] buttonOpts = {"SELECT AN ATTRIBUTE BELOW","PRICE","SQ. FOOTAGE","BEDROOMS"};
	public int[] houseAtts = new int[3]; 
	//public JComboBox addList = new JComboBox(buttonOpts);
	public JComboBox removeList = new JComboBox(buttonOpts);
	public String addItem,removeItem,attribute;
	public JTextField txt;
	public File f;
	public FileWriter fWriter;
	public boolean exists;
	
	public ManageRec(String title)
	{
		super(title);
		
		
		frame2 = new JFrame();
		panel2 = new JPanel();
		add = new JButton("ADD");
		remove = new JButton("REMOVE");
		search = new JButton("SEARCH");
		back = new JButton("BACK");
		
		add.addActionListener(this);
		remove.addActionListener(this);
		search.addActionListener(this);
		back.addActionListener(this);
		
		//GridLayout grd1 = new GridLayout(2,2,10,40);
		//setLayout(grd1);
		setLayout(new FlowLayout());
		add(add);
		add(remove);
		add(search);
		add(back);
		add(panel2);
		this.setBackground(Color.blue);
		setVisible(true);
		createFile();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void add()
	{
		frame3 = new JFrame();
		panel3 = new JPanel();
		//a1 = new JButton("PRICE");
		//a2 = new JButton("Sq. FOOTAGE");
		//a3 = new JButton("BEDROOMS");					//Considering changing this into a JRadioButton
		
		JLabel lab1 = new JLabel("PRICE:");
		JLabel lab2 = new JLabel("SQ. FOOTAGE:");
		JLabel lab3 = new JLabel("BEDROOMS:");
		JTextField txtPrice = new JTextField(15);
		JTextField txtSQ = new JTextField(15);
		JTextField txtBeds = new JTextField(15);
		back1 = new JButton("BACK TO MANAGE");
		//this.equals(frame3);
		
		back1.addActionListener(this);
		//addList.addActionListener(this);
		setLayout(new FlowLayout());		
		//panel3.add(addList);
		panel3.add(back1);
		panel3.add(lab1);
		panel3.add(txtPrice);
		panel3.add(lab2);
		panel3.add(txtSQ);
		panel3.add(lab3);
		panel3.add(txtBeds);
		frame3.setBounds(300,300,500,400);
		frame3.add(panel3);
		frame3.setVisible(true);
		frame3.setBackground(Color.green);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int pr = Integer.parseInt(txtPrice.getText());
		int sq = Integer.parseInt(txtSQ.getText());
		int br = Integer.parseInt(txtBeds.getText());
		
		
		houseAtts[0] = pr;
		houseAtts[1] = sq;
		houseAtts[2] = br;
		
	}
	
	public void remove()
	{
		frame2 = new JFrame();
		panel2 = new JPanel();
		JButton b1 = new JButton("BACK TO MANAGE");
		label = new JLabel("What category would you like to remove by?");
		//this.equals(frame2);
		
		removeList.addActionListener(this);
		
		setLayout(new FlowLayout());
		
		panel2.add(label);
		panel2.add(removeList);
		
		
		
		
		
		
		
		
	}
	
	public void search()
	{
		
	}
	
	public void back()
	{
		dispose();		
	}
	
	public void createFile()
	{
		if(exists)
		{
			try 
			{       
				FileWriter out = new FileWriter(f);
				for(int x = 0; x<= houseAtts.length; x++)
				{
					out.write(houseAtts[x]);
				}
		        out.close();
	
		    } catch (IOException e) 
		    {
		        e.printStackTrace();
		    }
		}
	}
	
	
	
	
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getActionCommand().equals("ADD"))
		{
			//repaint();  //***TRYING TO MAKE IT REPLACE EXISTING WINDOW INSTEAD OF OPENEING A NEW ONE***
			add();	
		}
		else if(evt.getActionCommand().equals("REMOVE"))
		{
			remove();
		}
		else if(evt.getActionCommand().equals("SEARCH"))
		{
			search();
		}
		else if(evt.getActionCommand().equals("BACK"))
		{
			back();
		}
		else if(evt.getSource() == back1) 
		{
			this.dispose();  //ERROR - Keeps disposing the window behind it instead of itself
		}
		//else if(evt.getActionCommand().equals("PRICE"))
		
//---------------------------------------------------------------------------------------------------------------------
		
		/*addItem = (String) addList.getSelectedItem();
		if(addItem.equals("PRICE"))
		{
			frame3 = new JFrame();
			panel3 = new JPanel();
			JLabel label =  new JLabel("Enter price: ");
			JTextField txt = new JTextField(15);	
			panel3.add(label);
			panel3.add(txt);
			panel3.add(confirm);
			frame3.add(panel3);
			frame3.setVisible(true);
			frame3.setBounds(350,350,400,105);
		}
		else if(addItem.equals("SQ. FOOTAGE"))
		{
			frame3 = new JFrame();
			panel3 = new JPanel();
			JLabel label =  new JLabel("Enter sq. footage: ");
			JTextField txt = new JTextField(15);	
			panel3.add(label);
			panel3.add(txt);
			panel3.add(confirm);
			frame3.add(panel3);
			frame3.setVisible(true);
			frame3.setBounds(350,350,400,105);
		}
		else if(addItem.equals("BEDROOMS"))
		{
			frame3 = new JFrame();
			panel3 = new JPanel();
			JLabel label =  new JLabel("Enter # of bedrooms: ");
			txt = new JTextField(15);	
			panel3.add(label);
			panel3.add(txt);
			panel3.add(confirm);
			frame3.add(panel3);
			frame3.setVisible(true);
			frame3.setBounds(350,350,400,105);
		}
		
//---------------------------------------------------------------------------------------------------------------------
		
		//removeItem = (String) removeList.getSelectedItem();
		//if(removeItem.equals("PRICE"))
		
		if(evt.getActionCommand().equals("CONFIRM"))
		{
			createFile();
			dispose();
		}
			
		/*if(evt.getActionCommand().equals("CONFIRM"))
		{
			attribute = txt.getText();
			try
			{
				//createFile();
				fWriter = new FileWriter(f);
				String content = "tr";			
				fWriter.write(content);
				fWriter.flush();
				fWriter.close();
			
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
			dispose();
		}*/
		
		//repaint();
		
		
	}
}

