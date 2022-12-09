package pack2;

import java.util.Arrays;
import java.util.Scanner;

public class Sum 
{
   public static void main(String[] args)
   {
	      Sum sum=new Sum();
	      Scanner input=new Scanner(System.in);
		  System.out.println("Enter number:");
		  int num=input.nextInt();
		  int[] ch=new int[num];
		  System.out.println("Enter array of character:");
	 	  for(int i=0;i<num;i++)
		  {
		  ch[i]=input.nextInt();
		  }
	 	  System.out.println("Enter Kth smallest number:");
	 	  int k=input.nextInt();
	 	  System.out.println("Enter Nth largest number:");
	 	  int n=input.nextInt();
	 	  int result=sum.sumOf(ch, k, n);
	 	  System.out.println(result);
  }
   public int sumOf(int[] num,int k,int n)
   {
	   int answer=0;
	   int len=num.length;
	   Arrays.sort(num);
	   int n1=num[k-1];
	   int n2=num[len-n];
	   answer=n1+n2;
	    return answer;
	   
   }
}
