package controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

public class ProntuariosController {
	@FXML
    private Button btMetricas;
    @FXML
    private TextArea taResultado;
    @FXML
    private Button btVoltar;
    @FXML
    private Button btProntuarios;

	private Application mainApp;

	public Button getBtMetricas() {
		return btMetricas;
	}

	public void setBtMetricas(Button btMetricas) {
		this.btMetricas = btMetricas;
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
	
	public Button getBtProntuarios() {
		return btProntuarios;
	}

	public void setBtProntuarios(Button btProntuarios) {
		this.btProntuarios = btProntuarios;
	}

	public Application getMainApp() {
		return mainApp;
	}

	public void setMainApp(Application mainApp) {
		this.mainApp = mainApp;
	}

    @FXML
    protected void aplicarAlgoritmos(ActionEvent event) {
    	// ir para o proxima pagina dos algoritmos
    }

    @FXML
    protected void selecionarProntuarios(ActionEvent event) {
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Selecionar arquivo");
		chooser.showOpenDialog(btMetricas.getScene().getWindow());
    }

    @FXML
    protected void voltarTela(ActionEvent event) {
    	// voltar para tela anterior
    }
   
}
