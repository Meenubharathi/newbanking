package pack2;

import java.util.Scanner;

public class SelectionSort
{
    public static void main(String[] args)
    {
    	SelectionSort select=new SelectionSort();
    	Scanner input=new Scanner(System.in);
    	System.out.println("Enter number of elements:");
   	    int num=input.nextInt();
   	    System.out.println("Enter elements");
   	    int[] arr =new int[num];
   	    for(int i=0;i<num;i++)
   	    {
   	        arr[i]=input.nextInt();
   	    }
   	    int[] result=select.selection(arr, num);
   	    for(int n:result)
   	    {
   	    	System.out.print(n+" ");
   	    }
   	
    }
    public int[] selection(int[] arr,int num)
    {
    	int temp=0;
    	for(int i=0;i<num;i++)
    	{
    		for(int j=i;j<num;j++)
    		{
    			if(arr[i]>arr[j])
    			{
    				temp=arr[i];
    				arr[i]=arr[j];
    				arr[j]=temp;
    			}
    		}
    	}
    	return arr;
    }
}
