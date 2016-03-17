package dataSources;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FootballSpectatorSource implements DataSource{


	private FootballArena arenaToCheck = FootballArena.STROMVALLEN;
	private final String FOOTBALL_SOURCE_URL = "http://api.everysport.com/v1/events?apikey=1769e0fdbeabd60f479b1dcaff03bf5c&league=63925&limit=";
	private final String NUMBEROFGAMES = "240"; //240 is max.

	public FootballSpectatorSource() {


	}


	@Override
	public String getName() {

		return "Antal åskådare";
	}

	@Override
	public String getUnit() {






		return null;
	}

	@Override
	public Map<LocalDate, Double> getData() {
		UrlFetcher fetcher = new UrlFetcher(FOOTBALL_SOURCE_URL + NUMBEROFGAMES);
		JsonToMapParser parser = new JsonToMapParser(fetcher.getContent());
		Map<String, Object> data = parser.getResult();
		Map<LocalDate, Double> result = new TreeMap<>();

		for (Map event : (List<Map>) data.get("events")) {
			Map<String, Object> facts = (Map<String, Object>) event.get("facts");
			if(facts.containsKey("arena")){
				Map<String, Object> arena = (Map<String, Object>) facts.get("arena");

				arenaIdMatchesChosenArenaId(arenaToCheck, result, event, arena);
			}
		}
		return result;
	}

	private void arenaIdMatchesChosenArenaId(FootballArena arenaToCheck, Map<LocalDate, Double> result, Map event,
			Map<String, Object> arena) {

		if (arena.get("id").toString().matches(arenaToCheck.getArenaId())){


		}

		Map<String, Object> facts = (Map<String, Object>) event.get("facts");
		//	Map<String, Object> spectators = (Map<String, Object>) facts.get("spectators");

		if (arena.get("id").toString().matches(arenaToCheck.getArenaId())) {
			LocalDate date = LocalDate.parse(event.get("startDate").toString().substring(0, 10));
			//Map<String, Object> spectators = (Map<String, Object>) event.get("facts");
			int nbrOfSpectators = Integer.parseInt(facts.get("spectators").toString());
			
			addSpectatorsToDate(result, date, nbrOfSpectators);
		}
	}

	private void addSpectatorsToDate(Map result, LocalDate date, int nbrOfSpectators){


		if (!result.containsKey(date)) {
			result.put(date, new Double(nbrOfSpectators));
		}


	}


}


