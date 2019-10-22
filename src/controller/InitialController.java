package controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class InitialController {
	@FXML
	private Label lbInstrucoes;
	@FXML
	private ImageView imgDoctor;
	@FXML
	private Button btIniciar;
	@FXML
	private Label lbWelcome;
	
	private Application mainApp;
	
	public Label getLbInstrucoes() {
		return lbInstrucoes;
	}

	public void setLbInstrucoes(Label lbInstrucoes) {
		this.lbInstrucoes = lbInstrucoes;
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

	public Label getLbWelcome() {
		return lbWelcome;
	}

	public void setLbWelcome(Label lbWelcome) {
		this.lbWelcome = lbWelcome;
	}

	public Application getMainApp() {
		return mainApp;
	}

	public void setMainApp(Application mainApp) {
		this.mainApp = mainApp;
	}

	@FXML
	protected void btIniciar(ActionEvent event) {
		// direcionar para a proxima tela
	}

}
