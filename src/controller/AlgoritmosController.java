package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import view.Main;

public class AlgoritmosController {
	@FXML
    private Button btVoltar;

    @FXML
    private Button btResultado;

    @FXML
    private Label lbSelecionarAlgoritmos;

    @FXML
    private CheckBox cbCosine;

    @FXML
    private CheckBox cbTrigram;

    @FXML
    private CheckBox cbLevenshtein;

    @FXML
    private CheckBox cbJaroWinkler;

    private Main mainApp;
    
    public Button getBtVoltar() {
		return btVoltar;
	}

	public void setBtVoltar(Button btVoltar) {
		this.btVoltar = btVoltar;
	}

	public Button getBtResultado() {
		return btResultado;
	}

	public void setBtResultado(Button btResultado) {
		this.btResultado = btResultado;
	}

	public Label getLbSelecionarAlgoritmos() {
		return lbSelecionarAlgoritmos;
	}

	public void setLbSelecionarAlgoritmos(Label lbSelecionarAlgoritmos) {
		this.lbSelecionarAlgoritmos = lbSelecionarAlgoritmos;
	}

	public CheckBox getCbCosine() {
		return cbCosine;
	}

	public void setCbCosine(CheckBox cbCosine) {
		this.cbCosine = cbCosine;
	}

	public CheckBox getCbTrigram() {
		return cbTrigram;
	}

	public void setCbTrigram(CheckBox cbTrigram) {
		this.cbTrigram = cbTrigram;
	}

	public CheckBox getCbLevenshtein() {
		return cbLevenshtein;
	}

	public void setCbLevenshtein(CheckBox cbLevenshtein) {
		this.cbLevenshtein = cbLevenshtein;
	}

	public CheckBox getCbJaroWinkler() {
		return cbJaroWinkler;
	}

	public void setCbJaroWinkler(CheckBox cbJaroWinkler) {
		this.cbJaroWinkler = cbJaroWinkler;
	}

	public Main getMainApp() {
		return mainApp;
	}

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
	
	/////////////////////// Métodos ////////////////////////
	@FXML
    protected void gerarResultado(ActionEvent event) throws IOException {
		// TODO conferir as caixas selecionadas 
		mainApp.telaResultados();
    }

    @FXML
    protected void selecionarCosine(ActionEvent event) {
    	cbCosine.setSelected(true);
    }

    @FXML
    protected void selecionarJaroWinkler(ActionEvent event) {
    	cbJaroWinkler.setSelected(true);
    }

    @FXML
    protected void selecionarLevenshtein(ActionEvent event) {
    	cbLevenshtein.setSelected(true);
    }

    @FXML
    protected void selecionarTrigram(ActionEvent event) {
    	cbTrigram.setSelected(true);
    }

    @FXML
    protected void voltarTela(ActionEvent event) throws IOException {
    	mainApp.telaProntuarios();
    }
}
