package dev.gracialab.glab.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import dev.gracialab.glab.commons.GenericServiceImpl;
import dev.gracialab.glab.dao.api.RolDaoAPI;
import dev.gracialab.glab.service.api.RolServiceAPI;
import dev.gracialab.glab.model.Rol;


@Service
public class RolServiceImpl extends GenericServiceImpl<Rol, Long> implements RolServiceAPI {
    @Autowired
    private RolDaoAPI rolDaoAPI;

    @Override
    public CrudRepository<Rol, Long> getDao() {
        return rolDaoAPI;
    }
}
