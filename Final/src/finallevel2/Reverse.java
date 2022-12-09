package finallevel2;

import java.util.Scanner;

public class Reverse 
{
     public static void main(String[] args)
     {
    	 Scanner input=new Scanner(System.in);
    	 System.out.println("Enter  Sentence");
    	 String st=input.nextLine();
    	
    	 reverse(st);
    			 
     }

	public static void reverse(String st) 
	{
		int len=st.length();
		System.out.println(len);
		char[] ch=st.toCharArray();
		int start=0;
		int end=len-1;
		while(start<end)
		{
		if(!((ch[start] >= '0' && ch[start] <= '9') || (ch[start] >= 'a' && ch[start] <= 'z')
					|| (ch[start] >= 'A' && ch[start] <= 'Z')) )
		{
			start++;
			continue;
		}
		
		else if(!((ch[end] >= '0' && ch[end] <= '9') || (ch[end] >= 'a' && ch[end] <= 'z')
				|| (ch[end] >= 'A' && ch[end] <= 'Z') ))
		{
			end--;
			continue;
		}
		else
		{
			char temp=ch[start];
			ch[start]=ch[end];
			ch[end]=temp;
			start++;
			end--;
		}
		}
		String c=new String(ch);
		System.out.println(c);
	}
}
