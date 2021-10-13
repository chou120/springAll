package com.yiwobao.springboot_11_plus;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yiwobao.springboot_11_plus.mapper.UserMapper;
import com.yiwobao.springboot_11_plus.pojo.User;
import com.yiwobao.springboot_11_plus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Springboot11PlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        List<User> list = userMapper.selectList(null);
        assertEquals(5, list.size());
        list.forEach(System.out::println);
    }


    @Test
    public void test3() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("id", "name", "email").likeRight("name", "黄");
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }


// 按照直属上级进行分组，查询每组的平均年龄，最大年龄，最小年龄

    /**
     * select avg(age) avg_age ,min(age) min_age, max(age) max_age from user group by manager_id having sum(age) < 500;
     **/

    @Test
    public void test4() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("manager_id", "avg(age) avg_age", "min(age) min_age", "max(age) max_age")
                .groupBy("manager_id").having("sum(age) < {0}", 500);
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }


    /*   select
     */
    @Test
    public void test5() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("id", "name").like("name", "黄");
        List<Object> objects = userMapper.selectObjs(wrapper);
        //List<User> users = userMapper.selectList(wrapper);


        objects.forEach(System.out::println);
    }


    @Test
    public void test6() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name", "黄");
        Integer count = userMapper.selectCount(wrapper);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }


    @Test
    void testInsert() {
        User user = new User();
        user.setName("张大炮");
        user.setEmail("19908488818@163.com");
        user.setAge(23);
        user.setManagerId(78L);
        int insert = userMapper.insert(user);//帮我们自动生成id
        System.out.println("id=" + user.getId());   //id会自动回填
    }


    @Test
    void testVserion() {
        // 1、查询用户信息
       /* User user = userMapper.selectById(125);
        int version=user.getVersion();
        user.setAge(456);
        user.setName("yuanj");
        user.setVersion(version);
        userMapper.updateById(user);
        */


        User user = userMapper.selectById(125);

        // 第一次使用
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "葛二蛋");
        userMapper.update(user, wrapper);

        // 第二次复用
        user.setAge(3);
        userMapper.update(user, wrapper);


    }


    @Test
    public void selectPage() {

        Page<User> userPage = new Page<>();
        userPage.setCurrent(1L);  //当前是第几页 默认为1
        userPage.setSize(2);  //每页大小
        IPage<User> userIPage = userMapper.selectPage(userPage, null);

        System.out.println("当前页" + userIPage.getCurrent());  //当前页
        System.out.println("总页数" + userIPage.getPages()); //总页数
        System.out.println("返回数据" + userIPage.getRecords());  //返回数据
        System.out.println("每页大小" + userIPage.getSize());  //每页大小
        System.out.println("满足符合条件的条数" + userIPage.getTotal());  //满足符合条件的条数
        System.out.println("下一页" + userPage.hasNext());   //下一页
        System.out.println("上一页" + userPage.hasPrevious());  //上一页
    }


    @Autowired
    private UserService userService;

    @Test
    public void testGetOne() {

       /* QueryWrapper<User> wrapper = Wrappers.query();
        wrapper.gt("age",28);
        User one = userService.getOne(wrapper, false); // 第二参数指定为false,使得在查到了多行记录时,不抛出异常,而返回第一条记录

        System.out.println(one);*/


        List<User> user = userService.query().gt("age", 28).list();
        user.forEach(System.out::println);

    }


    @Test
    public void testWrappers() {
        // 案例先展示需要完成的SQL语句，后展示Wrapper的写法
        List<User> users=null;
        // 1. 名字中包含佳，且年龄小于25
        // SELECT * FROM user WHERE name like '%佳%' AND age < 25
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        System.out.println("1------------\n");
       /* wrapper.like("name", "佳").lt("age", 25);
        users= userMapper.selectList(wrapper);*/
        // 下面展示SQL时，仅展示WHERE条件；展示代码时, 仅展示Wrapper构建部分
        System.out.println("2------------\n");
        // 2. 姓名为黄姓，且年龄大于等于20，小于等于40，且email字段不为空
        // name like '黄%' AND age BETWEEN 20 AND 40 AND email is not null
        wrapper.likeRight("name", "黄").between("age", 20, 40).isNotNull("email");
        users = userMapper.selectList(wrapper);
        System.out.println("3------------\n");

        // 3. 姓名为黄姓，或者年龄大于等于40，按照年龄降序排列，年龄相同则按照id升序排列
        // name like '黄%' OR age >= 40 order by age desc, id asc
        wrapper.likeRight("name", "黄").or().ge("age", 40).orderByDesc("age").orderByAsc("id");
        users = userMapper.selectList(wrapper);
        System.out.println("4------------\n");

        // 4.创建日期为2021年3月22日，并且直属上级的名字为李姓
        // date_format(create_time,'%Y-%m-%d') = '2021-03-22' AND manager_id IN (SELECT id FROM user WHERE name like '李%')
        wrapper.apply("date_format(create_time, '%Y-%m-%d') = {0}", "2021-03-22")  // 建议采用{index}这种方式动态传参, 可防止SQL注入
                .inSql("manager_id", "SELECT id FROM user WHERE name like '李%'");
        users = userMapper.selectList(wrapper);
        System.out.println("4------------\n");

        // 上面的apply, 也可以直接使用下面这种方式做字符串拼接，但当这个日期是一个外部参数时，这种方式有SQL注入的风险
        wrapper.apply("date_format(create_time, '%Y-%m-%d') = '2021-03-22'");
        users = userMapper.selectList(wrapper);
        System.out.println("5------------\n");

        // 5. 名字为王姓，并且（年龄小于40，或者邮箱不为空）
        // name like '王%' AND (age < 40 OR email is not null)
        wrapper.likeRight("name", "王").and(q -> q.lt("age", 40).or().isNotNull("email"));
        users = userMapper.selectList(wrapper);
        System.out.println("6------------\n");

        // 6. 名字为王姓，或者（年龄小于40并且年龄大于20并且邮箱不为空）
        // name like '王%' OR (age < 40 AND age > 20 AND email is not null)
        wrapper.likeRight("name", "王").or(
                q -> q.lt("age", 40)
                        .gt("age", 20)
                        .isNotNull("email")
        );
        users = userMapper.selectList(wrapper);
        System.out.println("7------------\n");

        // 7. (年龄小于40或者邮箱不为空) 并且名字为王姓
        // (age < 40 OR email is not null) AND name like '王%'
        wrapper.nested(q -> q.lt("age", 40).or().isNotNull("email"))
                .likeRight("name", "王");
        users = userMapper.selectList(wrapper);
        System.out.println("8------------\n");

        // 8. 年龄为30，31，34，35
        // age IN (30,31,34,35)
        wrapper.in("age", Arrays.asList(30, 31, 34, 35));
        users = userMapper.selectList(wrapper);
        System.out.println("8------------\n");

        // 或
        wrapper.inSql("age", "30,31,34,35");
        users = userMapper.selectList(wrapper);
        System.out.println("9------------\n");

        // 9. 年龄为30，31，34，35, 返回满足条件的第一条记录
        // age IN (30,31,34,35) LIMIT 1
        wrapper.in("age", Arrays.asList(30, 31, 34, 35)).last("LIMIT 2");
        users = userMapper.selectList(wrapper);
        System.out.println("10------------\n");

        // 10. 只选出id, name 列 (QueryWrapper 特有)
        // SELECT id, name FROM user;
        wrapper.select("id", "name");
        users = userMapper.selectList(wrapper);
        System.out.println("11------------\n");

        // 11. 选出id, name, age, email, 等同于排除 manager_id 和 create_time
        // 当列特别多, 而只需要排除个别列时, 采用上面的方式可能需要写很多个列, 可以采用重载的select方法，指定需要排除的列
        wrapper.select(User.class, info -> {
            String columnName = info.getColumn();
            return !"create_time".equals(columnName) && !"manager_id".equals(columnName);
        });



    }


    @Test
    public void testX() {
        User user = new User();
        user.setName("黄主管");
        user.setAge(28);

        QueryWrapper<User> wrapper = new QueryWrapper<>(user);
        List<User> users = userMapper.selectList(wrapper);

        users.forEach(System.out::println);
    }

    @Test
    public void testXX() {
        User user = new User();
        user.setName("黄");
        QueryWrapper<User> wrapper = new QueryWrapper<>(user);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }




    @Test
    public void testY() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        Map<String, Object> param = new HashMap<>();
        param.put("age", 40);
        param.put("name", "黄飞飞");
        wrapper.allEq(param);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void testZ() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        Map<String, Object> param = new HashMap<>();
        param.put("age", 40);
        param.put("name", null);
        wrapper.allEq(param);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }





    @Test
    public void testLambda() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(User::getName, "黄").lt(User::getAge, 30);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }


    @Test
    public void testLambda2() {
        LambdaQueryChainWrapper<User> chainWrapper = new LambdaQueryChainWrapper<>(userMapper);
        List<User> users = chainWrapper.like(User::getName, "黄").gt(User::getAge, 30).list();
        users.forEach(System.out::println);
    }



    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(2L);
        user.setAge(18);
        userMapper.updateById(user);
    }


    @Test
    public void testUpdate3() {
        User whereUser = new User();
        whereUser.setAge(23);
        whereUser.setName("张");
        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<>(whereUser);
        User user = new User();
        user.setEmail("zasd@baomidou.com");
        user.setManagerId(10L);

        userMapper.update(user, wrapper);
    }


    @Test
    public void testUpdate4() {
        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<>();
        wrapper.likeRight(User::getEmail, "boss").set(User::getManagerId, 8L);
        userMapper.update(null, wrapper);
    }



    @Test
    public void testCustomRawSql() {
        /*List<User> users = userMapper.selectRaw();
        users.forEach(System.out::println);
*/
        LambdaQueryWrapper<User> wrapper =new LambdaQueryWrapper<User>();
        /*List<User> all = userMapper.findAll(wrapper);
        all.forEach(System.out::println);*/

        wrapper =new LambdaQueryWrapper<User>();
        wrapper.likeRight(User::getName,"张");
        List<User> byName = userMapper.findByName(wrapper);
        byName.forEach(System.out::println);


    }





    @Test
    public void testPage() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.ge(User::getAge, 28);
        // 设置分页信息, 查第3页, 每页2条数据  不去查询总数
        Page<User> page = new Page<>(3, 2,false);
        // 执行分页查询
        Page<User> userPage = userMapper.selectPage(page, wrapper);
        System.out.println("总记录数 = " + userPage.getTotal());
        System.out.println("总页数 = " + userPage.getPages());
        System.out.println("当前页码 = " + userPage.getCurrent());
        // 获取分页查询结果
        List<User> records = userPage.getRecords();
        records.forEach(System.out::println);
    }


    @Test
    public void testAuto() {
        User user = new User();
        user.setName("我是青蛙呱呱");
        user.setAge(99);
        user.setEmail("frog@baomidou.com");
        user.setCreateTime(LocalDateTime.now());
        userMapper.insert(user);
        System.out.println(user.getId());
    }


















}
