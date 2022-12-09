package pack2;

import java.util.Scanner;

public class Unique 
{
     public static void main(String[] args)

     {
    	 Scanner input=new Scanner(System.in);
    	 System.out.println("Enter the string:");
    	 String st=input.next();
    	 int len=st.length();
    	 char[] ch=new char[len];
    	 ch=st.toCharArray();
    	 for(int i=0;i<len;i++)
    	 {
    		 int count1=0;
        	 int count2=0;
    		 for(int j=0;j<len;j++)
    		 {
    			 if(ch[i]==ch[j])
    			 {
    				 count1++;
    			 }
    			 else
    			 {
    				 count2++;
       			 }
    			
    		 }
    		 if(count1==1 && count2!=0)
    		 {
    			 System.out.println(ch[i]);
    			 return;
    		 }
    	 }
    	System.out.println("no match found");    			 
     }
}
