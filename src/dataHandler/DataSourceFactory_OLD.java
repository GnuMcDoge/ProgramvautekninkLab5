package dataHandler;

import dataSources.DataSource;
import dataSources.FootballGoalSource;
import dataSources.FootballSpectatorSource;
import dataSources.RainfallSource;
import dataSources.TemperatureSource;

public class DataSourceFactory_OLD {




	public DataSourceFactory_OLD(){

	}

	public static DataSource get(String source){

		if (source == null)
			return null;

		if(source.equalsIgnoreCase("goals"))
			return new FootballGoalSource();
		
		else if (source.equalsIgnoreCase("spectators"))
			return new FootballSpectatorSource();
		
		else if (source.equalsIgnoreCase("temperature"))
			return new TemperatureSource();
		
		else if (source.equalsIgnoreCase("rainfall"))
			return new RainfallSource();
		
		return null;
	}


}
