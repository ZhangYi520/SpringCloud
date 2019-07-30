package com.zy.zy_sso;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@ComponentScan("com.zy.zy_sso")
@EnableSwagger2
@MapperScan(basePackages = { "com.zy.zy_sso" })
@EnableScheduling
public class ZySsoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZySsoApplication.class, args);

        System.out.println(
                        "*　　　　　　　　┏┓　　　┏┓+ +                           \n"+
                        "*　　　　　　　┏┛┻━━━┛┻┓ + +							\n"+
                        "*　　　　　　　┃　　　　　　　┃ 　							\n"+
                        "*　　　　　　　┃　　　━　　　┃ ++ + + +						\n"+
                        "*　　　　　　 ████━████ ┃+		\n"+
                        "*　　　　　　　┃　　　　　　　┃ +		\n"+
                        "*　　　　　　　┃　　　┻　　　┃			\n"+
                        "*　　　　　　　┃　　　　　　　┃ + +		\n"+
                        "*　　　　　　　┗━┓　　　┏━┛			\n"+
                        "*　　　　　　　　　┃　　　┃　　　　　　　	\n"+
                        "*　　　　　　　　　┃　　　┃ + + + +	\n"+
                        "*　　　　　　　　　┃　　　┃　　　　　　　　	\n"+
                        "*　　　　　　　　　┃　　　┃ + 　　　　                     神兽保佑,代码无bug　\n"+
                        "*　　　　　　　　　┃　　　┃			\n"+
                        "*　　　　　　　　　┃　　　┃　　+　　　　　	\n"+
                        "*　　　　　　　　　┃　 　　┗━━━┓ + +	\n"+
                        "*　　　　　　　　　┃ 　　　　　　　┣┓		\n"+
                        "*　　　　　　　　　┃ 　　　　　　　┏┛		\n"+
                        "*　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +	\n"+
                        "*　　　　　　　　　　┃┫┫　┃┫┫			\n"+
                        "*　　　　　　　　　　┗┻┛　┗┻┛+ + + +		\n"+
                        "*									\n"+
                        "*			项目启动完成。。。。.................... \n"


        );
    }

}
