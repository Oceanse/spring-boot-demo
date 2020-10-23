package com.example.springboot;

import com.example.springboot.bind_value_to_bean.ReadInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Demoapplication.class)
public class BindValueToBeanFieldTest {

    @Autowired
    ReadInfo readInfo;


    /**
     * @Component+@ConfigFilesController(prefix = "person")+application.yaml 绑定全局配置文件属性到person对象
     */
    @Test
    public void testPerson() {
        readInfo.showPerson();
    }


    /**
     * @EnableConfigurationProperties(Flower.class) + @ConfigurationProperties(prefix = "flower") 绑定全局配置文件属性到person对象
     * @Value("#{systemProperties['name']}") 从jvm参数获取name值，但是会被全局配置文件的参数覆盖
     */
    @Test
    public void testFlower() {
        readInfo.showFlower();
    }



    /**
     * 验证@Value
     *  @Value(“#{}”) 表示SpEl表达式通常用来获取bean的属性，或者调用bean的某个方法
     *  @Value(“${xxxx}”)注解从配置文件读取值的用法
     *  @Value("#{systemProperties['os.name']}")获取vm参数
     */
    @Test
    public void testDuck(){
         readInfo.showDuck();
    }


    /**
     *  @Value 和 @ConfigurationProperties同时存在互补配合使用
     *  @Value 和 @ConfigurationProperties同时起作用时，会以@ConfigurationProperties为主
     */
    @Test
    public void showRectangle(){
        readInfo.showRectangle();
    }



    /**
     @PropertySource 加载指定的自定义属性配置文件和bean绑定
     @PropertySource 必须和@configrationproperties结合使用,当然也必须注册到spring容器中
     @PropertySource 表明从指定的配置文件获取值，@configrationproperties（prefix=）表明使用配置文件的哪一部分
     决定权：全局配置文件>@PropertySource自定义配置文件>@Value>class内属性赋值
     */
    @Test
    public void showCat(){
         readInfo.showCat();
    }






    /**
     * 验证 @Value @PropertySource class内属性赋值
     * 优先级：@PropertySource自定义配置文件>@Value>class内属性赋值
     * 补充：全局配置文件>@PropertySource自定义配置文件>@Value>class内属性赋值
     */
    @Test
    public void showCat2(){
         readInfo.showCat2();
    }



}
