package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
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
	protected void selecionarProntuarios(ActionEvent event) throws InterruptedException {
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Selecionar arquivo");
		List<File> files;
		do {
			files = chooser.showOpenMultipleDialog(btProntuarios.getScene().getWindow());
			
			if(files.size() == 1) {
	        	taResultado.clear();
	        	
	        	Alert dialog = new Alert(AlertType.ERROR);
	    		dialog.setTitle("Error");
	    		dialog.setHeaderText(null);
	    		dialog.setContentText("É necessário selecionar no mínimo dois arquivos.");
	    		dialog.show();
	    		dialog.wait();
	        }
		} while(files.size() == 1);
                	
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
