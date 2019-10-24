package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import view.Main;

public class ResultadosController {
    @FXML
    private TextArea taResultado;
    
    @FXML
    private Button btVoltar;
    
    @FXML
    private Label lbSelecionarAlgoritmos;
    
    @FXML
    private Button btGerar;
    
    @FXML
    private Button btImportar;
    
    private Main mainApp;

	public Main getMainApp() {
		return mainApp;
	}

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
	
	public TextArea getTaResultado() {
		return taResultado;
	}

	public void setTaResultado(TextArea taResultado) {
		this.taResultado = taResultado;
	}

	public Button getBtVoltar() {
		return btVoltar;
	}

	public void setBtVoltar(Button btVoltar) {
		this.btVoltar = btVoltar;
	}

	public Label getLbSelecionarAlgoritmos() {
		return lbSelecionarAlgoritmos;
	}

	public void setLbSelecionarAlgoritmos(Label lbSelecionarAlgoritmos) {
		this.lbSelecionarAlgoritmos = lbSelecionarAlgoritmos;
	}

	public Button getBtGerar() {
		return btGerar;
	}

	public void setBtGerar(Button btGerar) {
		this.btGerar = btGerar;
	}

	public Button getBtImportar() {
		return btImportar;
	}

	public void setBtImportar(Button btImportar) {
		this.btImportar = btImportar;
	}

	/////////////////////// Métodos ////////////////////////
    @FXML
    protected void gerarResultados(ActionEvent event) {
    	// TODO gerar resultados com o algoritmo selecionado
    }

    @FXML
    protected void importarResultados(ActionEvent event) {
    	// TODO salvar o resultado em um txt (protuario original - prontuario minerado - valores)
    }

    @FXML
    protected void voltarTela(ActionEvent event) throws IOException {
    	mainApp.telaAlgoritmos();
    }

}
