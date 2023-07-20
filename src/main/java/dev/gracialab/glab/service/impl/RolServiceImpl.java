package dev.gracialab.glab.service.impl;

import java.util.ArrayList;
import java.util.List;

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

    public Rol getByName(String name){
        List<Rol> returnList = new ArrayList<>();
        getDao().findAll().forEach(obj -> {
            if(obj.getName().equals(name)){
                returnList.add(obj);
            }
        });
        if(!returnList.isEmpty()){
            return returnList.get(0);
        }
        return null;
    }
}
