package train;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
//import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Ticket 
{
	 Map<String,List<TrainDetails>> passmap=new HashMap<>();
	 List<Integer> lb1=new ArrayList<>(Arrays.asList(1));
     List<Integer> mb1=new ArrayList<>(Arrays.asList(1));
     List<Integer> ub1=new ArrayList<>(Arrays.asList(1));
     List<Integer> rac1=new ArrayList<>(Arrays.asList(1));
	 List<Integer> wl1=new ArrayList<>();
	 int wl=0;
		     
     public Map<String,Integer> availablity(long trainNumber,String trainName)
     {
    	 Map<String,Integer> map=new LinkedHashMap<>();
    	 if(trainNumber==12345 && trainName.equals("fastExpress"))
    	 {
    	 map.put("Available Lower Berth  1st Class", lb1.size());
    	 map.put("Available Middle Berth 1st Class", mb1.size());
    	 map.put("Available Upper Berth  1st Class", ub1.size());
     	 map.put("Available rac Ticket 1st Class  ", rac1.size());
      	 }
    	 return map;
    	 
     }
     
     public String booking(String berth,TrainDetails train)
     {
    	 String message="";
    		 if(berth.equals("Lower") && lb1.size()>0)
    		 {
    			 int seatNo=lb1.get(0);
    			 train.setSeatNo(lb1.get(0));
    			 train.setBerth("Lower");
    			 message="Successfully Booked,your seat number is "+seatNo+" Lower";
    			 lb1.remove(0);
    		 }
    		 else if(berth.equals("Middle") && mb1.size()>0)
    		 {
    			 train.setSeatNo(mb1.get(0));
    			 train.setBerth("Middle");
    			 message="Successfully Booked,your seat number is "+mb1.get(0)+" Middle";
    			 mb1.remove(0);
    		 }
    		 else if(berth.equals("Upper") && ub1.size()>0)
    		 {
    			 train.setSeatNo(ub1.get(0));
    			 train.setBerth("Upper");
    			 message="Successfully Booked,your seat number is "+ub1.get(0)+" Upper";
    			 ub1.remove(0);
    		 }
    		 else if(lb1.size()>0)
    		 {
    			 int seatNo=lb1.get(0);
    			 train.setSeatNo(lb1.get(0));
    			 train.setBerth("Lower");
    			 message="Successfully Booked,your seat number is "+seatNo+" Lower";
    			 lb1.remove(0);
    		 }
    		 else if(mb1.size()>0)
    		 {
    			 train.setSeatNo(mb1.get(0));
    			 train.setBerth("Middle");
    			 message="Successfully Booked,your seat number is "+mb1.get(0)+" Middle";
    			 mb1.remove(0);
    		 }
    		 else if(ub1.size()>0)
    		 {
    			 train.setSeatNo(ub1.get(0));
    			 train.setBerth("upper");
    			 message="Successfully Booked,your seat number is "+ub1.get(0)+" Upper";
    			 ub1.remove(0);
    		 }
    		 else if(rac1.size()>0)
    		 {
    			 train.setSeatNo(rac1.get(0));
    			 train.setBerth("rac");
    			 message="berth not available,rac is given "+rac1.get(0);
    			 rac1.remove(0);
       		 }
    		 
    		 else
    		 {
    			 wl++;
    			 train.setSeatNo(0);
    			 train.setBerth("waiting list");
    			 message="You are in waiting List";
    		 }
    		 return message;
     }
    
public Map<String,List<TrainDetails>> getPassenger(String pnr,List<TrainDetails> list)
{
	passmap.put(pnr, list);
	return passmap;
}
public List<TrainDetails> getDetails(String pnr)
{
	List<TrainDetails> list=passmap.get(pnr);
	return list;
}
public String cancel(String pnr)
{
	List<TrainDetails> list=getDetails(pnr);
	int len=list.size();
	for(int i=0;i<len;i++)
	{
		TrainDetails train=list.get(i);
		int number=train.getSeatNo();
		String berth=train.getBerth();
		if(berth.equals("Lower"))
		{
			lb1.add(number);
		}
		if(berth.equals("Middle"))
		{
			mb1.add(number);
		}
		if(berth.equals("Upper"))
		{
			ub1.add(number);
		}
		if(berth.equals("rac"))
		{
			rac1.add(number);
		}
		else
		{
			wl--;
		}
	}
	passmap.remove(pnr);
	String message="Cancellation successfull";
	return message;
}

}



/* List<Integer> lb2=new ArrayList<>(Arrays.asList(6,7,8,9,10));
List<Integer> mb2=new ArrayList<>(Arrays.asList(16,17,18,19,20));
List<Integer> ub2=new ArrayList<>(Arrays.asList(26,27,28,29,30));
List<Integer> rac2=new ArrayList<>(Arrays.asList(36,37,38,39,40));*/

/* map.put("Avaliable Lower Berth  2nd Class", lb2.size());
map.put("Avaliable Middle Berth 2nd Class", mb2.size());
map.put("Avaliable Upper Berth  2nd Class", ub2.size());
map.put("Available rac Ticket  2nd Class ", rac2.size());*/



    	/* else if(classType.equals("2ndclass"))
    	 {
    		 if(berth.equals("Lower") && lb2.size()>0)
    		 {
    			 train.setSeatNo(lb2.get(0));
    			 lb2.remove(0);
    			 message="Successfully Booked,your seat number is "+lb2.get(0)+" Lower";
    		 }
    		 else if(berth.equals("Middle") && mb2.size()>0)
    		 {
    			 train.setSeatNo(mb2.get(0));
    			 mb2.remove(0);
    			 message="Successfully Booked,your seat number is "+mb2.get(0)+" Middle";
    		 }
    		 else if(berth.equals("Upper") && ub2.size()>0)
    		 {
    			 train.setSeatNo(ub2.get(0));
    			 ub2.remove(0);
    			 message="Successfully Booked,your seat number is "+ub2.get(0)+" Upper";
    		 }
    		 else if(lb2.size()>0)
    		 {
    			 train.setSeatNo(lb2.get(0));
    			 lb2.remove(0);
    			 message="Successfully Booked,your seat number is "+lb2.get(0)+" Lower";
    		 }
    		 else if(mb2.size()>0)
    		 {
    			 train.setSeatNo(mb2.get(0));
    			 mb2.remove(0);
    			 message="Successfully Booked,your seat number is "+mb2.get(0)+" Middle";
    		 }
    		 else if(ub2.size()>0)
    		 {
    			 train.setSeatNo(ub2.get(0));
    			 ub2.remove(0);
    			 message="Successfully Booked,your seat number is "+ub2.get(0)+" Upper";
    		 }
    		 else if(rac2.size()>0)
    		 {
    			 train.setSeatNo(rac2.get(0));
    			 rac2.remove(0);
    			 message="berth not available,rac is given "+rac2.get(0);
    		 }
    		 else
    		 {
    			 message="seats not available in this berth,kindly select breth again.";
    		 }
    	 }*/
    
