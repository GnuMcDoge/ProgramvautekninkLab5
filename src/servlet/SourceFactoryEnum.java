package servlet;

import dataSources.DataSource;
import dataSources.FootballGoalSource;
import dataSources.FootballSpectatorSource;
import dataSources.RainfallSource;
import dataSources.TemperatureSource;
import dataSources.TemperatureSource_OLD;

public enum SourceFactoryEnum {

	GOALS {
		public DataSource getSource() {
			return new FootballGoalSource();
		}

	},
	SPECTATORS {
		public DataSource getSource() {
			return new FootballSpectatorSource();
		}

	},
	TEMPERATURE {

		public DataSource getSource() {
			return new TemperatureSource();
		}

	},
	RAINFALL {

		public DataSource getSource() {
			return new RainfallSource();
		}
	};

	public abstract DataSource getSource();

}
