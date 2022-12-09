package pack2;

import java.util.Scanner;

public class ClockwiseRotate 
{
     public static void main(String[] args)
     {
    	 ClockwiseRotate clock=new ClockwiseRotate();
    	 Scanner input=new Scanner(System.in);
    	 System.out.println("Enter number of elements");
    	 int num=input.nextInt();
    	 System.out.println("Enter elements");
    	 int[] arr =new int[num];
    	 for(int i=0;i<num;i++)
    	 {
    		 arr[i]=input.nextInt();
    	 }
    	 System.out.println("Enter number of rotation");
    	 int r=input.nextInt();
    	 int[] result=clock.rotation(num,arr,r);
    	 for(int ans:result)
    	 {
    	 System.out.print(ans+" ");
    	 }
    	 
     }
     public int[] rotation(int num,int[] arr,int r)
     {
    	 int temp=0;
    	 for(int i=0;i<r;i++)
    	 {
    		 for(int j=0;j<num;j++)
    		 {
    		 temp=arr[num-1];
    		 arr[num-1]=arr[j];
    		 arr[j]=temp;
    		 //System.out.println(arr[j]+" ");
    		 }
    	 }
    	 
    	 return arr;
     }
}
