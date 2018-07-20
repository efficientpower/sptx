package org.wjh.dao;

import org.wjh.domain.User;

public interface UserDao {

    public User getById(Integer id);

    public void update(User user);

    public void insert(User user);

    public void deleteById(Integer id);
}
