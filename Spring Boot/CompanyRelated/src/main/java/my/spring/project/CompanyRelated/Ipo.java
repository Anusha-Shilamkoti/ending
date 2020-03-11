package my.spring.project.CompanyRelated;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="ipo")
public class Ipo {
	@Id
	 private int id;
	  private String companyName;
	  private String stockExchange;
	  private float pricePerShare;
	  private String totalNoOfShares;
	  Date openDateTime=new Date();
	  private String remarks;
	@Override
	public String toString() {
		return "Ipo [id=" + id + ", companyName=" + companyName + ", stockExchange=" + stockExchange
				+ ", pricePerShare=" + pricePerShare + ", totalNoOfShares=" + totalNoOfShares + ", openDateTime="
				+ openDateTime + ", remarks=" + remarks + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}
	public float getPricePerShare() {
		return pricePerShare;
	}
	public void setPricePerShare(float pricePerShare) {
		this.pricePerShare = pricePerShare;
	}
	public String getTotalNoOfShares() {
		return totalNoOfShares;
	}
	public void setTotalNoOfShares(String totalNoOfShares) {
		this.totalNoOfShares = totalNoOfShares;
	}
	public Date getOpenDateTime() {
		return openDateTime;
	}
	public void setOpenDateTime(Date openDateTime) {
		this.openDateTime = openDateTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
