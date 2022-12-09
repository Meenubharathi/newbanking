package pack2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class NumberTimes 
{
	public static void main(String[] args)
	{
	NumberTimes count=new NumberTimes();
	Scanner input=new Scanner(System.in);
    System.out.println("Enter number of elements:");
    int num=input.nextInt();
    System.out.println("Enter elements");
 	 int[] arr =new int[num];
 	 for(int i=0;i<num;i++)
 	 {
 		 arr[i]=input.nextInt();
 	 }
 	 count.numberCount(arr, num);
 	 
 
	}
	public void numberCount(int[] arr,int num)
	{
		List<String> result=new ArrayList<>();
		for(int i=0;i<num;i++)
		{
			int count=0;
			for(int j=0;j<num;j++)
			{
			   if(arr[i]==arr[j])
			   {
				  count++;
			   }
			}
			 result.add(arr[i]+"-"+count);
		}
		Set<String> set=new HashSet<String>(result);
		System.out.println(set);
		 
		
	}
    
}
