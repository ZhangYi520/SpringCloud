package com.zy.rabbitmq;

import com.zy.rabbitmq.mq.MessageProvider;
import com.zy.rabbitmq.mq.Sender;
import com.zy.rabbitmq.pojo.MessagePojo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private Sender sender;

    @Autowired
    private MessageProvider messageProvider;

    @Test
    public void hello() throws Exception {
        sender.send () ;
    }

    @Test
    public void hello1() throws Exception {
        MessagePojo m =new MessagePojo();
        m.setDelay(10);
        m.setClassName("类名字");

        messageProvider.sendMessage(m);
    }
}
