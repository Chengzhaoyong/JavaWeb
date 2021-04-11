package cn.itcast.servlet.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.PageBean;
import cn.itcast.domain.User;
import cn.itcast.domain.admin;
import cn.itcast.servlet.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用Dao完成查询
        return dao.findAll();
    }
    public admin login(admin admin){
            return dao.findUserByUsernameAndPassword(admin.getUsername(),admin.getPassword());
    }

    @Override
    public void add(User user) {
        dao.add(user);
    }

    @Override
    public void delUser(String id) {
        dao.delUser(Integer.parseInt(id));
    }
/*
   查询修改的用户信息
 */
    @Override
    public User findById(String id) {
        return dao.findById(Integer.parseInt(id));
    }
    /*
      修改功能
     */
    @Override
    public void update(User user) {
        dao.update(user);
    }

    /*
    删除选中多行
     */
    @Override
    public void delSelectedUser(String[] ids) {
        dao.delSelectedUser(ids);
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _row, Map<String, String[]> condition) {
        int currentPage=Integer.parseInt(_currentPage);
        int row=Integer.parseInt(_row);

        int totalCount=dao.findTotalCount(condition);//总记录数
        int totalPage=totalCount%row==0 ? totalCount/row:totalCount/row+1;//总页数

        int start=(currentPage-1)*row;
        List<User> list=dao.findUserListByPage(start,row,condition);
        PageBean<User> pb=new PageBean<User>();
        pb.setCurrentPage(currentPage);
        pb.setList(list);
        pb.setRow(row);
        pb.setTotalCount(totalCount);
        pb.setTotalPage(totalPage);


        return pb;
    }


}