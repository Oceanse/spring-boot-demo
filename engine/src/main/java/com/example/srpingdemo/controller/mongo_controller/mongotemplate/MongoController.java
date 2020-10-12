package com.example.srpingdemo.controller.mongo_controller.mongotemplate;

import com.example.srpingdemo.mongo.HumanRepositoryImpl;
import com.example.srpingdemo.mongo.TestResourceinfoRepositoryCustom;
import com.example.srpingdemo.mongo.UserRepositoryCustom;
import com.example.srpingdemo.mongo.UserRepository_MongoRepository;
import com.example.srpingdemo.mongo.Human;
import com.example.srpingdemo.mongo.TestResourceinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class MongoController {

    @Autowired
    UserRepositoryCustom userRepositoryCustom;

    @Autowired
    TestResourceinfoRepositoryCustom testResourceinfoRepositoryCustom;

    @Autowired
    HumanRepositoryImpl humanRepository;

    @Autowired
    UserRepository_MongoRepository userRepository_mongoRepository;







    //查询
    @GetMapping("/findtestresource/{id}")
    public List<TestResourceinfo> findTestResource(@PathVariable("id") String id) {
        List<TestResourceinfo> testResourceinfos = testResourceinfoRepositoryCustom.findByResourceId(id);
        return testResourceinfos;
    }





    @GetMapping("/addResource")
    public void addResource(@PathParam("jarFilePath") String jarFilePath, @PathParam("resourceId") String resourceId) {
        testResourceinfoRepositoryCustom.addTestResource(jarFilePath, resourceId);
        System.out.println("insert a resource who jarFilePath is " + jarFilePath + " and resourceId is " + resourceId);
    }








   /* @GetMapping("/savepets")
    public void myPets() {
        humanRepository.savePets();
    }

    @GetMapping("/human")
    public List<Human> findHumans() {
        return humanRepository.findHuman();
    }

    @GetMapping("/human2")
    public List<Human> findHumans2() {
        return humanRepository.findHuman2();
    }

    @GetMapping("/human3")
    public List<Human> findHumans3() {
        return humanRepository.findHuman3();
    }

    @GetMapping("/human4")
    public List<Human> findHumans4() {
        return humanRepository.findHuman4();
    }

    @GetMapping("/human5")
    public List<Human> findHumans5() {
        return humanRepository.findHuman5();
    }

    @GetMapping("/human6")
    public List<Human> findHumans6() {
        return humanRepository.findHuman6();
    }

    @GetMapping("/human6_2")
    public List<Human> findHumans6_2() {
        return humanRepository.findHuman6_2();
    }

    @GetMapping("/human7")
    public List<Human> findHumans7() {
        return humanRepository.findHuman7();
    }

    @GetMapping("/human8")
    public List<Human> findHumans8() {
        return humanRepository.findHuman8();
    }

    @GetMapping("/human9")
    public List<Human> findHumans9() {
        return humanRepository.findHuman9();
    }
*/
}
