package train;

public class TrainDetails 
{
	public String toString() {
		return "\n TrainDetails [Name=" + name + "\n Age=" + age + "\n Gender=" + Gender 
				+ "\n Berth=" + berth + "\n Date=" + date + "\n FromPlace=" + fromPlace + "\n ToPlace=" + toPlace
				+ "\n SeatNo=" + seatNo + "]";
	}
	private String name;
	private int age;
    private String Gender;
    private String berth;
    private String date;
	private String fromPlace;
	private String toPlace;
	private int seatNo;
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public String getName() 
    {
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getAge() 
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public String getGender()
	{
		return Gender;
	}
	public void setGender(String gender) 
	{
		Gender = gender;
	}
	public String getBerth()
	{
		return berth;
	}
	public void setBerth(String berth) 
	{
		this.berth = berth;
	}
	public String getDate()
	{
		return date;
	}
	public void setDate(String date) 
	{
		this.date = date;
	}
	public String getFromPlace()
	{
		return fromPlace;
	}
	public void setFromPlace(String fromPlace) 
	{
		this.fromPlace = fromPlace;
	}
	public String getToPlace()
	{
		return toPlace;
	}
	public void setToPlace(String toPlace)
	{
		this.toPlace = toPlace;
	}

	
}
