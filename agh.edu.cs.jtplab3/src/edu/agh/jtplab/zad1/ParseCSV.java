package edu.agh.jtplab.zad1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.validator.routines.UrlValidator;

public class ParseCSV {
	  
	public static void read(String csvFile,DatabaseConnector databaseConnector) throws IOException, SQLException {
			BufferedReader br = null;
			String line = "";
			String cvsSplitBy = ",";
	
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
					// use comma as separator
					String[] record = line.split(cvsSplitBy);
				    UrlValidator urlValidator = new UrlValidator();
				    
				    //valid URL
				    if (urlValidator.isValid("http://"+record[1]) || urlValidator.isValid("https://"+record[1]) ) {
						databaseConnector.insertIntoBookmarks( Integer.parseInt(record[0]),record[1],record[2],record[3]);
				    } else {
				       System.out.println("url is invalid");
				    }

			}
			if (br!=null) br.close();
			System.out.println("Parsing Done");
	}
	
}
