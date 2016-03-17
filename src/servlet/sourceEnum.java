package servlet;

import dataSources.DataSource;
import dataSources.FootballGoalSource;
import dataSources.FootballSpectatorSource;
import dataSources.TemperatureSource_OLD;

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
			return new TemperatureSource_OLD();
		}
	 
	};
	
	
	public abstract DataSource getSource();
	

}
