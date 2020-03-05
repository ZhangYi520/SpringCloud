package com.zy.zy_sso;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication
//@ComponentScan("com.zy.zy_sso")
@EnableSwagger2
@MapperScan(basePackages = { "com.zy.zy_sso" })
@EnableScheduling
/**
*@Description:
*@Param: 
*@return: 
*@Author: zhang yi
*@date: 
*/
public class ZySsoApplication {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(ZySsoApplication.class, args);

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

        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
//        log.info("\n----------------------------------------------------------\n\t" +
//                "Application Jeecg-Boot is running! Access URLs:\n\t" +
//                "Local: \t\thttps://localhost:" + port + path + "/\n\t" +
//                "External: \thttps://" + ip + ":" + port + path + "/\n\t" +
//                "swagger-ui: \thttps://" + ip + ":" + port + path + "/swagger-ui.html\n\t" +
//                "Doc: \t\thttps://" + ip + ":" + port + path + "/doc.html\n" +
//                "----------------------------------------------------------");
    }

}
