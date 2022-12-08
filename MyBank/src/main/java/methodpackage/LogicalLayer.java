package methodpackage;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Clock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import exception.CheckException;



public class LogicalLayer
{
   /* public boolean setUserLogin(int userID,String userPassword) throws SQLException
    {
    	        String password="PASSWORD";
    	    	boolean check = false;
    	         if(userID==100&&userPassword.equals(password))
    	        		{
    	        	       check=true;
    	        		}
    	        		
    	       return check;
    	    	
    }*/
    public Map<Integer,UserDetails> getAllUserDetails() throws CheckException
    {
    	Map<Integer,UserDetails> map=new HashMap<>();
        String query1="select * from USER";
    	try(Connection connect1=Database.connection();
    	      PreparedStatement	statement1 =connect1.prepareStatement(query1);ResultSet result=statement1.executeQuery();)
    	       	   {
    	       	    while(result.next())
    	    	    {
    	     	    	UserDetails user=new UserDetails();
    	       	    	user.setUserId(result.getInt(1));
    	       	    	user.setName(result.getString(2));
    	       	    	user.setEmail(result.getString(3));
    	       	    	user.setPhoneNo(result.getLong(4));
    	       	    	user.setPassWord(result.getString(5));
    	       	    	user.setStatus(result.getString(6));
    	       	    	map.put(result.getInt("CUSTOMER_ID"), user);
    	    	   
    	    	    }
    	       	   } 
    	           catch (SQLException e)
    	                {
    	        	        throw new CheckException("error",e);
						}
    	return map;
    }
    public Map<Long,CustomerAccountDetails> getAllAccountDetails() throws CheckException
    {
       	Map<Long,CustomerAccountDetails> map1=new HashMap<>();
      	 String query="select * from CUSTOMER_ACCOUNT_DETAILS" ;
    	 try(Connection connect=Database.connection();
       		  	 PreparedStatement	statement =connect.prepareStatement(query);ResultSet result=statement.executeQuery();)
         	{
         		while(result.next())
         		{
         	        CustomerAccountDetails acc=new CustomerAccountDetails();
         			acc.setCustomerID(result.getInt(1));
         		    acc.setAccountNo(result.getLong(2));
         		    acc.setIFSCcode(result.getString(3));
         		    acc.setBranch(result.getString(4));
         		    acc.setBalance(result.getLong(5));
         			acc.setAccountType(result.getString(6));
         			acc.setStatus(result.getString(7));
         			map1.put(result.getLong("ACCOUNT_NO"),acc);
          	    	
         	    		  
         		}
         		return map1;
         	} catch (SQLException e)
    	      {
         		throw new CheckException("error",e);
			  }
     }
    public Map<Integer,CustomerDetails> getAllPersonalDetails() throws CheckException
    {

     	Map<Integer,CustomerDetails> map=new HashMap<>();
    	String query="select * from USER INNER JOIN CUSTOMER_DETAILS ON USER.CUSTOMER_ID=CUSTOMER_DETAILS.CUSTOMER_ID";
    	try(Connection connect=Database.connection();
   		  	 PreparedStatement	statement =connect.prepareStatement(query);ResultSet result=statement.executeQuery();)
     	{
     		while(result.next())
     		{
     	   		CustomerDetails details=new CustomerDetails();
     	   	    details.setUserId(result.getInt(1));
   	    	    details.setName(result.getString(2));
   	    	    details.setEmail(result.getString(3));
   	    	    details.setPhoneNo(result.getLong(4));
   	    	    details.setPassWord(result.getString(5));
   	    	    details.setStatus(result.getString(6));
   	    	    details.setRole(result.getString(7));
     	   		details.setCustomerID(result.getInt(8));
     	    	details.setAdharNo(result.getLong(9));
     	    	details.setPanNo(result.getString(10));
     	    	details.setDob(result.getString(11));
     	    	details.setAddress(result.getString(12));
     	    
     	    	map.put(result.getInt("CUSTOMER_ID"),details);
     		}
     		
     	  } catch (SQLException e)
    	        {
     		           throw new CheckException("error",e);
				}
    	return map;
    }
    public boolean setCustomerLogin(int userId,String userPassword) throws CheckException
    {
    	String password=getPassword(userId);
    	boolean check=false;
    	if(userPassword.equals(password))
    	{
    		check=true;
    	}
    	return check;
    }
 public Map<Integer,UserDetails> setUserCustomer(int id) throws CheckException
  {
    		    Map<Integer,UserDetails> map=new HashMap<>();	    
    	             	String  query1="select * from USER where CUSTOMER_ID= "+id+"";
    	       	     try(Connection connect=Database.connection();
    	       		  	 PreparedStatement	statement =connect.prepareStatement(query1);)
    	       	     {
    	       		try(ResultSet result=statement.executeQuery())
    	       	    {
    	       	    while(result.next())
    	    	        {
    	    		   	UserDetails user=new UserDetails();
    	       	    	user.setUserId(result.getInt(1));
    	       	    	user.setName(result.getString(2));
    	       	    	user.setEmail(result.getString(3));
    	       	    	user.setPhoneNo(result.getLong(4));
    	       	    	user.setPassWord(result.getString(5));
    	       	    	user.setStatus(result.getString(6));
    	       	    	map.put(user.getUserId(), user);
    	    	        }
    	    	      }
    	       	   } catch (SQLException e) 
    	       	     {
    	       		     throw new CheckException("error",e);
				     }
        	  		return map;
  }
    	 
    
    public Map<Long,CustomerAccountDetails> getAccountDetails(int id) throws CheckException
    {
    		//Map<Integer,Map<Long,CustomerAccountDetails>> map=new HashMap<>();
    	Map<Long,CustomerAccountDetails> map1=new HashMap<>();
       	 String query="select*from CUSTOMER_ACCOUNT_DETAILS where CUSTOMER_ID= "+id+" AND STATUS LIKE 'ACTIVE'";
     	 try(Connection connect=Database.connection();
        		  	 PreparedStatement	statement =connect.prepareStatement(query);ResultSet result=statement.executeQuery();)
          	{
          		while(result.next())
          		{
          	    	CustomerAccountDetails acc=new CustomerAccountDetails();
         			acc.setCustomerID(result.getInt(1));
         		    acc.setAccountNo(result.getLong(2));
         		    acc.setIFSCcode(result.getString(3));
         		    acc.setBranch(result.getString(4));
         		    acc.setBalance(result.getLong(5));
         			acc.setAccountType(result.getString(6));
         			acc.setStatus(result.getString(7));
          	    	map1.put(acc.getAccountNo(), acc);	  
          		}
          	
          	} catch (SQLException e) 
     	    {
          		throw new CheckException("error",e);
			}
     	return map1;
    }
   
 
   public Map<Integer,CustomerDetails> getPersonalDetails(int id) throws CheckException
    {
    	Map<Integer,CustomerDetails> map=new HashMap<>();
    	String query="select * from CUSTOMER_DETAILS where CUSTOMER_ID= "+id+"";
    	try(Connection connect=Database.connection();
   		  	 PreparedStatement	statement =connect.prepareStatement(query);ResultSet result=statement.executeQuery();)
     	{
     		while(result.next())
     		{
     			CustomerDetails details=new CustomerDetails();
     			details.setCustomerID(result.getInt(1));
     	    	details.setAdharNo(result.getLong(2));
     	    	details.setPanNo(result.getString(3));
     	    	details.setDob(result.getString(4));
     	    	details.setAddress(result.getString(5));
     	    	map.put(result.getInt("CUSTOMER_ID"),details);
     		}
     		return map;
     	} catch (SQLException e)
    	{
     		throw new CheckException("error",e);
		}
    
    }
   /* public String deleteRow(int id) throws SQLException                           
    {
   	 String query="delete from USER where CUSTOMER_ID = "+id+"";
   	try(Connection connect=Database.connection();
   	  	 PreparedStatement	statement =connect.prepareStatement(query);)
   		{
   	         statement.execute(query);
   		}
   	 return query;
    }*/
    public long milliseconds()
    {
 	  
    	Clock clock=Clock.systemDefaultZone();
    	long milliSecond=clock.millis();
 	    return milliSecond;
    }
	public long credit(long amount,long accNo) throws CheckException
	{   long acc_no=present(accNo);
        long balance =getBalance(acc_no);
	    balance=balance+amount;
	    return balance;
	}
    public long debit(long amount,long accNo) throws CheckException
    {
    	long acc_no=present(accNo);
    	  long balance =getBalance(acc_no);
 	     if(balance>=1000)
 	     { 
 	    	 if(amount<balance)
 		        {
 		                balance=balance-amount;
 	                    if(balance<1000)
 	                    return balance;
 	            }
 	     }
 	     return balance;
    } 
   
    public long getBalance(long accNo) throws CheckException
    {
    	String query="select BALANCE from CUSTOMER_ACCOUNT_DETAILS  where ACCOUNT_NO="+accNo+"";
    	long balance = 0;
    	try(Connection connect=Database.connection();
      		  	 PreparedStatement	statement =connect.prepareStatement(query);ResultSet result=statement.executeQuery();)
        	{
        		while(result.next())
        		{
        			balance=result.getLong("BALANCE");
        		}
            } catch (SQLException e)
    	    {
            	throw new CheckException("error",e);
			}
    	return balance;
    }
   public long getcusId(long accNo) throws CheckException
    {
    	String query="select CUSTOMER_ID from CUSTOMER_ACCOUNT_DETAILS  where ACCOUNT_NO="+accNo+"";
    	int id = 0;
    	try(Connection connect=Database.connection();
      		  	 PreparedStatement	statement =connect.prepareStatement(query);ResultSet result=statement.executeQuery();)
        	{
        		while(result.next())
        		{
        			id=result.getInt("CUSTOMER_ID");
        		}
            } catch (SQLException e) 
    	    {
            	throw new CheckException("error",e);
			}
    	return id;
    }

    public void update(long oldValue,long newValue) throws CheckException         //4
    {
   	 String query="update CUSTOMER_ACCOUNT_DETAILS set BALANCE = "+newValue+" where BALANCE = "+oldValue+"";
   	
   	 try(Connection connect=Database.connection();
   		  	 PreparedStatement	statement =connect.prepareStatement(query);)
   	    {
   		     statement.executeUpdate();
   	    } catch (SQLException e) 
   	    {
   	    	throw new CheckException("error",e);
		}
     }
    public long present(long accNo) throws CheckException
    {
    	String query="SELECT ACCOUNT_NO FROM CUSTOMER_ACCOUNT_DETAILS  WHERE ACCOUNT_NO="+accNo+"";
    	long acc_no=0;
    	try(Connection connect=Database.connection();
     		  	 PreparedStatement	statement =connect.prepareStatement(query);ResultSet result=statement.executeQuery();)
    
    	{
       		while(result.next())
       		{
       			acc_no=result.getLong("ACCOUNT_NO");
       		}
        } catch (SQLException e) 
    	{
        	throw new CheckException("error",e);
		}
   	return acc_no;
    }
   
    public boolean presentadhar(long adhar) throws CheckException
    {
    	String query="SELECT ADHAR FROM CUSTOMER_DETAILS";
        List<Long> adharNo=new ArrayList<>();
        boolean check=false;
    	try(Connection connect=Database.connection();
     		  	 PreparedStatement	statement =connect.prepareStatement(query);ResultSet result=statement.executeQuery();)
    
    	{
       		while(result.next())
       		{
       			adharNo.add(result.getLong("ADHAR"));
       			check=adharNo.contains(adhar);
       		}
       		return check;
       	} catch (SQLException e) 
    	{
        	throw new CheckException("error",e);
		}
   	    
    }
    public boolean presentPan(String pan) throws CheckException
    {
    	String query="SELECT PAN FROM CUSTOMER_DETAILS";
    	List<String> panNo=new ArrayList<>();
    	boolean check=false;
       	try(Connection connect=Database.connection();
     		  	 PreparedStatement	statement =connect.prepareStatement(query);ResultSet result=statement.executeQuery();)
    
    	{
       		while(result.next())
       		{
       			panNo.add(result.getString("PAN"));
       			check=panNo.contains(pan);
       		}
       		return check;
        } catch (SQLException e) 
    	{
        	throw new CheckException("error",e);
		}
    }
   public String getPassword(int id) throws CheckException
   {
	   String query ="select PASSWORD from USER where CUSTOMER_ID="+id+"";
   	String password = null ;
   	try(Connection connect=Database.connection();
     		  	 PreparedStatement	statement =connect.prepareStatement(query);ResultSet result=statement.executeQuery();)
       	{
       		while(result.next())
       		{
       			password=result.getString("PASSWORD");
       		}
       	} catch (SQLException e) 
   	    {
       		throw new CheckException("error",e);
		}
   	return password;
     }
   public String getRole(int id) throws CheckException
   {
	   String query ="select ROLE from USER where CUSTOMER_ID="+id+"";
   	String role= null ;
   	try(Connection connect=Database.connection();
     		  	 PreparedStatement	statement =connect.prepareStatement(query);ResultSet result=statement.executeQuery();)
       	{
       		while(result.next())
       		{
       			role=result.getString("ROLE");
       		}
       	} catch (SQLException e)
   	    {
       		throw new CheckException("error",e);
		}
   	return role;
     }

   public void updateUserDetails(String field,Object value,int id) throws CheckException
   {
	   String query="update USER set "+field+" = ? where CUSTOMER_ID="+id+"";
	   try(Connection connect=Database.connection();
  		  	 PreparedStatement	statement =connect.prepareStatement(query);)
  	 {
  		statement.setObject(1,value);
  			statement.executeUpdate();
  	 } catch (SQLException e)
	   {
  		throw new CheckException("error",e);
	   }
   }
   
  /* public void updateAccountDetails(String field,String value,long accNo) throws SQLException
   {
	   String query="update CUSTOMER_ACCOUNT_DETAILS set "+field+" = ? where ACCOUNT_NO="+accNo+"";
	   try(Connection connect=Database.connection();
  		  	 PreparedStatement	statement =connect.prepareStatement(query);)
  	 {
  		statement.setString(1,value);
  			statement.executeUpdate();
  	 }
   }*/
   public void updatePersonalDetails(String field,String value,int id) throws CheckException
   {
	   String query="update CUSTOMER_DETAILS set "+field+" = ? where CUSTOMER_ID="+id+"";
	   try(Connection connect=Database.connection();
  		  	 PreparedStatement	statement =connect.prepareStatement(query);)
  	 {
  		    statement.setObject(1,value);
  			statement.executeUpdate();
  	 } catch (SQLException e)
	   {
  		throw new CheckException("error",e);
	   }
   }
   public Map<Long,List<TransactionDetails>> lastTransaction(long accNo) throws CheckException
   {
	   Map<Long,List<TransactionDetails>> map=new HashMap<>();
	  List<TransactionDetails> list=new ArrayList<TransactionDetails>();
	   String query="select * from TRANSACTION_DETAILS where ACCOUNT_NO="+accNo+" ";
	   try(Connection connect=Database.connection();
   		  	 PreparedStatement	statement =connect.prepareStatement(query);ResultSet result=statement.executeQuery();)
     	{
     		while(result.next())
     		{
     		     TransactionDetails trans=new TransactionDetails();
     		     trans.setTransactionId(result.getInt(1));
                 trans.setCustomerId(result.getInt(2));
                 trans.setTime(result.getLong(3));
                 trans.setAccount_Number(result.getLong(4));
                 trans.setModeOfTransaction(result.getString(5));
                 trans.setAmount(result.getLong(6));
                 trans.setCurrent_Balance(result.getLong(7));
                 trans.setTransaction_Account(result.getLong(8));
                 list.add(trans);
                 map.put(accNo,list);
     		}
     		return map;
     	} catch (SQLException e) 
	    {
     		throw new CheckException("error",e);
		}
   }
  /* public String getStatus(long accNo ) throws SQLException
   {
	   String query="select STATUS from CUSTOMER_ACCOUNT_DETAILS where ACCOUNT_NO="+accNo+"";
	   String status = null;
	   try(Connection connect=Database.connection();
   		  	 PreparedStatement	statement =connect.prepareStatement(query);ResultSet result=statement.executeQuery();)
     	{
     		while(result.next())
     		{
     			status=result.getString("STATUS");
     		}
     	}
 	return status;
     }*/
   
  /* public String getUserStatus(int id) throws SQLException
   {
	   String query="select STATUS from CUSTOMER_ACCOUNT_DETAILS where CUSTOMER_ID="+id+"";
	   String status = null;
	   try(Connection connect=Database.connection();
   		  	 PreparedStatement	statement =connect.prepareStatement(query);ResultSet result=statement.executeQuery();)
     	{
     		while(result.next())
     		{
     			status=result.getString("STATUS");
     		}
     	}
 	return status;
 
   }*/

 
    }
    

