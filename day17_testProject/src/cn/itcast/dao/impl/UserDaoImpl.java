package cn.itcast.dao.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.domain.admin;
import cn.itcast.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        String sql="select * from user";
        List<User> list=template.query(sql,new BeanPropertyRowMapper<User>(User.class));
        System.out.println(list);
        return list;
    }
/*
    管理员登录功能
 */
    public admin findUserByUsernameAndPassword(String username,String password){
   try{
       String sql="select * from admin where username=? and password=?";
       admin admin=template.queryForObject(sql,new BeanPropertyRowMapper<admin>(admin.class),username,password);
       System.out.println(admin);
       return admin;
    }catch (Exception e){
       e.printStackTrace();
       return null;
   }
}
/*
添加用户功能
 */
    @Override
    public void add(User user) {
         String sql="insert into user values(null,?,?,?,?,?,?,?,?)";
         template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),
                 user.getQq(),user.getEmail(),user.getUsername(),user.getPassword());

    }
/*
删除选中行
 */
    @Override
    public void delUser(int parseInt) {
        String sql="delete from user where id=?";
        template.update(sql,parseInt);
    }
/*
  查询修改用户信息
 */
    @Override
    public User findById(int id) {
        String sql="select * from user where id=?";
        User user= template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);
        return user;
    }
    /*
      修改功能
     */
    @Override
    public void update(User user) {
        String sql="update user set name=? , gender=? , " +
                " age=? , address=? , qq=? , email=? , " +
                "username=? , password=? where id=?";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getUsername(),user.getPassword(),user.getId());
    }
/*
  删除选中多行
 */
    @Override
    public void delSelectedUser(String[] ids) {
        if(ids!=null&ids.length!=0){
            for(String id:ids){
                delUser(Integer.parseInt(id));
            }
        }

    }
/*
查找总记录数
 */
    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        String sql="select count(*) from user where 1=1 ";

        Set<String> set=condition.keySet();
        StringBuilder sb=new StringBuilder(sql);
        List<Object> params=new ArrayList<Object>();
        for (String key:set){
            //排除分页参数
            if("currentPage".equals(key)||"row".equals(key)){
                continue;
            }
            String value=condition.get(key)[0];
            if(value!=null&&!(value.equals(""))){
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");

            }
        }


        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }
/*
   分页后的显示list
 */
    @Override
    public List<User> findUserListByPage(int start, int row, Map<String, String[]> condition) {
        String sql="select * from user where 1=1 ";

        Set<String> set=condition.keySet();
        StringBuilder sb=new StringBuilder(sql);
        List<Object> params=new ArrayList<Object>();
        for (String key:set){
            //排除分页参数
            if("currentPage".equals(key)||"row".equals(key)){
                continue;
            }
            String value=condition.get(key)[0];
            if(value!=null&&!(value.equals(""))){
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");

            }
        }
        sb.append(" limit ?,?");
        params.add(start);
        params.add(row);
        sql=sb.toString();
        return template.query(sql,new BeanPropertyRowMapper<User>(User.class),params.toArray());
    }


}
