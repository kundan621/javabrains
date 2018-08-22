package com.csebuddy.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//business service are singleton by default in spring
//to tell these add service annotation
@Service
public class TopicService {
	@Autowired
	private TopicRepository topicRepository;
	
/*	private List<Topic> topics= new ArrayList<>( Arrays.asList(
				new Topic("spring","Spring framework","Spring framework descripton"),
				new Topic("java","java","Spring framework descripton"),
				new Topic("c","c  framework","Spring framework descripton")
				));*/
	
	public List<Topic> getAllTopics(){
		List<Topic> topics=new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id) {
	//	return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
		Optional<Topic> optinalEntity=topicRepository.findById(id);
		return optinalEntity.get();
		
		
		}

	public void addTopic(Topic topic) {
		// TODO Auto-generated method stub
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
           topicRepository.save(topic);
		   
	}

	public void deleteTopic(String id) {
/*		// TODO Auto-generated method stub
		for(int i=0;i<topics.size();i++) {
			Topic t=topics.get(i);
			if(t.getId().equals(id)) {
				topics.remove(t);
				return;
			}
		}
	}*/
		topicRepository.deleteById(id);
	}

}
