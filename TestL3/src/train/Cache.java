package train;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cache 
{
	int num=1000;
    Map<Integer,String> map=new HashMap<>();
   // Map<String,List<TrainDetails>> details=new LinkedHashMap<>();
    public void login()
    {
    	map.put(101, "tt001");
    	map.put(102, "tt002");
    	map.put(103, "tt003");
    	map.put(104, "tt004");
    	map.put(105, "tt005");
    }
    public boolean loginCheck(int id,String password)
    {
    	login();
    	boolean check=false;
    	if(map.containsKey(id))
    	{
    		if(password.equals(map.get(id)))
    		{
    			check=true;
    		}
    	}
    	return check;
    }
    
    public String pnrCode()
    {
    	 num=num+1;
    	String code="FE"+num+"SJ";
    	return code;
    }
}
