package methodpackage;

public class CustomerAccountDetails

{
	private int customerID;
	private long accountNo;
	private String IFSCcode;
	private String branch;
	private String accountType;
	private long balance;
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setCustomerID(int cusId)
	{
		this.customerID=cusId;
	}
	 public int getCustomerID()
     {
    	 return customerID;
     }
     public void setAccountNo(long accNo)
     {
    	 this.accountNo=accNo;
     }
     public long getAccountNo()
     {
    	 return accountNo;
     }
     public void setIFSCcode(String code)
     {
    	 this.IFSCcode=code;
     }
     public String getIFSCcode()
     {
    	 return IFSCcode;
     }
     public void setBranch(String branch)
     {
    	 this.branch=branch;
     }
     public String getBranch()
     {
    	 return branch;
     }
     public void setAccountType(String accType)
     {
    	 this.accountType=accType;
     }
     public String getAccountType()
     {
    	 return accountType;
     }
     public void setBalance(long balance)
     {
    	 this.balance=balance;
     }
     public long getBalance()
     {
    	 return balance;
     }
     public String toString()
     {
    	 return "CUSTOMER_ID: " +this.customerID+ " ,ACCOUNT_NO: " +this.accountNo+ " ,IFSC_CODE: " +this.IFSCcode+
    			 " ,BRANCH: "+this.branch+ " ,ACCOUNT_TYPE: " +this.accountType+ " ,BALANCE: " +this.balance+ " ,STATUS: "+this.status;
     }
}
