package dev.gracialab.glab.dao.api;

import org.springframework.data.repository.CrudRepository;

import dev.gracialab.glab.model.User;

public interface UserDaoAPI extends CrudRepository<User, Long>{
    
}