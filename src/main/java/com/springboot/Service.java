package com.springboot;

import java.util.Comparator;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Service {
   @Autowired
   private PassengerRepository repo;
public MessageResponse create(Passenger passengerRequest)
{
	
	passengerRequest.setP_id(passengerRequest.getP_id());
	passengerRequest.setP_name(passengerRequest.getP_name());
	passengerRequest.setFrom_place(passengerRequest.getFrom_place());
	passengerRequest.setTo_place(passengerRequest.getTo_place());
	repo.save(passengerRequest);
	return new MessageResponse("Passenger created!");
}
public Passenger update(Integer p_id,Passenger passengerrequest)throws ResourceNotFoundException
{
      Optional<Passenger>passenger=repo.findById(p_id);
      if(passenger.isEmpty())
      {
    	  throw new ResourceNotFoundException("No such Passenger");
      }
      else
      {
    	Passenger obj = passenger.get();
    	obj.setP_name(passengerrequest.getP_name());
    	 obj.setFrom_place(passengerrequest.getFrom_place());
    	 obj.setTo_place(passengerrequest.getTo_place());
    	 
    	
    	  repo.save(obj);
      
	
	
	return obj;
      }
}
public Passenger single(Integer p_id)
{
	return repo.findById(p_id).get();
}
public List<Passenger> getAll()
{
	List<Passenger>list=repo.findAll();
	 list.sort(Comparator.comparing(Passenger::getP_name));
	 return list;
	
}


}
