package org.wjh.dao;

import org.apache.ibatis.annotations.Param;
import org.wjh.domain.User;

import java.util.List;

public interface UserDao {

    public User getById(Integer id);

    public void update(User user);

    public void insert(User user);

    public void batchInsert(@Param("list")List<User> users);

    public void deleteById(Integer id);
}
