package onlinejob;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class OnlineJobRunner 
{
	static Scanner input=new Scanner(System.in);
	public static void main(String[] args) throws SQLException
    {
  	  OnlineJobMethod job=new OnlineJobMethod();
  	  Candidate candidate=new Candidate();
  	  Company company=new Company();
  	  //Vaccancies vac=new Vaccancies();
  	  try
  	  {
  		  System.out.println("Enter 1 for Candidate \n"
  		  		+ "Enter 2 for Company");
  		  int num=input.nextInt();
  		  input.nextLine();
  		  switch(num)
  		  {
  		  case 1:
  		      System.out.println("Enter 1 for Registration \n"
  		      		+ "Enter 2 for already resistered");
  		      int enter=input.nextInt();
  		      input.nextLine();
  		      switch(enter)
  		      {
  		       /*case 1:
  		       String query=job.candidateDetails();
  	  	       job.table(query);
  	  	       break;*/
  		       case 1:
  		    	 List<Candidate> list=new ArrayList<>();
  		    	 System.out.println("Enter name");
  		    	 String name=input.next();
  		    	 candidate.setName(name);
  		    	 System.out.println("Enter Age");
  		    	 int age=input.nextInt();
  		    	 candidate.setAge(age);
  		    	 System.out.println("Enter phone no");
  		    	 long number=input.nextLong();
  		    	 candidate.setPhoneNo(number);
  		    	 System.out.println("Enter qualification");
  		    	 String qual=input.next();
  		    	 candidate.setQualification(qual);
  		    	 System.out.println("Enter userId");
  		    	 int id=input.nextInt();
  		    	 candidate.setUserId(id);
  		    	 System.out.println("Enter password");
  		    	 String password=input.next();
  		    	 candidate.setPassword(password);
  		    	 list.add(candidate);
  		    	 job.insertCandidateDetails(list);
  		    	 
  		       case 2:
  		    	   System.out.println("Enter userId");
  		    	   id=input.nextInt();
  		    	   System.out.println("Enter password");
  		    	   String pw=input.next();
  		    	   Map<Integer,Candidate> map=job.getCandidateDetails(id, pw);
  		    	   for(Map.Entry<Integer,Candidate> entry:map.entrySet())
  		    	   {
  		    		   System.out.println(" "+entry.getValue());
  		    	   }
  		    	  System.out.println("\nJobs Available\n");
  		    	 List<String> listpost=job.getList();
  		    	 int len=listpost.size();
  		    	 for(int i=0;i<len;i++)
  		    	 {
  		    	     System.out.println(i+1+" "+listpost.get(i));
  		    	 }
  		    	 System.out.println("\nselect post");
  		    	 String post=input.next();
  		    	 Map<Integer,Company> mapC=job.getIdDetails(post);
  		    	for(Map.Entry<Integer,Company> entry:mapC.entrySet())
		    	   {
		    		   System.out.println(entry.getValue());
		    	   }
		    	
  		       Map<Integer,Vaccancies> mapv=job.getPostDetails(post);
  			   for(Map.Entry<Integer,Vaccancies> entry:mapv.entrySet())
	    	   {
	    		   System.out.println(entry.getValue());
	    	   }
	    	   System.out.println("Enter 1 to apply");
	    	   int apply=input.nextInt();
	    	   if(apply==1)
	    	   {
	    		  String qual1=job.getQualification(id);
	    		  System.out.println(qual1);
	    		  String qual2=job.getQualification1(post);
	    		  System.out.println(qual2);
	    		  if(qual1.equals(qual2))
	    		  {
	    			  System.out.println("you are eligible for the post");
	    		  }
	    		  else
	    		  {
	    			  System.out.println("you are not eligible");
	    		  }
	    	   }
  			   
  		    	break;
  		    	
  		      }
  		      break;
  		  case 2:
  			  System.out.println("Enter 1 for  regisration \n"
  			  		+ "Enter 2 already registered");
		      int enter1=input.nextInt();
		      input.nextLine();
		      switch(enter1)
		      {
		       case 1:
		    	  System.out.println("Enter name");
		    	  String name=input.next();
		    	  company.setCompanyName(name);
		    	  System.out.println("Enter Location");
		    	  String location=input.next();
		    	  company.setLocation(location);
		    	  System.out.println("Enter phone no");
		    	  long number=input.nextLong();
		    	  company.setPhoneNo(number);
		    	  System.out.println("Enter userid");
		    	  int id=input.nextInt();
		    	  company.setUserid(id);
		    	  System.out.println("Enter password");
		    	  String password=input.next();
		    	  company.setPassword(password);
		    	  //list.add(company);
		    	  System.out.println("Enter number of post");
		    	  int n=input.nextInt();
		    	  List<Vaccancies> list1=new ArrayList<>();
		    	  for(int i=0;i<n;i++)
		    	  {
		    	   Vaccancies vac=new Vaccancies();
		    	   System.out.println("Enter Post");
		    	   String post=input.next();
		    	   vac.setPost(post);
		    	   System.out.println("Enter vaccancy");
		    	   int vaccancy=input.nextInt();
		    	   vac.setVaccancy(vaccancy);
		    	   System.out.println("Enter salary");
		    	   long salary=input.nextLong();
		    	   vac.setSalary(salary);
		    	   System.out.println("Enter qualification");
		    	   String qual=input.next();
		    	   vac.setQualification(qual);
		    	   list1.add(vac);
		    	  }
		    	   job.insertCompanyDetails(company,list1);
		       break;
		       case 2:
		    	   System.out.println("Enter userId");
  		    	   int userid=input.nextInt();
  		    	   System.out.println("Enter password");
  		    	   String pw=input.next();
  		    	   Map<Integer, Company> map=job.getCompanyDetails(userid, pw);
  		    	   for(Map.Entry<Integer,Company> entry:map.entrySet())
  		    	   {
  		    		   System.out.println(entry.getKey()+" "+entry.getValue());
  		    	   }
  		    	break;
		    
	  	       
		      }
  		  
  			  
		   
  		  }
  	  }
  	  catch(SQLException ex)
  	  {
  		  ex.printStackTrace();
  	  }
  	  
  	  
  	  
  	  
    }
}
