package com.example.srpingdemo.controller;

import com.example.srpingdemo.ReadInfo;
import com.example.srpingdemo.TestResourceService;
import com.example.srpingdemo.pojo.Dog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/hello")
public class HelloController {


    @Autowired
    ReadInfo readInfo;

    @Autowired
    private TestResourceService testResourceService;

    @Autowired
    ApplicationContext app;


    private static final Logger LOG = LogManager.getLogger(HelloController.class);


    /**
     *
     * @return string info
     */
   @GetMapping("/speak")
    public String speak(){
       LOG.debug("hello world");
       return "Hello World!";
    }


    /**
     * Get the vm
     * @return ip+port
     */
    @GetMapping("/vm")
    public String  printvm() {
        String ip = System.getProperty("ip");
        String port=System.getProperty("port");
        return ip+":"+port;
    }



    /**
     *
     * @return return the content of the file
     * @throws IOException in case file is not found
     */
    @GetMapping("/content")
    public String read() throws IOException{

        //Resource是org.springframework.core.io.Resource
        Resource resource = new ClassPathResource("config/aat_register.json");
        String  path = resource.getFile().getPath();
        String content = new String(Files.readAllBytes(Paths.get(path)));

        return path+": "+content;
    }



    /**
     * 验证@Value
     * Autowired注入ReadInfo
     * @return dogInfo
     */
    @GetMapping("/showMyDog")
    public String dogInfo(){
        return readInfo.showMyDog();
    }



    /**
     * @Configuration+@bean注册bean
     * Autowired注入ApplicationContext
     * @return true if contains bean of bot
     */
    @GetMapping("/containsBot")
    public boolean containsBot(){
        return app.containsBean("bot");
    }




    /**
     * 验证@ImportResource(locations = {"classpath:config/beans.xml"})+bean.xml注册bean
     * @Configuration+@bean注册bean
     * Autowired注入ApplicationContext
     * @return true if contains bean of bot
     */
    @GetMapping("/containsBags")
    public boolean containsBags(){
        return app.containsBean("bags");
    }



    /**
     * 验证PathVariable
     * @param name nameInfo
     * @param age ageInfo
     * @return total info
     */
    @GetMapping("/info/{myName}/{myAge}")
    public String shows(@PathVariable("myName") String name, @PathVariable("myAge")int age ){
        System.out.println("age="+age+" "+"name="+name);
        return "My name is "+ name + " and I am " + new Integer(age)+" years old";
    }



    /**
     * 验证@Component+@PropertySource(value={"classpath:cat.properties"})+cat.properties配置文件属性到cat对象
     * @return
     */
    @GetMapping("/showCat")
    public String showCat() {
        return readInfo.showCat();
    }



    /**
     * 精确匹配
     * 精确模糊匹配和模糊匹配重合时，以精确匹配为主
     * 同时验证@ConfigurationProperties(prefix = "person")+@Component+application.yaml 绑定全局配置文件属性到person对象
     * @return personInfo
     */
    @GetMapping("/showPerson/ocean")
    public String preciseInfo(){
        return readInfo.showPerson()+" precise";
    }



    /**
     * 模糊匹配
     * 精确模糊匹配和模糊匹配重合时，以精确匹配为主
     * @return personInfo
     */
    @GetMapping("/showPerson/*")
    public String blurryInfos(){
       return readInfo.showPerson()+" blurry";
    }



    /**
     * RequestBody注解  JSON转成java对象
     * @param dog
     * @return
     */
    @PostMapping("/postdog")
    public Dog showDog(@RequestBody Dog dog){
        System.out.println(dog);
        return dog;
    }


    /**
     * 验证 Flower:
     *     @Value("#{systemProperties['name']}")
     *     String name;
     * @return
     */
    @GetMapping("/showFlower")
    public String showFlower() {
        return readInfo.showFlower();
    }



    /**
     * 上传jar到工程根目录/jarDir
     * @param file
     * @throws IOException
     */
    @PostMapping("uploadJar")
    public void uploadResource(@RequestParam(value = "file", required = false) MultipartFile file) throws IOException{
         LOG.info("Start to load resources");
         testResourceService.uploadTestResources(file);
    }
}
