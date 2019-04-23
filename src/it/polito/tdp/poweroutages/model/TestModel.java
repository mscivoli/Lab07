package it.polito.tdp.poweroutages.model;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		//System.out.println(model.getNercList());
		//System.out.println(model.getEventList(19).toString());
		System.out.println(model.calcolaSequenza(3, 4, 200));
		System.out.println(model.getBestCustomers());
		System.out.println(model.getBestOre());
		
		
		
	}
}
