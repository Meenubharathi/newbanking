package hotel;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HotelRunner
{
    
	public static void main(String[] args)
	{
		HotelPojo pojo=new HotelPojo();
		HotelMethod method=new HotelMethod();
		Scanner input=new Scanner(System.in);
		try
		{
			System.out.println("Enter 1 for print hotel data \n"
					+ "Enter 2 for sort hotel by names \n"
					+ "Enter 3 for sort hotel by highest rating \n"
					+ "Enter 4 for print hotel data for the location \n"
					+ "Enter 5 for sort hotel by maximum number of rooms \n"
					+ "Enter 6 for print user booking data");
			int enter=input.nextInt();
			input.nextLine();
			switch(enter)
			{
			case 1:
				Map<Integer,HotelPojo> map=method.details();
				for(Map.Entry<Integer, HotelPojo> entry:map.entrySet())
				{
					System.out.println(entry.getValue());
				}
                break;
			case 2:
				Map<Integer,HotelPojo> map1=method.sortName();
				for(Map.Entry<Integer,HotelPojo> entry:map1.entrySet())
				{
					System.out.println(entry.getValue());
				}
				break;
			case 3:
				Map<Integer,HotelPojo> map2=method.sortRating();
				for(Map.Entry<Integer,HotelPojo> entry:map2.entrySet())
				{
					System.out.println(entry.getValue());
				}
				break;
			case 4:
				System.out.println("Enter location");
				String place=input.next();
				List<HotelPojo> list=method.location(place);
				System.out.println(list);
				break;
			case 5:
				Map<Integer,HotelPojo> map3=method.sortRoom();
				for(Map.Entry<Integer,HotelPojo> entry:map3.entrySet())
				{
					System.out.println(entry.getValue());
				}
				break;
			case 6:
				Map<Integer,UserPojo> map4=method.userdetails();
				for(Map.Entry<Integer, UserPojo> entry:map4.entrySet())
				{
					System.out.println(entry.getValue());
				}
                break;
				
				
				
				
			}
		}catch(InputMismatchException ex)
    	{
    		
    	}
	}
}
