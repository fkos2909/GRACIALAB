package dev.gracialab.glab.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import dev.gracialab.glab.commons.GenericServiceImpl;
import dev.gracialab.glab.dao.api.UserDaoAPI;
import dev.gracialab.glab.service.api.UserServiceAPI;
import dev.gracialab.glab.model.User;


@Service
public class UserServiceImpl extends GenericServiceImpl<User, Long> implements UserServiceAPI {
    @Autowired
    private UserDaoAPI userDaoAPI;

    @Override
    public CrudRepository<User, Long> getDao() {
        return userDaoAPI;
    }
}
