import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Car
{
	private int year;
	
	private String make;
	private String model;
	
	private LocalDateTime parkTime;
	
	public Car(String make, String model, int year)
	{
		this.make = make;
		this.model = model;
		this.year = year;
		parkTime = LocalDateTime.now();
	}

	public int getYear()
	{
		return year;
	}

	public void setYear(int year)
	{
		this.year = year;
	}

	public String getMake()
	{
		return make;
	}

	public void setMake(String make)
	{
		this.make = make;
	}

	public String getModel()
	{
		return model;
	}

	public void setModel(String model)
	{
		this.model = model;
	}

	public LocalDateTime getParkTime()
	{
		return parkTime;
	}
	
	public long getParkCost()
	{
		LocalDateTime currentTime = LocalDateTime.now();
		
		return parkTime.until(currentTime, ChronoUnit.SECONDS);
	}
	
	public String toString()
	{
		return String.format("%s %s %d", make, model, year);
	}
}