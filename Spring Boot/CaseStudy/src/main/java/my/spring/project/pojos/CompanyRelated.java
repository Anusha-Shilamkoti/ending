package my.spring.project.pojos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CompanyRelated")
public class CompanyRelated {
	@Id
	private int id;
	  private String companyName;
	  private float turnOver;
	  private String ceo;
	  private String boardOfDirectors;
	  private String listedStockExchange;
	  private String sector;
	  private String brief;
	  private String stockCode;
	@Override
	public String toString() {
		return "CompanyRelated [id=" + id + ", companyName=" + companyName + ", turnOver=" + turnOver + ", ceo=" + ceo
				+ ", boardOfDirectors=" + boardOfDirectors + ", listedStockExchange=" + listedStockExchange
				+ ", sector=" + sector + ", brief=" + brief + ", stockCode=" + stockCode + "]";
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
	public float getTurnOver() {
		return turnOver;
	}
	public void setTurnOver(float turnOver) {
		this.turnOver = turnOver;
	}
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	public String getBoardOfDirectors() {
		return boardOfDirectors;
	}
	public void setBoardOfDirectors(String boardOfDirectors) {
		this.boardOfDirectors = boardOfDirectors;
	}
	public String getListedStockExchange() {
		return listedStockExchange;
	}
	public void setListedStockExchange(String listedStockExchange) {
		this.listedStockExchange = listedStockExchange;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getStockCode() {
		return stockCode;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	
}
