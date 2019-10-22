package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.Main;

public class InitialController implements Initializable {
	@FXML
	private Label lbInstrucoes;
	@FXML
	private ImageView imgDoctor;
	@FXML
	private Button btIniciar;
	@FXML
	private Label lbWelcome;

	private Main mainApp;

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

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
	
	@FXML
	protected void btIniciar(ActionEvent event) throws IOException {
		mainApp.telaProntuarios();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		imgDoctor.setImage(new Image(Main.class.getResourceAsStream("../../img/doctor.png")));
	}

}
