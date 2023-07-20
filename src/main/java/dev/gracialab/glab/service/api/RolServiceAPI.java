package dev.gracialab.glab.service.api;

import dev.gracialab.glab.commons.GenericServiceAPI;
import dev.gracialab.glab.model.Rol;

public interface RolServiceAPI extends GenericServiceAPI<Rol, Long> {
    public Rol getByName(String name);
}
