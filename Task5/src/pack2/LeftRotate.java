package pack2;

import java.util.Scanner;

public class LeftRotate 
{
   public static void main(String[] args)
   {
	   LeftRotate left =new LeftRotate();
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
  	 int[] result=left.rotation(num,arr,r);
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
	   for(int j=0;j<num-1;j++)
		 {
		 temp=arr[j];
		 arr[j]=arr[j+1];
		 arr[j+1]=temp;
		 }
    	 }
	   return arr;
   }
}
