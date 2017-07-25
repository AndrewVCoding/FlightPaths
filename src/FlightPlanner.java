import java.util.List;

class FlightPlanner
{
	public static void main(String[] args)
	{
		String[] paths = {"Dallas|Austin|60|120", "Dallas|Houston|70|150", "Dallas|Costa Rica|175|480",
		                  "Austin|Dallas|65|130", "Austin|Costa Rica|180|410", "Costa Rica|Frankfurt|245|650",
		                  "Austin|London|230|590", "Austin|Frankfurt|240|630", "Frankfurt|London|110|125",
		                  "London|Houston|210|540", "Houston|Costa Rica|180|420", "Costa Rica|Austin|180|420"};

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
