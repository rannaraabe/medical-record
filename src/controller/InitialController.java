
package controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import view.Main;

public class InitialController {
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

	public ImageView getImgElements() {
		return imgElements;
	}

	public void setImgElements(ImageView imgElements) {
		this.imgElements = imgElements;
	}

	public ImageView getImgDoctor() {
		return imgDoctor;
	}

	public void setImgDoctor(ImageView imgDoctor) {
		this.imgDoctor = imgDoctor;
	}

	public Button getBtIniciar() {
		return btIniciar;
	}

	public void setBtIniciar(Button btIniciar) {
		this.btIniciar = btIniciar;
	}

	public Button getBtAjuda() {
		return btAjuda;
	}

	public void setBtAjuda(Button btAjuda) {
		this.btAjuda = btAjuda;
	}

	public Button getBtSobre() {
		return btSobre;
	}

	public void setBtSobre(Button btSobre) {
		this.btSobre = btSobre;
	}

	public Application getMainApp() {
		return mainApp;
	}

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}

	/////////////////////// M�todos ////////////////////////
	@FXML
	protected void selecionarAjuda(ActionEvent event) {
		// TODO open dialog com instru�oes de uso
		Alert dialog = new Alert(AlertType.INFORMATION);
		dialog.setTitle("Ajuda");
		dialog.setHeaderText(null);
		dialog.setContentText("Passo a passo de uso do sistema: \n >Selecione o bot�o 'Iniciar'"
				+ "\n >Selecione o bot�o 'Selecionar prontu�rios' e escolha os prontu�rios desejados em .pdf (o sistema permite a escolha de no m�nimo dois prontu�rios por vez)"
				+ "\n >Clique no bot�o 'Selecionar m�tricas'"
				+ "\n >Selecione as m�tricas desejadas para comparar os prontu�rios"
				+ "\n >Se desejar, escolha os dados que queira para estarem nos resultados finais (por padr�o, o sistema informa apenas qual o prontu�rio e a anamnese)"
				+ "\n >Clique no bot�o 'Gerar resultados'"
				+ "\n >Se desejar, importe os resultados selecionando o bot�o 'Importar Resultados'");
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
				"O sistema MT-MR � um sistema que integra IA com Medicina. O objetivo principal do sistema � ler dados de prontu�rios m�dicos uplados e compar�-los entre si para detectar a semelhan�a entre os dign�sticos, atrav�s de m�tricas selecionadas."
				+ "\nDesenvolvido por Ranna Raabe�");
		dialog.show();
	}
}
