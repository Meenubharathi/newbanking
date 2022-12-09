package onlinejob;

public class Vaccancies 
{
    private String post;
    private int vaccancy;
    private long salary;
    private String qualification;
    public String getQualification() 
    {
		return qualification;
	}
	public void setQualification(String qualification) 
	{
		this.qualification = qualification;
	}
	public String getPost()
    {
		return post;
	}
	public void setPost(String post)
	{
		this.post = post;
	}
	public int getVaccancy()
	{
		return vaccancy;
	}
	public void setVaccancy(int vaccancy)
	{
		this.vaccancy = vaccancy;
	}
	public long getSalary()
	{
		return salary;
	}
	public void setSalary(long salary) 
	{
		this.salary = salary;
	}
	
	public String toString() {
		return " post=" + post + "\n vaccancy=" + vaccancy + "\n salary=" + salary + "\n qualification=" + qualification;
	}
	
	
}
