package cn.itcast.travel.service;

import cn.itcast.travel.domain.User;
import org.apache.commons.beanutils.BeanUtils;

public interface UserService {
   Boolean regist(User user);

    Boolean active(String code);

    User login(User user);
}
