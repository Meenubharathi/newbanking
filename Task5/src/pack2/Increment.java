package pack2;

import java.util.Scanner;

public class Increment
{
	public static void main(String[] args)
	{
	  Increment incre=new Increment();
	  Scanner input=new Scanner(System.in);
	  System.out.println("Enter number:");
	  int num=input.nextInt();
	  int[] ch=new int[num];
	  System.out.println("Enter array of character:");
 	  for(int i=0;i<num;i++)
	  {
	  ch[i]=input.nextInt();
	  }
 	  int[] result=incre.increment(ch);
 	  int len=result.length;
 	  for(int i=0;i<len;i++)
 	  {
 	 System.out.println(result[i]);
 	  }
	}
	public int[] increment(int[] num)
	{
		int n=0;
		for(int a:num)
			{
			  n=n*10+a;
			}
		int value=n+1;
		int len=num.length;
		  int[] arr=new int[len];
		  for(int i=len-1;i>=0;i--)
		  {
		      int a=value%10;
		       arr[i]=a;
		      value=value/10;
		  }
		  return arr;
		  
		/*String str=String.valueOf(n1);
		int len=str.length();
		int arr[]=new int[len];
		for(int i=0;i<len;i++)
		{
			arr[i]=str.charAt(i)-'0';
		}
		return arr;*/
	}
}
