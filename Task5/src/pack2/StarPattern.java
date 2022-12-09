package pack2;

public class StarPattern 
{
   public static void main(String[] args)
   {
	   int num=5;
	   right(num);
	   left(num);
	   pyramid(num);
	   diamond(num);
	   rightPascal(num);
	    sandGlass(num);
	    triangle(num);
	    emptydiamond(num);

   }

public static void emptydiamond(int num)
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
			System.out.print("*");
			}
			else
			{
				System.out.print(" ");
			}
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
		for(int j=1;j<=2*(num-i)-1;j++)
		{
			if(j==1||j==2*(num-i)-1)
			{
				System.out.print("*");
			}
			else
			{
				System.out.print(" ");
			}
		}
		System.out.println();
	}
}

public static void triangle(int num)
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
			if(j==1||i==num||j==2*i-1)
			{
			System.out.print("*");
			}
			else
			{
				System.out.print(" ");
			}
		}
		System.out.println();
	}
}

public static void sandGlass(int num) 
{
		for(int i=0;i<=num-1;i++)
		{
			for(int j=0;j<i;j++)
			{
				System.out.print(" ");
			}
			for(int j=0;j<=num-i-1;j++)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
		for(int i=1;i<=num;i++)
		{
			for(int j=num-i;j>0;j--)
			{
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
}

public static void rightPascal(int num)
{
	for(int i=1;i<=num;i++)
	{
		for(int j=1;j<=i;j++)
		{
			System.out.print("* ");
		}
		System.out.println();
	}
	for(int i=1;i<=num-1;i++)
	{
		for(int j=num-1;j>=i;j--)
		{
			System.out.print("* ");
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
		for(int j=1;j<=(2*i)-1;j++)
		{
			System.out.print("*");
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
		for(int j=1;j<=2*(num-i)-1;j++)
		{
			System.out.print("*");
		}
		System.out.println();
	}
}

public static void pyramid(int num) 
{
	for(int i=1;i<=num;i++)
	{
		for(int j=num-i;j>0;j--)
		{
			System.out.print(" ");
		}
		for(int j=1;j<=i;j++)
		{
			System.out.print("* ");
		}
		System.out.println();
	}
}

public static void left(int num) 
{
	for(int i=1;i<=num;i++)
	{
		for(int j=2*(num-i);j>0;j--)
		{
			System.out.print(" ");
		}
		for(int j=1;j<=i;j++)
		{
			System.out.print("* ");
		}
		System.out.println();
	}
}

public static void right(int num)
{
	for(int i=1;i<=num;i++)
	{
		for(int j=1;j<=i;j++)
		{
			System.out.print("* ");
		}
		System.out.println();
	}
}
}
