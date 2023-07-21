package dev.gracialab.glab.dao.api;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;

import dev.gracialab.glab.model.Rol;

public interface RolDaoAPI extends JpaRepository<Rol, Long> {
    Optional<Rol> findByName(String name);
}
