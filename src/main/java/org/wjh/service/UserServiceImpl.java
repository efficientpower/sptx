package org.wjh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wjh.dao.UserDao;
import org.wjh.domain.User;

import java.util.List;
import java.util.UUID;

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

    public void insert(User user) {
        userDao.insert(user);
    }

    public void batchInsert(List<User> users) {
        userDao.batchInsert(users);
    }

}
