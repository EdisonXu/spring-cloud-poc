package com.edi.services.persist;

import com.edi.common.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

/**
 * Created by Edison Xu on 2016/12/27.
 */
@Component
public class UserDao {

    private final SqlSession sqlSession;

    public UserDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public User selectUserById(long id){
        return this.sqlSession.selectOne("selectUserById", id);
    }


}
