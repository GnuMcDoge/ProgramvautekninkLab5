package dataHandler;

import com.owlike.genson.Genson;

import dataCollection.DataCollectionBuilder;
import dataCollection.Resolution;
import dataSources.DataSource;
import dataSources.FootballArena;
import dataSources.FootballGoalSource;
import dataSources.TemperatureSource_OLD;

public class DataSourcesToJsonConverter {
	String jsonString;

	/**
	 * Stander constructor for DataSourcesToJsonConverter() which have given
	 * data sources
	 * 
	 */
	public DataSourcesToJsonConverter() {
		this(new FootballGoalSource(), new TemperatureSource_OLD(FootballArena.STROMVALLEN.getCityTemperatureURL()),
				Resolution.DAY);
	}

	/**
	 * Constructor for DataSourcesToJsonConverter() which need data sources
	 * 
	 * @param goalSource
	 *            FootballGoalsSource
	 * @param tempSource
	 *            TemperatureSource
	 * @param res
	 *            Resolution
	 */
	public DataSourcesToJsonConverter(FootballGoalSource goalSource, TemperatureSource_OLD tempSource, Resolution res) {
		DataCollectionBuilder dcBuilder = new DataCollectionBuilder(goalSource, tempSource, res);
		jsonString = new Genson().serialize(dcBuilder.getResult());

	}

	public DataSourcesToJsonConverter(String ds1, String ds2) {
		

		DataSource source1 = DataSourceFactory.get(ds1);
		DataSource source2 = DataSourceFactory.get(ds2);
		
		DataCollectionBuilder dcBuilder = new DataCollectionBuilder(source1, source2);
		jsonString = new Genson().serialize(dcBuilder.getResult()); 
	
		
	}

	/**
	 * Collect data from the given sources and return it as a string
	 * 
	 * @return String
	 */
	public String getString() {

		return jsonString;
	}
}


