package onlinejob;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class OnlineJobMethod 
{
	
      public void table(String query) throws SQLException
      {
    	  try(Connection connect=Database.connect();
    	  PreparedStatement statement=connect.prepareStatement(query))
    	  {
    		  statement.execute(query);
    	  }
      }
      public String candidateDetails()
      {
    	  String query="create table CandidateDetails"+"(CANDIDATE_ID integer(5) AUTO_INCREMENT NOT NULL,"+"NAME varchar(20) NOT NULL,"
    	  		+"PHONENO bigint(10) NOT NULL,"+"QUALIFICATION varchar(20) NOT NULL,"+"USER_ID integer(5) NOT NULL UNIQUE,"+"PASSWORD varchar(10) NOT NULL,"
    	  					+"AGE integer(2) NOT NULL,"+"PRIMARY KEY(CANDIDATE_ID))";
    	  return query;
      }
      public String CompanyDetails()
      {
    	  String query ="create table CompanyDetails"+"(COMPANY_ID integer(5) AUTO_INCREMENT NOT NULL,"+"NAME varchar(20) NOT NULL,"+"LOCATION varchar(20) NOT NULL,"+
                         "PHONENO bigint(10) NOT NULL,"+"USER_ID integer(5) NOT NULL,"+"PASSWORD varchar(10) NOT NULL,"
                         		+ "PRIMARY KEY(COMPANY_ID))";
    	  return query;
      }
      public String vaccancy()
      {
    	  String query="create table vacancy"+"(COMPANY_ID integer(5) NOT NULL,"+"POST varchar(20) NOT NULL,"
    	  		+ "VACCANCY integer(4) NOT NULL,"+"SALARY bigint(10) NOT NULL,"+"QUALIFICATION varchar(10) NOT NULL,"
    			  +"FOREIGN KEY(COMPANY_ID) REFERENCES CompanyDetails(COMPANY_ID))";
    	  return query;
      }
      public void insertCandidateDetails(List<Candidate> list) throws SQLException
      {
    	  String query="insert into CandidateDetails"+"(NAME,PHONENO,QUALIFICATION,USER_ID,PASSWORD,AGE)"+"values (?,?,?,?,?,?)";
    	  try(Connection connect=Database.connect();
    			  PreparedStatement statement=connect.prepareStatement(query);)
    	  {
    		  for(Candidate candi:list)
    		  {
    			  statement.setString(1, candi.getName());
    			  statement.setLong(2,candi.getPhoneNo());
    			  statement.setString(3,candi.getQualification());
    			  statement.setInt(4,candi.getUserId());
    			  statement.setString(5, candi.getPassword());
    			  statement.setInt(6, candi.getAge());
    			  statement.execute();
    		  }
    	  }
    	  
      }
      public String getPassword(int id) throws SQLException
      {
   	   String query ="select PASSWORD from CandidateDetails where USER_ID="+id+"";
      	String password = null ;
      	try(Connection connect=Database.connect();
        		  	 PreparedStatement	statement =connect.prepareStatement(query);ResultSet result=statement.executeQuery();)
          	{
          		while(result.next())
          		{
          			password=result.getString("PASSWORD");
          		}
          	}
      	return password;
        
      }
      public String getQualification(int id) throws SQLException
      {
   	   String query ="select QUALIFICATION from CandidateDetails where USER_ID="+id+"";
      	String qual = null ;
      	try(Connection connect=Database.connect();
        		  	 PreparedStatement	statement =connect.prepareStatement(query);ResultSet result=statement.executeQuery();)
          	{
          		while(result.next())
          		{
          			qual=result.getString("QUALIFICATION");
          		}
          	}
      	return qual;
        
      }
      public String getQualification1(String post) throws SQLException
      {
    	  //int id=getCompanyId(post);
    	 String query ="select QUALIFICATION from vacancy where POST='"+post+"'";
      	 String qual = null ;
      		try(Connection connect=Database.connect();
        		  	 PreparedStatement	statement =connect.prepareStatement(query);ResultSet result=statement.executeQuery();)
          	{
          		while(result.next())
          		{
          			qual=result.getString("QUALIFICATION");
          		}
          	}
      	return qual;
        
      }
      public Map<Integer,Candidate> getCandidateDetails(int id,String password) throws SQLException
      {
    	  Map<Integer,Candidate> map=new HashMap<>();
    	  String pw=getPassword(id);
    	  //System.out.println(pw);
    	  if(pw.equals(password))
    	  {
    		  String query="select * from CandidateDetails where USER_ID=? and PASSWORD=?";
    		  try(Connection connect=Database.connect();
    				  PreparedStatement statement=connect.prepareStatement(query);)
    		  {
    		     statement.setInt(1, id);
    		     statement.setString(2, password);
    		     try(ResultSet result=statement.executeQuery())	  
    		     {
    			    while(result.next())
    			    {
    				   Candidate candi=new Candidate();
    				   candi.setName(result.getString("NAME"));
    				   candi.setPhoneNo(result.getLong("PHONENO"));
    				   candi.setQualification(result.getString("QUALIFICATION"));
    				   candi.setAge(result.getInt("AGE"));
    				   map.put(id, candi);
    			    }
    		     }
    		  }
    	  }
    	  else
    	  {
    		  System.out.println("incorrect password");
    	  }
    	  return map;
    	  
      }
      
      public void insertCompanyDetails(Company com,List<Vaccancies> list) throws SQLException
      {
    	  String query="insert into CompanyDetails"+"(NAME,LOCATION,PHONENO,USER_ID,PASSWORD)"+"values(?,?,?,?,?)";
    	  int id=0;
    	  try(Connection connect=Database.connect();
    			PreparedStatement statement=connect.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);)
    	  {
    		 	  statement.setString(1,com.getCompanyName());
    			  statement.setString(2, com.getLocation());
    			  statement.setLong(3,com.getPhoneNo());
    			  statement.setInt(4,com.getUserid());
    			  statement.setString(5, com.getPassword());
    			  statement.execute();
    			  try(ResultSet result=statement.getGeneratedKeys();)
    			  {
    				  while(result.next())
    				  {
    					  id=result.getInt(1);
    					  insertVacancy(list,id);
    				  }
    				 
    				  
    			  }
    		  
    	  }
      }
      
      public String getPassword1(int id) throws SQLException
      {
   	   String query ="select PASSWORD from CompanyDetails where USER_ID="+id+"";
      	String password = null ;
      	try(Connection connect=Database.connect();
        		  	 PreparedStatement	statement =connect.prepareStatement(query);ResultSet result=statement.executeQuery();)
          	{
          		while(result.next())
          		{
          			password=result.getString("PASSWORD");
          		}
          	}
      	return password;
        
      }
      public Map<Integer,Company> getCompanyDetails(int id,String password) throws SQLException
      {
    	  Map<Integer,Company>  map=new HashMap<>();
    	  String pw=getPassword1(id);
    	  if(pw.equals(password))
    	  {
    		  String query="select * from CompanyDetails where USER_ID=? and PASSWORD=?";
    		  try(Connection connect=Database.connect();
    				  PreparedStatement statement=connect.prepareStatement(query);)
    		  {
    			  statement.setInt(1, id);
    			  statement.setString(2, password);
    			  try(ResultSet result=statement.executeQuery())
    			  {
    				  while(result.next())
    				  {
    				  Company com=new Company();
    				  com.setCompanyName(result.getString("NAME"));
    				  com.setLocation(result.getString("LOCATION"));
    				  com.setPhoneNo(result.getLong("PHONENO"));
    				  map.put(id, com);
    				  }
    			  }
    		  }
    	  }
    	  else
    	  {
    		  System.out.println("incorrect password");
    	  }
    	  return map;
      }
      public void insertVacancy(List<Vaccancies> list,int id) throws SQLException
      {
    	  String query="insert into vacancy"+"(COMPANY_ID,POST,VACCANCY,SALARY,QUALIFICATION)"+"values(?,?,?,?,?)";
    	  try(Connection connect=Database.connect();
    			 PreparedStatement statement=connect.prepareStatement(query);)
    	  {
    		  for(Vaccancies v:list)
    		  {
    			  statement.setInt(1, id);
    			  statement.setString(2,v.getPost());
    			  statement.setInt(3, v.getVaccancy());
    			  statement.setLong(4,v.getSalary());
    			  statement.setString(5,v.getQualification());
    			  statement.execute();
    		  }
    	  }
      }
      
      public List<String> getList() throws SQLException
      {
    	  List<String> list=new ArrayList<>();
    	  String query="select POST from vacancy";
    	  try(Connection connect=Database.connect();
    			  PreparedStatement statement=connect.prepareStatement(query);ResultSet result=statement.executeQuery())
    	  {
    		  while(result.next())
    		  {
    			  list.add(result.getString("POST"));
    		  }
    	  }
    	  return list;
      }
      
      public int getCompanyId(String post) throws SQLException
      {
    	  String query="select COMPANY_ID from vacancy where POST='"+post+"'";
    	  int id=0;
    	  try(Connection connect=Database.connect();
    			  PreparedStatement statement=connect.prepareStatement(query))
    	  {
    		   try(ResultSet result=statement.executeQuery())
    		  {
    			  while(result.next())
    			  {
    	            id=result.getInt("COMPANY_ID");
    			  }
    		  }
    	  }
    	  return id;
     	 
      }
      public Map<Integer,Vaccancies> getPostDetails(String post) throws SQLException
      {
    	  Map<Integer,Vaccancies> map=new HashMap<>();
    	  int id=getCompanyId(post);
    	  String query="select * from vacancy where POST='"+post+"'";
    	  try(Connection connect=Database.connect();
    			  PreparedStatement statement=connect.prepareStatement(query))
    	  {
    		   try(ResultSet result=statement.executeQuery())
    		  {
    			  while(result.next())
    			  {
    				  Vaccancies vac=new Vaccancies();
    				  vac.setPost(result.getString("POST"));
    				  vac.setQualification(result.getString("QUALIFICATION"));
    				  vac.setSalary(result.getLong("SALARY"));
    				  vac.setVaccancy(result.getInt("VACCANCY"));
    				  //list.add(vac);
    				  map.put(id,vac);
    			  }
    		  }
    	  }
    	  return map;
      }
      public Map<Integer,Company> getIdDetails(String post) throws SQLException
      {
    	  Map<Integer,Company> map=new HashMap<>();
    	  int id=getCompanyId(post);
    	  String query="select * from CompanyDetails where COMPANY_ID="+id+"";
    	  try(Connection connect=Database.connect();
    			  PreparedStatement statement=connect.prepareStatement(query))
    	  {
    		   try(ResultSet result=statement.executeQuery())
    		  {
    			  while(result.next())
    			  {
    				  Company com=new Company();
    				  com.setCompanyName(result.getString("NAME"));
    				  com.setLocation(result.getString("LOCATION"));
    				  com.setPhoneNo(result.getLong("PHONENO"));
    				  map.put(id, com);
    			  }
    		  }
    	  }
    	  return map;
      }
      
      
      
      
      
      
      
      
}
