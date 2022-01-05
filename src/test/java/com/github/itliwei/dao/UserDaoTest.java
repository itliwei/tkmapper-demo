package com.github.itliwei.dao; 
 
import com.github.itliwei.MyBaseMapper;
import com.github.itliwei.entity.User;
import com.github.itliwei.mapper.TestMapper;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/** 
* UserDao Tester. 
* 
* @author <Authors name> 
* @since <pre>十二月 30, 2021</pre> 
* @version 1.0 
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private Mapper mapper;

    @Autowired
    private MyBaseMapper myBaseMapper;

    @Autowired
    private TestMapper testMapper;

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 
    @Test
    public void testInsert(){
        User user = new User();
        user.setId(100L);
        user.setUsername("liwei");
        user.setPassword("123");
        int insert = userDao.save(user);
//        int insert = userMapper.insert(user);

        List<User> users = testMapper.findById(100L);

        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("id",100L);
        List list = userDao.searchByExample(example);
        Assert.isTrue(insert>1,"success");
    }

    @Test
    public void testQuery(){
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("id",100L);
        List list = userMapper.selectByExample(example);
        Assert.isTrue(list.size() > 1,"success");
    }


}
