package hotel;

public class UserPojo 
{
    private String userName;
    private int userid;
    private String hotelname;
    private int amount;
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public int getUserid()
	{
		return userid;
	}
	public void setUserid(int userid)
	{
		this.userid = userid;
	}
	public String getHotelname() 
	{
		return hotelname;
	}
	public void setHotelname(String hotelname)
	{
		this.hotelname = hotelname;
	}
	public int getAmount() 
	{
		return amount;
	}
	public void setAmount(int amount) 
	{
		this.amount = amount;
	}
	
	public String toString() {
		return "userName:" + userName + ", userid:" + userid + ", hotelname:" + hotelname + ", amount:"
				+ amount;
	}
    
	
    
}
