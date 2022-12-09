package pack2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MisMatch 
{
    public static void main(String[] args)
    {
    	MisMatch mis=new MisMatch();
    	Scanner input=new Scanner(System.in);
    	System.out.println("enter number of elements");
    	int num=input.nextInt();
    	String[] arr1=new String[num];
    	System.out.println("Enter arr1 elelments");
    	for(int i=0;i<num;i++)
    	{
    		arr1[i]=input.next();
    	}
    	String[] arr2=new String[num];
    	System.out.println("Enter arr2 elelments");
    	for(int i=0;i<num;i++)
    	{
    		arr2[i]=input.next();
    	}
    	List<String> result=mis.mismatch(arr1,arr2,num);
    	System.out.println(result);
    	
    }
    public List<String> mismatch(String[] arr1,String[] arr2,int num)
    {
    	List<String> result=new ArrayList<>();
    	for(int i=0;i<num;i++)
    	{
    		if(!arr1[i].equals(arr2[i]))
    		{
    			String ans=arr1[i].concat(arr2[i]);
    			result.add(ans);
    		}
    	}
    	return result;
    	
    }
}
