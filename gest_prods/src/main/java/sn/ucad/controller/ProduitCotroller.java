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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sn.ucad.Domaine.Commande;
import sn.ucad.Domaine.Produit;
import sn.ucad.fegnService.FeignCommandesService;
import sn.ucad.repository.ProduitReposittory;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/produitapi")
public class ProduitCotroller  {
	@Autowired
	private ProduitReposittory repo;
	@Autowired
	private FeignCommandesService feignCommandesService;
	@GetMapping("/produits")
	public List<Produit>  afficherProduit(){
		return repo.findAll();
	}
	@PostMapping("/produits")
	public Produit ajouterProduit(@RequestBody Produit prod) {
		return repo.save(prod);
	}
	@GetMapping("/produits/{id}")
	public Produit obtenirUnProduit(@PathVariable(value = "id") Long id) {
		Optional<Produit> produit = repo.findById(id);
		if (produit.isPresent())
			return produit.get();
		return null;
		
	}
	@PutMapping("/produits/{id}")
	public Produit updateProduit(@PathVariable(value = "id") Long id,@RequestBody Produit newprod) {
		
		Optional<Produit> prod = repo.findById(id);
		if(prod.isPresent()) {
			Produit produit = prod.get();
			produit.setNom(newprod.getNom());
			produit.setPrix(newprod.getPrix());
			return repo.save(produit);
		}
		
		return null;
	}
	
	@DeleteMapping("/produits/{id}")
	public void deleteProduct(@PathVariable(value="id") Long id) {
		 repo.deleteById(id);	
	}
	@GetMapping("/all-commandes")
	public List<Commande> getCommandes(){
		return this.feignCommandesService.getAllCommande();
	}
	@GetMapping("/produit-by-ref-cmd/{refcmd}")
	public List<Produit> getProuitByRefCommande(@PathVariable(value="refcmd") String refcmd){
		return this.repo.findByRefCommande(refcmd);
	}

}
