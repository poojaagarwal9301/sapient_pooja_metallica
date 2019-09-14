package com.refdata.RefDataServices.entity;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import lombok.Getter;

import org.springframework.hateoas.ResourceSupport;

import com.refdata.RefDataServices.resources.RefDataResource;


@Getter
public class CounterPartyResource extends ResourceSupport {

	private final CounterParty counterParty;
	
	public CounterPartyResource(final CounterParty counterParty) {
        this.counterParty = counterParty;
        final int id = counterParty.getId();
        add(linkTo(RefDataResource.class).withRel("counter_party"));
        add(linkTo(methodOn(RefDataResource.class).getCounterPartyById(id)).withSelfRel());
    }

	
}
