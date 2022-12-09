package pack2;

import java.util.Scanner;

public class InsertionSort 
{
	 public static void main(String[] args)
	    {
	    	InsertionSort insert=new InsertionSort();
	    	Scanner input=new Scanner(System.in);
	    	System.out.println("Enter number of elements:");
	   	    int num=input.nextInt();
	   	    System.out.println("Enter elements");
	   	    int[] arr =new int[num];
	   	    for(int i=0;i<num;i++)
	   	    {
	   	        arr[i]=input.nextInt();
	   	    }
	   	    int[] result=insert.insertion(arr, num);
	   	    for(int n:result)
	   	    {
	   	    	System.out.print(n+" ");
	   	    }
	   	
	    }
	 public int[] insertion(int[] arr,int num)
	 {
		for(int i=1;i<num;i++)
		{
			int x=arr[i];
			int j=i-1;
			while(j>=0&&arr[j]>x)
			{
				arr[j+1]=arr[j];
				j=j-1;
			}
			arr[j+1]=x;
		}
		 return arr;
	 }
}
