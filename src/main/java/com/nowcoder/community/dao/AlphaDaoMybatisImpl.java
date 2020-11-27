package com.nowcoder.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
//优先级高
public class AlphaDaoMybatisImpl implements AlphaDao {
    @Override
    public String select(){
        return "MyBatis";
    }
}
