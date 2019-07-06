/**
 * 
 */
package com.springboot.microservices.dbservice.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.microservices.dbservice.repository.QuotesRepository;
import com.springboot.microservices.resource.model.Quote;
import com.springboot.microservices.resource.model.Quotes;

/**
 * @author varun
 *
 */
@RestController
@RequestMapping("/rest/db")
public class DBServiceResource {
	
	private QuotesRepository quotesRepository;
	
	public DBServiceResource(QuotesRepository quotesRepository) {
		this.quotesRepository = quotesRepository;
	}



	@GetMapping("/{userName}")
	public List<String> getQuotes(@PathVariable("userName") final String userName) {
		return getUserName(userName);
		
	}



	private List<String> getUserName(final String userName) {
		return quotesRepository.findByUserName(userName)
		.stream().map(Quotes::getQuote)
		.collect(Collectors.toList());
	}
	
	@PostMapping("/add")
	public List<String> add(@RequestBody final Quote quote) {
		
		quote.getQuotes()
		.stream()
		.map(quotes -> new Quotes(quote.getUserName(), quotes))
		.forEach(quotes -> quotesRepository.save(quotes));
		return getUserName(quote.getUserName());
		
	}
	
	@DeleteMapping("/delete/{userName}")
	public List<String> delete(@PathVariable("userName") final String userName) {
		
		List<Quotes> quotes = quotesRepository.findByUserName(userName);
		quotesRepository.deleteAll(quotes);
		
		return getUserName(userName);
		
	}
	

}
