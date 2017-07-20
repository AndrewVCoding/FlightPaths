import java.util.List;

public class FlightPlanner
{
	public static void main(String[] args)
	{
		String[] paths = {"Dallas|Austin|1|1", "Dallas|Houston|1|1", "Dallas|Costa Rica|1|1",
		                  "Austin|Dallas|1|1", "Austin|Costa Rica|1|1", "Costa Rica|Frankfurt|1|1",
		                  "Austin|London|1|1", "Austin|Frankfurt|1|1", "Frankfurt|London|1|1",
		                  "London|Houston|1|1", "Houston|Costa Rica|1|1", "Costa Rica|Austin|1|1"};

		String[] flights = {"Middle|Fate|C", "Dallas|Frankfurt|C", "Frankfurt|Dallas|T", "Austin|London|T"};
		FlightData flightData = new FlightData();

		flightData.createGraph(paths);

		int flightNum = 1;

		for(String flight: flights)
		{
			String[] flightInfo = flight.split("\\|");
			System.out.println("Flight " + flightNum + ": " + flightInfo[0] + " to " + flightInfo[1] + " (" +
			                   flightInfo[2] + ")");
			List<String> flightPaths = flightData.printFlightPaths(flightInfo[0], flightInfo[1]);
			for(String flightPath: flightPaths)
				System.out.print(flightPath);
			System.out.println();
		}
	}
}
