package com.lai.daoImpl;

import com.lai.dao.UserDao;
import com.lai.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/**
 * Created by lailai on 2017/9/18.
 */
@Component
public class UserDaoImpl implements UserDao{
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public void saveUser(User user) {
        mongoTemplate.save(user);
    }

    @Override
    public User findUserByUserName(String username) {
        Query query=new Query(Criteria.where("userName").is(username));
        User user=mongoTemplate.findOne(query,User.class);
        return user;
    }

    @Override
    public void updateUser(User user) {
        Query query=new Query(Criteria.where("id").is(user.getId()));
        Update update=new Update().set("userName",user.getUserName()).set("password",user.getPassword());
        mongoTemplate.updateFirst(query,update,User.class);
    }

    @Override
    public void deleteUserById(Long id) {
        Query query=new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,User.class);
    }
}
