package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.Userdao;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements Userdao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public User findUsername(String username) {

        //如果用户名不存在，就报异常，所以抓异常
        User user= null;
        try {
            String sql="select * from tab_user where username=?";
            user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),username);
        } catch (Exception e) {

        }

        return user;
    }

    @Override
    public void save(User user) {

        String sql="insert into tab_user(username,password,name,birthday,sex,telephone,email,status,code)" +
                "values(?,?,?,?,?,?,?,?,?)";
        template.update(sql,user.getUsername(),user.getPassword(),user.getName(),user.getBirthday(),user.getSex(),user.getTelephone(),user.getEmail(),user.getStatus(),user.getCode());


    }

    @Override
    public User findCode(String code) {
        User user=null;
        try {
            String sql="select * from tab_user where code=?";
             user= template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),code);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public void updateStatus(User user) {
        String sql="update tab_user set status=? where uid=?";
        template.update(sql,"Y",user.getUid());
    }

    @Override
    public User findNamePassword(String username, String password) {
        User user=null;
        try {
            String sql="select * from tab_user where username=? and password=?";
            user=template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),username,password);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return user;
    }
}
