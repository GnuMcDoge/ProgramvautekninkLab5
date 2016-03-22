package dataHandler;

import javax.xml.crypto.Data;

import com.owlike.genson.Genson;

import dataCollection.DataCollectionBuilder;
import dataCollection.Resolution;
import dataSources.DataSource;
import dataSources.FootballArena;
import dataSources.FootballGoalSource;
import dataSources.TemperatureSource;
import dataSources.TemperatureSource_OLD;

public class DataSourcesToJsonConverter {
	String jsonString;
	DataSource source1;
	DataSource source2;

	/**
	 * Stander constructor for DataSourcesToJsonConverter() which have given
	 * data sources
	 * 
	 */
	public DataSourcesToJsonConverter() {
		this(new FootballGoalSource(), new TemperatureSource(), Resolution.DAY);
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
	public DataSourcesToJsonConverter(DataSource ds1, DataSource ds2) {

		this(ds1, ds2, Resolution.DAY);

	}

	public DataSourcesToJsonConverter(DataSource ds1, DataSource ds2, Resolution res) {
		DataCollectionBuilder dcBuilder = new DataCollectionBuilder(ds1, ds2, res);
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
