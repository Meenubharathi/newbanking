package pack2;

import java.util.Scanner;

public class BubbleSort
{
	public static void main(String[] args)
    {
    	BubbleSort bubble=new BubbleSort();
    	Scanner input=new Scanner(System.in);
    	System.out.println("Enter number of elements:");
   	    int num=input.nextInt();
   	    System.out.println("Enter elements");
   	    int[] arr =new int[num];
   	    for(int i=0;i<num;i++)
   	    {
   	        arr[i]=input.nextInt();
   	    }
   	    int[] result=bubble.bubbleSort(arr, num);
   	    for(int n:result)
   	    {
   	    	System.out.print(n+" ");
   	    }
   	
    }
 public int[] bubbleSort(int[] arr,int num)
 {
	 int temp=0;
 
	 for(int i=0;i<num;i++)
	 {
		 for(int j=0;j<num-i-1;j++)
		 {
			if(arr[j]>arr[j+1])
			{
				temp=arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=temp;
			}
		 }
		/* if(arr[i]>arr[i+1])
		 {
			 temp=arr[i];
			 arr[i]=arr[i+1];
			 arr[i+1]=temp;
		 }
		 */
	 }
	 return arr;
}
}
