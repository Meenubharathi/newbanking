package onlinejob;

public class Company 
{
     private String companyName;
     private String location;
     private long phoneNo;
     private int userid;
     private String password;
     
     
    public String getCompanyName()
    {
		return companyName;
	}
	public void setCompanyName(String companyName) 
	{
		this.companyName = companyName;
	}
	public String getLocation()
	{
		return location;
	}
	public void setLocation(String location)
	{
		this.location = location;
	}
	public long getPhoneNo()
	{
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo)
	{
		this.phoneNo = phoneNo;
	}
	public int getUserid()
	{
		return userid;
	}
	public void setUserid(int userid)
	{
		this.userid = userid;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	public String toString() {
		return "\n companyName:" + companyName + "\n location:" + location + "\n phoneNo:" + phoneNo;
	}
	
	
	
	
}
