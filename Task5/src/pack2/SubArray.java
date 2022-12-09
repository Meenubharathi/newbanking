package pack2;

import java.util.Scanner;

public class SubArray
{
       public static void main(String[] args)
       {
    	   SubArray sub=new SubArray();
    	  Scanner input=new Scanner(System.in);
    	  System.out.println("Enter number:");
    	  int num=input.nextInt();
    	  int[] ch=new int[num];
    	  System.out.println("Enter array of character:");
     	 
    	  for(int i=0;i<num;i++)
    	  {
    	  ch[i]=input.nextInt();
    	  }
    	  System.out.println("Enter the sum:");
    	  int sum=input.nextInt();
    	  int[] answer=sub.subArray(ch, num, sum);
    	  //System.out.println(answer);
    	  for(int ch1:answer)
    	   {
    	        System.out.println(ch1);
    	    }
    	  
    	  
    	  
       }
       public int[] subArray(int[] arr,int num,int sum)
       {
    	   
    	   int ans=0;int start=0;int end=0;int result[]=new int[2];
    	   for(int i=0;i<num;i++)
    	   {
    		   for(int j=i;j<num;j++)
    		   {
    		   ans+=arr[j];
    		   if(ans<sum)
    		   {
    			  start=i;
    			  end=j;
    		    }
    		   else if(ans==sum)
    		   {
    			   result[0]=i+1;
    			   result[1]=j+1;
    			   return result;
    		   }
    		   else
    		   {
    			   ans=0;
    			   break;
    		   }
    		   
    	   }
    	   }
    	   result[0]=start;
    	   result[1]=end;
    	 
    	   return result;
       }   
       
}
