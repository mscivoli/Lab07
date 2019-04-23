package it.polito.tdp.poweroutages.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

import it.polito.tdp.poweroutages.db.PowerOutageDAO;

public class Model {
	 
	private LocalDateTime dataMassima;
	private long minuti = 0;

	PowerOutageDAO podao;
	private List<Event> gliEventi;
	private List<Event> best;
	
	
	public Model() {
		podao = new PowerOutageDAO();
	}
	
	public List<Nerc> getNercList() {
		return podao.getNercList();
	}

	public List<Event> getEventList(int nerc_id) {
		return podao.getEventList(nerc_id);
	}
	
	public List<Event> calcolaSequenza(int nerc_id, int maxAnni, long maxOre) {
		
		List<Event> parziale = new ArrayList<Event>();
		gliEventi = this.getEventList(nerc_id);
		this.best = null;
		
		
		this.cerca(parziale, 0, maxAnni, maxOre, minuti);
		
		return best;
		
	}

	private void cerca(List<Event> parziale, int livello, int maxAnni, long maxOre, long minuti) {
		
		//System.out.println(parziale.toString());
		//System.out.println(minuti/60);
		
		if(best==null || maggiore(parziale, best)) {
			best = new ArrayList<>(parziale);
		}
		
		for(Event e : gliEventi) {
			if(aggiuntaValida(e, parziale, maxAnni, maxOre, minuti)) {
				parziale.add(e);
				long minutiNuovi = minuti + e.inizio.until(e.fine, ChronoUnit.MINUTES);
				cerca(parziale, livello + 1, maxAnni, maxOre, minutiNuovi);
				parziale.remove(parziale.size() - 1);
				
			}
		}
		
	}

	private boolean maggiore(List<Event> parziale, List<Event> best2) {
		
		int sommap = 0;
		int sommab = 0;
		
		for(Event etemp : parziale) {
			sommap += etemp.customers;
		}
		
		for(Event etemp : best) {
			sommab += etemp.customers;
		}
		
		if(sommap>sommab) {
			return true;
		}
		return false;
	}

	private boolean aggiuntaValida(Event e, List<Event> parziale, int maxAnni, long maxOre, long minuti) {
	
		
		if(parziale.size()==0) {
			dataMassima = e.inizio.plusYears(maxAnni-1);
			this.minuti = 0;
			return true;
		}
		
		if(e.fine.isBefore(dataMassima) && e.inizio.isAfter(parziale.get(parziale.size()-1).inizio)) {
			if(e.inizio.until(e.fine, ChronoUnit.MINUTES)+minuti < maxOre*60) {
				return true;
			}
		}
		
		
		return false;
	}
	
	public int getBestCustomers() {
		int sommab = 0;

		for(Event etemp : best) {
			sommab += etemp.customers;
		}
		return sommab;
	}

	public long getBestOre() {
		
		long sommaOre = 0;
		
		for(Event etemp : best) {
			sommaOre += etemp.inizio.until(etemp.fine, ChronoUnit.MINUTES);
		}
		
		return sommaOre/60;
	}
}
