package com.quickblox.q_municate_core.new_db.managers;

import com.j256.ormlite.dao.Dao;
import com.quickblox.q_municate_core.new_db.dao.CommonDao;
import com.quickblox.q_municate_core.new_db.models.User;
import com.quickblox.q_municate_core.utils.ErrorUtils;

import java.sql.SQLException;
import java.util.List;

public class UserManager implements CommonDao<User> {

    private Dao<User, Integer> userDao;

    public UserManager(Dao<User, Integer> userDao) {
        this.userDao = userDao;
    }

    @Override
    public int create(User item) {
        try {
            return userDao.create(item);
        } catch (SQLException e) {
            ErrorUtils.logError(e);
        }
        return 0;
    }

    @Override
    public List<User> getAll() {
        List<User> userList = null;
        try {
            userList = userDao.queryForAll();
        } catch (SQLException e) {
            ErrorUtils.logError(e);
        }
        return userList;
    }

    @Override
    public User get(int id) {
        User user = null;
        try {
            user = userDao.queryForId(id);
        } catch (SQLException e) {
            ErrorUtils.logError(e);
        }
        return user;
    }

    @Override
    public void update(User item) {
        try {
            userDao.update(item);
        } catch (SQLException e) {
            ErrorUtils.logError(e);
        }
    }

    @Override
    public void delete(User item) {
        try {
            userDao.delete(item);
        } catch (SQLException e) {
            ErrorUtils.logError(e);
        }
    }
}