package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.spi.InitialContextFactory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import model.DataSet;
import model.utils.ReaderPDF;
import view.Main;

public class ProntuariosController implements Initializable {
	@FXML
	private TextArea taResultado;
	
	@FXML
	private Button btProntuarios;
	
	@FXML
	private Button btVoltar;
	
	@FXML
	private Button btMetricas;
	
	private Main mainApp;
	
	private static int quantidade;

	public static int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

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
	protected void selecionarProntuarios(ActionEvent event) throws InterruptedException, IOException {
		FileChooser chooser = new FileChooser();
		
		chooser.setTitle("Selecionar arquivo");
		List<File> files;
		Alert dialog = new Alert(AlertType.ERROR);
		
		do {
			files = chooser.showOpenMultipleDialog(btProntuarios.getScene().getWindow());
			
			if(files.size() == 1) {
	        	taResultado.clear();
	        	
	    		dialog.setTitle("Error");
	    		dialog.setHeaderText(null);
	    		dialog.setContentText("É necessário selecionar no mínimo dois arquivos.");
	    		dialog.show();
	        }
			
		} while(files.size() == 1);
		
		setQuantidade(files.size());
        printProntuarios(taResultado, files);
	}
	
	private void printProntuarios(TextArea textArea, List<File> files) throws IOException {
        if (files == null || files.isEmpty()) 
            return;
        
        int cont = 1;
		ReaderPDF readerPDF = new ReaderPDF();
		DataSet ds = new DataSet();
		
		// Convertendo os arquivos PDF em txt
        for (File file : files) {
			readerPDF.generateTxtFromPDF(file.getPath(), cont);
			cont++;
		}
        
        cont = 1;
        for (File file : files) {
        	//System.out.println(file.getPath());
        	String path = ".\\dataset\\output\\pdfAnamnese"+ cont +".txt";
            textArea.appendText("================================== "+ file.getName() +" ==================================\n" + ds.readerArchive(path) +"\n");
            cont++;
        }
    }

	@FXML
	protected void selecionarMetricas(ActionEvent event) throws IOException {
		mainApp.telaAlgoritmos();
	}

	@FXML
	protected void voltarTela(ActionEvent event) throws IOException {
		mainApp.telaInicial();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
