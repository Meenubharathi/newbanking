package pack2;

import java.util.Scanner;

public class MergeSorting 
{
    public static void main(String[] args)
    {
    	MergeSorting merge=new MergeSorting();
    	Scanner input=new Scanner(System.in);
    	System.out.println("Enter number of elements:");
   	    int num=input.nextInt();
   	    System.out.println("Enter elements");
   	    int[] arr =new int[num];
   	    for(int i=0;i<num;i++)
   	    {
   	        arr[i]=input.nextInt();
   	    }
   	    merge.sort(arr,0, num-1);
   	    for(int n:arr)
   	    {
   	    	System.out.print(n+" ");
   	    }
    }
   public void sort(int[] arr,int i,int j)
   {
	   if(i<j)
	   {
		   int mid=(i+j)/2;
		   sort(arr,i,mid);
		   sort(arr,mid+1,j);
		   mergeSort(arr,i,mid,j);
	   }
   }
   public void mergeSort(int[] arr, int low, int mid, int high) 
   {
	int i=low;
	int j=mid+1;
	int k=low;
	int[] b=new int[arr.length];
	while(i<=mid && j<=high)
	{
		if(arr[i]<arr[j])
		{
			b[k]=arr[i];
			i++;
			k++;
		}
		else
		{
			b[k]=arr[j];
			j++;
			k++;
		}
	}
	while(i<=mid)
	{
		b[k]=arr[i];
		i++;
		k++;
	}
	while(j<=high)
	{
		b[k]=arr[j];
		j++;
		k++;
	}
	for(i=low;i<=high;i++)
	{
		arr[i]=b[i];
	}
	
}
}
