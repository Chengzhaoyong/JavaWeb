package cn.itcast.servlet;

import cn.itcast.domain.PageBean;
import cn.itcast.domain.User;
import cn.itcast.domain.admin;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 查询所有用户信息
     * @return
     */
     List<User> findAll();
    /*
    登录方法
     */
    admin login(admin admin);

    void add(User user);
/*
    删除选中行
 */
    void delUser(String id);


    User findById(String id);
/*
   修改功能
 */
    void update(User user);
/*
删除选中多行
 */
    void delSelectedUser(String[] ids);

    PageBean<User> findUserByPage(String currentPage, String row, Map<String, String[]> condition);
}
