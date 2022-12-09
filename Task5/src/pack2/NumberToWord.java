package pack2;

import java.util.Scanner;

public class NumberToWord
{
	public static void main(String args[])
	{
	String[] singledigits = {"", "one", "two",   "three", "four",
                              "five", "six", "seven", "eight", "nine"};
       
	String[] twodigits = {"ten","eleven","twelve", "thirteen",  "fourteen", 
			           "fifteen", "sixteen","seventeen", "eighteen", "nineteen"};
       
	String[] tensmultiple ={"","","twenty",  "thirty", "forty",
                             "fifty", "sixty", "seventy", "eighty", "ninety"};
	
	 String[] tenspower = { "hundred", "thousand" };
	 
	 Scanner input=new Scanner(System.in);
	 String answer="";
	 System.out.println("Enter the number:");
	 int num=input.nextInt();
	 if(num==0)
	 {
		 System.out.println("No Number found");
	 }
	 else
	 {
		 while(num<10000)
		 {
			 if(num>999)
			 {
				 int value=num/1000;
				 answer+=singledigits[value]+" "+tenspower[1]+" ";
				 num=num%1000;
			 }
			 else if(num<=999 && num>=100)
			 {
				 int value=num/100;
				 answer+=singledigits[value]+" "+tenspower[0]+" ";
				 num=num%100;
			 }
			 else if(num<=99 && num>=20)
			 {
				 int value=num/10;
				 answer+=tensmultiple[value]+" ";
				 num=num%10;	
			 }
			 else if(num<=19 && num>=10)
			 {
				 int value=num%10;
				 answer+=twodigits[value];
		    	 break;
			 }
			 else
			 {
				 int value=num;
				 answer+=singledigits[value];
				 break;
				 
			 }
		 }
		 System.out.println(answer);
	 }

	} 
}
