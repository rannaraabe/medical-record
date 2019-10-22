package controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class AlgoritmosController {
    @FXML
    private Button btVoltar;
    @FXML
    private Button btGerar;
    @FXML
    private TextArea taResultado;
    @FXML
    private Button btImportar;
    @FXML
    private Label lbSelecionarAlgoritmos;
    @FXML
    private ChoiceBox<?> cbAlgoritmos;
    @FXML
    private LineChart<?, ?> lcGrafico;
    
    private Application mainApp;
    
    public Button getBtVoltar() {
		return btVoltar;
	}

	public void setBtVoltar(Button btVoltar) {
		this.btVoltar = btVoltar;
	}

	public Button getBtGerar() {
		return btGerar;
	}

	public void setBtGerar(Button btGerar) {
		this.btGerar = btGerar;
	}

	public TextArea getTaResultado() {
		return taResultado;
	}

	public void setTaResultado(TextArea taResultado) {
		this.taResultado = taResultado;
	}

	public Button getBtImportar() {
		return btImportar;
	}

	public void setBtImportar(Button btImportar) {
		this.btImportar = btImportar;
	}

	public Label getLbSelecionarAlgoritmos() {
		return lbSelecionarAlgoritmos;
	}

	public void setLbSelecionarAlgoritmos(Label lbSelecionarAlgoritmos) {
		this.lbSelecionarAlgoritmos = lbSelecionarAlgoritmos;
	}

	public ChoiceBox<?> getCbAlgoritmos() {
		return cbAlgoritmos;
	}

	public void setCbAlgoritmos(ChoiceBox<?> cbAlgoritmos) {
		this.cbAlgoritmos = cbAlgoritmos;
	}

	public LineChart<?, ?> getLcGrafico() {
		return lcGrafico;
	}

	public void setLcGrafico(LineChart<?, ?> lcGrafico) {
		this.lcGrafico = lcGrafico;
	}

	public Application getMainApp() {
		return mainApp;
	}

	public void setMainApp(Application mainApp) {
		this.mainApp = mainApp;
	}

	@FXML
    protected void gerarResultados(ActionEvent event) {
    	// gerar resultados com o algoritmo selecionado
    }

    @FXML
    protected void importarResultados(ActionEvent event) {
    	// salvar o resultado em um txt (protuario original - prontuario minerado - valores)
    }

    @FXML
    protected void voltarTela(ActionEvent event) {
    	// voltar para tela anterior
    }

}
