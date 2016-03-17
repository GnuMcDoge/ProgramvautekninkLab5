package dataHandler;

import com.owlike.genson.Genson;

import dataCollection.DataCollectionBuilder;
import dataCollection.Resolution;
import dataSources.DataSource;
import dataSources.FootballArena;
import dataSources.FootballGoalSource;
import dataSources.TemperatureSource;

public class DataSourcesToJsonConverter {
	String jsonString;

	/**
	 * Stander constructor for DataSourcesToJsonConverter() which have given
	 * data sources
	 * 
	 */
	public DataSourcesToJsonConverter() {
		this(new FootballGoalSource(), new TemperatureSource(FootballArena.STROMVALLEN.getCityTemperatureURL()),
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
	public DataSourcesToJsonConverter(FootballGoalSource goalSource, TemperatureSource tempSource, Resolution res) {
		DataCollectionBuilder dcBuilder = new DataCollectionBuilder(goalSource, tempSource, res);
		jsonString = new Genson().serialize(dcBuilder.getResult());

	}

	public DataSourcesToJsonConverter(String Ds1, String Ds2) {

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

class GNU {
	public static DataSource getGNU(String gnu) {
		switch (gnu.toLowerCase()) {
		case "football":
			return new FootballGoalSource();
		case "temperature":
			return new TemperatureSource("GNU");
		default:
			throw new RuntimeException("Invalid datasource!");
		}
	}
}
