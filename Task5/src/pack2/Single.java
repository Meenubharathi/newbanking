package pack2;

import java.util.Scanner;

public class Single 
{
	public static void main(String[] args)
	{
      Single one=new Single();
	  Scanner input=new Scanner(System.in);
	  System.out.println("Enter number:");
	  int num=input.nextInt();
	  int[] ch=new int[num];
	  System.out.println("Enter array of character:");
 	  for(int i=0;i<num;i++)
	  {
	  ch[i]=input.nextInt();
	  }
 	  int result=one.single(ch);
 	  System.out.println(result);

	}
	public int single(int[] num)
	{
		int j=0;
		int answer=0;
		int len=num.length;
		for(int i=0;i<len;i++)
		{
			int count=0;
			for(j=0;j<len;j++) 
			{
				if(num[i]==num[j])
				{
					count++;
					
				}
			}
			if(count==1)
			{
				answer=num[i];
			}
		}
		return answer;
	}
}
