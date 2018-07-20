package org.wjh.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wjh.dao.UserDao;
import org.wjh.domain.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User getById(Integer id) {
        // TODO Auto-generated method stub
        return userDao.getById(id);
    }

    @Transactional(rollbackFor=Exception.class)
    public void updateInTx(Integer id) {
        // TODO Auto-generated method stub
        User u = userDao.getById(id);
        u.setName(UUID.randomUUID().toString());
        userDao.update(u);
    }

}
