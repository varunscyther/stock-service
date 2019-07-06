/**
 * 
 */
package com.springboot.microservices.resource.model;

import java.util.List;

/**
 * @author varun
 *
 */
public class Quote {

	private String userName;
	private List<String> quotes;
	/**
	 * 
	 */
	public Quote() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Quote(String userName, List<String> quotes) {
		this.userName = userName;
		this.quotes = quotes;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<String> getQuotes() {
		return quotes;
	}
	public void setQuotes(List<String> quotes) {
		this.quotes = quotes;
	}

	
}
