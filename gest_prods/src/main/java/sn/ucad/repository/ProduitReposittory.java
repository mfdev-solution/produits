package sn.ucad.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.ucad.Domaine.Produit;


public interface ProduitReposittory extends JpaRepository<Produit, Long>{
	
	List<Produit> findByRefCommande(String refCommande);
	

}
