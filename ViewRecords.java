import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewRecords
{
	public static void main(String args[]) 
  {
	  JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    int price,area,beds;
    String p,a,b = null;
    //f = new File
    //addRecFrames arf = new addRecFrames(b);
    
    
    try
    {
    	
    	BufferedReader rd = new BufferedReader(new FileReader("house.dat"));
    	String reader = rd.readLine();
    	while(!reader.equals("------------"));
    	{
    		p = rd.readLine();
    		a = rd.readLine();
    		b = rd.readLine();
    	}
    	
    	System.out.println(p);
    	System.out.println(a);
    	System.out.println(b);
    	
    }
    catch(IOException e)
    {
    	e.printStackTrace();
    }
    
    
    
    Object rowData[][] = { 
    						{ "1","1,1", "1,2", "1,3" },
       						{ "2","2,1", "2,2", "2,3" } 
       					 };

    Object columnNames[] = { "#","Price", "Sq. Footage", "Bedrooms" };
    JTable table = new JTable(rowData, columnNames);

    JScrollPane scrollPane = new JScrollPane(table);
    frame.add(scrollPane, BorderLayout.CENTER);
    frame.setSize(300, 150);
    //frame.setWritable(false);
    frame.setVisible(true);

  }
}