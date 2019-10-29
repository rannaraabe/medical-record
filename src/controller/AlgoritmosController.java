package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import model.algorithms.Cosine;
import model.algorithms.JaroWinkler;
import model.algorithms.Levenshtein;
import model.algorithms.Trigram;
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

	@FXML
	private TextArea taResultados;

	@FXML
	private Label lbMostrarDados;
	
	@FXML
	private CheckBox cdDadosPaciente;

	@FXML
	private CheckBox cdDadosAtendimento;

	@FXML
	private CheckBox cbAnamnese;

	@FXML
	private CheckBox cbNotasAdicionais;

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
		// TODO passar os dados
		if (cbCosine.isSelected()) {
			Cosine cosine = new Cosine();
			cosine.similarity("", "");
			System.out.println("cosine selecionado");
		}

		if (cbJaroWinkler.isSelected()) {
			JaroWinkler jaro = new JaroWinkler();
			jaro.similarity("", "");
			System.out.println("jaro selecionado");
		}

		if (cbLevenshtein.isSelected()) {
			Levenshtein levenshtein = new Levenshtein();
			levenshtein.similarity("", "");
			System.out.println("levenshtein selecionado");
		}

		if (cbTrigram.isSelected()) {
			Trigram trigram = new Trigram();
			trigram.similarity("", "");
			System.out.println("trigram selecionado");
		}

		mainApp.telaResultados();
	}

	@FXML
	protected void voltarTela(ActionEvent event) throws IOException {
		mainApp.telaProntuarios();
	}
}
