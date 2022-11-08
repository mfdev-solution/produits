package sn.ucad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.ucad.Domaine.Commande;

public interface CommandeRepository  extends JpaRepository<Commande,Long>  {
	
	List<Commande> findByRefCommande(String refCommande);
	List<Commande> findByIdClient(Long idClient);
 //	List<Commande> findByRefCommande(String refCommande);
}
