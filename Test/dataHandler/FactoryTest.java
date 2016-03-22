package dataHandler;

import static org.junit.Assert.*;



import dataSources.DataSource;
import dataSources.FootballGoalSource;
import dataSources.FootballSpectatorSource;
import dataSources.RainfallSource;
import dataSources.TemperatureSource;
import servlet.SourceFactoryEnum;

import org.junit.Before;
import org.junit.Test;

public class FactoryTest {

	private DataSource ds;

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void getCorrectSourceTest() {

		ds = SourceFactoryEnum.valueOf("goals".toUpperCase()).getSource();
		assertTrue(ds instanceof FootballGoalSource);

		ds = SourceFactoryEnum.valueOf("spectators".toUpperCase()).getSource();
		assertTrue(ds instanceof FootballSpectatorSource);

		ds = SourceFactoryEnum.valueOf("temperature".toUpperCase()).getSource();
		assertTrue(ds instanceof TemperatureSource);

		ds = SourceFactoryEnum.valueOf("rainfall".toUpperCase()).getSource();
		assertTrue(ds instanceof RainfallSource);

	}

	@Test(expected = IllegalArgumentException.class)
	public void illegalArgumentTest() {

		ds = SourceFactoryEnum.valueOf("randomParameter".toUpperCase()).getSource();
	}

	@Test(expected = NullPointerException.class)
	public void nullPointerTest() {

		ds = SourceFactoryEnum.valueOf(null).getSource();
	}

}
