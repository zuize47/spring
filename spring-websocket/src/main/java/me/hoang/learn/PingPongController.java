package me.hoang.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

/**
 * Created by hoang on 2/22/2017.
 */
@Controller
@EnableScheduling
public class PingPongController {
    @Autowired
    SimpMessagingTemplate template;

    @Scheduled(fixedDelay = 20000L)
    @SendTo("/topic/pingpong")
    public void sendPong() {
        template.convertAndSend("/topic/pingpong", "pong (periodic)");
    }

    @MessageMapping("/ping")
    @SendTo("/topic/pingpong")
    public String sendPingResponse() {
        return "pong (response)";
    }
}
