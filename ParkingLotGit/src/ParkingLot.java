import java.util.Map;
import java.util.Scanner;

public class ParkingLot
{
	public static void main(String[] args) throws MaxSizeExceededException, DuplicateKeyException
	{
		int carOption;
		int maxSpots;
		
		Scanner keys = new Scanner(System.in);
		
		MaxSizeHashMap<String, Car> licenseToCar;
		
		System.out.print("Enter maximum parking spots: ");
		maxSpots = keys.nextInt();
		licenseToCar = new MaxSizeHashMap<>(maxSpots);
		
		do
		{
			for (Map.Entry<String, Car> carEntry : licenseToCar.getEntrySet())
			{
				System.out.println(carEntry.getKey() + " | " + carEntry.getValue());
			}
			
			System.out.print("Park car, remove car, or exit? (1/2/3): ");
			carOption = keys.nextInt();
			keys.nextLine();
			
			if (carOption == 1)
			{
				if (licenseToCar.isFull())
				{
					System.out.println("Parking lot is full.");
				}
				else
				{		
					System.out.print("Enter license plate: ");
					
					String license = keys.nextLine();
					
					if (licenseToCar.containsKey(license))
					{
						System.out.println("Car already parked.");
					}
					else
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
						licenseToCar.put(license, new Car(make, model, year));
					}
				}
			}
			else if (carOption == 2)
			{
				if (licenseToCar.isEmpty())
				{
					System.out.println("Parking lot is empty.");
				}
				else
				{
					System.out.print("Enter car license to remove: ");
					
					String license = keys.nextLine();
					
					Car removedCar = licenseToCar.remove(license);
					
					if (removedCar == null)
					{
						System.out.println("Car license not found.");
					}
					else
					{
						System.out.printf("Removed car %s. Park cost is $%s.\n",
										  removedCar, removedCar.getParkCost());
					}
				}
			}
		}
		while (carOption != 3);
	}
}