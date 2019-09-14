package com.refdata.RefDataServices.entity;

import lombok.Getter;

import org.springframework.hateoas.ResourceSupport;



import com.refdata.RefDataServices.resources.RefDataResource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@Getter
public class CommodityResource extends ResourceSupport {

	private final Commodity commodity;
	
	public CommodityResource(final Commodity commodity) {
        this.commodity = commodity;
        final int id = commodity.getId();
        add(linkTo(RefDataResource.class).withRel("commodities"));
        add(linkTo(methodOn(RefDataResource.class).getCommodityById(id)).withSelfRel());
    }

}
