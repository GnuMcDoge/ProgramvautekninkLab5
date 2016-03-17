package dataSources;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

/**
 * 
 * 
 * @author Rashed Davodi
 * @author Mikael Ivarsson
 * @version 29-02-16
 *
 */

public class TemperatureSource implements DataSource{
	private String name;
	private String unit;
	
	public TemperatureSource(){
		
		
	}
	
	
	public  TemperatureSource (String name, String unit){
		this.name = name;
		this.unit = unit;
		
	}

	/**
	 * Return unit
	 * 
	 */
	@Override
	public String getUnit(){
		return "C";
	}
	
	/**
	 * Return name
	 */
	@Override
	public String getName(){

		return "Temperature";
	}

	/**
	 * Collects data from an online source and returns the data.
	 * @return a map with dates and temperature.
	 */
	@Override
	public Map<LocalDate, Double> getData() {
		UrlFetcher url = new UrlFetcher("http://opendata-download-metobs.smhi.se/explore/zip?parameterIds=2&stationId=107420&period=corrected-archive&includeMetadata=false");

	
		CSVParser parser = new CSVParser(url.getContent());

		return parser.getResult("Y");
	}

}
