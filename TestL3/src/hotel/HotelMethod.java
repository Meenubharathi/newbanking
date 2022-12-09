package hotel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HotelMethod 
{
	
	Map<Integer,HotelPojo> map=new HashMap<>();
	HotelPojo pojo=new HotelPojo();
	HotelPojo pojo1=new HotelPojo();
	HotelPojo pojo2=new HotelPojo();
    
	public Map<Integer,HotelPojo> details()
   {
      pojo.setHotelName("aa"); 
	  pojo.setLocation("madurai");
	  pojo.setNoOfRooms(2);
	  pojo.setRating(5);
	  pojo.setRoomPrice(200);
	  map.put(1, pojo);
	  pojo1.setHotelName("cc");
	  pojo1.setLocation("chennai");
	  pojo1.setNoOfRooms(3);
	  pojo1.setRating(3);
	  pojo1.setRoomPrice(150);
	  map.put(2, pojo1);
	  pojo2.setHotelName("bb");
	  pojo2.setLocation("karaikudi");
	  pojo2.setNoOfRooms(4);
	  pojo2.setRating(4);
	  pojo2.setRoomPrice(100);
	  map.put(3, pojo2);
	  
	  return map;
   }
	
	public Map<Integer,HotelPojo>  sortName()
	{
		List<String> list=new ArrayList<>();
	    map=details();
		Map<String,HotelPojo> map2=new HashMap<>();
		Map<Integer,HotelPojo> ans=new HashMap<>();
		
		int len=map.size();
		for(int i=1;i<len+1;i++)
		{
			HotelPojo a=map.get(i);
			list.add(a.getHotelName());
			map2.put(a.getHotelName(), a);
		}
		Collections.sort(list);
		for(int i=0;i<list.size();i++)
		{
			ans.put(i, map2.get(list.get(i)));
		}
		return ans;
	}
	
	public Map<Integer,HotelPojo> sortRating()
	{
		List<Integer> list=new ArrayList<>();
		Map<Integer,HotelPojo> map1=new HashMap<>();
		Map<Integer,HotelPojo> ans=new LinkedHashMap<>();
		map=details();
		int len=map.size();
		for(int i=1;i<len+1;i++)
		{
			HotelPojo a=map.get(i);
			list.add(a.getRating());
			map1.put(a.getRating(), a);
		}
		Collections.sort(list);
		System.out.println(list);
		for(int i=list.size()-1;i>=0;i--)
		{
			ans.put(i,map1.get(list.get(i)));
		}
		return ans;
	}
	
	public List<HotelPojo> location(String place)
	{
		List<HotelPojo> list=new ArrayList<>();
		map=details();
		int len=map.size();
		for(int i=1;i<len+1;i++)
		{
			HotelPojo a=map.get(i);
			//list.add(a.getLocation());
			if(place.equals(a.getLocation()))
			{
				list.add(a);
			}
		}
		return list;
	}
	
	public Map<Integer,HotelPojo> sortRoom()
	{
		List<Integer> list=new ArrayList<>();
		Map<Integer,HotelPojo> map1=new HashMap<>();
		Map<Integer,HotelPojo> ans=new LinkedHashMap<>();
		map=details();
		int len=map.size();
		for(int i=1;i<len+1;i++)
		{
			HotelPojo a=map.get(i);
			list.add(a.getNoOfRooms());
			map1.put(a.getNoOfRooms(), a);
		}
		Collections.sort(list);
		System.out.println(list);
		for(int i=list.size()-1;i>=0;i--)
		{
			ans.put(i,map1.get(list.get(i)));
		}
		return ans;
	}
	Map<Integer,UserPojo> usermap=new HashMap<>();
	public Map<Integer,UserPojo> userdetails()
	{
		UserPojo user=new UserPojo();
		user.setUserid(1);
		user.setUserName("meenu");
		user.setHotelname("aa");
		user.setAmount(1000);
		usermap.put(1, user);
		
		UserPojo user1=new UserPojo();
		user1.setUserid(2);
		user1.setUserName("bharathi");
		user1.setHotelname("bb");
		user1.setAmount(700);
		usermap.put(2, user1);
		
		UserPojo user2=new UserPojo();
		user2.setUserid(3);
		user2.setUserName("abi");
		user2.setHotelname("cc");
		user2.setAmount(750);
		usermap.put(3, user2);
		
		return usermap;
	}
}
