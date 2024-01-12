package net.javaguides.springboot.publisher;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javaguides.springboot.dto.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RabbitMQJsonProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.routing.json.key.name}")
    private String routingJsonKey;

    private final RabbitTemplate rabbitTemplate;

    public  void sendJsonMessage(User user){
        log.info("Json message sent -> {}", user.toString());
        rabbitTemplate.convertAndSend(exchange,routingJsonKey,user);
    }
}
