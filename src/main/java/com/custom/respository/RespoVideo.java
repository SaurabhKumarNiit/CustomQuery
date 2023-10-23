package com.custom.respository;

import org.springframework.data.repository.CrudRepository;

import com.custom.enties.VideoRequest;

public interface RespoVideo  extends CrudRepository<VideoRequest, Integer>{

}
