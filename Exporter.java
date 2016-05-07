import java.awt.*; 
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.table.TableModel;

public class Exporter 
{
		public Exporter() 
		{ 
			JTable exportData;
			File file;
			
		}
		
		public void exportRecords(JTable exportData, File exportFile)
		{
			TableModel layout = (TableModel) exportData.getLayout();
			
			//JTable layout = exportData.getLayout();
			try
			{
				PrintWriter spreadsheet = new PrintWriter(new FileWriter(exportFile));
				for(int count = 0; count<exportData.getColumnCount(); count++)
				{
					spreadsheet.print(exportData.getColumnName(count) + "\t");	
				}
				spreadsheet.print("\n");
				
				for(int count = 0; count<exportData.getRowCount(); count++)
					for(int count2 = 0; count2<exportData.getColumnCount(); count2++)
					{
						spreadsheet.println(exportData.getValueAt(count,count2).toString());
					}
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
			
		}
		
		/*public void exportTable(JTable table, File file) throws IOException 
		{
			TableModel model = table.getModel();
			FileWriter out = new FileWriter(file);
			for(int i=0; i < model.getColumnCount(); i++) 
			{
				out.write(model.getColumnName(i) + "\t");
			}
			out.write("\n");

			for(int i=0; i< model.getRowCount(); i++) 
			{
				for(int j=0; j < model.getColumnCount(); j++) 
				{
					out.write(model.getValueAt(i,j).toString()+"\t");
				}
			out.write("\n");
			}

		out.close();
		System.out.println("write out to: " + file);
		}*/
	}