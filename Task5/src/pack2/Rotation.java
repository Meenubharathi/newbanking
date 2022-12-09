package pack2;

import java.util.Scanner;

public class Rotation 
{
	    static Scanner inp=new Scanner(System.in);
        public static void main(String[] args)
        {
	        System.out.println("Enter the sentence:");
	        String st1=inp.nextLine();
	        System.out.println("Enter the new sentence:");
	        String st2=inp.nextLine();
	        String st3=st1+st1;
	        if(st3.contains(st2))
	        {
	        	System.out.println("yes");
	        }
	        else
	        {
	        	System.out.println("no");
	        }
        }
}
