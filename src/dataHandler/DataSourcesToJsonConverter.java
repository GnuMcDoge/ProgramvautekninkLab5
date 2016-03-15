package dataHandler;

import com.owlike.genson.Genson;

import dataCollection.DataCollectionBuilder;
import dataCollection.Resolution;
import dataSources.FootballArena;
import dataSources.FootballGoalsSource;
import dataSources.TemperatureSource;

public class DataSourcesToJsonConverter {
	String jsonString;

	/**
	 * Stander constructor for DataSourcesToJsonConverter() which have given
	 * data sources
	 * 
	 */
	public DataSourcesToJsonConverter() {
		this(new FootballGoalsSource(), new TemperatureSource(FootballArena.STROMVALLEN.getCityTemperatureURL()),
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
	public DataSourcesToJsonConverter(FootballGoalsSource goalSource, TemperatureSource tempSource, Resolution res) {
		DataCollectionBuilder dcBuilder = new DataCollectionBuilder(goalSource, tempSource, res);
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
