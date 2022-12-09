package pack2;

import java.util.Scanner;

public class PrintPattern
{
    public static void main(String[] args)
    {
    	PrintPattern print = new PrintPattern();
    	Scanner input=new Scanner(System.in);
   	    System.out.println("Enter number of elements:");
   	    int num=input.nextInt();
   	    System.out.println("Enter elements");
   	 	 int[] arr =new int[num];
   	 	 for(int i=0;i<num;i++)
   	 	 {
   	 		 arr[i]=input.nextInt();
   	 	 }
   	 	 print.printPattern(arr, num);
   
    }
    public void printPattern(int[] arr,int num)
    {
       for(int i=0;i<5;i++)
       {
    	   int n=i;
    	   for(int j=0;j<=i;j++)
    	   {
    		   System.out.print(arr[n]+" ");
    		   n=n+4-j;
    	   }
    	   System.out.println();
       }
    }
}
