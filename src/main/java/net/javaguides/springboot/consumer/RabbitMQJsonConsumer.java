package net.javaguides.springboot.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javaguides.springboot.dto.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RabbitMQJsonConsumer {

    @RabbitListener(
            queues = "${rabbitmq.queue.json.name}"
    )
    public void jsonConsume(User user){
        log.info("Received new json user -> {}", user.toString());
    }
}
