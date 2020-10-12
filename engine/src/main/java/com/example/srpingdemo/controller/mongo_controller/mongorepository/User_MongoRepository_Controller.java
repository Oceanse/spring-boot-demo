package com.example.srpingdemo.controller.mongo_controller.mongorepository;

import com.example.srpingdemo.mongo.UserRepository_MongoRepository;
import com.example.srpingdemo.mongo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Arrays;
import java.util.List;


/**
 * 1.通过继承Spring Data MongoDb Repository可以使你不用写相关的查询组合语句，它会内部为我们实现这样的一个类
 * 2.只要你按规定定义好方法名就可以免去你写查询组合语句。
 * 3. service中注入该接口就可以使用，无需实现里面的方法，spring会根据定义的规则自动生成
 * 4. MongoRepository实现了的只是最基本的增删改查的功能，要想增加额外的查询方法，需要按照规则定义接口的方法
 */
@RestController
public class User_MongoRepository_Controller {
    @Autowired
    UserRepository_MongoRepository userRepository_mongoRepository;


    /**
     * 查询
     * MongoRepository 自带方法findAll
     * 注意不能写成 @GetMapping("/listallusers/")
     *
     * @return
     */
    @GetMapping("/listallusers")
    public List<User> listAllUsers() {
        List<User> users = userRepository_mongoRepository.findAll();//直接调用MongoRepository中的 List<T> findAll();
        return users;
    }


    /**
     * 插入
     *  MongoRepository 自带方法<S extends T> S insert(S var1);
     */
    @GetMapping("/repoadduser")
    public void addUser() {
        User user = new User();
        user.setName("dd");
        user.setAge(30);
        user.setHobby("sports");
        userRepository_mongoRepository.insert(user);
    }


    /**
     * 更新
     *  MongoRepository 自带方法 <S extends T> List<S> save(Iterable<S> var1);
     */
    @GetMapping("/updateuser")
    public void update() {
        User user = new User();
        user.setName("dd");
        user.setAge(120);
        user.setHobby("music");
        List list=Arrays.asList(user);
        //userRepository_mongoRepository.save(list);
    }



    @GetMapping("/delete")
    public void delete() {
        User user = new User();
        user.setName("dd");
        user.setAge(120);
        user.setHobby("music");
        List list=Arrays.asList(user);
        userRepository_mongoRepository.deleteAll(); //清空表中所有的数据
    }





    /**
     * 增加
     * MongoRepository 自带方法save(Iterable<S> var1)
     */
    @GetMapping("/adduser2")
    public void addUsers2() {
        User user1 = new User();
        user1.setName("aaa");
        user1.setAge(27);
        user1.setHobby("music");

        User user2 = new User();
        user2.setName("bbb");
        user2.setAge(28);
        user2.setHobby("sports");

        User user3 = new User();
        user2.setName("ccc");
        user2.setAge(33);
        user2.setHobby("sports");

        List<User> list = Arrays.asList(user1, user2,user3);
        userRepository_mongoRepository.insert(list);
    }


    /**
     * 查询
     * MongoRepository自定义方法
     * find + By + 属性名（首字母大写）
     *
     * @param name
     * @return
     */
    @GetMapping("/listusers/{name}")
    public List<User> listUsersByName(@PathVariable("name") String name) {
        List<User> users = userRepository_mongoRepository.findByName(name);
        return users;
    }


    /**
     * 模糊查询
     * MongoRepository自定义方法
     * find + By + 属性名（首字母大写） + Like
     *
     * @param name
     * @return
     */
    @GetMapping("/fuzzyQuery/{name}")
    public List<User> fuzzyQueryByName(@PathVariable("name") String name) {
        List<User> users = userRepository_mongoRepository.findByNameLike(name);
        return users;
    }

    /**分页查询
     *  MongoRepository自带方法： findAll(Pageable pageable);
     * http://localhost:8083/pageQuery?pageNumber=0&pageSize=5 每页5条记录，查看首页，页码从0开始
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @GetMapping("/pageQuery")
    public List<User> pageQueryByName(
            @PathParam("pageNumber") int pageNumber,//pageNumber=0时对应的是首页
            @PathParam("pageSize") int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);//public PageRequest(int page, int size)
        Page<User> all = userRepository_mongoRepository.findAll(pageable);
        List<User> users = all.getContent();
        return users;
    }

    /**
     * 模糊查询+分页
     * http://localhost:8083/pageFuzzyByHobby/spo?pageNumber=0&pageSize=3  每页3条记录，查看首页，页码从0开始
     * @param hobby
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @GetMapping("/pageFuzzyByHobby/{hobby}")
    public List<User> pageFuzzyQueryByHobby(
            @PathVariable("hobby") String hobby,
            @PathParam("pageNumber") int pageNumber,//pageNumber=0时对应的是首页
            @PathParam("pageSize") int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);//public PageRequest(int page, int size)
        Page<User> all = userRepository_mongoRepository.findByHobbyLike(hobby,pageable);
        List<User> users = all.getContent();
        return users;
    }



    /**
     * 返回大于age的user
     * @param age
     * @return
     */
    @GetMapping("/query/agethan/{age}")
    public List<User> ageGreaterThan(@PathVariable("age") int age) {
        List<User> users = userRepository_mongoRepository.findByAgeGreaterThan(age);
        return users;
    }


    /**
     * 返回所有数量
     * @return
     */
    @GetMapping("/query/countall")
    public long countall() {
        long count = userRepository_mongoRepository.count();
        return count;
    }


    /**
     * 返回指定name的数量
     * @param name
     * @return
     */
    @GetMapping("/query/count/{name}")
    public long countByName(@PathVariable("name") String name) {
        long count = userRepository_mongoRepository.countByName(name);
        return count;
    }



    /**
     * Query注解添加到存储库查询方法可以指定要使用的查询字符串，可以替代方法名称派生查询
     * @param username
     * @return
     */
    @GetMapping("/query/{username}")
    public List<User> queryByUserName(@PathVariable("username") String username) {
        List<User> users = userRepository_mongoRepository.findByUserName(1,username);
        return users;
    }


    /**
     * Query注解中的 fields是我们指定的返回字段
     * @param age
     * @return
     */
    @GetMapping("/query/age/{age}")
    public List<User> queryByAge(@PathVariable("age") int age) {
        List<User> users = userRepository_mongoRepository.findByAge(age);
        return users;
    }





}
