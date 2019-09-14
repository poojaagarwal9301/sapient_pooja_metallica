package com.trade.TradeServices.entity.resources;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import lombok.Getter;

import org.springframework.hateoas.ResourceSupport;

import com.trade.TradeServices.contoller.TradesController;
import com.trade.TradeServices.dto.TradeDTO;
import com.trade.TradeServices.entity.Trade;

@Getter
public class TradeResource extends ResourceSupport {

	private final TradeDTO trade;
	
	public TradeResource(final TradeDTO trade) {
        this.trade = trade;
        final int id = trade.getId();
        add(linkTo(TradesController.class).withRel("trades"));
        add(linkTo(methodOn(TradesController.class).getTradeById(id)).withSelfRel());
    }

}

