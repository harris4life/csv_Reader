package ms3_challenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class csv_reader {

	
	
	
	public static void main(String[] args) throws Exception {
	
		
		SQLite database = new SQLite(); 
		Connection con=DriverManager.getConnection("jdbc:sqlite:demo.db");
		Statement st = con.createStatement();
	
		int failedCount = 0 , 
			successfulCount = 0, 
		
		
		
		
		FileWriter csvWriter = new FileWriter("failedEntries.csv");  
		csvWriter.append("A,B,C,D,E,F,G,H,I,J");  
		
		FileWriter logWriter = new FileWriter("log.txt");  
		
	
		String row; 
		int counter = 0; 
		BufferedReader csvReader = new BufferedReader(new FileReader("src/ms3Interview.csv")); 
		
		while ((row = csvReader.readLine()) != null && (counter!=10)) {  
		    String[] data = row.split(",");
		    
		    
		    
		    boolean isMissingAColumn = false; 
		    for(String i:data) {
		    	if(i.equals("") ) {
		    		isMissingAColumn = true; 
		    	}
		    }
		    
		    
	    	//a. Records that do not match the column count must be written to the bad-data-<timestamp>.csv file
		    if(isMissingAColumn==true) {
		    	failedCount++; 
		    	for(String i:data) {
			    	csvWriter.append(i+",");
			    }
		    	csvWriter.append("/n");		    	
		    }else {
		    	database.addRow(data, st);
		    	successfulCount++; 
		    }
		    
		   
		}
	    
	/*	logWriter.append("successfulCount: " + successfulCount); 
		logWriter.append("failedCount: " + failedCount); 
		logWriter.append("receivedCount: " + database.recieved); */

		
	 
		csvReader.close(); 

	}
		
}
	
	
	
	
	

