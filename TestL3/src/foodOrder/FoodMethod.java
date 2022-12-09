package foodOrder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class FoodMethod implements Serializable
{
	Map<String,UserPojo> map=new HashMap<>();
       public void createFile(UserPojo user)
     {
    	map.put(user.getEmail(), user);
    	try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("Order.ser"));)
    	{
    		oos.writeObject(map);
     	} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
     }
     
	public Map<String,UserPojo> readFile() 
     {
    	 try(ObjectInputStream ios=new ObjectInputStream(new FileInputStream("Order.ser"));)
    	 {
    		 map=(Map<String,UserPojo>) ios.readObject();
    	 } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	 
    	 return map;
     }
 
}
