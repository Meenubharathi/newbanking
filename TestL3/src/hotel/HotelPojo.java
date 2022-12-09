package hotel;

public class HotelPojo 
{
    private String hotelName;
    private int noOfRooms;
    private String location;
    private int rating;
    private int roomPrice;
    
    public String getHotelName() 
    {
		return hotelName;
	}
	public void setHotelName(String hotelName)
	{
		this.hotelName = hotelName;
	}
	public int getNoOfRooms()
	{
		return noOfRooms;
	}
	public void setNoOfRooms(int noOfRooms) 
	{
		this.noOfRooms = noOfRooms;
	}
	public String getLocation() 
	{
		return location;
	}
	public void setLocation(String location) 
	{
		this.location = location;
	}
	public int getRating() 
	{
		return rating;
	}
	public void setRating(int rating) 
	{
		this.rating = rating;
	}
	public int getRoomPrice() 
	{
		return roomPrice;
	}
	public void setRoomPrice(int roomPrice) 
	{
		this.roomPrice = roomPrice;
	}
	
	public String toString() {
		return "hotelName:" + hotelName + ", noOfRooms:" + noOfRooms + ", location:" + location + ", rating:"
				+ rating + ", roomPrice:" + roomPrice;
	}
	
	
}
