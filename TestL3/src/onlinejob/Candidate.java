package onlinejob;

public class Candidate 
{
    
	private String name;
    private String qualification;
   	private long phoneNo;
    private int age;
    private String password;
    private int userId;
  
    public String getPassword() 
    {
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public int getUserId() 
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getQualification()
	{
		return qualification;
	}
	public void setQualification(String qualification)
	{
		this.qualification = qualification;
	}
	public long getPhoneNo()
	{
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo)
	{
		this.phoneNo = phoneNo;
	}
	 public int getAge() 
	 {
			return age;
	 }
	 public void setAge(int age) 
     {
			this.age = age;
	 }
	
	public String toString() {
		return "\n name=" + name + "\n qualification=" + qualification + "\n phoneNo=" + phoneNo + "\n age=" + age;
	}
		
		
}
