package com.iiht.stock.vo;

import java.math.BigDecimal;
public class StockpriceModel {
	private Integer companyCode;
	private String companyName;
	private BigDecimal currentPrice;
	private BigDecimal openPrice;
	private BigDecimal highPrice;
	private BigDecimal lowPrice;
	private String priceDate;
	
	private String key1;
	private String key2;
	private String dayPeriod[];
	private String weekPeriod[];
	private String monthPeriod[];
	private String dayPrice[][];
	private String weekPrice[][];
	private String monthPrice[][];
	private String dataPrice[][];
	private String dataPeriod[];
	private String periodFrom;
	private String periodEnd;
	private Integer week;
	private String month;
	private String period;
	public Integer getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(Integer companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public BigDecimal getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(BigDecimal currentPrice) {
		this.currentPrice = currentPrice;
	}
	public String getPriceDate() {
		return priceDate;
	}
	public void setPriceDate(String priceDate) {
		this.priceDate = priceDate;
	}
	public BigDecimal getOpenPrice() {
		return openPrice;
	}
	public void setOpenPrice(BigDecimal openPrice) {
		this.openPrice = openPrice;
	}
	public BigDecimal getHighPrice() {
		return highPrice;
	}
	public void setHighPrice(BigDecimal highPrice) {
		this.highPrice = highPrice;
	}
	public BigDecimal getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(BigDecimal lowPrice) {
		this.lowPrice = lowPrice;
	}
	public String getPeriodFrom() {
		return periodFrom;
	}
	public void setPeriodFrom(String periodFrom) {
		this.periodFrom = periodFrom;
	}
	public String getPeriodEnd() {
		return periodEnd;
	}
	public void setPeriodEnd(String periodEnd) {
		this.periodEnd = periodEnd;
	}
	public Integer getWeek() {
		return week;
	}
	public void setWeek(Integer week) {
		this.week = week;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getKey1() {
		return key1;
	}
	public void setKey1(String key1) {
		this.key1 = key1;
	}
	public String getKey2() {
		return key2;
	}
	public void setKey2(String key2) {
		this.key2 = key2;
	}
	public String[] getDayPeriod() {
		return dayPeriod;
	}
	public void setDayPeriod(String[] dayPeriod) {
		this.dayPeriod = dayPeriod;
	}
	public String[] getWeekPeriod() {
		return weekPeriod;
	}
	public void setWeekPeriod(String[] weekPeriod) {
		this.weekPeriod = weekPeriod;
	}
	public String[] getMonthPeriod() {
		return monthPeriod;
	}
	public void setMonthPeriod(String[] monthPeriod) {
		this.monthPeriod = monthPeriod;
	}
	public String[][] getDayPrice() {
		return dayPrice;
	}
	public void setDayPrice(String[][] dayPrice) {
		this.dayPrice = dayPrice;
	}
	public String[][] getWeekPrice() {
		return weekPrice;
	}
	public void setWeekPrice(String[][] weekPrice) {
		this.weekPrice = weekPrice;
	}
	public String[][] getMonthPrice() {
		return monthPrice;
	}
	public void setMonthPrice(String[][] monthPrice) {
		this.monthPrice = monthPrice;
	}
	public String[][] getDataPrice() {
		return dataPrice;
	}
	public void setDataPrice(String[][] dataPrice) {
		this.dataPrice = dataPrice;
	}
	public String[] getDataPeriod() {
		return dataPeriod;
	}
	public void setDataPeriod(String[] dataPeriod) {
		this.dataPeriod = dataPeriod;
	}
	
}
