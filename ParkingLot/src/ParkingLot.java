import java.util.Scanner;

public class ParkingGarage
{
	public static void main(String[] args)
	{
		int carOption;
		int maxSpots;
		
		Scanner keys = new Scanner(System.in);
		
		Car[] carSpots;
		
		System.out.print("Enter maximum parking spots: ");
		maxSpots = keys.nextInt();
		carSpots = new Car[maxSpots];
		
		do
		{
			int spot;
			
			for (int i = 0; i < carSpots.length; i++)
			{
				if (carSpots[i] != null)
				{
					System.out.println(i + " | " +
									   carSpots[i].getMake() + " " +
									   carSpots[i].getModel() + " " +
									   carSpots[i].getYear());
				}
			}
			
			System.out.print("Park car, remove car, or exit? (1/2/3): ");
			carOption = keys.nextInt();
			keys.nextLine();
			
			if (carOption == 1)
			{
				int year;
				
				String make;
				String model;
				
				System.out.print("Enter car make: ");
				make = keys.nextLine();
				System.out.print("Enter car model: ");
				model = keys.nextLine();
				System.out.print("Enter car year: ");
				year = keys.nextInt();
				keys.nextLine();
				spot = getOpenSpot(carSpots);
				
				if (spot >= 0)
				{
					carSpots[spot] = new Car(make, model, year);
				}
				else
				{
					System.out.println("No more spots available.");
				}
			}
			else if (carOption == 2)
			{
				System.out.print("Enter car number to remove: ");
				spot = keys.nextInt();
				keys.nextLine();
				
				if (spot >= 0 && spot <= carSpots.length - 1)
				{
					if (carSpots[spot] != null)
					{
						System.out.println("Parking cost: $" +
										   carSpots[spot].getParkCost() + ".");
						carSpots[spot] = null;
					}
					else
					{
						System.out.println("This spot is already empty.");
					}
				}
				else
				{
					System.out.println("Car number must be from 0 to " +
									   (carSpots.length - 1) + ".");
				}
			}
		}
		while (carOption != 3);
	}
	
	public static int getOpenSpot(Car[] carSpots)
	{
		Scanner keys = new Scanner(System.in);
		
		for (int i = 0; i < carSpots.length; i++)
		{
			if (carSpots[i] == null)
			{	
				System.out.print("Take spot number " +
								 i + " or skip? (1/2): ");
				
				int spotOption = keys.nextInt();
				
				if (spotOption == 1)
				{
					return i;
				}
				else if (spotOption == 2)
				{
					System.out.println("Skipping spot number " + i + ".");
				}
			}
		}
		
		return -1;
	}
}