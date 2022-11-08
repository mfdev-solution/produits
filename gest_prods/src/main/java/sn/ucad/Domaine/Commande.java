package sn.ucad.Domaine;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class Commande {

	private Long Id;
	private Date date;
	private String refCommande;
	private Long idClient;
	
	public String getRefCommande() {
		return refCommande;
	}
	public void setRefCommande(String refCommande) {
		this.refCommande = refCommande;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Date getDate() {
		
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	public Commande() {}
	public Commande(Long id, Date date, String refCommande, Long idClient) {
		Id = id;
		this.date = date;
		this.refCommande = refCommande;
		this.idClient = idClient;
	}
	
	
	
	
	
	
	
	
	
}
