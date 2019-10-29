package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import view.Main;

public class ProntuariosController {
	@FXML
	private TextArea taResultado;
	
	@FXML
	private Button btProntuarios;
	
	@FXML
	private Button btVoltar;
	
	@FXML
	private Button btMetricas;
	
	private Main mainApp;

	public TextArea getTaResultado() {
		return taResultado;
	}

	public void setTaResultado(TextArea taResultado) {
		this.taResultado = taResultado;
	}

	public Button getBtProntuarios() {
		return btProntuarios;
	}

	public void setBtProntuarios(Button btProntuarios) {
		this.btProntuarios = btProntuarios;
	}

	public Button getBtVoltar() {
		return btVoltar;
	}

	public void setBtVoltar(Button btVoltar) {
		this.btVoltar = btVoltar;
	}

	public Button getBtMetricas() {
		return btMetricas;
	}

	public void setBtMetricas(Button btMetricas) {
		this.btMetricas = btMetricas;
	}

	public Main getMainApp() {
		return mainApp;
	}

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}

	/////////////////////// Métodos ////////////////////////	
	@FXML
	protected void selecionarProntuarios(ActionEvent event) {
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Selecionar arquivo");

		taResultado.clear();
        List<File> files = chooser.showOpenMultipleDialog(btProntuarios.getScene().getWindow());
        printProntuarios(taResultado, files);
	}
	
	private void printProntuarios(TextArea textArea, List<File> files) {
        if (files == null || files.isEmpty()) 
            return;
        
        for (File file : files) 
            textArea.appendText(file.getAbsoluteFile() + "\n===================================================\n");
    }

	@FXML
	protected void selecionarMetricas(ActionEvent event) throws IOException {
		mainApp.telaAlgoritmos();
	}

	@FXML
	protected void voltarTela(ActionEvent event) throws IOException {
		mainApp.telaInicial();
	}

}
