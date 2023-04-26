package com.zpf;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zpf.dao.UserDao;
import com.zpf.domain.User;
import com.zpf.domain.query.UserQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.jws.soap.SOAPBinding;
import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SpringBootMybatisPlusApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void testGetAll() {
        //方式一：按条件查询
//        QueryWrapper qw = new QueryWrapper();
//        qw.lt("age",16);
//        List<User> users = userDao.selectList(qw);
//        System.out.println(users);
        //方式二：按条件查询  lambda格式
//        QueryWrapper<User> qw = new QueryWrapper();
//        qw.lambda().lt(User::getAge, 18);
//        List<User> list = userDao.selectList(qw);
//        System.out.println(list);

        //模拟页面传递过来的数据
//        UserQuery userQuery = new UserQuery();
//        userQuery.setAge(10);
//        userQuery.setAge2(30);

        //null判定

        //方式三：lambda格式
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        //10-30岁之间
//        lqw.lt(User::getAge,30).gt(User::getAge,10);
        //小于10岁或大于30
//        lqw.lt(null != userQuery.getAge2(), User::getAge, userQuery.getAge2());
//        lqw.ge(null != userQuery.getAge(), User::getAge, userQuery.getAge());

        //等同于=
//        lqw.eq(User::getName ,"苏苏").eq(User::getPassword ,"12341");
//        User user = userDao.selectOne(lqw);
//        System.out.println(user);

        //范围查询
        lqw.between(User::getAge,10,20);

        //模糊匹配
//        lqw.like(User::getName,"苏");

        List<User> users = userDao.selectList(lqw);
        System.out.println(users);
    }

    @Test
    void testGetById() {
        User user = userDao.selectById(1);
        System.out.println(user);
    }

    @Test
    void testInsert() {
        User user = new User();
        user.setName("ww");
        user.setAge(18);
        user.setPassword("12341");
        user.setTel("124551");

        userDao.insert(user);

    }

    @Test
    void testDelete() {
        ArrayList<Long> users = new ArrayList<>();
        users.add(5L);
        users.add(6L);
        userDao.deleteBatchIds(users);
//        userDao.deleteById(1650846994117738497L);
    }

    //逻辑删除  避免关联删除
    @Test
    void testDeleteLogic() {
        userDao.deleteById(3L);
    }

    @Test
    void testUpdate() {
//        User user = new User();
//        user.setId(1L);
//        user.setName("苏苏");
//        user.setAge(12);
//        user.setPassword("12341");
//        user.setVersion(1);
//        userDao.updateById(user);

        User user1 = userDao.selectById(1L);  //version=2
        User user2 = userDao.selectById(1L);  //version=2

        user1.setName("苏琬玥");
        userDao.updateById(user1);  //version=3

        user2.setName("朱鹏飞");
        userDao.updateById(user2);

    }

    @Test
    void testGetByPage() {
        Page<User> userPage = new Page<>(1, 2);
        userDao.selectPage(userPage, null);
        System.out.println("当前页：" + userPage.getCurrent());
        System.out.println("每页显示数：" + userPage.getSize());
        System.out.println("共多少页：" + userPage.getPages());
        System.out.println("一共多少条" + userPage.getTotal());
        System.out.println("数据：" + userPage.getRecords());
    }
}
