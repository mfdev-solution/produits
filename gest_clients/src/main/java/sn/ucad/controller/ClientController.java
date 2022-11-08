package sn.ucad.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import sn.mfdev.domain.Produit;
//import sn.mfdev.domain.Produit;
import sn.ucad.domaine.Client;
import sn.ucad.repository.ClientRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/clientapi")
public class ClientController {
	
	@Autowired
	private ClientRepository repo;
	
	@GetMapping("/clients")
	public List<Client>  afficherClient(){
		return repo.findAll();
	}
	@PostMapping("/clients")
	public Client ajouterClient(@RequestBody Client cli) {
		return repo.save(cli);
	}
	@GetMapping("/client/{id}")
	public Client obtenirUnProduit(@PathVariable(value = "id") Long id) {
		Optional<Client> client = repo.findById(id);
		if (client.isPresent())
			return client.get();
		return null;
		
	}
	@PutMapping("/clients/{id}")
	public Client updateClient(@PathVariable(value = "id") Long id,@RequestBody Client newClient) {
		
		Optional<Client> cli = repo.findById(id);
		if(cli.isPresent()) {
			Client client = cli.get();
			client.setNom(newClient.getNom());
			client.setEmail(newClient.getEmail());
			client.setPrenom(newClient.getPrenom());
			client.setPassword(newClient.getPassword());
			return repo.save(client);
		}
		
		return null;
	}
	@DeleteMapping("/clients/{id}")
	public void deleteClient(@PathVariable(value="id") Long id) {
		 repo.deleteById(id);	
	
	}
}
