
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

	/////////////////////// Métodos ////////////////////////
	@FXML
	protected void selecionarAjuda(ActionEvent event) {
		// TODO open dialog com instruçoes de uso
		Alert dialog = new Alert(AlertType.INFORMATION);
		dialog.setTitle("Ajuda");
		dialog.setHeaderText(null);
		dialog.setContentText("Passo a passo de uso do sistema: \n >Selecione o botão 'Iniciar'"
				+ "\n >Selecione o botão 'Selecionar prontuários' e escolha os prontuários desejados em .pdf (o sistema permite a escolha de no mínimo dois prontuários por vez)"
				+ "\n >Clique no botão 'Selecionar métricas'"
				+ "\n >Selecione as métricas desejadas para comparar os prontuários"
				+ "\n >Se desejar, escolha os dados que queira para estarem nos resultados finais (por padrão, o sistema informa apenas qual o prontuário e a anamnese)"
				+ "\n >Clique no botão 'Gerar resultados'"
				+ "\n >Se desejar, exporte os resultados selecionando o botão 'Exportar Resultados'");
		dialog.show();
	}

	@FXML
	protected void selecionarIniciar(ActionEvent event) throws IOException {
		mainApp.telaProntuarios();
	}

	@FXML
	protected void selecionarSobre(ActionEvent event) {
		// TODO open dialog com resumo doq eh o projeto e criadora
		Alert dialog = new Alert(AlertType.INFORMATION);
		dialog.setTitle("Sobre");
		dialog.setHeaderText(null);
		dialog.setContentText(
				"O sistema MT-MR é um sistema que integra IA com Medicina. O objetivo principal do sistema é ler dados de prontuários médicos uplados e compará-los entre si para detectar a semelhança entre os dignósticos, através de métricas selecionadas."
				+ "\nDesenvolvido por Ranna Raabe®");
		dialog.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
