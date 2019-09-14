package com.marketdata.MarketDataServices.dto;

import lombok.Getter;

import org.springframework.hateoas.ResourceSupport;

import com.marketdata.MarketDataServices.entity.Commodity;
import com.marketdata.MarketDataServices.resources.CommodityController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@Getter
public class CommodityResource extends ResourceSupport {

	private final Commodity commodity;
	
	public CommodityResource(final Commodity commodity) {
        this.commodity = commodity;
        final int id = commodity.getId();
        add(linkTo(CommodityController.class).withRel("people"));
        add(linkTo(methodOn(CommodityController.class).getCommodityById(id)).withSelfRel());
    }

}
