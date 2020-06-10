package hotel;



import hotel.Customer;


public class RoomCustomer extends Customer {
	

	String roomType;
	float Price;
	int status;
	
	RoomCustomer()
	{
		
	}

	public RoomCustomer(String roomType, float price, int status) {
		super();
		this.roomType = roomType;
		Price = price;
		this.status = status;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public RoomCustomer(int customerID, String custName, String addr, String phone, String Type) {
		super(customerID, custName, addr, phone, Type);
		// TODO Auto-generated constructor stub
	}
		
	
}


