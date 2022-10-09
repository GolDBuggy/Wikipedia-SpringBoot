package com.java.wikipedia.Controller;

import com.java.wikipedia.Model.Topic;
import com.java.wikipedia.Service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topic")
@RequiredArgsConstructor
public class TopicController {

    private final TopicService topicService;

    @PostMapping("/save")
    public ResponseEntity<Topic> create(@RequestBody Topic topic){
        topicService.saveTopic(topic);
        return ResponseEntity.ok(topic);
    }
}
