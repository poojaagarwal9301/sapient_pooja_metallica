package com.refdata.RefDataServices.entity;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import lombok.Getter;

import org.springframework.hateoas.ResourceSupport;

import com.refdata.RefDataServices.resources.RefDataResource;


@Getter
public class LocationResource extends ResourceSupport {

	private final Location location;
	
	public LocationResource(final Location location) {
        this.location = location;
        final int id = location.getId();
        add(linkTo(RefDataResource.class).withRel("location"));
        add(linkTo(methodOn(RefDataResource.class).getCommodityById(id)).withSelfRel());
    }

}
