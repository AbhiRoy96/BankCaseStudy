package abhishek.foundation.bank.bankcasestudy.entity;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.common.hash.Hashing;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer transactionID;
	private Integer fromAccount;
	private Integer toAccount;
	private String type;
	private double amount;
	private String status;
	private String txHash;
	
	public Transaction ()
	{
		
	}
	
	public Transaction (String type, Integer fromAccount, Integer toAccount, double amount) {
		String digest = fromAccount.toString() + LocalDateTime.now();
		String sha256hex = Hashing.sha256().hashString(digest, StandardCharsets.UTF_8).toString();
	
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.type = type;
		this.amount = amount;
		this.txHash = sha256hex;
		this.status = "Initiated";
	}
	
	public Integer getTransactionID() {
		return transactionID;
	}
	
	public void setTransactionID(Integer transactionID) {
		this.transactionID = transactionID;
	}

	public Integer getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(Integer fromAccount) {
		this.fromAccount = fromAccount;
	}

	public Integer getToAccount() {
		return toAccount;
	}

	public void setToAccount(Integer toAccount) {
		this.toAccount = toAccount;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTxHash() {
		return txHash;
	}

	public void setTxHash(String txHash) {
		this.txHash = txHash;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
