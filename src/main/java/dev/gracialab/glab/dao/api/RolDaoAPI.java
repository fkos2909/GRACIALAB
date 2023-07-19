package dev.gracialab.glab.dao.api;
import org.springframework.data.repository.CrudRepository;

import dev.gracialab.glab.model.Rol;

public interface RolDaoAPI extends CrudRepository<Rol, Long> {
    
}
