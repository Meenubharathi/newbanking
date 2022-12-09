package finallevel2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sum 
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
	   int sum=3;
	   findsumlist(arr,num,sum);
	   
   }

public static void findsumlist(int[] arr, int num, int sum)
{
	//int[] ans=new int[num];
	List<Integer> list=new ArrayList<Integer>();
	for(int i=0;i<num;i++)
	{
		if(arr[i]%sum==0)
		{
		    list.add(arr[i]);
		}
	}
	for(int i=0;i<list.size();i++)
	{
		for(int j=i+1;j<list.size();j++)
		{
		int add=list.get(i)+list.get(j);
		if(add%sum==0)
		{
			System.out.println(list.get(i)+","+list.get(j));
		}
		}
	}
	for(int i=0;i<list.size()-2;i++)
	{
		for(int j=i+1;j<list.size();j++)
		{
			for(int k=j+1;k<list.size();k++)
			{
		System.out.println(list.get(i)+","+list.get(j)+","+list.get(k));
		}
	}
	}
	
}
}
