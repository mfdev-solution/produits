package sn.ucad.fegnService;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import sn.ucad.Domaine.Commande;

@FeignClient(value="feignProduit", url="http://localhost:3006/commandeapi")
public interface FeignCommandesService {
	
	@GetMapping("/commandes")
	List<Commande> getAllCommande();
	

}
