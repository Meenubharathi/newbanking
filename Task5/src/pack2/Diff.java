package pack2;

import java.util.Arrays;
import java.util.Scanner;

public class Diff 
{
    public static void main(String[] args)
    {
    	Diff diff=new Diff();
    	Scanner input=new Scanner(System.in);
    	System.out.println("Enter the size of array:");
    	int num=input.nextInt();
    	System.out.println("Enter elements:");
    	int[] arr=new int[num];
    	for(int i=0;i<num;i++)
    	{
    		arr[i]=input.nextInt();
    	}
    	System.out.println("Enter no of students:");
    	int stu=input.nextInt();
    	int ans=diff.difference(num,arr,stu);
    	System.out.println("the minimum difference between min and max chocolate is"+ans);
    }
    public int difference(int num,int[] arr,int stu)
    {
    	
    	Arrays.sort(arr);
    	int[] res=new int[num-stu+1];
    	for(int i=0;i<=num-stu;i++)
    	{
    	    res[i]=arr[i+stu-1]-arr[i];
    	}
    	int ans=res[0];
    	for (int j = 1; j < res.length; j++)
    	{
    	   ans = Math.min(ans, res[j]);
    	}
       	return  ans;
    }
}
