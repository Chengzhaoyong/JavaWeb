package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.Userdao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;

public class UserServiceImpl implements UserService {
    private Userdao userdao=new UserDaoImpl();
    @Override
    public Boolean regist(User user) {
      User u=userdao.findUsername(user.getUsername());
      if(u!=null){
          //用户名存在
          return true;
      }else{
        user.setCode(UuidUtil.getUuid());
        user.setStatus("N");
        userdao.save(user);
        String content="<a>http://localhost:8080/user/active?code="+user.getCode()+"</a>";
        MailUtils.sendMail(user.getEmail(),content,"激活邮件");
      }
        return false;
    }

    @Override
    public Boolean active(String code) {
        User user=userdao.findCode(code);
        if(user!=null){
          userdao.updateStatus(user);
            return true;
        }
        return false;
    }

    //登录功能，查找是否存在该用户名密码
    @Override
    public User login(User user) {
       return userdao.findNamePassword(user.getUsername(),user.getPassword());

    }
}
