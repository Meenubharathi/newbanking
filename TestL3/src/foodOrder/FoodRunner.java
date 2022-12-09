package foodOrder;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FoodRunner implements Serializable
{
    public static void main(String[] args) throws ClassNotFoundException
    {
    	Scanner input=new Scanner(System.in);
    	UserPojo user=new UserPojo();
    	FoodMethod method=new FoodMethod();
    	logical logic=new logical();
    	try 
    	{
    		boolean ans=true;
    		while(ans)
    		{
    		System.out.println("Enter 1 for Signup \n"
    				+ "Enter 2 for Login \n"
    				+ "enter 3 for Exit ");
    		int enter =input.nextInt();
    		input.nextLine();
    		switch(enter)
    		{
    		case 1:
    			System.out.println("Enter name:");
    			String name=input.next();
    			user.setName(name);
    			System.out.println("Enter age:");
    		    int age=input.nextInt();
    		    user.setAge(age);
    		    System.out.println("Enter email:");
    		    String mail=input.next();
    		    user.setEmail(mail);
    		    boolean che=true;
    		    while(che)
    		    {
    		    	System.out.println("Enter password:");
        		    String pw=input.next();
        		    String pattern="\\w{5,10}";
        		    boolean answ=Pattern.matches(pattern, pw);
        		    if(answ)
        		    {
        		    	user.setPassword(pw);
        		    	che=false;
        		    }
        		    else
        		    {
        		    	System.out.println("password should contain atleast 5 characters(no&alp)");
        		    	che=true;
        		    }
    		    }
    		        		    
    		    
    		    System.out.println("Enter mobile number:");
    		    long number=input.nextLong();
    		    user.setMobile(number);
    		    logic.setDetails(user);
    		    System.out.println(logic.getDetails());
    			break;
    		case 2:
    			System.out.println("Enter email");
    			String email=input.next();
    			System.out.println("Enter password");
    			String password=input.next();
    			boolean check=logic.login(email, password);
    			if(check)
    			{
    				System.out.println("successfully logged in");
    				System.out.println("\nEnter 1 for hotel \n"
    						+ "Enter 2 for food");
    				int num=input.nextInt();
    				if(num==1)
    					{
    					Map<Integer,String> map=logic.hotelList();
    					for(Map.Entry<Integer, String> entry:map.entrySet())
    					{
    						System.out.println(entry.getValue());
    					}
    					System.out.println("\n Enter hotel name");
    					String hn=input.next();
    					Map<Integer,String> food=logic.foodList(hn);
    					for(Map.Entry<Integer, String> entry:food.entrySet())
    					{
    						System.out.println(entry.getKey()+" "+entry.getValue());
    					}
    					}
    				if(num==2)
    				{
    					Map<Integer,String> allFood=logic.allFood();
    					for(Map.Entry<Integer, String> entry:allFood.entrySet())
    					{
    						System.out.println(entry.getKey()+" "+entry.getValue());
    					}
    				}
    				System.out.println("Enter number");
    				int count=input.nextInt();
    				int[] arr=new int[count];
    				for(int i=0;i<count;i++)
    				{
    					arr[i]=input.nextInt();
    				}
    				int total=logic.total(arr);
    				System.out.println("Total amount is"+total);
    			}
    			else
    			{
    				System.out.println("sorry,try again");
    			}
    			break;
    		}
    		}
    		
    	}
    	catch(InputMismatchException ex)
    	{
    		
    	}
    }
}
