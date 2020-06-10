package hotel;

public class Hotel {
	
    private String hotelName;
    private String hotelAddress;
	
	private Hotel(String hotelName,String hotelAddress)
	{
		this.hotelName=hotelName;
		this.hotelAddress=hotelAddress;
	}
	
	private static final Hotel INSTANCE = new Hotel("CRESCENT","HUBLI");
	
	public static Hotel getInstance()
	{
		return INSTANCE;
	}

}
 

