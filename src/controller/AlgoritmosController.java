package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import model.utils.ConfusionMatrix;
import view.Main;

public class AlgoritmosController implements Initializable {
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

	@FXML
	private Button btImportar;

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

	public TextArea getTaResultados() {
		return taResultados;
	}

	public void setTaResultados(TextArea taResultados) {
		this.taResultados = taResultados;
	}

	public Label getLbMostrarDados() {
		return lbMostrarDados;
	}

	public void setLbMostrarDados(Label lbMostrarDados) {
		this.lbMostrarDados = lbMostrarDados;
	}

	public CheckBox getCdDadosPaciente() {
		return cdDadosPaciente;
	}

	public void setCdDadosPaciente(CheckBox cdDadosPaciente) {
		this.cdDadosPaciente = cdDadosPaciente;
	}

	public CheckBox getCdDadosAtendimento() {
		return cdDadosAtendimento;
	}

	public void setCdDadosAtendimento(CheckBox cdDadosAtendimento) {
		this.cdDadosAtendimento = cdDadosAtendimento;
	}

	public CheckBox getCbAnamnese() {
		return cbAnamnese;
	}

	public void setCbAnamnese(CheckBox cbAnamnese) {
		this.cbAnamnese = cbAnamnese;
	}

	public CheckBox getCbNotasAdicionais() {
		return cbNotasAdicionais;
	}

	public void setCbNotasAdicionais(CheckBox cbNotasAdicionais) {
		this.cbNotasAdicionais = cbNotasAdicionais;
	}

	public Button getBtImportar() {
		return btImportar;
	}

	public void setBtImportar(Button btImportar) {
		this.btImportar = btImportar;
	}
	
	/////////////////////// Métodos ////////////////////////
	@FXML
	protected void gerarResultado(ActionEvent event) throws IOException {
		ConfusionMatrix cm = new ConfusionMatrix();
		
		int qFiles = 5;
		
		if (cbCosine.isSelected())
			taResultados.setText("Resultados Cosine: \n" + cm.printMatrix(qFiles, "cosine"));
		
		/*if (cbCosine.isSelected() && cbTrigram.isSelected())
			taResultados.setText(cm.printMatrix(qFiles, "cosine") + "\n" + cm.printMatrix(qFiles, "trigram"));
		
		if (cbCosine.isSelected() && cbTrigram.isSelected() && cbJaroWinkler.isSelected())
			taResultados.setText(cm.printMatrix(qFiles, "cosine") + "\n" + cm.printMatrix(qFiles, "trigram") + "\n" + cm.printMatrix(qFiles, "jaro"));
		
		if (cbCosine.isSelected() && cbTrigram.isSelected() && cbJaroWinkler.isSelected() && cbLevenshtein.isSelected())
			taResultados.setText(cm.printMatrix(qFiles, "cosine") + "\n" + cm.printMatrix(qFiles, "trigram") + "\n" + cm.printMatrix(qFiles, "jaro") + "\n" + cm.printMatrix(qFiles, "levenshtein"));*/
		
		if (cbTrigram.isSelected())
			taResultados.setText("Resultados Trigram: \n" + cm.printMatrix(qFiles, "trigram"));
		
		/*if(cbTrigram.isSelected() && cbJaroWinkler.isSelected())
			taResultados.setText(cm.printMatrix(qFiles, "trigram") + "\n" + cm.printMatrix(qFiles, "jaro"));
		
		if(cbTrigram.isSelected() && cbJaroWinkler.isSelected() && cbLevenshtein.isSelected())
			taResultados.setText(cm.printMatrix(qFiles, "trigram") + "\n" + cm.printMatrix(qFiles, "jaro") + "\n" + cm.printMatrix(qFiles, "levenshtein"));*/
		
		if (cbJaroWinkler.isSelected())
			taResultados.setText("Resultados Jaro-Winkler: \n" + cm.printMatrix(qFiles, "jaro"));
		
		/*if (cbJaroWinkler.isSelected() && cbLevenshtein.isSelected())
			taResultados.setText(cm.printMatrix(qFiles, "jaro") + "\n" + cm.printMatrix(qFiles, "levenshtein"));*/
		
		if (cbLevenshtein.isSelected())
			taResultados.setText("Resultados Levenshtein: \n" + cm.printMatrix(qFiles, "levenshtein"));

		// como pegar os dados da quantidade e dos prontuarios da pagina passada
	}
	
	@FXML
	protected void importarResultados(ActionEvent event) {
		// TODO salvar em um arquivo txt os resultados e abrir um alert diaglog indicando q salvou ok e mostrando o caminho
	}

	@FXML
	protected void voltarTela(ActionEvent event) throws IOException {
		mainApp.telaProntuarios();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
}
