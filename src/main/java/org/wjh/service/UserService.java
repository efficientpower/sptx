package org.wjh.service;

import org.wjh.domain.User;

public interface UserService {

    public User getById(Integer id);

    public void updateInTx(Integer id);
}
