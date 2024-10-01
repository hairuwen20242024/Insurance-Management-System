package com.insurance.system.kafka;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

    private final KafkaProducer kafkaProducer;

    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public String publish(@RequestParam("message") String message) {
        kafkaProducer.sendMessage("test-topic", message);
        return "Message published";
    }
}

