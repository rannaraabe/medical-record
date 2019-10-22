package controller;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import view.Main;

public class ProntuariosController {
	@FXML
    private Button btMetricas;
    @FXML
    private Button btVoltar;
    @FXML
    private Button btProntuarios;
    @FXML
    private Button btGerar;
    @FXML
    private Button btImportar;
    @FXML
    private ChoiceBox<?> cbAlgoritmos;
    @FXML
    private Label lbSelecionarAlgoritmos;
    @FXML
    private LineChart<?, ?> lcGrafico;
    @FXML
    private TextArea taResultado;

	private Main mainApp;

	public Main getMainApp() {
		return mainApp;
	}

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}

    @FXML
    protected void selecionarProntuarios(ActionEvent event) {
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Selecionar arquivo");
		File file = chooser.showOpenDialog(btProntuarios.getScene().getWindow());
		
		// TODO escrever em taResultado o arquivo
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
    protected void voltarTela(ActionEvent event) throws IOException {
    	mainApp.telaInicial();
    }
     
}
