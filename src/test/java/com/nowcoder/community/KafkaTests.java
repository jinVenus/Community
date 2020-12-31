package com.nowcoder.community;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CommunityApplication.class)
@SpringBootTest
public class KafkaTests {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Test
    public void testKafka(){
        kafkaProducer.sendMessage("tests", "hello");
        kafkaProducer.sendMessage("tests", "are you okay?");
        kafkaProducer.sendMessage("tests", "1");
        kafkaProducer.sendMessage("tests", "2");

        try {
            Thread.sleep(1000 * 10);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

@Component
class KafkaProducer{

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendMessage(String topic, String content){
        kafkaTemplate.send(topic, content);
    }

}

@Component
class KafkaConsumer{

    @KafkaListener(topics = {"tests"})
    public void handleMessage(ConsumerRecord record){
        System.out.println(record.value());
    }

}