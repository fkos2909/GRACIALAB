package dev.gracialab.glab.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import dev.gracialab.glab.commons.GenericServiceImpl;
import dev.gracialab.glab.dao.api.ReserveDaoAPI;
import dev.gracialab.glab.model.Reserve;
import dev.gracialab.glab.service.api.ReserveServiceAPI;

@Service
public class ReserveServiceImpl extends GenericServiceImpl<Reserve, Long> implements ReserveServiceAPI {

    @Autowired
    private ReserveDaoAPI reserveDaoAPI;

    @Override
    public CrudRepository<Reserve, Long> getDao() {
        return reserveDaoAPI;
    }

    @Override
    public void confirm(Long id) {
        get(id).setState(true);
    }
    
}
