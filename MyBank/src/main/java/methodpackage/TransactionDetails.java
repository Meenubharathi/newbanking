package methodpackage;


public class TransactionDetails
{
	private int customerId;
   	private long time;
    private long accountNumber;
    private long currentBalance;
    private long transactionAccount;
    private Long amount;
    private String modeOfTransaction;
    private int transactionId;
    public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getCustomerId() 
    {
		return customerId;
	}
	public void setCustomerId(int customerId) 
	{
		this.customerId = customerId;
	}
    public String getModeOfTransaction()
    {
		return modeOfTransaction;
	}
	public void setModeOfTransaction(String modeOfTransaction)
	{
		this.modeOfTransaction = modeOfTransaction;
	}
	  public Long getAmount() 
    {
		return amount;
	}
	public void setAmount(Long amount) 
	{
		this.amount = amount;
	}
    public  long getTime()
	{
		return time;
	}
	public void setTime(long times)
	{
	    this.time = times;
	}
	public long getAccountNumber() 
	{
		return accountNumber;
	}
	public void setAccount_Number(long accountNumber) 
	{
		this.accountNumber = accountNumber;
	}
	public long getCurrent_Balance() 
	{
		return currentBalance;
	}
	public void setCurrent_Balance(long currentbalance)
	{
		currentBalance = currentbalance;
	}
		public long getTransaction_Account() 
	{
		return transactionAccount;
	}
	public void setTransaction_Account(long transactionAccount ) 
	{
		this.transactionAccount = transactionAccount;
	}
	public String toString()
	{
		return "CUSTOMER_ID: " +this.customerId+ " ,TIME: " +this.time+ " ,ACCOUNT_NO: " +this.accountNumber+ " MODE_OF_TRANSACTION: " +this.modeOfTransaction+
		                 " ,AMOUNT: " +this.amount+ " ,CURRENT_BALANCE: " +this.currentBalance+ " ,Transaction_account: " +this.transactionAccount+ " TRANSACTION_ID: "+this.transactionId;
	}
 }

