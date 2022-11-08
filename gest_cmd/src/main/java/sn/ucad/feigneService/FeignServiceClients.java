package sn.ucad.feigneService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import sn.ucad.Domaine.Client;

@FeignClient(value="feignCmd" , url="http://localhost:3001/clientapi")
public interface FeignServiceClients {
	
	
	@GetMapping("/clients")
	Client[] getClients() ;
	@GetMapping("/client/{id}")
	Client getClientById(@PathVariable(value = "id") Long id);

}
