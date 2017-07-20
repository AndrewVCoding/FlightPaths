public class FlightPlanner
{
	public static void main(String[] args)
	{
		String[] paths = {"Dallas|Austin|1|60", "Dallas|Houston|2|70", "Dallas|Costa Rica|8|160",
		                  "Austin|Dallas|1|70", "Austin|Costa Rica|8|170", "Costa Rica|Frankfurt|13|210",
		                  "Austin|London|14|230", "Austin|Frankfurt|14|250", "Frankfurt|London|2|110",
		                  "London|Houston|15|160", "Houston|Costa Rica|7|165", "Costa Rica|Austin|8|150"};

		String[] flights = {"Middle|Fate|C", "Dallas|Frankfurt|C", "Frankfurt|Dallas|T"};
		FlightData flightData = new FlightData();

		flightData.createGraph(paths);

		int flightNum = 1;

		for(String flight: flights)
		{
			String[] flightInfo = flight.split("\\|");
			System.out.println("Flight " + flightNum + ": " + flightInfo[0] + " to " + flightInfo[1] + " (" +
			                   flightInfo[2] + ")");
			flightData.printFlightPaths(flightInfo[0], flightInfo[1]);
		}
	}
}
