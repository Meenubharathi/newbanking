package methodpackage;

public class CustomerDetails extends UserDetails
{
     private int customerID;
     private String panNo;
     private long adharNo;
     private String dob;
     private String address;
     public void setCustomerID(int cusID)
     {
    	 this.customerID=cusID;
     }
     public int getCustomerID()
     {
    	 return customerID;
     }
     public void setPanNo(String panNo)
     {
    	 this.panNo=panNo;
     }
     public String getPanNo()
     {
    	 return panNo;
     }
     public void setAdharNo(long adharNo)
     {
    	 this.adharNo=adharNo;
     }
     public long getAdharNo()
     {
    	 return adharNo;
     }
     public void setDob(String dob)
     {
    	 this.dob=dob;
     }
     public String getDob()
     {
    	 return dob;
     }
     public void setAddress(String address)
     {
    	 this.address=address;
     }
     public String getAddress()
     {
    	 return address;
     }
     public String toString()
     {
    	 return "CUSTOMER_ID: " +this.customerID+ " ,PAN_NO: " +this.panNo+ 
    			 " ,ADHAR_NO: " +this.adharNo+ " ,DOB: " +this.dob+ " ,ADDRESS: " +this.address;
     }
    
}
