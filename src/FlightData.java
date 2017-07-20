import java.util.ArrayList;
import java.util.List;

public class FlightData
{
	List<City> CITIES = new ArrayList<>();
	double COST = 0;
	int TIME = 0;

	public void createGraph(String[] paths)
	{
		boolean debug = false;

		//Iterate through the array of paths, adding each city and its destinations
		for(String line : paths)
		{
			String[] pathData = line.split("\\|");

			//Get the cities from the list of cities. If they are not already in the list, this will create new ones.
			City start = getCity(pathData[0]);
			City desti = getCity(pathData[1]);

			start.addDestination(desti, pathData[2], pathData[3]);
		}
	}

	public Double getCost(String source, String destination)
	{
		boolean debug = false;

		Double output = -1.0;

		for(City start : CITIES)
			if(start.NAME.equals(source))
			{
				int index = 0;
				for(City dest : start.DESTINATIONS)
				{
					if(dest.NAME.equals(destination))
						output = start.COSTS.get(index);
					else
						index++;
				}
			}

		return output;
	}

	public int getTime(String source, String destination)
	{
		boolean debug = false;

		int output = -1;

		for(City start : CITIES)
			if(start.NAME.equals(source))
			{
				int index = 0;
				for(City dest : start.DESTINATIONS)
				{
					if(dest.NAME.equals(destination))
						output = start.TIMES.get(index);
					else
						index++;
				}
			}

		return output;
	}

	public void printFlightPaths(String startIn, String destinationIn)
	{
		boolean debug = false;

		if(debug)
			System.out.println("Getting flight plan");

		List<List<City>> paths = new ArrayList<>();
		List<City> path = new ArrayList<>();
		path.add(getCity(startIn));
		City dest = getCity(destinationIn);

		String plan = "     ";

		COST = 0;
		TIME = 0;

		//Get a list of paths from the source to the destination
		getPaths(path, dest, paths);

		//Display the flight plans
		int pathNum = 0;
		for(List<City> flightPlan : paths)
		{
			pathNum++;
			plan += "Path " + pathNum  + ": " + flightPlan.get(0).NAME;
			int index = 1;
			while(index < flightPlan.size())
			{
				plan += " -> " + flightPlan.get(index).NAME;
				index++;
			}
			String cost = String.format("%1$,.2f", COST);

			plan += ". Time: " + TIME + " Cost: " + cost + "\n     ";
		}

		if(pathNum == 0)
			plan = "     No flight plans available";

		System.out.println(plan);


	}

	public void getPaths(List<City> path, City destination, List<List<City>> paths)
	{
		boolean debug = false;

		City current = path.get(path.size() - 1);

		if(debug)
			System.out.println("getPaths: current city: " + current.NAME);

		//Look at each destination city in the current city
		for(City next : current.DESTINATIONS)
		{
			if(debug)
				System.out.println("Looking at next: " + next.NAME);

			//If the next city is already in the list, don't add it to the list
			if(!path.contains(next))
			{
				if(debug)
					System.out.println("Adding " + next.NAME + " to path");

				List<City> newPath = new ArrayList<>(path);

				COST += getCost(current.NAME, next.NAME);
				TIME += getTime(current.NAME, next.NAME);

				newPath.add(next);

				//If the next node is the destination
				if(next.NAME.equals(destination.NAME))
				{
					if(debug)
						System.out.println("path has reached the destination");

					paths.add(newPath);
				}
				else
				{
					if(debug)
						System.out.println("next is is not destination");
					getPaths(newPath, destination, paths);
				}
			}
			else if(debug)
				System.out.println("next city already in list: " + next.NAME);
		}
	}

	public City getCity(String name)
	{
		boolean debug = false;

		for(City city : CITIES)
			if(city.NAME.equals(name))
				return city;

		City temp = new City(name);
		CITIES.add(temp);

		return temp;
	}
}
