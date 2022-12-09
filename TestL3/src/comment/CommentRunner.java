package comment;

import java.util.Scanner;

public class CommentRunner
{
    public static void main(String[] args)
    {
    	CommentMethod method=new CommentMethod();
    	Scanner input=new Scanner(System.in);
    	boolean check=true;
    	while(check)
    	{
    		System.out.println("Enter Commands");
    		String command=input.next();
    		switch(command)
    		{
    		case "SET":
    			String name=input.next();
    			int value=input.nextInt();
    			method.set(name, value);
    			break;
    		case "GET":
    			name=input.next();
    			value=method.get(name);
    			if(value==0)
    			{
    				System.out.println("NULL");
    			}
    			else
    			{
    				System.out.println(value);
    			}
    			break;
    		case "UNSET":
    			 name=input.next();
     			 method.unset(name);
    			break;
    		case "NUMEQUALTO":
    			value=input.nextInt();
    			int count=method.numEqualTo(value);
    			System.out.println(count);
    			break;
    		case "END":
    			check=false;
    			break;
    		case "BEGIN":
    			
    			break;
    		case "ROLLBACK":
    			break;
    		case "COMMIT":
    			break;
    			
    		}
    	}
    			
    }
}
