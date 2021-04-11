package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;

public interface Userdao {
    User findUsername(String username);
    void save(User user);

    User findCode(String code);

    void updateStatus(User user);

    User findNamePassword(String username, String password);
}
