package methodpackage;

public class UserDetails
{
    private int  userId;
    private String name;
    private String email;
    private long phoneNo;
    private String passWord;
    private String status;
    public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	private String role;
    public String getStatus() 
    {
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public void setUserId(int userId)
    {
    	this.userId=userId;
    }
    public int getUserId()
    {
    	return userId;
    }
    public void setName(String name)
    {
    	this.name=name;
    }
    public String getName()
    {
    	return name;
    }
    public void setEmail(String email)
    {
    	this.email=email;
    }
    public String getEmail()
    {
    	return email;
    }
    public void setPhoneNo(long phNo)
    {
    	this.phoneNo=phNo;
    }
    public long getPhoneNo()
    {
    	return phoneNo;
    }
    public void setPassWord(String passWord)
    {
    	this.passWord=passWord;
    }
    public String getPassWord()
    {
    	return passWord;
    }
    public String toString()
    {
    	return "CUSTOMER_ID: " +this.userId+ " ,NAME: " +this.name+ " ,Email: " +this.email+ " ,PHONE_NO: " +this.phoneNo+ " ,PASSWORD: " +this.passWord+
    			" ,STATUS: " +this.status+ " ,ROLE: " +this.role;
    }
}
