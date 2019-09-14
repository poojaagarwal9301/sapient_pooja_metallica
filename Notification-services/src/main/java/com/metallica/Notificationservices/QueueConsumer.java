package com.metallica.Notificationservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.json.JsonParseException;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.metallica.Notificationservices.dto.*;

@Component
public class QueueConsumer {
	
/* @Autowired
 MailServiceImpl mailServiceImpl;
 */
 protected Logger logger = LoggerFactory.getLogger(getClass());
 
 public void receiveMessage(String message) {
  logger.info("Received (String) " + message);
  processMessage(message);
 }
 
 public void receiveMessage(byte[] message) {
  String strMessage = new String(message);
  logger.info("Received (No String) " + strMessage);
  processMessage(strMessage);
 }
 
 private void processMessage(String message) {
  try {
   MarketPricesNotificationDTO mailDTO = new ObjectMapper().readValue(message, MarketPricesNotificationDTO.class);
   System.out.println(mailDTO);
   TradeNotificationDTO tradeNotificationDTO = new ObjectMapper().readValue(message, TradeNotificationDTO.class);
   System.out.println(tradeNotificationDTO);
   System.out.println(mailDTO);
  } catch (JsonParseException e) {
   logger.warn("Bad JSON in message: " + message);
  } catch (JsonMappingException e) {
   logger.warn("cannot map JSON to NotificationRequest: " + message);
  } catch (Exception e) {
   logger.error(e.getMessage());
  }
 }
 
}