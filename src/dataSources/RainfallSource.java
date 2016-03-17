package dataSources;

import java.time.LocalDate;
import java.util.Map;

public class RainfallSource implements DataSource{
	
	
	private String url = "http://opendata-download-metobs.smhi.se/explore/zip?parameterIds=5&stationId=107420&period=corrected-archive&includeMetadata=false";

	@Override
	public String getName() {
	
		return "Nederbörd";
	}

	@Override
	public String getUnit() {
		
		return "mm";
	}

	@Override
	public Map<LocalDate, Double> getData() {
		UrlFetcher data = new UrlFetcher(url);

		
		CSVParser parser = new CSVParser(data.getContent());
		
		return parser.getResult("G");
		
	}

}
