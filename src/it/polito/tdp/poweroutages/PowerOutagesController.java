package it.polito.tdp.poweroutages;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.poweroutages.model.Model;
import it.polito.tdp.poweroutages.model.Nerc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PowerOutagesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<Nerc> boxNerc;

    @FXML
    private TextField txtAnni;

    @FXML
    private TextField txtOre;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtRisultati;
    
    private Model model;

    @FXML
    void doCalcolaScenario(ActionEvent event) {
    	
    	

    }

    @FXML
    void initialize() {
        assert boxNerc != null : "fx:id=\"boxNerc\" was not injected: check your FXML file 'PowerOutages.fxml'.";
        assert txtAnni != null : "fx:id=\"txtAnni\" was not injected: check your FXML file 'PowerOutages.fxml'.";
        assert txtOre != null : "fx:id=\"txtOre\" was not injected: check your FXML file 'PowerOutages.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'PowerOutages.fxml'.";
        assert txtRisultati != null : "fx:id=\"txtRisultati\" was not injected: check your FXML file 'PowerOutages.fxml'.";

    }
    
    public void setModel(Model model) {
		this.model = model;
		List<Nerc> nercList = model.getNercList();
		
		boxNerc.getItems().addAll(nercList);
		
	}
}
