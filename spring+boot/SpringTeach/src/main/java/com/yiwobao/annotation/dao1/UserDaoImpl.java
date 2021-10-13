package com.yiwobao.annotation.dao1;

import com.yiwobao.annotation.dao.UserDao;
import com.yiwobao.annotation.pojo.User;
import org.springframework.stereotype.Repository;

@Repository("userDao1")
public class UserDaoImpl implements UserDao {

    @Override
    public Boolean login(User user) {

        if(user.getUname().equals("lisi")
                &&user.getPassword().equals("lisi")){
            return true;
        }
        return false;
    }
}
