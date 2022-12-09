package train;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TrainRunner 
{
	static Scanner input=new Scanner(System.in);
    public static void main(String[] args)
    {
    	Cache base=new Cache();
    	TickectDetails ticket=new TickectDetails();
    	Ticket available=new Ticket();
    	System.out.println("Enter ID:");
    	int num=input.nextInt();
    	System.out.println("Enter password:");
    	String pw=input.next();
    	try
    	{
    	boolean ans=base.loginCheck(num, pw);
    	if(!ans)
    	{
    		System.out.println("Incorrect ID or Password");
    	}
    	while(ans)
    	{
    	System.out.println("Enter 1:booking \n"
    			+ "Enter 2:cancellation \n"
    			+ "Enter 3:Exit");
    	int choice=input.nextInt();
    	input.nextLine();
    	switch(choice)
    	{
    	case 1:
    		List<TrainDetails> list=new ArrayList<>();
    		System.out.println("Enter Train Number:");
    		long number=input.nextLong();
    		ticket.setTrainNo(number);
    		System.out.println("Enter Train Name:");
    		String trainName=input.next();
    		ticket.setTrainName(trainName);
    		Map<String,Integer> map=available.availablity(number,trainName);
    		if(!map.isEmpty())
    		{
    		for(Map.Entry<String, Integer> entry:map.entrySet())
    		{
    			 System.out.println(entry.getKey()+"   "+entry.getValue());
    		}
    		System.out.println();
    		System.out.println("Enter of Ticket Booking");
    		int count=input.nextInt();
    		if(count<=4)
    		{
    		for(int i=0;i<count;i++)
    		{
    		TrainDetails tt=new TrainDetails();
    		System.out.println("Enter date of journey:");
    		String date=input.next();
    		tt.setDate(date);
    		System.out.println("Enter from place:");
    		String from=input.next();
    		tt.setFromPlace(from);
    		System.out.println("Enter to place:");
    		String to=input.next();
    		tt.setToPlace(to);
    		System.out.println("Enter Name:");
    		String name=input.next();
    		tt.setName(name);
    		System.out.println("Enter Age:");
    		int age=input.nextInt();
    		tt.setAge(age);
    		System.out.println("Enter Gender (Male or Female):");
    		String gender=input.next();
    		tt.setGender(gender);
    		System.out.println("Enter berth (Upper,Middle,Lower):");
    		String berth=input.next();
    		String message=available.booking(berth, tt);
    		System.out.println(message);
    		list.add(tt);
    		}
    		String pnr=base.pnrCode();
    		System.out.println("Your PNR Code is "+pnr);
    		System.out.println(list);
    		Map<String,List<TrainDetails>> passmapMap=available.getPassenger(pnr, list);
    		}else
    		{
    			System.out.println("4 tickets only");
    		}
    		}
    		else
    		{
    			System.out.println("Please check your train number.");
    		}
      		break;
    	case 2:
    		System.out.println("Enter PNR Code");
    		String code=input.next();
    		List<TrainDetails> details=available.getDetails(code);
    		System.out.println(details);
    		System.out.println("press 1 to confirm cancellation");
    		int confirm=input.nextInt();
    		if(confirm==1)
    		{
    			System.out.println(available.cancel(code));
    		}
    		break;
    	case 3:
    		ans=false;
    		break;
    	
    	}
    	}
    	}
    	catch(InputMismatchException ex)
    	{
    		
    	}
    	
    }
}
