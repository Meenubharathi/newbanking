package comment;

import java.util.HashMap;
import java.util.Map;

public class CommentMethod 
{
    Map<String,Integer> map=new HashMap<>();
    public void set(String name,int value)
    {
    	map.put(name, value);
    	System.out.println(map);
    }
    public int get(String name)
    { 
    	int value=0;
    	if(map.containsKey(name))
    	{
    	 value=map.get(name);
    	}
    	else
    	{
    		return 0;
    	}
    			
    	return value;
    }
    public void unset(String name)
    {
    	map.remove(name);
    }
    public int numEqualTo(int value)
    { 
    	int count=0;
    	for(Map.Entry<String,Integer> entry:map.entrySet())
    	{
    		int value1=entry.getValue();
    		if(value==value1)
    		{
    			count++;
    		}
    	}
    	return count;
    }
    
    
}
