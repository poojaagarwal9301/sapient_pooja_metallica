package com.marketdata.MarketDataServices.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marketdata.MarketDataServices.dto.NotificationDTO;

@Component
public class QueueProducer {
	
 protected Logger logger = LoggerFactory.getLogger(getClass());
 
 @Value("${fanout.exchange}")
 private String fanoutExchange;
 
 private final RabbitTemplate rabbitTemplate;
 
 @Autowired
 public QueueProducer(RabbitTemplate rabbitTemplate) {
  super();
  this.rabbitTemplate = rabbitTemplate;
 }
 
 public void produce(NotificationDTO notificationDTO) throws Exception {
  logger.info("Storing notification...");
  rabbitTemplate.setExchange(fanoutExchange);
  rabbitTemplate.convertAndSend(new ObjectMapper().writeValueAsString(notificationDTO));
  logger.info("Notification stored in queue sucessfully");
 }
 
}