package servlet;

import dataSources.DataSource;
import dataSources.FootballGoalSource;
import dataSources.FootballSpectatorSource;
import dataSources.TemperatureSource;

public enum sourceEnum {
	
	

	GOALS(){
		public DataSource getSource(){
			return new FootballGoalSource();	
		}
		
		
	},
	SPECTATORS{
		public DataSource getSource(){
			return new FootballSpectatorSource();
		}
		
	},
	TEMPERATURE{
		
		public DataSource getSource(){
			return new TemperatureSource();
		}
	 
	};
	
	
	public abstract DataSource getSource();
	

}
