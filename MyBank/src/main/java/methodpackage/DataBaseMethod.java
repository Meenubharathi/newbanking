package methodpackage;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import exception.CheckException;



public class DataBaseMethod
{
	public void table(String query) throws SQLException             //1
	{  
		try(Connection connect=Database.connection();
	  	 PreparedStatement	statement =connect.prepareStatement(query);)
		{
	         statement.execute(query);
		}
	}
    public String createUserTable()
    {
    	String query="create table USER"+"(CUSTOMER_ID integer(5) NOT NULL,"+"NAME varchar(20) NOT NULL,"
                                        +"EMAIL varchar(30) NOT NULL,"+"PHONE_NO bigint(10) NOT NULL,"
    			                        +"PASSWORD varchar(15) NOT NULL,"+"STATUS varchar(10) NOT NULL,"+"ROLE varchar(15) NOT NULL,"+"PRIMARY KEY (CUSTOMER_ID))";
    	return query;
    }
    public String createCustomerDetailTable()
    {
    	String query="create table CUSTOMER_DETAILS (CUSTOMER_ID integer(5) NOT NULL,ADHAR bigint(15) NOT NULL UNIQUE,PAN varchar(15) NOT NULL UNIQUE,"
     	 		+ "DOB varchar(15) NOT NULL,ADDRESS varchar(100) NOT NULL,PRIMARY KEY (CUSTOMER_ID),FOREIGN KEY (CUSTOMER_ID) REFERENCES USER(CUSTOMER_ID))";
    	return query;
    }
    public String createCustomerAccountDetailTable()
    {
    	String query="create table CUSTOMER_ACCOUNT_DETAILS (CUSTOMER_ID integer(5) NOT NULL,ACCOUNT_NO bigint(20) NOT NULL,"
    			+ "IFSC_CODE varchar(15) NOT NULL,BRANCH varchar(20) NOT NULL,BALANCE bigint(20) NOT NULL,ACCOUNT_TYPE varchar(50) NOT NULL,"
    			+"STATUS varchar(10) NOT NULL,"
    			+ "PRIMARY KEY (ACCOUNT_NO),FOREIGN KEY (CUSTOMER_ID) REFERENCES USER(CUSTOMER_ID))";
     	return query;
    }
    public String createTransactionTable()
    {
        String query="create table TRANSACTION_DETAILS (TRANSACTION_ID integer(5)  AUTO_INCREMENT,CUSTOMER_ID integer(5) NOT NULL,TIME bigint(20) NOT NULL,ACCOUNT_NO bigint(20) NOT NULL,"
        		+ "MODE_OF_TRANSACTION varchar(50) NOT NULL,AMOUNT bigint(10) NOT NULL,CURRENT_BALANCE bigint(10) NOT NULL,"
        		+ "TRANSACTION_ACCOUNT bigint(20) NOT NULL,PRIMARY KEY (TRANSACTION_ID),"
        		+ "FOREIGN KEY (ACCOUNT_NO) REFERENCES CUSTOMER_ACCOUNT_DETAILS (ACCOUNT_NO)) ";
        return query;
    }
    public void insertUserDetails(List<UserDetails> list) throws CheckException
    {
    	String query="insert into USER"+"(CUSTOMER_ID,NAME,EMAIL,PHONE_NO,PASSWORD,STATUS,ROLE)"+"values (?,?,?,?,?,?,?)";
    	 try(Connection connect=Database.connection();
    		  	 PreparedStatement	statement =connect.prepareStatement(query);)
    	        {
    	           for(UserDetails user:list)
    	           {
    	        	   statement.setInt(1,user.getUserId());
    	        	   statement.setString(2, user.getName());
    	        	   statement.setString(3, user.getEmail());
    	        	   statement.setLong(4, user.getPhoneNo());
    	        	   statement.setString(5, user.getPassWord());
    	        	   statement.setString(6, user.getStatus());
    	        	   statement.setString(7,user.getRole());
    	        	   statement.execute();
    	           }
    	        }
    	        catch (SQLException e) 
    	        {
					throw new CheckException("error",e);
				}
    }
    public void insertCustomerDetails(List<CustomerDetails> list) throws CheckException 
    {
    	String query="insert into CUSTOMER_DETAILS"+"(CUSTOMER_ID,ADHAR,PAN,DOB,ADDRESS)"+"values (?,?,?,?,?)";
    	 try(Connection connect=Database.connection();
    		  	 PreparedStatement	statement =connect.prepareStatement(query);)
    	        {
    	           for(CustomerDetails customer:list)
    	           {
    	        	   statement.setInt(1, customer.getCustomerID());
    	        	   statement.setLong(2,customer.getAdharNo());
    	        	   statement.setString(3, customer.getPanNo());
    	        	   statement.setString(4,customer.getDob());
    	        	   statement.setString(5,customer.getAddress());
    	        	   
    	        	   statement.execute();
    	           }
    	        } 
    	   catch (SQLException e) 
    	    {
    		   throw new CheckException("error",e);
    	    }
						
    }
    public void insertCustomerAccountDetails(List<CustomerAccountDetails> list) throws CheckException
    {
    	String query="insert into CUSTOMER_ACCOUNT_DETAILS"+"(CUSTOMER_ID,ACCOUNT_NO,IFSC_CODE,BRANCH,BALANCE,ACCOUNT_TYPE,STATUS)"+"values (?,?,?,?,?,?,?)";
    	 try(Connection connect=Database.connection();
    		  	 PreparedStatement	statement =connect.prepareStatement(query);)
    	        {
    	            for(CustomerAccountDetails acc:list)
    	            {
    	            	statement.setInt(1, acc.getCustomerID());
    	            	statement.setLong(2, acc.getAccountNo());
    	            	statement.setString(3, acc.getIFSCcode());
    	            	statement.setString(4, acc.getBranch());
    	            	statement.setLong(5, acc.getBalance());
    	            	statement.setString(6, acc.getAccountType());
    	            	statement.setString(7, acc.getStatus());
    	            	statement.execute();
    	            }
    	        } catch (SQLException e) 
    	             {
    	        	      throw new CheckException("error",e);
				     }
    }
    public void insertTransactionDetails(List<TransactionDetails> list) throws CheckException
    {
    	String query="insert into TRANSACTION_DETAILS"+"(CUSTOMER_ID,TIME,ACCOUNT_NO,CURRENT_BALANCE,MODE_OF_TRANSACTION,AMOUNT,TRANSACTION_ACCOUNT)"+"values (?,?,?,?,?,?,?)";
    	 try(Connection connect=Database.connection();
    		  	 PreparedStatement	statement =connect.prepareStatement(query);)
    	        {
    		       for(TransactionDetails trans:list)
    		       {   
    		    	   statement.setInt(1, trans.getCustomerId());
    		    	   statement.setLong(2, trans.getTime());
    		    	   statement.setLong(3,trans.getAccountNumber());
    		    	   statement.setLong(4,trans.getCurrent_Balance());
    		    	   statement.setString(5,trans.getModeOfTransaction());
    		    	   statement.setLong(6, trans.getAmount());
    		    	   statement.setLong(7, trans.getTransaction_Account());
    		    	   statement .execute();
    		       }
    	        } catch (SQLException e) 
    	          {
    	        	throw new CheckException("error",e);
				  }
    }
}
