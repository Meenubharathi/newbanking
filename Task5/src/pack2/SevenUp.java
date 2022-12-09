package pack2;

import java.util.Scanner;

public class SevenUp 
{
	public static void main(String[] args)
	{
      SevenUp seven = new SevenUp();
	  Scanner input=new Scanner(System.in);
	  System.out.println("Enter number:");
	  int num=input.nextInt();
	  int[] ch=new int[num];
	  System.out.println("Enter array of character:");
 	  for(int i=0;i<num;i++)
	  {
	  ch[i]=input.nextInt();
	  }
 	  int result=seven.sevenUp(ch);
 	  for(int i=0;i<result;i++)
 	  {
 	  System.out.print(ch[i]+" ");
 	  }

	}
	public int sevenUp(int[] num)
	{
		int j=0;
		int len=num.length;
		num[j++]=num[0];
		for(int i=0;i<len;i++)
		{
			if(i+1<len && num[i]%7==0)
			{
				num[j++]=num[i+1];
			}
		}
		return j;
	}
}
