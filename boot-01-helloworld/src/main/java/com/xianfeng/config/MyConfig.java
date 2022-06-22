package com.xianfeng.config;

import com.xianfeng.bean.Pet;
import com.xianfeng.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import java.util.logging.Handler;

/**
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认是单例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods:代理bean的方法
 *      Full（true）、Lite（false）
 *      组件依赖
 * 4、Import
 *      给容器中自动创建出这两个类型的组件、默认组件的名字就是醛全类名
 *
 * 5、@ImportResource("classpath:beans.xml")
 *      导入配置文件
 */
//@Import({User.class, Handler.class})
@Configuration(proxyBeanMethods = true) //告诉SpringBoot这是一个配置类 == 配置文件
//@ImportResource("classpath:beans.xml")
public class MyConfig {

    /**
     * 外部无论对配置类中的这个组件方法调用多少次，获取的都是之前注册的，是单实例的，从IOC容器中获取组件
     * @return
     */
//    @ConditionalOnBean(name="tom")
    @Bean("zhangsan") //给容器中添加组件，以方法名作为组件的id,返回类型就是组件类型，返回的值就是组件在容器中的实例
    public User user01(){
        User zhangsan = new User("张三", 18);
        //User组件依赖了Pet组件
        zhangsan.setPet(tomcat());
        return zhangsan;
    }

    @Bean("tomcat")
    public Pet tomcat(){
        return new Pet("tomcat");
    }
}
