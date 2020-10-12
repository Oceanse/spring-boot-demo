package com.example.srpingdemo.mongo;

import com.mongodb.BasicDBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;


/**
 *  MongoTemplate对MongoDB的CRUD的操作
 * User 已经通过@Document注解指定操作的集合名，把此model映射到数据库的中的my_user集合
 * User类
 */
@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @Autowired
    MongoTemplate mongoTemplate;


    /**
     * mongoTemplate.find 返回List
     * 根据名字查询，返回满足条件的所有user
     */
    @Override
    public List<User> usersFindByName(String name) {

       /* Query query=new Query();
        query.addCriteria(Criteria.where("name").is(name))

        //等价于Query query=new Query(Criteria.where("name").is(name));

        //等价于 Query query = Query.query(Criteria.where("name").is(name));

        //等价于
        Criteria criteria = new Criteria();
        criteria.and("name").is(name);
        Query query=new Query(criteria);
        ;

        Query query=new Query(Criteria.where("name").is(name));
        //按照年龄字段降序排列
        query.with(new Sort(Sort.Direction.DESC,"age"));
        //取满足前面条件的前两个文档
        query.limit(2);
        List<User> userList=mongoTemplate.find(query,User.class);
        return userList;*/
        return null;
    }


    /**
     * mongoTemplate.findOne
     * 根据名字查询，返回满足条件第一个文档
     */
    @Override
    public User userFindByName(String name){

        Query query=new Query(Criteria.where("name").is(name));
        //query.fields().include("age");
        //query.fields().exclude("name");


        User user = mongoTemplate.findOne(query, User.class);
        return user;
    }


    /**
     *
     * mongoTemplate 多条件 and 查询
     * @param name
     * @param age
     * @return
     */
    @Override
    public User userFindByNameAge(String name, int age) {


       /*等价于
       Query query = Query.query(where("name").is(name));
       Query query1 = query.addCriteria(where("age").is(age));

       等价于
       Criteria criteria = new Criteria();
       criteria.and("name").is(name);
       criteria.and("age").is(age);
       Query query=new Query(criteria);

       等价于
       Query query=new Query(Criteria.where("name").is(name).andOperator(Criteria.where("age").is(age)));
       一个Criteria中只能有一个andOperator，and可以多个，我们查询并列条件时，比较建议使用and方法。

        等价于
        BasicDBList basicDBList=new BasicDBList();
        basicDBList.add(new BasicDBObject("name",name));
        basicDBList.add(new BasicDBObject("age",age));
        DBObject obj =new BasicDBObject();
        obj.put("$and", basicDBList);
        Query query=new BasicQuery(obj);

        等价于
        QueryBuilder queryBuilder= new QueryBuilder();
        queryBuilder.and(new BasicDBObject("name",name),new BasicDBObject("age",age));
        Query query=new BasicQuery(queryBuilder.get());
       */

        Query query=Query.query(Criteria.where("name").is(name).and("age").is(age));
        User user = mongoTemplate.findOne(query,User.class);
        return user;
    }

    //根据年龄查询，待实现
    @Override
    public List<User> usersFindByAge(int age) {
        return null;
    }


    /**
     * mongoTemplate 根据属性数组中的某一元素查询
     *
     *   {
     *         	"score": [{"chin":100},{"math":1120},{"eng":1150}],
     *         	"name": "ocean2",
     *         	"age": 22
     *   }
     *
     */
    @Override
    public User userFindByScore(int num) {

        Query query=Query.query(new Criteria().and("score").elemMatch(Criteria.where("math").is(num)));
      /*等价于
      Query query=Query.query(Criteria.where("score.math").is(num));*/
        User user = mongoTemplate.findOne(query,User.class);
        return user;
    }



    /**
     * mongoTemplate 根据name和属性数组中的某一元素查询
     *
     *  {
     *      "score": [{"chin":100},{"math":1120},{"eng":1150}],
     *      "name": "ocean2",
     *      "age": 22
     *  }
     *
     * @param name
     * @param num
     * @return
     */
    @Override
    public User userFindByNameScore(String name, int num) {
        Query query=Query.query(Criteria.where("name").is(name).and("score").elemMatch(Criteria.where("math").is(num)));

        /*等价于
        Query query=Query.query(Criteria.where("name").is(name).and("score.math").is(num));*/
        User user = mongoTemplate.findOne(query,User.class);
        return user;
    }


    /**
     * where("hobby").in(myhobby)
     */
    @Override
    public User userFindByHobby() {
        List<String> myhobby= Arrays.asList("music","spotrs","code");
        List<Integer> score= Arrays.asList(100,200,300);
        Query query=Query.query(Criteria.where("hobby").in(myhobby));
        //Query query=Query.query(Criteria.where("score.chin").in(score));
        User user = mongoTemplate.findOne(query,User.class);
        return user;
    }


    /**
     *通过名字查询，并且只返回score属性，其它属性为默认值
     */
    @Override
    public User findByName(String name){

      /*  BasicDBObject dbObject = new BasicDBObject();
        dbObject.put("name", name);

        BasicDBObject fieldsObject = new BasicDBObject();
        fieldsObject.put("score", true);//只返回score属性
        fieldsObject.put("name", false);//name是主键，默认为true,这里设为false

        Query query = new BasicQuery(dbObject,fieldsObject);
        //或者Query query = new BasicQuery(dbObject.toJson(),fieldsObject.toJson());

        User user = mongoTemplate.findOne(query,User.class);
        return user;*/
        //{"name":null,"age":0,"score":[{"chin":100},{"math":1120},{"eng":1150}],"hobby":null}
        return null;
    }

    //增加用户
    //save：插入相同主键的文档时候会覆盖旧主键对应的文档
    //insert:插入相同主键的文档会产生duplicate key异常
    //插入操作时，java对象的所有属性都会映射到数据库文档中，若java对象某个属性值没有进行设置，那么文档的字段将采用改属性的默认值
    @Override
    public void addUser(String name,int age) {
        User user=new User();
        user.setName(name);
        user.setAge(age);
        mongoTemplate.insert(user);
    }





    //增加用户
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
    @Override
    public void addUser2(User user){
        mongoTemplate.save(user);
    }






    //删除用户
    @Override
    public void delByName(String name) {
        Query query=new Query(where("name").is(name));
        //query.with(new Sort(Sort.Direction.DESC,name));
        mongoTemplate.findAndRemove(query,User.class);
    }




    /**
     * 更新
     * 把名字为name的第一条文档对象的age属性值修改为150
     * @param name
     */
    @Override
    public void updateFirstByName(String name) {
       Query query=new Query(where("name").is(name));
       Update update=new Update();
       update.set("age",140);
       mongoTemplate.updateFirst(query,update,User.class);

       /*或者类似思路：
       * user = mongoTemplate.findOne(Query.query(Criteria.where("name").is("Jam")), User.class);
         user.setName("Neo");
         mongoTemplate.save(user, "user");
       * */



    }



    /**
     * 更新
     * mongoTemplate.updateMulti
     * @param name
     */
    @Override
    public void updateAllByName(String name) {
        Query query=new Query(where("name").is(name));
        Update update=new Update();
        update.set("age",130);
        mongoTemplate.updateMulti(query,update,User.class);
    }

}
