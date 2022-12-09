package pack2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Ascending
{
     public static void main(String[] args)
     {
    	 Ascending asc=new Ascending();
    	 Scanner input=new Scanner(System.in);
    	 System.out.println("Enter number of elements:");
    	 int num=input.nextInt();
    	 System.out.println("Enter elements");
    	 int[] arr =new int[num];
    	 for(int i=0;i<num;i++)
    	 {
    	    arr[i]=input.nextInt();
    	 }
    	 int[] result=asc.ascending(num,arr);
    	 for(int i=num-1;i>=0;i--)
    	 {
    	 System.out.println(result[i]+" ");
    	 }
    	 
     }
     public int[] ascending(int num,int[] arr)
     {
    	 Map<Integer,Integer> map=new HashMap<>();
    	 List<Integer> list=new ArrayList<Integer>();
    	 int[] result=new int[num];
    	 int ans=0;
    	 for(int i=0;i<num;i++)
    	 {
    		 	 if(arr[i]<99)
    			 {
    			 int value=arr[i]%10;
    			 int value1=arr[i]/10;
    			 ans=value+value1;
    			
    			 }
    			 if(arr[i]<999)
    			 {
    				 int value=arr[i]%100;
    				 int value1=value%10;
    				 int value2=value/10;
        			 int value3=arr[i]/100;
        			 ans=value1+value2+value3;
        		 }
    			 if(arr[i]<9999)
    			 {
    				 int value=arr[i]%1000;
    				 int value1=value%100;
    				 int value2=value%10;
    				 int value3=value1/10;
    				 int value4=value/100;
    				 int value5=arr[i]/1000;
    				 ans=value2+value3+value4+value5;
    			 }
    			 map.put(arr[i], ans);
    		 }
    	 System.out.println(map);
    	 int temp=0;
    	 for(int i=0;i<num;i++)
    	 {
    		 for(int j=0;j<num;j++)
    		 {
    			 int n1=map.get(arr[i]);
    			 int n2=map.get(arr[j]);
    			 if(n1>n2)
    			 {
    				 temp=arr[i];
    				 arr[i]=arr[j];
    				 arr[j]=temp;
    			 }
    		 }
    	 }
    	 return arr;
     }
}
