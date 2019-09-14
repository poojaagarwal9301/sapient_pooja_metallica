package com.marketdata.MarketDataServices.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marketdata.MarketDataServices.dto.CommodityResource;
import com.marketdata.MarketDataServices.entity.Commodity;
import com.marketdata.MarketDataServices.services.CommodityService;

@RestController
@RequestMapping(value = "/marketPrices" , produces = "application/hal+json")
public class CommodityController {
	
	@Autowired
	private CommodityService commodityservice;
	
	@GetMapping
	public ResponseEntity<Resources<CommodityResource>> getAll(){
		final List<CommodityResource> commodity = 
				commodityservice.getAll().stream().map(CommodityResource::new).collect(Collectors.toList());
		final Resources<CommodityResource> resources = new Resources<>(commodity);
		final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
		resources.add(new Link(uriString, "self"));
	    return ResponseEntity.ok(resources);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CommodityResource> getCommodityById(@PathVariable int id){
		Commodity commodity = commodityservice.findCommodityById(id);
		return ResponseEntity.ok(new CommodityResource(commodity));
	}
	
	@PostMapping
	public void persistCommodity(@RequestBody Commodity commodity){
		commodityservice.persistCommodity(commodity);
	}
	
	@RequestMapping(method=RequestMethod.PATCH)
	public Commodity updateCommodity(@RequestBody Commodity commodity){
		return commodityservice.updateCommodity(commodity);
	}
}
