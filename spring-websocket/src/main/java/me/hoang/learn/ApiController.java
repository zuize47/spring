package me.hoang.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hoang on 2/22/2017.
 */
@RestController
@RequestMapping(value = "/api")
public class ApiController {


    @Autowired
    SimpMessagingTemplate template;
    @RequestMapping(value = "/hello/{message}", method = RequestMethod.GET)
    public String hello(@PathVariable("message") String message){
        template.convertAndSend("/topic/pingpong", message);
        return "OK";
    }
}
