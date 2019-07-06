/**
 * 
 */
package com.springboot.microservices.dbservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.microservices.resource.model.Quotes;

/**
 * @author varun
 *
 */
public interface QuotesRepository extends JpaRepository<Quotes, Integer>{
 List<Quotes> findByUserName(String userName);
}
