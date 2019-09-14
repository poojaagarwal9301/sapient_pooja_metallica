package com.refdata.RefDataServices.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.refdata.RefDataServices.entity.Commodity;
import com.refdata.RefDataServices.entity.CommodityResource;
import com.refdata.RefDataServices.entity.CounterParty;
import com.refdata.RefDataServices.entity.CounterPartyResource;
import com.refdata.RefDataServices.entity.Location;
import com.refdata.RefDataServices.entity.LocationResource;
import com.refdata.RefDataServices.services.RefDataService;

@RestController
@RequestMapping("/refData")
public class RefDataResource {
	
	@Autowired
	private RefDataService refDataService;

	@GetMapping("/commodity/{id}")
	public ResponseEntity<CommodityResource> getCommodityById(@PathVariable int id){
		Commodity commodity = refDataService.getCommodityById(id);
		return ResponseEntity.ok(new CommodityResource(commodity));
	}
	
	@GetMapping("/commodity")
	public ResponseEntity<Resources<CommodityResource>> getAllCommodities(){
		final List<CommodityResource> commodity = 
				refDataService.getAllCommodities().stream().map(CommodityResource::new).collect(Collectors.toList());
		final Resources<CommodityResource> resources = new Resources<>(commodity);
		final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
		resources.add(new Link(uriString, "self"));
	    return ResponseEntity.ok(resources);
	}
	
	@GetMapping("/counterparty/{id}")
	public ResponseEntity<CounterPartyResource> getCounterPartyById(@PathVariable int id){
		CounterParty counterParty = refDataService.getCounterPartyById(id);
		return ResponseEntity.ok(new CounterPartyResource(counterParty));
	}
	
	@GetMapping("/counterparty")
	public ResponseEntity<Resources<CounterPartyResource>> getAllCounterParty(){
		final List<CounterPartyResource> counterPartyResources = 
				refDataService.getAllCounterParty().stream().map(CounterPartyResource::new).collect(Collectors.toList());
		final Resources<CounterPartyResource> resources = new Resources<>(counterPartyResources);
		final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
		resources.add(new Link(uriString, "self"));
	    return ResponseEntity.ok(resources);
	}
	
	@GetMapping("/locations/{id}")
	public ResponseEntity<LocationResource> getLocationById(@PathVariable int id){
		Location location = refDataService.getLocationById(id);
		return ResponseEntity.ok(new LocationResource(location));
	}
	
	@GetMapping("/locations")
	public ResponseEntity<Resources<LocationResource>> getAllLocations(){
		final List<LocationResource> locationResources = 
				refDataService.getAllLocations().stream().map(LocationResource::new).collect(Collectors.toList());
		final Resources<LocationResource> resources = new Resources<>(locationResources);
		final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
		resources.add(new Link(uriString, "self"));
	    return ResponseEntity.ok(resources);
	}
}
