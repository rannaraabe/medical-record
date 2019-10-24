package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
	
	/////////////////////// Métodos ////////////////////////
	@FXML
	protected void selecionarAjuda(ActionEvent event) {
		// TODO open dialog com instruçoes de uso
	}

	@FXML
	protected void selecionarIniciar(ActionEvent event) throws IOException {
		mainApp.telaProntuarios();
	}

	@FXML
	protected void selecionarSobre(ActionEvent event) {
		// TODO open dialog com resumo doq eh o projeto e criadora
	}
}
