package controller;

import dto.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import publisher.RabbitMQJsonPublisher;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {

    private RabbitMQJsonPublisher jsonPublisher;

    public MessageJsonController(RabbitMQJsonPublisher jsonPublisher) {
        this.jsonPublisher = jsonPublisher;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        jsonPublisher.sendJsonMessage(user);
        return ResponseEntity.ok("Json message sent to RabbitMQ...");

    }
}
