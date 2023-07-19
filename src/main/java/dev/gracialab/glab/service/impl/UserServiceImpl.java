package dev.gracialab.glab.service.impl;

import java.util.ArrayList;
import java.util.List;

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

    public List<User> search(String mail) {
        // SearchSpecifications<User> searchSpecifications = new SearchSpecifications<>();
        // searchSpecifications.add(new searchCriteria("mail", mail, SearchOperation.EQUAL));
        List<User> returnList = new ArrayList<>();
        getDao().findAll().forEach(obj -> {
            if(obj.getMail().equals(mail)) {
                returnList.add(obj);
            }
        });
        return returnList;
    }
}
