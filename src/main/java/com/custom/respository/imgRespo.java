package com.custom.respository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.custom.enties.img;

public interface imgRespo extends CrudRepository<img, Integer> {

	@Query("select name from img where videos=:n")
	String findByVideos(@Param("n") String namess);

}
