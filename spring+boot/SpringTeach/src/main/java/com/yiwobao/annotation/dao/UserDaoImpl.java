package com.yiwobao.annotation.dao;

import com.yiwobao.annotation.pojo.User;
import org.springframework.stereotype.Repository;

/*给创建的bean一个实例名称*/
@Repository("userDao")
public class UserDaoImpl  implements UserDao{

    @Override
    public Boolean login(User user) {

        if(user.getUname().equals("zhangsan")
                &&user.getPassword().equals("123")){
            return true;
        }
        return false;
    }
}
