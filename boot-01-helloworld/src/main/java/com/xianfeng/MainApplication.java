package com.xianfeng;

import com.xianfeng.bean.Pet;
import com.xianfeng.bean.User;
import com.xianfeng.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 主程序类
 * @SpringBootApplication：这是一个SpringBoot应用
 */



@SpringBootApplication
public class MainApplication {


    public static void main(String[] args) {
        //返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        String[] names = run.getBeanDefinitionNames();

        for(String name:names){
            System.out.println(name);
        }

        //从容器中获取组件
        Pet pet01 = run.getBean("tomcat", Pet.class);
        Pet pet02 = run.getBean("tomcat", Pet.class);

        System.out.println("组件：" + (pet01==pet02));

        //com.xianfeng.config.MyConfig$$EnhancerBySpringCGLIB$$6f68fe95@a098d76  代理对象
        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);

        /**
         * 如果@Configuration(proxyBeanMethods = true)代理对象调用方法，SpringBoot总归检查这个组件是否在容器中有
         * 保持组件单实例
         * 如果@Configuration(proxyBeanMethods = false)MyConfig就不是代理对象
         */
        User user01 = bean.user01();
        User user02 = bean.user01();
        System.out.println(user01==user02);

        User user1 = run.getBean("zhangsan", User.class);
        Pet tom = run.getBean("tomcat", Pet.class);

        System.out.println("用户的宠物：" + (user1.getPet() == tom));
    }

}
