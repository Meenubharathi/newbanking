package pack2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class  ListProgram
{
     public static void main(String[] args)
     {
    	 ListProgram lp=new ListProgram();
    	Scanner input=new Scanner(System.in); 
    	System.out.println("Enter size of list1");
    	int num1=input.nextInt();
    	System.out.println("Enter size of list2");
    	int num2=input.nextInt();
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
    	System.out.println("Enter list1");
    	for(int i=0;i<num1;i++)
    	{
    		list1.add(input.nextInt());
    	}
    	System.out.println("Enter list1");
    	for(int i=0;i<num2;i++)
    	{
    		list2.add(input.nextInt());
    	}
    	List<Integer> union=lp.fullList(list1,list2);
    	System.out.println(union);
    	
    	List<Integer> except=lp.exception(list1, list2);
    	System.out.println(except);
    	List<Integer> intersect=lp.intersection(list1, list2);
    	System.out.println(intersect);
    
     }
     public List<Integer> fullList(List<Integer> list1,List<Integer> list2)
     {
    	 Set<Integer> set=new HashSet<>();
    	 set.addAll(list1);
    	 set.addAll(list2);
    	 List<Integer> list = new ArrayList<>(set);
     	 return list;
     }
     public List<Integer> intersection(List<Integer> list1,List<Integer> list2)
     {
    	 list1.retainAll(list2);
    	 return list1;
     }
     public List<Integer> exception(List<Integer> list1,List<Integer> list2)
     {
    	 List<Integer> list=new ArrayList<>();
    	 int size1=list1.size();
    	 for(int i=0;i<size1;i++)
    	 {
    		 if(list1.get(i)%2==0)
    		 {
    			 list.add(list1.get(i));
    			 //System.out.println(list);
    		 }
    	 }
    	 int size2=list2.size();
    	 for(int i=0;i<size2;i++)
    	 {
    		 if(list2.get(i)%2!=0)
    		 {
    			 list.add(list2.get(i));
    		 }
    	 }
    	 return list;
     }
   
}
