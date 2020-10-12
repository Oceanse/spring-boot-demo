package com.example.srpingdemo.mongo;

import com.example.srpingdemo.mongo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 1.通过继承Spring Data MongoDb Repository可以使你不用写相关的查询组合语句，它会内部为我们实现这样的一个类
 * 2.只要你按规定定义好方法名或者特定注解就可以免去你写查询组合语句。
 * 3. service中注入该接口就可以使用，无需实现里面的方法，spring会根据定义的规则自动生成
 * 4. MongoRepository实现了的只是最基本的增删改查的功能，要想增加额外的查询方法，需要按照规则定义接口的方法
 */
@Repository
public interface UserRepository_MongoRepository extends MongoRepository<User,String> {

    //内置方法：
    // List<T> findAll();
    //<S extends T> S insert(S var1);
    //<S extends T> List<S> insert(Iterable<S> var1);


    //自定义方法
    public List<User> findByName(String name); //按照某个属性查询： find + By + 属性名（首字母大写）
    public List<User> findByNameLike(String name);//按照某个属性模糊查询： find + By + 属性名（首字母大写） + Like
    public Page<User> findByHobbyLike(String hobby, Pageable pageable);//模糊查询+分页


    //统计指定name的数量
    long countByName(String name);


    //Query注解添加到存储库查询方法可以指定要使用的查询字符串，可以替代方法名称派生查询
    //?0标识匹配方法的第一个参数，?1标识匹配方法的第二个参数
    //方法名可以随意命名
    //最终效果等价于 public List<User> findByName(String name);
    @Query(value="{'name':?0}")
    public List<User> findByUserName(String name);

    //这里如果age参数没有什么作用，那么等价于上面findByUserName(String name) 方法
    @Query(value="{'name':?1}")//按照第二个参数查询
    public List<User> findByUserName(int age, String name);


    //fields是我们指定的返回字段，其中id是自动返回的，不用我们指定
    //'name':1,  1代表true，也就是代表返回的意思；其他属性返回值是默认值
    @Query(fields="{'name':1, 'age':1}")
    public List<User> findByAge(int age);//[{"name":"ocean2","age":22,"score":null,"hobby":null}]



    //按照 name 模糊分页查询，只返回name属性
    @Query(fields="{'name':1}")
    public List<User> findByNameLike(String name,Pageable pageable );



    //关于大小比较方法名的规则
    public List<User> findByAgeGreaterThan(int age);//GreaterThan(大于)
    public List<User> findByAgeLessThan(int age);//LessThan（小于）
    public List<User> findByAgeBetween(int age);//Between（在…之间）
    public List<User> findByNameNot(String name);//Not（不包含）




}
