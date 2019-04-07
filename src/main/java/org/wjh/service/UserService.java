package org.wjh.service;

import org.wjh.domain.User;

import java.util.List;

public interface UserService {

    public User getById(Integer id);

    public void updateInTx(Integer id);

    public void insert(User user);

    public void batchInsert(List<User> users);
}
