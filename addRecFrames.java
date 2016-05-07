import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class addRecFrames extends JFrame implements ActionListener
{
	JFrame addFrame;
	JPanel addPanel;
	JButton okay,back,remove,export;
	JLabel lab1,lab2,lab3;
	JTextField txtPr,txtSq,txtBr;
	public int pr,sq,br;
	//public String[] houseAtts = new String[3];
	public ArrayList<String> houseAtts = new ArrayList<String>(3);
	public File f;
	public File tempFile;
	JTable table;
	
	public addRecFrames(String title)
	{
		f = new File("house.dat");
		addFrame = new JFrame();
		addPanel = new JPanel();
		
		lab1 = new JLabel("PRICE (###,###):");
		lab2 = new JLabel(" SQ FOOTAGE:");
		lab3 = new JLabel("  BEDROOMS:");
		
		txtPr = new JTextField(15);
		txtSq = new JTextField(15);
		txtBr = new JTextField(15);
		
		okay = new JButton("ADD");
		remove = new JButton("REMOVE");
		export = new JButton("EXPORT");
		back = new JButton("BACK");
		
		
		okay.addActionListener(this);
		back.addActionListener(this);
		export.addActionListener(this);
		remove.addActionListener(this);
		
		setLayout(new FlowLayout());
		
		addPanel.add(lab1);
		addPanel.add(txtPr);
		addPanel.add(lab2);
		addPanel.add(txtSq);
		addPanel.add(lab3);
		addPanel.add(txtBr);
		addPanel.add(okay);
		addPanel.add(remove);
		addPanel.add(export);
		addPanel.add(back);
		addFrame.add(addPanel);
		addFrame.setVisible(true);
		addFrame.setBounds(300,300,250,250);
		setResizable(false);
		addFrame.setBackground(Color.green);
		addFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getActionCommand().equals("ADD"))
		{
			/*houseAtts[0] = txtPr.getText();
			houseAtts[1] = txtSq.getText();
			houseAtts[2] = txtBr.getText();*/
			
			if(txtPr.getText().length() > 0 && txtSq.getText().length() > 0 && txtBr.getText().length() > 0)
			{
				houseAtts.add(txtPr.getText());
				houseAtts.add(txtSq.getText());
				houseAtts.add(txtBr.getText());
				
				try 
				{       
					BufferedWriter out = new BufferedWriter(new FileWriter(f,true));
					for(int x = 0; x< houseAtts.size(); x++)
					{
						System.out.println(houseAtts.get(x));
						out.write(houseAtts.get(x)); 
						out.newLine();
					}
					
					out.write("------------");
					out.close();
		
			    } catch (IOException e) 
			    {
			        e.printStackTrace();
			    }
			}
			else
			{
				JOptionPane.showMessageDialog(addFrame, "No data entered!","ERROR", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		if(evt.getActionCommand().equals("REMOVE"))
		{
			boolean found = false;
			int x = 0;
			int y = 1;
			int z = 2;
			String Pr,Sq,Br;
			
			Pr = txtPr.getText();
			Sq = txtSq.getText();
			Br = txtBr.getText();
			
			if(txtPr.getText().length() > 0 && txtSq.getText().length() > 0 && txtBr.getText().length() > 0)
			{	
				try
				{
					tempFile = new File(f + "temp.txt");
					BufferedReader br = new BufferedReader (new FileReader(f));
					BufferedWriter bw = new BufferedWriter (new FileWriter(f));
					PrintWriter Pwr = new PrintWriter(new FileWriter (tempFile));
					String line = null;
		
					//read from original, write to temporary and trim space, while title not found
					while((line = br.readLine()) !=null) 
					{
						//bw.write("");
						
						Pwr.println(line);
						Pwr.flush();
					}
					// close readers and writers
					br.close();
					bw.close();
					Pwr.close();
		
					// delete book file before renaming temp
					f.delete();
		
					// rename temp file back to books.txt
					if(tempFile.renameTo(f))
					{
						System.out.println("Update succesful");
					}
					else
					{
				        System.out.println("Update failed");
				    }
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
			else
			{
					JOptionPane.showMessageDialog(addFrame, "No data entered!","ERROR", JOptionPane.INFORMATION_MESSAGE);
			}	
			/*try
			{
				BufferedReader reader = new BufferedReader(new FileReader(f));
				BufferedWriter writer = new BufferedWriter(new FileWriter(f));
				String s1;
				int count = 0;
				while((s1 = reader.readLine()) != null && count<3)
				{
					
					if(s1.equals(Pr) && !s1.equals("------------"))
					{
						System.out.println("***" + s1);
						houseAtts.remove(s1);
						writer.write("DATA REMOVED");
						s1 = "";
						//writer.write(s1);
					}
					//writer.close();
					count++;
					
					
				}
				
				reader.close();
				
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			/*while(x<houseAtts.length && y<houseAtts.length && z<houseAtts.length && !found)
			{
				if(Pr.equals(houseAtts[x]))
					if(Sq.equals(houseAtts[y]))
						if(Br.equals(houseAtts[z]))
						{
							found = true;
						}
						else
						{
							x++;
							y++;
							z++;
						}
			}
			
			if(!found)
				JOptionPane.showMessageDialog(addFrame, "Data does not exist");
			else
			{
				//DELETE THE VALUES FROM FILE: CREATE ALGORITHM FOR THIS!
				
				for(int k = x; k<houseAtts.length-1;k++)
				{
					y--;
					z--;
				}
			}*/
				
		}
		
		
		if(evt.getActionCommand().equals("EXPORT"))
		{
			if(txtPr.getText().length() > 0 && txtSq.getText().length() > 0 && txtBr.getText().length() > 0)
			{	
				Exporter toExl = new Exporter();
				toExl.exportRecords(table,new File("househelper.xls"));
			}
			else
			{
				JOptionPane.showMessageDialog(addFrame, "No data entered!","ERROR", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		if(evt.getActionCommand().equals("BACK"))
		{
			addFrame.dispose();
		}
	}
	
}
