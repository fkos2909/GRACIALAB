package dev.gracialab.glab.service.api;

import java.util.List;

import dev.gracialab.glab.commons.GenericServiceAPI;
import dev.gracialab.glab.model.Rol;
import dev.gracialab.glab.model.User;

public interface UserServiceAPI extends GenericServiceAPI<User, Long> {
    
    public List<User> search(String mail);
    public Rol getRol(String name);
}
