package dataHandler;

import dataSources.FootballGoalSource;
import dataSources.FootballSpectatorSource;
import dataSources.RainfallSource;
import dataSources.TemperatureSource;

import javax.management.RuntimeErrorException;

import dataSources.DataSource;

public class DataSourceFactory {

	private static enum Factory {

		GOALS(FootballGoalSource.class), SPECTATORS(FootballSpectatorSource.class), TEMPERATURE(
				TemperatureSource.class), RAINFALL(RainfallSource.class);

		private final Class<? extends DataSource> source;

		private Factory(Class<? extends DataSource> source) {

			this.source = source;
		}

		public DataSource getDataSource() {
			try {
				return source.newInstance();
			} catch (IllegalAccessException | InstantiationException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public static DataSource getDataSource(String src) {

		return Factory.valueOf(src).getDataSource();

	}

}
