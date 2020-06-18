package com.iiht.stock.vo;

public class CompanyModel {
	private Integer id;
	private String companyName;
	private Integer companyCode;
	private String exchangeName;
	private String turnOver;
	private String ceo;
	private String boardOfDrectors;
	private String sectorName;
	private String brief;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Integer getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(Integer companyCode) {
		this.companyCode = companyCode;
	}

	public String getExchangeName() {
		return exchangeName;
	}
	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}
	public String getTurnOver() {
		return turnOver;
	}
	public void setTurnOver(String turnOver) {
		this.turnOver = turnOver;
	}
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	public String getBoardOfDrectors() {
		return boardOfDrectors;
	}
	public void setBoardOfDrectors(String boardOfDrectors) {
		this.boardOfDrectors = boardOfDrectors;
	}

	public String getSectorName() {
		return sectorName;
	}
	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	
	
}
