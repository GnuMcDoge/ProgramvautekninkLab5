package dataSources;

import java.io.BufferedReader;
import java.io.StringReader;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * Parse a CSV file.
 * 
 * @author Rashed Davodi
 * @author Mikael Ivarsson
 * @version 29-02-16
 *
 */

public class CSVParser {
	

	private String csvString;
	
	public CSVParser(String file){
	
		this.csvString = file;
		
		
		
		
	}
	
	/**
	 * The main method to parse a CSV file.
	 * @return a map with dates and temperatures.
	 */
	public Map<LocalDate, Double> getResult(String splitter){
		
		Map<LocalDate, Double> temperatureMap = new HashMap<LocalDate, Double>();
		
		String[] splitString;
		
		splitString = csvString.split(";");
		
		for (int i = 0; i < splitString.length; i++) {
			if(splitString[i].startsWith(splitter))
			{
				
			try{	temperatureMap.put(LocalDate.parse(splitString[i-2]), 
						Double.parseDouble(splitString[i-1]));
			}
			catch(DateTimeParseException e){}
			}
			
			
		}
		System.out.println(temperatureMap);
		
		return temperatureMap;
	}
	
	

}
