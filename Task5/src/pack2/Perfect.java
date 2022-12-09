package pack2;

import java.util.Scanner;

public class Perfect 
{
    public static void main(String[] args)
    {
    	Perfect per=new Perfect();
    	Scanner input=new Scanner(System.in);
    	System.out.println("Enter a single digit");
    	int num=input.nextInt();
    	int ans=per.perfect(num);
    	System.out.println(ans);
    }
    public int perfect(int num)
    {
    	int ans=0;
    	int temp=10-num;
    	ans=(num*10)+temp;
    	return ans;
    }
}
