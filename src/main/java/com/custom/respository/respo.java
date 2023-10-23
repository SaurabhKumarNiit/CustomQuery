package com.custom.respository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.custom.enties.rites;

public interface respo extends CrudRepository<rites, Integer> {

	@Query("select u from rites u where u.email=:n and u.password=:m ")
	rites findByLogin(@Param("n") String name, @Param("m") String password);
	
//	@Query("select u from rites u where u.email=:n and u.password=:m and u.admin=:p ")
//	rites findByAdmin(@Param("n") String name, @Param("m") String password,@Param("p") boolean admins);
	
}