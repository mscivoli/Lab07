package it.polito.tdp.poweroutages.model;

import java.time.*;

public class Event {
	
	int id;
	LocalDateTime inizio;
	LocalDateTime fine;
	//int year;
	int customers;
	int nerc_id;
	
	public Event(int id, int nerc_id, int customers, LocalDateTime inizio, LocalDateTime fine) {
		
		this.id=id;
		this.customers=customers;
		this.inizio = inizio;
		this.fine=fine;
		this.nerc_id = nerc_id;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getInizio() {
		return inizio;
	}

	public void setInizio(LocalDateTime inizio) {
		this.inizio = inizio;
	}

	public LocalDateTime getFine() {
		return fine;
	}

	public void setFine(LocalDateTime fine) {
		this.fine = fine;
	}

	public int getCustomers() {
		return customers;
	}

	public void setCustomers(int customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", inizio=" + inizio + ", fine=" + fine + ", customers=" + customers + ", nerc_id="
				+ nerc_id + "]\n";
	}
	
	

}
