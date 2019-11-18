package com.sunil.kafka.springbootkafkaproducer;

import com.sunil.kafka.springbootkafkaproducer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    private static final String TOPIC = "test-topic-106";

    @Override
    public void run(String... args) throws Exception {
            for (int i=0;i<10;i++){
              kafkaTemplate.send(TOPIC, new User("user-1", "new message" + i));
//               kafkaTemplate.send(TOPIC,5,new User("user-1", "new message" + i));
//              kafkaTemplate.send(TOPIC,"1",new User("User-1","message"+i ));
//                kafkaTemplate.setDefaultTopic(TOPIC);
//                kafkaTemplate.sendDefault(new User("user-1","defauly-message-"+i));
//                System.out.println("published"+ i);
            }

    }
}
