package dev.gracialab.glab.dao.api;

import org.springframework.data.repository.CrudRepository;

import dev.gracialab.glab.model.Reserve;

public interface ReserveDaoAPI extends CrudRepository<Reserve, Long>{
    
}