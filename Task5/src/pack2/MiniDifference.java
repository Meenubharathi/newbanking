package pack2;

import java.util.Scanner;

public class MiniDifference 
{
    public static void main(String[] args)
    {
    	MiniDifference mini=new MiniDifference();
    	Scanner input=new Scanner(System.in);
    	 System.out.println("Enter number of elements:");
    	    int num=input.nextInt();
    	    System.out.println("Enter elements");
    	 	 int[] arr =new int[num];
    	 	 for(int i=0;i<num;i++)
    	 	 {
    	 		 arr[i]=input.nextInt();
    	 	 }
    	 	int[] ans=mini.minimumDifference(num, arr);
    	 	for(int n:ans)
    	 	{
    	 		System.out.println(n);
    	 	}
    	 
    }
    public int[] minimumDifference(int num,int[] arr)
    {
    	int min=0;
    	int n=0;
    	int[] ans=new int[2];
    	for(int i=0;i<num;i++)
    	{
    		for(int j=0;j<num;j++)
    		{
    			if(arr[i]<arr[j])
    			{
    			   min=arr[j]-arr[i];
    			  // System.out.println(min+"   i  "+arr[i]+"  j  "+arr[j]);
    			   if(n==0)
    			   {
    				   n=min;
    				  // System.out.println(n);
    			   }else if(n>min)
    			   {
    				   n=min;
    				   ans[0]=arr[i];
    				   ans[1]=arr[j];
    				   
    			   }
    			}
       		}
    	}
    	return ans;
    }
}
