package com.trade.TradeServices.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trade.TradeServices.dto.TradeDTO;
import com.trade.TradeServices.entity.Trade;
import com.trade.TradeServices.entity.resources.TradeResource;
import com.trade.TradeServices.services.TradeService;

@RestController
@RequestMapping("/trades")
public class TradesController {
	
	@Autowired
	private TradeService tradeservice;

	@GetMapping("/{id}")
	public ResponseEntity<TradeResource> getTradeById(@PathVariable int id){
		TradeDTO trade = tradeservice.findTradeById(id);
		return ResponseEntity.ok(new TradeResource(trade));
	}
	
	@PostMapping
	public void persistTrade(@RequestBody Trade trade) throws Exception{
		tradeservice.persistTrade(trade);
	}
	
	@RequestMapping(method=RequestMethod.PATCH)
	public TradeDTO updateTrade(@RequestBody Trade trade){
		return tradeservice.updateTrade(trade);
	}
}
