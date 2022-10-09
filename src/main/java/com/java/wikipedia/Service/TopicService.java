package com.java.wikipedia.Service;

import com.java.wikipedia.Model.Topic;
import com.java.wikipedia.Repo.TopicRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TopicService {

    private final TopicRepo topicRepo;


    public void saveTopic(Topic topic){
        topicRepo.save(topic);
    }

    public Topic getByName(String topicName) {
        return topicRepo.findByTopicName(topicName).get();
    }
}
