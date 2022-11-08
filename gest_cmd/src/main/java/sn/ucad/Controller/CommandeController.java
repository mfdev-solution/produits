package sn.ucad.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.ucad.Domaine.Client;
import sn.ucad.Domaine.Commande;
import sn.ucad.feigneService.FeignServiceClients;
import sn.ucad.repository.CommandeRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/commandeapi")
public class CommandeController {
	@Autowired
	private CommandeRepository commandeRepository;
	
	@Autowired
	private FeignServiceClients feignServiceClients;
	
	@GetMapping("/all-client")
	public Client[] getAllClient() {
		return this.feignServiceClients.getClients();
	}
	@GetMapping("/clients/{id}")
	public Client getClientByIdFeign(@PathVariable(value = "id") Long id) {
		return this.feignServiceClients.getClientById(id);
	}
	@GetMapping("/commandes/{ref}")
	public List<Commande> getClientByIdFeign(@PathVariable(value = "ref") String ref) {
		return this.commandeRepository.findByRefCommande(ref);
	}
	@GetMapping("/commandes")
	public List<Commande> getAllCommades() {
		
		return commandeRepository.findAll();
	}
	@GetMapping("/commande-by-id-client/{id}")
	public List<Commande> getClientById(@PathVariable(value="id") Long id){
		return this.commandeRepository.findByIdClient(id);
	}
	
	@PostMapping("/commandes")
	public Commande ajouterProduit(@RequestBody Commande cmd) {
		return commandeRepository.save(cmd);
	}
	@DeleteMapping("/commandes/{id}")
	public void deleteCommande(@PathVariable(value="id") Long id) {
		commandeRepository.deleteById(id);	
	}
}
