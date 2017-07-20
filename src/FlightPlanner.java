public class FlightPlanner
{
	public static void main(String[] args)
	{
		String[] paths = {"start|middle|1|2", "middle|origin|3|4", "origin|fate|5|6", "start|fate|4|2"};
		FlightData flightData = new FlightData();

		flightData.createGraph(paths);

		flightData.printFlightPaths("start", "fate");
	}
}
