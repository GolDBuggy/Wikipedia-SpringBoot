package com.java.wikipedia.Repo;

import com.java.wikipedia.Model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicRepo extends JpaRepository<Topic,String> {

    Optional<Topic> findByTopicName(String topicName);
}
