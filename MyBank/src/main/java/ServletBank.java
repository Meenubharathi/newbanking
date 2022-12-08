import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exception.CheckException;
import methodpackage.CustomerAccountDetails;
import methodpackage.CustomerDetails;
import methodpackage.DataBaseMethod;
import methodpackage.LogicalLayer;
import methodpackage.TransactionDetails;
import methodpackage.UserDetails;

public class ServletBank extends HttpServlet
{   
	 LogicalLayer logic=new LogicalLayer();
	 DataBaseMethod data=new DataBaseMethod();
     
	protected void doPost(HttpServletRequest request, 
		      HttpServletResponse response) throws ServletException, IOException 
	{
	     
	     String userName=request.getParameter("button");
	     try
	     {
	     if(userName.equals("Login"))
	     {
	    	  	  int customerId=Integer.parseInt(request.getParameter("userid"));
	  	    	  String password=request.getParameter("password");
	  	    	  HttpSession session=request.getSession(true);
		          session.setAttribute("customerId", customerId);
		          try
		          {
		          boolean check=logic.setCustomerLogin(customerId, password);
	    	      if(check)
	    	      {
	    	        	 String role=logic.getRole(customerId);
	    	        	 if(role.equals("CUSTOMER"))
	    	        	 {
	    		         RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/Customer.jsp");
	     		         requestDispatcher.forward(request, response);
	    	        	 }
	    	        	 else
	    	        	 {
	    	        		 RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/Admin.jsp");
	    	 	 	     	 requestDispatcher.forward(request, response);
	    	 	     
	    	        	 }
	    	     }
	    	      else
	                {
		        	  String message = "incorrect id or password";
    	    	      request.getSession().setAttribute("message",message);
    	    	      response.sendRedirect("jsp/Login.jsp");
		             }
		          }
		          catch(CheckException e)
		          {
		        	  request.setAttribute("error" ,e.getCause());
		          }
	    	 }
 	     
  	      
	     
	     else if(userName.equals("home"))
	     {
	    	 HttpSession session=request.getSession(false);
	         int customerId=(int) session.getAttribute("customerId");
	         try
	         {
	          Map<Long,CustomerAccountDetails> map=logic.getAccountDetails(customerId);
             request.setAttribute("map", map);
              RequestDispatcher requestDispatcher = 
	 	     		request.getRequestDispatcher("jsp/CustomerMainPage.jsp");
	 	     	requestDispatcher.forward(request, response);
	         }
	         catch(CheckException e)
	         {
	        	 request.setAttribute("error" ,e.getCause());
	         }
	     }
	     else if(userName.equals("View Account"))
	     {
	    	 HttpSession session=request.getSession(false);
	         int customerId=(int) session.getAttribute("customerId");
	         try
	         {
	         Map<Long,CustomerAccountDetails> map=logic.getAccountDetails(customerId);
             request.setAttribute("map", map);
             RequestDispatcher requestDispatcher = 
	 	     		request.getRequestDispatcher("jsp/ViewAccounts.jsp");
	 	     	requestDispatcher.forward(request, response);
	         }
	         catch(CheckException e)
	         {
	        	 request.setAttribute("error" ,e.getCause());
	         }
	     }
	     else if(userName.equals("View detail"))
	     {
	    	 HttpSession session=request.getSession(false);
	         int customerId=(int) session.getAttribute("customerId");
	         try
	         {
	         Map<Integer,UserDetails> map=logic.setUserCustomer(customerId);
	         request.setAttribute("map", map);
	         Map<Integer,CustomerDetails> map1=logic.getPersonalDetails(customerId);
	         request.setAttribute("map1", map1);
	         RequestDispatcher requestDispatcher = 
	 	     		request.getRequestDispatcher("jsp/Viewprofile.jsp");
	 	     	requestDispatcher.forward(request, response);
	         }catch(CheckException e)
	         {
	        	 request.setAttribute("error" ,e.getCause());
	         }
	     }
	     else if(userName.equals("update"))
	     {
	    	 HttpSession session=request.getSession(false);
	         int customerId=(int) session.getAttribute("customerId");
	         long mobile=Long.parseLong(request.getParameter("mobile"));
	         String email=request.getParameter("email");
	         String address=request.getParameter("address");
	         String field="PHONE_NO";
	         String field1="EMAIL";
	         String field2="ADDRESS";
	         try
	         {
	 	     logic.updateUserDetails(field, mobile, customerId);
	 	     logic.updateUserDetails(field1,email, customerId);
	 	     logic.updatePersonalDetails(field2, address, customerId);
	 	     
	 	     request.setAttribute("update" ,"successfully updated");
	 	     Map<Integer,UserDetails> map=logic.setUserCustomer(customerId);
	         request.setAttribute("map", map);
	         Map<Integer,CustomerDetails> map1=logic.getPersonalDetails(customerId);
	         request.setAttribute("map1", map1);
	         RequestDispatcher requestDispatcher = 
	 	     		request.getRequestDispatcher("jsp/Viewprofile.jsp");
	 	     	requestDispatcher.forward(request, response);
	         }
	         catch(CheckException e)
	         {
	        	 request.setAttribute("error" ,e.getCause());
	         }
	
	     }
	     else if(userName.equals("Transfer"))
	     {
	    	 HttpSession session=request.getSession(false);
	         int customerId=(int) session.getAttribute("customerId");
	         try
	         {
	         Map<Long,CustomerAccountDetails> map=logic.getAccountDetails(customerId);
             request.setAttribute("map", map);
	         RequestDispatcher requestDispatcher = 
	 	     		request.getRequestDispatcher("jsp/Transfer.jsp");
	 	     	requestDispatcher.forward(request, response);
	         }
	         catch(CheckException e)
	         {
	        	 request.setAttribute("error" ,e.getCause());
	         }
	     }
	     else if(userName.equals("process"))
	     {
	    	 HttpSession session=request.getSession(false);
	         int customerId=(int) session.getAttribute("customerId");
	         
             List<TransactionDetails> trans=new ArrayList<TransactionDetails>();
             try
             {
             TransactionDetails transaction=new TransactionDetails();
             TransactionDetails transfer=new TransactionDetails();
             long time=logic.milliseconds();
             long accountNo=Long.parseLong(request.getParameter("accountNo"));
 	    	 String mode="Debit";
 	    	 String mode1="Credit";
 	    	 long amount=Long.parseLong(request.getParameter("amount"));
 	    	 long transaccountNo=Long.parseLong(request.getParameter("transAcc"));
 	    	 long debit=logic.debit(amount,accountNo);
 	    	 long credit=logic.credit(amount,transaccountNo);
             int id1=(int) logic.getcusId(transaccountNo);
 	    	transaction.setTime(time);
		    transaction.setCustomerId(customerId);
		    transaction.setAccount_Number(accountNo);
		    transaction.setModeOfTransaction(mode);
		    transaction.setAmount(amount);
		    transaction.setCurrent_Balance(debit);
		    transaction.setTransaction_Account(transaccountNo);
		    
		    transfer.setTime(time);
		    transfer.setCustomerId(id1);
		    transfer.setAccount_Number(transaccountNo);
		    transfer.setModeOfTransaction(mode1);
		    transfer.setAmount(amount);
		    transfer.setCurrent_Balance(credit);
		    transfer.setTransaction_Account(accountNo);
		 
		    long balance=logic.getBalance(accountNo);
		    long balance1=logic.getBalance(transaccountNo);
		    if(balance>=1000)
		    {
		    logic.update(balance,debit);
		    logic.update(balance1,credit);
            
		    trans.add(transaction);
      	    trans.add(transfer);
      	  
      	    data.insertTransactionDetails(trans);
      	    request.setAttribute("transfer" ,"successfully transfered");
	         Map<Long,CustomerAccountDetails> map=logic.getAccountDetails(customerId);
             request.setAttribute("map", map);
               RequestDispatcher requestDispatcher = 
	 	     		request.getRequestDispatcher("jsp/Transfer.jsp");
	 	     	requestDispatcher.forward(request, response);
		    }
		   
		    else
		    {
		    	request.setAttribute("nottransfer" ,"your balance is less than 1000");
		         Map<Long,CustomerAccountDetails> map=logic.getAccountDetails(customerId);
	             request.setAttribute("map", map);
		         RequestDispatcher requestDispatcher = 
		 	     		request.getRequestDispatcher("jsp/Transfer.jsp");
		 	     	requestDispatcher.forward(request, response);
		
		    }
	     }catch(CheckException e)
	     {
	    	 request.setAttribute("error" ,e.getCause());
             RequestDispatcher requestDispatcher = 
	 	     		request.getRequestDispatcher("jsp/Transfer.jsp");
	 	     	requestDispatcher.forward(request, response);
	     }
	     }
	     else if(userName.equals("Statement"))
	     {  
	    	 HttpSession session=request.getSession(false);
	         int customerId=(int) session.getAttribute("customerId");
	         try
	         {
	         Map<Long,CustomerAccountDetails> map1=logic.getAccountDetails(customerId);
             request.setAttribute("map1", map1);
              RequestDispatcher requestDispatcher = 
	 	     		request.getRequestDispatcher("jsp/SelectAccount.jsp");
	 	     	requestDispatcher.forward(request, response);
	         }
	         catch(CheckException e)
	         {
	        	 request.setAttribute("error" ,e.getCause());
	         }
	     }
	     else if(userName.equals("next"))
	     {
	    	 HttpSession session=request.getSession(false);
	         int customerId=(int) session.getAttribute("customerId");
	    	 try
             {
		   	 Long accountNo=Long.parseLong(request.getParameter("accNo"));
	    	 Map<Long,List<TransactionDetails>> map=logic.lastTransaction(accountNo);
	    	 request.setAttribute("map", map);
	         Map<Long,CustomerAccountDetails> map1=logic.getAccountDetails(customerId);
             request.setAttribute("map1", map1);
	    	 RequestDispatcher requestDispatcher = 
		 	     		request.getRequestDispatcher("jsp/SelectAccount.jsp");
		 	     	requestDispatcher.forward(request, response);
	         }
	         catch(CheckException e)
	         {
	        	 request.setAttribute("error" ,e.getCause());
	         }
		    
	     }
	     else if(userName.equals("WithDraw"))
	     {
	    	 HttpSession session=request.getSession(false);
	         int customerId=(int) session.getAttribute("customerId");
	         try
	         {
	         Map<Long,CustomerAccountDetails> map=logic.getAccountDetails(customerId);
             request.setAttribute("map", map);
	         RequestDispatcher requestDispatcher = 
	 	     		request.getRequestDispatcher("jsp/Request.jsp");
	 	     	requestDispatcher.forward(request, response);
	         }
	         catch(CheckException e)
	         {
	        	 request.setAttribute("error" ,e.getCause());
	         }
	     }
	     else if(userName.equals("Deposit"))
	     {
	    	 HttpSession session=request.getSession(false);
	         int customerId=(int) session.getAttribute("customerId");
	         try
	         {
	         Map<Long,CustomerAccountDetails> map=logic.getAccountDetails(customerId);
             request.setAttribute("map", map);
	         RequestDispatcher requestDispatcher = 
	 	     		request.getRequestDispatcher("jsp/Request.jsp");
	 	     	requestDispatcher.forward(request, response);
	         }
	         catch(CheckException e)
	         {
	        	 request.setAttribute("error" ,e.getCause());
	         }
	     }
	     else if(userName.equals("Change Password"))
	     {
	         RequestDispatcher requestDispatcher = 
	 	     		request.getRequestDispatcher("jsp/ChangePassword.jsp");
	 	     	requestDispatcher.forward(request, response);
	     }
	     else if(userName.equals("Change password"))
	     {
	    	 HttpSession session=request.getSession(false);
	         int customerId=(int) session.getAttribute("customerId");
	    	 String password=request.getParameter("oldPW");
	    	 String newPassword=request.getParameter("newPW");
	    	 String reEnter=request.getParameter("RenewPW");
	    	 try
	    	 {
	    	 String pw=logic.getPassword(customerId);
	    	 String field="PASSWORD";
	    	 if(password.equals(pw))
	    	 {
	    		 if(newPassword.equals(reEnter))
	    		 {
	    			 logic.updateUserDetails(field, reEnter, customerId);
	    		 request.setAttribute("update1" ,"successfully updated");
		         RequestDispatcher requestDispatcher = 
			 	     		request.getRequestDispatcher("jsp/ChangePassword.jsp");
			 	     	requestDispatcher.forward(request, response);
	    		 }
	    		 else
		    	 {
		    		 request.setAttribute("update2" ,"incorrect password");
			         RequestDispatcher requestDispatcher = 
				 	     		request.getRequestDispatcher("jsp/ChangePassword.jsp");
				 	     	requestDispatcher.forward(request, response);
				 }
	    	 }
	    	 else
	    	 {
	    		 request.setAttribute("update2" ,"incorrect password");
		         RequestDispatcher requestDispatcher = 
			 	     		request.getRequestDispatcher("jsp/ChangePassword.jsp");
			 	     	requestDispatcher.forward(request, response);
			 }
	    	 }
	    	 catch(CheckException e)
	    	 {
	    		 request.setAttribute("update2" ,"incorrect password");
	    	 }
	     }
	   
	     else if(userName.equals("View Accounts"))
	     {   
	    	 try
	    	 {
	    	 Map<Long,CustomerAccountDetails> map=logic.getAllAccountDetails();
	    	 request.setAttribute("map",map);
	         RequestDispatcher requestDispatcher = 
	 	     		request.getRequestDispatcher("jsp/AdminViewAccounts.jsp");
	 	     	requestDispatcher.forward(request, response);
	    	 }
	    	 catch(CheckException e)
	    	 {
	    		 request.setAttribute("error" ,e.getCause());
	    	 }
	     }
	     else if(userName.equals("Home"))
	     {
	         RequestDispatcher requestDispatcher = 
	 	     		request.getRequestDispatcher("jsp/AdminMainPage.jsp");
	 	     	requestDispatcher.forward(request, response);
	     }
	     else if(userName.equals("View Details"))
	     {
	    	 try
	    	 {
	    	 Map<Integer,CustomerDetails> map1=logic.getAllPersonalDetails();
	    	 request.setAttribute("map1",map1);
	         RequestDispatcher requestDispatcher = 
	 	     		request.getRequestDispatcher("jsp/AdminViewprofile.jsp");
	 	     	requestDispatcher.forward(request, response);
	    	 }
	    	 catch(CheckException e)
	    	 {
	    		 request.setAttribute("error" ,e.getCause());
	       	 }
	     }
	      else if(userName.equals("Add User"))
	     {
	         RequestDispatcher requestDispatcher = 
	 	     		request.getRequestDispatcher("jsp/AddUser.jsp");
	 	     	requestDispatcher.forward(request, response);
	     }
	     else if(userName.equals("Add user"))
	     {
	    	 List<UserDetails> list2=new ArrayList<UserDetails>();
	    	 List<CustomerDetails> list=new ArrayList<CustomerDetails>();
	   	   	 try
	   	   	 {
	    	 int id=Integer.parseInt(request.getParameter("customerid"));
	    	 String name=request.getParameter("name");
	    	 String dob=request.getParameter("dob");
	    	 long mobile=Long.parseLong(request.getParameter("mobile"));
	    	 String email=request.getParameter("email");
	    	 long adhar=Long.parseLong(request.getParameter("adhar"));
	    	 boolean checkAdhar=logic.presentadhar(adhar);
	    	 String pan=request.getParameter("pan");
	    	 boolean checkPan=logic.presentPan(pan);
	    	 String address=request.getParameter("address");
	    	 String password=request.getParameter("password");
	         String status="ACTIVE";
	         String role=request.getParameter("role");
	         if(!checkAdhar)
	         {
	        	 if(!checkPan)
	        	 {
	         UserDetails user=new UserDetails();
	    	 user.setUserId(id);
   	   	     user.setName(name);
   	   	     user.setPhoneNo(mobile);
   	   	     user.setEmail(email);
   	   	     user.setPassWord(password);
   	   	     user.setRole(role);
   	   	     user.setStatus(status);
   	   	     list2.add(user);
		     data.insertUserDetails(list2);
		     
   	   	     CustomerDetails details=new CustomerDetails();
   	   	     details.setCustomerID(id);
   	   	     details.setDob(dob);
   	   	     details.setAdharNo(adhar);
	   	     details.setPanNo(pan);
	   	     details.setAddress(address);
	   	     list.add(details);
   	   	     data.insertCustomerDetails(list);
   	   	     
   	   	      RequestDispatcher requestDispatcher = 
	 	     		request.getRequestDispatcher("jsp/AddAccount.jsp");
	 	     	requestDispatcher.forward(request, response);
	        	 }
	        	 else
		         {
		        	  request.setAttribute("error" ,"check your Pan number");
		             RequestDispatcher requestDispatcher = 
			 	     		request.getRequestDispatcher("jsp/AddUser.jsp");
			 	     	requestDispatcher.forward(request, response);
			
		         }
		   	  
	         }
	         else
	         {
	        	  request.setAttribute("error" ,"check your adhar number");
	             RequestDispatcher requestDispatcher = 
		 	     		request.getRequestDispatcher("jsp/AddUser.jsp");
		 	     	requestDispatcher.forward(request, response);
		
	         }
	   	   	 }
	   	   	 catch(CheckException e)
	   	   	 {
	   	   	 request.setAttribute("error" ,e.getCause());
             RequestDispatcher requestDispatcher = 
	 	     		request.getRequestDispatcher("jsp/AddUser.jsp");
	 	     	requestDispatcher.forward(request, response);
	
	   	   	 }

	     }
	     else if(userName.equals("Add Account"))
	     {
	         RequestDispatcher requestDispatcher = 
	 	     		request.getRequestDispatcher("jsp/AddAccount.jsp");
	 	     	requestDispatcher.forward(request, response);
	     }
	     else if(userName.equals("Add account"))
	     {
	    	 try
	    	 {
	     	 int id=Integer.parseInt(request.getParameter("customerid"));
	    	 Long accountNo=Long.parseLong(request.getParameter("accNo"));
		     String accountType=request.getParameter("accType");
		     String ifsc=request.getParameter("ifscCode");
		     long balance=Long.parseLong(request.getParameter("balance"));
		     String branch=request.getParameter("branch");
		     String status="ACTIVE";
		     
		     CustomerAccountDetails acc=new CustomerAccountDetails();
		     acc.setCustomerID(id);
		     acc.setAccountNo(accountNo);
		     acc.setAccountType(accountType);
		     acc.setIFSCcode(ifsc);
		     acc.setBalance(balance);
		     acc.setBranch(branch);
		     acc.setStatus(status);
		     
		     List<CustomerAccountDetails> list1=new ArrayList<CustomerAccountDetails>();
 			 list1.add(acc);
 			 data.insertCustomerAccountDetails(list1);
 			 
 			request.setAttribute("add" ,"updated successfully");
            RequestDispatcher requestDispatcher = 
	 	     		request.getRequestDispatcher("jsp/AddAccount.jsp");
	 	     	requestDispatcher.forward(request, response);
	   
	    	 }
	    	 catch(CheckException e)
	    	 {
	    		 request.setAttribute("error" ,e.getCause());
	             RequestDispatcher requestDispatcher = 
		 	     		request.getRequestDispatcher("jsp/AddAccount.jsp");
		 	     	requestDispatcher.forward(request, response);
		
	    	 }
		 }
	     else if(userName.equals("LogOut"))
	     {
	         response.sendRedirect("jsp/Login.jsp");
	     }
	     }
	     catch(NumberFormatException e)
	   	   {
	    	 String message1 = "ENTER CORRECT VALUES";
   	         request.getSession().setAttribute("message1",message1);
   	         response.sendRedirect("jsp/Login.jsp");
	   	   }
	  	}

}
