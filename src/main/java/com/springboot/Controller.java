package com.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@Autowired
	private Service service;
	@RequestMapping(method=RequestMethod.POST,value="/create")
	public MessageResponse create(@RequestBody Passenger passengerRequest)
	{
		return service.create(passengerRequest);
	}
	@RequestMapping(method=RequestMethod.GET,value="/all")
	public ResponseEntity<List<Passenger>> getAllPassenger()
	{
		List<Passenger>passengers=service.getAll();
		return new ResponseEntity<>(passengers,HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.GET,value="/find/{id}")
	public ResponseEntity<Passenger>getPassengerbyId(@PathVariable("id")Integer p_id)
	{
		Passenger passenger= service.single(p_id);
		return new ResponseEntity<>(passenger,HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/update/{id}")
	public Passenger update(@RequestBody Passenger passengerrequest, @PathVariable("id")Integer p_id) throws  ResourceNotFoundException
	{
		 
		 return service.update(p_id, passengerrequest);
	}

}
