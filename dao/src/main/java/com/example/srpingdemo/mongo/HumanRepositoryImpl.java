package com.example.srpingdemo.mongo;

import com.example.srpingdemo.mongo.Human;
import com.example.srpingdemo.mongo.Tiger;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class HumanRepositoryImpl {

    private String collectionName="pets";

    @Autowired
    MongoTemplate mongoTemplate;





 /*   public void savePets(){
        Human human=new Human();
        List<Tiger> pets=Arrays.asList(new Tiger("aa",32),new Tiger("bb",23),new Tiger("cc2",32));
        human.setName("ocean");
        human.setTigers(pets);
        mongoTemplate.save(human);
    }







       //findHuman  findHuman2 findHuman3结果是相同的
        public List<Human> findHuman(){

        DBObject queryObject = new BasicDBObject();
        queryObject.put("name","ocean");//查询条件

        DBObject fieldsObject = new BasicDBObject();
            fieldsObject.put("name", true);  //只显示name属性的值，其它属性为默认值null或者0等
        fieldsObject.put("_id", false);

        Query query = new BasicQuery(queryObject,fieldsObject);
        return mongoTemplate.find(query,Human.class);//[{"name":"ocean","tigers":null},{"name":"ocean","tigers":null}]
    }
*/

    //findHuman  findHuman2 findHuman3结果是相同的
    /*public List<Human> findHuman2(){

        DBObject queryObject = Query.query(Criteria.where("name").is("ocean")).getQueryObject();//查询条件

        DBObject fieldsObject = new BasicDBObject();
        fieldsObject.put("name", true);  //只显示name属性的值，其其它属性为默认值null或者0等
        fieldsObject.put("_id", false);

        Query query = new BasicQuery(queryObject,fieldsObject);
        return mongoTemplate.find(query,Human.class);//[{"name":"ocean","tigers":null},{"name":"ocean","tigers":null}]
    }*/


    //findHuman  findHuman2 findHuman3结果是相同的
    public List<Human> findHuman3(){

        Aggregation aggregation=Aggregation.newAggregation(
                Aggregation.match(Criteria.where("name").is("ocean")),
                Aggregation.project("name")
        );
        List<Human> humans = mongoTemplate.aggregate(aggregation,collectionName, Human.class).getMappedResults();
        return humans;
    }


    //findHuman4 findHuman5效果相同
    //只显示Human类的tigers属性
    /*[{"name":null,"tigers":[{"tigerName":"aa","age":32},{"tigerName":"bb","age":23},{"tigerName":"cc","age":32}]},
       {"name":null,"tigers":[{"tigerName":"aa4","age":324},{"tigerName":"bb4","age":234},{"tigerName":"cc4","age":324}]}]*/
  /*  public List<Human> findHuman4(){

        DBObject queryObject = new BasicDBObject();
        queryObject.put("name","ocean");//查询条件

        DBObject fieldsObject = new BasicDBObject();
        fieldsObject.put("tigers", true);  //只显示tigers属性的值，其它属性为默认值null或者0等
        fieldsObject.put("_id", false);

        Query query = new BasicQuery(queryObject,fieldsObject);
        return mongoTemplate.find(query,Human.class);
    }*/


    //findHuman4 findHuman5 findHuman6 findHuman6_2效果相同
    public List<Human> findHuman5(){

        Aggregation aggregation=Aggregation.newAggregation(
                Aggregation.match(Criteria.where("name").is("ocean")),
                Aggregation.project("tigers")
        );
        List<Human> humans = mongoTemplate.aggregate(aggregation,collectionName, Human.class).getMappedResults();
        return humans;
    }


    //findHuman4 findHuman5 findHuman6效果相同
/*    public List<Human> findHuman6(){

        DBObject queryObject = Query.query(Criteria.where("name").is("ocean")).getQueryObject();//查询条件

        DBObject fieldsObject = new BasicDBObject();
        fieldsObject.put("tigers", true);
        fieldsObject.put("_id", false);

        Query query = new BasicQuery(queryObject,fieldsObject);
        return mongoTemplate.find(query,Human.class);//[{"name":"ocean","tigers":null},{"name":"ocean","tigers":null}]
    }*/

   /* public List<Human> findHuman6_2(){

        DBObject queryObject = Query.query(Criteria.where("name").is("ocean")).getQueryObject();//查询条件

        DBObject fieldsObject = new BasicDBObject("tigers",1);

        Query query = new BasicQuery(queryObject,fieldsObject);
        return mongoTemplate.find(query,Human.class);//[{"name":"ocean","tigers":null},{"name":"ocean","tigers":null}]
    }
*/






     //findHuman7  findHuman9效果相同
    //只显示tigers.name属性的值，其它属性为默认值null或者0等
    /*[{"name":null,"tigers":[{"tigerName":"aa","age":0},{"tigerName":"bb","age":0},{"tigerName":"cc","age":0}]},
       {"name":null,"tigers":[{"tigerName":"aa4","age":0},{"tigerName":"bb4","age":0},{"tigerName":"cc4","age":0}]}]*/
/*
    public List<Human> findHuman7(){

        DBObject queryObject = Query.query(Criteria.where("name").is("ocean")).getQueryObject();//查询条件

        DBObject fieldsObject = new BasicDBObject();
        fieldsObject.put("tigers.tigerName", true);
        fieldsObject.put("_id", false);

        Query query = new BasicQuery(queryObject,fieldsObject);
        return mongoTemplate.find(query,Human.class);//[{"name":"ocean","tigers":null},{"name":"ocean","tigers":null}]
    }
*/


    //不明白
    public List<Human> findHuman8(){

        Aggregation aggregation=Aggregation.newAggregation(
                Aggregation.match(Criteria.where("name").is("ocean")),
                Aggregation.project("tigers.tigerName")
        );
        List<Human> humans = mongoTemplate.aggregate(aggregation,collectionName, Human.class).getMappedResults();
        return humans;
    }


/*    public List<Human> findHuman9(){

        DBObject queryObject = Query.query(Criteria.where("name").is("ocean")).getQueryObject();

        DBObject fieldsObject = new BasicDBObject();
        fieldsObject.put("tigers.tigerName", true);
        fieldsObject.put("_id", false);

        Query query = new BasicQuery(queryObject,fieldsObject);
        return mongoTemplate.find(query,Human.class);
    }*/


    public List<Tiger> findTigers3(){

        List<String> names= Arrays.asList("ocean","ocean2");
        List<String> petNames= Arrays.asList("aa","bb2","cc3");
        Aggregation aggregation=Aggregation.newAggregation(
                Aggregation.unwind("tigers"),
                Aggregation.match(Criteria.where("name").in(names)),
                //Aggregation.project("tigers.tigerName")  结果：[{"tigerName":"aa","age":0},{"tigerName":"bb","age":0},{"tigerName":"cc","age":0}]
                Aggregation.project("tigers.tigerName","tigers.age")
        );
        return mongoTemplate.aggregate(aggregation, collectionName, Tiger.class).getMappedResults();
    }








   /* public List<Tiger> findTigers(){

        Aggregation aggregation=Aggregation.newAggregation(
                Aggregation.group("name").count().as("总人数")
        );
        return mongoTemplate.aggregate(aggregation, "pets", Tiger.class).getMappedResults();
    }*/
  /*  public List<Human> findTigers(){

        List<String> petNames= Arrays.asList("aa","bb","cc");
                Query query=new Query(Criteria.where("tigers.tigerName").in(petNames));
        return mongoTemplate.find(query,Human.class);
    }*/


    //等价于 public List<Human> findTigers1()
    public List<Human> findTigers4(){

        Aggregation aggregation=Aggregation.newAggregation(
                //Aggregation.match(Criteria.where("name").in("ocean"))
                //Aggregation.unwind("tigers"),
                Aggregation.match(Criteria.where("name").in("ocean").and("tigers.tigerName").is("aa"))
               // Aggregation.project("name")
        );
        return mongoTemplate.aggregate(aggregation, collectionName, Human.class).getMappedResults();


    }



}
