package finallevel2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThreeArray 
{
    public static void main(String[] args)
    {
    	Scanner input=new Scanner(System.in);
    	int[] a= {30,40,50,60,70,85,90};
    	int[] b= {25,50,55,65,85,100};
    	int[] c= {20,25,30,50,60,70,80,85};
    	common(a,b,c);
    }

public static void common(int[] a, int[] b, int[] c) 
{
	/*int[] d=new int[10];
	for(int i=0;i<a.length;i++)	
	{
		for(int j=0;j<b.length;j++)
		{
			if(a[i]==b[j])
			{
				d[i]=a[i];
			}
		}
	}
	for(int i=0;i<d.length;i++)
	{
		for(int j=0;j<c.length;j++)
		{
			if(d[i]==c[j])
			{
				System.out.println(d[i]);
			}
		}
	}*/
	
	int len1=a.length;
	int len2=b.length;
	int len3=c.length;
    List<Integer> list=new ArrayList<>();
    int i=0,j=0,k=0;
    while(i<len1 && j<len2 && k<len3)
    {
    	if(a[i]==b[j] && b[j]==c[k])
    	{
    		list.add(a[i]);
    		i++;j++;k++;
    	}
    	else if(a[i]>b[j])
    	{
    		j++;
    	}
    	else if(b[j]>c[k])
    	{
    		k++;
    	}
    	else
    	{
    		i++;
    	}
    }
   System.out.println(list);
	
}
}
