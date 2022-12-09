package foodOrder;

import java.util.HashMap;
import java.util.Map;

public class logical 
{
	Map<Integer,String> allfood=new HashMap<>();
	Map<Integer,Integer> allrate=new HashMap<>();
	Map<String,Map<Integer,String>> hotel1=new HashMap<>();
	Map<Integer,String> hotel=new HashMap<>();
	FoodMethod food=new FoodMethod();
	Map<String,UserPojo> userMap=new HashMap<>();
	public void setDetails(UserPojo user)
	{
			userMap=food.readFile();
		    food.createFile(user);
	}
	public Map<String,UserPojo> getDetails()
	{
			userMap=food.readFile();
		    return userMap;
	}
	public boolean login(String email,String password)
	{
		userMap=food.readFile();
		UserPojo up=userMap.get(email);
		String pw=up.getPassword();
		if(password.equals(pw))
		{
			return true;
		}
		return false;
	}
	public Map<Integer,String> hotelList()
	{
		hotel.put(1, "aa");
		hotel.put(2, "bb");
		return hotel;
	}
	public void process()
	{
		Map<Integer,String> food1=new HashMap<>();
		Map<Integer,Integer> rate1=new HashMap<>();
	 food1.put(1, "Sandwich   70");
   	 food1.put(2, "pizza      100");
   	 food1.put(3, "fried Rice 100");
   	 food1.put(4, "parotta    15");
   	 rate1.put(1, 70);
   	 rate1.put(2, 100);
   	 rate1.put(3, 100);
   	 rate1.put(4, 15);
   	Map<Integer,String> food2=new HashMap<>();
	Map<Integer,Integer> rate2=new HashMap<>();
	
   	 food2.put(5, "Noodles      75");
   	 food2.put(6, "Chicken_Rice 80");
   	 food2.put(7, "Chicken_Biriyany 150");
   	 food2.put(8, "Prawn        120");
   	 rate2.put(5, 75);
   	 rate2.put(6, 80);
   	 rate2.put(7, 150);
   	 rate2.put(8, 120);
   	 hotel1.put("aa", food1);
   	 hotel1.put("bb",food2);
   	 
   	 allfood.putAll(food1);
   	 allfood.putAll(food2);
   	 allrate.putAll(rate1);
   	 allrate.putAll(rate2);
   	 }
	
	public Map<Integer,String> foodList(String name)
	{
	    process();
		Map<Integer,String> food=hotel1.get(name);
		return food;
	}
	public Map<Integer,String> allFood()
	{
		process();
	      return allfood;
	}
	public int total(int[] arr)
	{
		int len=arr.length;
		int sum=0;
		for(int i=0;i<len;i++)
		{
			sum+=allrate.get(arr[i]);
		}
		return sum;
	}
	
}
