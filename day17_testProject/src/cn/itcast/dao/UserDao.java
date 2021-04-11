package cn.itcast.dao;

import cn.itcast.domain.User;
import cn.itcast.domain.admin;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public List<User> findAll();

    admin findUserByUsernameAndPassword(String username, String password);

    void add(User user);

    void delUser(int parseInt);


    User findById(int id);

    void update(User user);
/*
删除选中多行
 */
    void delSelectedUser(String[] ids);
/*
  返回查询的总记录数
 */
    int findTotalCount(Map<String, String[]> condition);
/*
返回分页后页面显示的list集合
 */
    List<User> findUserListByPage(int start, int row, Map<String, String[]> condition);
}
