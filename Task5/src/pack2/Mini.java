package pack2;

import java.util.Scanner;

public class Mini 
{
	public static void main(String[] args)
	{
		Mini min=new Mini();
	  Scanner input=new Scanner(System.in);
	  System.out.println("Enter number:");
	  int num=input.nextInt();
	  int[] ch=new int[num];
	  System.out.println("Enter array of character:");
 	  for(int i=0;i<num;i++)
	  {
	  ch[i]=input.nextInt();
	  }
 	  int result=min.mini(ch);
 	  for(int i=0;i<result;i++)
 	  {
 	  System.out.print(ch[i]+" ");
 	  }

	}
	public int mini(int[] num)
	{   
		int j=0;
		int len=num.length;
		if(num[len-1]>num[0]  && num[0]<num[1])
		{
			num[j++]=num[0];
		}
		if(num[len-2]>num[len-1] && num[len-1]<num[0])
		{
			num[j++]=num[len-1];
			//System.out.println(num[len-1]);
		}
		for(int i=1;i<len;i++)
		{
			
			if(i+1<len && num[i-1]>=num[i]  && num[i]<=num[i+1])
			{
				num[j++]=num[i];
			}
		}
		
			return j;
	}
	 
}
