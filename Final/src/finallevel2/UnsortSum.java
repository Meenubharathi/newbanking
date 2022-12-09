package finallevel2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class UnsortSum 
{
    public static void main(String[] args)
    {
    Scanner input=new Scanner(System.in);
 	   System.out.println("Enter number of elements");
 	   int num=input.nextInt();
 	   int[] arr=new int[num];
 	   System.out.println("enter numbers");
 	   for(int i=0;i<num;i++)
 	   {
 		   arr[i]=input.nextInt();
 	   }
 	   System.out.println("Enter sum");
 	   int sum=input.nextInt();
 	  List<List<Integer>> list=fun(arr,sum);
 	  System.out.println(list);
    }

   
    
    public static List<List<Integer>> fun(int[] arr,int sum)
    {
  	  List<List<Integer>> list=new LinkedList<>();
  	  int len=arr.length;
  	  for(int i=0;i<len;i++)
  	  {
  		  List<Integer> list1=new ArrayList<>();
  		  int ans=0;
  		  ans+=arr[i];
  		  if(ans<sum)
  		  {
  			  list1.add(arr[i]);
  			  for(int j=i+1;j<len;j++)
  			  {
  				  if(ans<sum)
  				  {
  					  ans+=arr[j];
  					  list1.add(arr[j]);
  				  }
  				 
  				  else
  				  {
  					  ans=0;
  					  list1.clear();
  					  break;
  				  }
  				 if(ans==sum)
				  {
					  list.add(list1);
					  ans=0;
					  break;
				  }
  				  
  			  }
  		  }
  		  else if(ans==sum)
  		  {
  			  list1.add(arr[i]);
  			  list.add(list1);
  		  }
  	  }
  	  return list;
  	  
    }
}
		
	

