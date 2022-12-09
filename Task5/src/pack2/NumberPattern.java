package pack2;

public class NumberPattern
{
   public static void main(String[] args)
   {
	   int num=5;
	   simple(num);
	   pascal(num);
	   diamond(num);
	   fulldiamond(num);
   }

public static void fulldiamond(int num) 
{
	int space=num-1;
	for(int i=1;i<=num;i++)
	{
		for(int j=1;j<=space;j++)
		{
			System.out.print(" ");
		}
		space--;
		for(int j=i;j>=1;j--)
		{
			System.out.print(j);
		}
		for(int j=2;j<=i;j++)
		{
			System.out.print(j);
		}
		System.out.println();
	}
	space=1;
	for(int i=1;i<=num-1;i++)
	{
		for(int j=1;j<=space;j++)
		{
			System.out.print(" ");
		}
		space++;
		for(int j=num-i;j>=1;j--)
		{
			System.out.print(j);
		}
		for(int j=2;j<=num-i;j++)
		{
			System.out.print(j);
		}
		System.out.println();
	}
}

public static void diamond(int num)
{
	int space=num-1;
	for(int i=1;i<=num;i++)
	{
		for(int j=1;j<=space;j++)
		{
			System.out.print(" ");
		}
		space--;
		for(int j=1;j<=2*i-1;j++)
		{
			if(j==1||j==2*i-1)
			{
			System.out.print(i);
			}else
			{
				System.out.print(" ");
			}
		}
		System.out.println();
	}
	space=1;
	for(int i=1;i<=num;i++)
	{
		for(int j=1;j<=space;j++)
		{
			System.out.print(" ");
		}
		space++;
		for(int j=1;j<=2*(num-i)-1;j++)
		{
			if(j==1||j==2*(num-i)-1)
			{
			System.out.print(num-i);
			}else 
			{
				System.out.print(" ");
			}
		}
		System.out.println();
	}
}

public static void pascal(int num) 
{
	//int ans=1;
	for(int i=1;i<=num;i++)
	{   int ans=1;
		for(int j=num-i;j>0;j--)
		{
			System.out.print(" ");
		}
		for(int j=1;j<=i;j++)
		{
			System.out.print(ans+" ");
			ans=ans*(i-j)/j;
		}
		System.out.println();
	}
}

public static void simple(int num)
{
	for(int i=1;i<=num;i++)
	{
		for(int j=1;j<=i;j++)
		{
			System.out.print(j+" ");
		}
		System.out.println();
	}
}

}
