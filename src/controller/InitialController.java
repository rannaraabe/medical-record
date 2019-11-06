
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import view.Main;

public class InitialController implements Initializable {
	@FXML
	private ImageView imgElements;

	@FXML
	private ImageView imgDoctor;

	@FXML
	private Button btIniciar;

	@FXML
	private Button btAjuda;

	@FXML
	private Button btSobre;

	private Main mainApp;

	public Application getMainApp() {
		return mainApp;
	}

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}

	/////////////////////// Metodos ////////////////////////
	@FXML
	protected void selecionarAjuda(ActionEvent event) {
		Alert dialog = new Alert(AlertType.INFORMATION);
		dialog.setTitle("Ajuda");
		dialog.setHeaderText(null);
		dialog.setContentText("Passo a passo de uso do sistema: \n >Ao iniciar o sistema, selecione o botao 'Selecionar prontuarios' e escolha os prontuarios desejados em .pdf (o sistema permite a escolha de no minimo dois prontuarios por vez)"
				+ "\n >Voce pode escolher 'Selecionar metricas' ou 'Gerar Similaridade'"
				+ "\n >Ao clicar no botao 'Selecionar metricas', selecione as metricas desejadas para comparar os prontuarios"
				+ "\n >Clique no botao 'Gerar resultados'"
				+ "\n >Se desejar, exporte os resultados selecionando o botao 'Exportar Resultados'"
				+ "\n >Caso clique no botao 'Gerar Similaridade', será exibido um grafico com os resultados.");
		dialog.show();
	}

	@FXML
	protected void selecionarIniciar(ActionEvent event) throws IOException {
		mainApp.telaProntuarios();
	}

	@FXML
	protected void selecionarSobre(ActionEvent event) {
		Alert dialog = new Alert(AlertType.INFORMATION);
		dialog.setTitle("Sobre");
		dialog.setHeaderText(null);
		dialog.setContentText(
				"O sistema MT-MR eh um sistema que integra IA com Medicina. O objetivo principal do sistema eh ler dados de prontuarios medicos uplados e compara-los entre si para detectar a semelhanca entre os diagnosticos, atraves de metricas selecionadas."
				+ "\nDesenvolvido por Ranna Raabe");
		dialog.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
}
