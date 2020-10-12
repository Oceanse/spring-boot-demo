package com.example.srpingdemo.controller.mongo_controller.mongotemplate;


import com.example.srpingdemo.mongo.UserRepositoryCustom;
import com.example.srpingdemo.mongo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;


/**
 * MongoTemplate对MongoDB的CRUD的操作
 */
@RestController
public class User_Mongotemplate_Controller {

    @Autowired
    UserRepositoryCustom userRepositoryCustom;




    /**
     * 查询
     * mongoTemplate.find 返回List
     *
     * @param name
     * @return
     */
    @GetMapping("/findusers/{name}")
    public List<User> findUsersByName(@PathVariable("name") String name) {
        List<User> users = userRepositoryCustom.usersFindByName(name);
        return users;
    }


    /**
     * 查询
     * mongoTemplate.findOne 返回满足条件第一个文档
     *
     * @param name
     * @return
     */
    @GetMapping("/finduser/{name}")
    public User findUserByName(@PathVariable("name") String name) {
        User user = userRepositoryCustom.userFindByName(name);
        return user;
    }



    /**
     * 查询 http://localhost:8083/findMyuser?name=ocean&age=28
     * mongoTemplate 多条件 and 查询
     *
     * @param name
     * @param age
     * @return
     */
    @GetMapping("/findMyuser")
    public User findUserBynameAndAge(@PathParam("name") String name, @PathParam("age") int age) {
        User user = userRepositoryCustom.userFindByNameAge(name, age);
        return user;
    }


    /**
     * mongoTemplate 根据属性数组中的某一元素查询
     * {
     * "score": [{"chin":100},{"math":1120},{"eng":1150}],
     * "name": "ocean2",
     * "age": 22
     * }
     *
     * @param math
     * @return
     */
    @GetMapping("/findMyuserbyscore")
    public User findUserByScore(@PathParam("math") int math) {
        User user = userRepositoryCustom.userFindByScore(math);
        return user;
    }


    /**
     * mongoTemplate  根据name和属性数组中的某一元素查询
     * {
     * "score": [{"chin":100},{"math":1120},{"eng":1150}],
     * "name": "ocean2",
     * "age": 22
     * }
     */
    //http://localhost:8083/findMyuserbyscore?name=ocean&math=1120
    @GetMapping("/findMyuserbynamescore")
    public User findUserByNameScore(@PathParam("name") String name, @PathParam("math") int math) {
        User user = userRepositoryCustom.userFindByNameScore(name, math);
        return user;
    }


    /**
     * Criteria.where("hobby").in(myhobby)
     * @return
     */
    @GetMapping("/findMyuserbyhobby")
    public User findUserByHobby() {
        User user = userRepositoryCustom.userFindByHobby();
        System.out.println(user);
        return user;
    }


    /**
     * 查询,只返回score属性,其他属性为默认值
     * @param name
     * @return
     */
    @GetMapping("/findScoreByName/{name}")
    public User findScoreByName(@PathVariable("name") String name) {
        User user = userRepositoryCustom.findByName(name);
        System.out.println(user);
        return user;
    }


    //增加 Postman测试
     /*
    当用postman发送restful请求时， 对应json中有但是User类中没有的字段，
    依然可以生成文档对象，只是文档对象没有多余的字段（score字段）
    猜测：json---->User对象---->文档对象
    POST localhost:8083/adduser2

    {
	"score": [{"chin":1000},{"math":1120},{"eng":1150}],
	"name": "ocean2",
	"age": 22,
	"sex":"man"
    }

	但是mongo原生操作：db.my_user.save({
                    	"score": [{"chin":1000},{"math":1120},{"eng":1150}],
	                    "name": "ocean2",
                    	"age": 22,
                    	"sex":"man"
                        })
    会生成和插入文档完全相同的对象,因为不需要经过javaEntity转换
*/
    @PostMapping("/adduser2")
    public void addUsers2(@RequestBody User user) {
        userRepositoryCustom.addUser2(user);
    }





    /**
     *  增加
     *  http://localhost:8083/adduser?name=ocean&age=28
     *  mongoTemplate.insert(user);
     *
     * @param name
     * @param age
     */
    @GetMapping("/adduser")
    public void addUsers(@PathParam("name") String name, @PathParam("age") int age) {
        userRepositoryCustom.addUser(name, age);
        System.out.println("insert a user who name is " + name + " and age is " + age);
    }



    /**
     * mongoTemplate.findAndRemove
     * 删除
     * @param name
     */
    @GetMapping("/removeuser/{name}")
    public void removeUserByName(@PathVariable("name") String name) {
        userRepositoryCustom.delByName(name);
    }



    /**
     * 更新第一个文档对象的age
     * mongoTemplate.updateFirst
     * @param name
     */
    @GetMapping("/updateuserbyname/{name}")
    public void updateFirstUserByName(@PathVariable("name") String name) {
        userRepositoryCustom.updateFirstByName(name);
    }



    /**
     * 更新所有文档对象的age
     * mongoTemplate.updateMulti(query,update,User.class);
     * @param name
     */
    @GetMapping("/updateusersbyname/{name}")
    public void updateAllUsersByName(@PathVariable("name") String name) {
        userRepositoryCustom.updateAllByName(name);
    }























}
