package view;

import java.io.IOException;

import controller.InitialController;
import controller.ProntuariosController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	private Stage primaryStage;
	public AnchorPane rootLayout;

	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("MT-MR");
		telaInicial();
	}

	public void telaInicial() throws IOException {
		FXMLLoader fxmlInicial = new FXMLLoader();
		fxmlInicial.setLocation(getClass().getResource("Initial.fxml"));
		AnchorPane screenInitial = (AnchorPane) fxmlInicial.load();
	
		Scene scene = new Scene(screenInitial);
		primaryStage.setScene(scene);
		primaryStage.show();

		InitialController controller = fxmlInicial.getController();
		controller.setMainApp(this);
	}

	public void telaProntuarios() throws IOException {
		FXMLLoader fxmlProntuarios = new FXMLLoader();
		fxmlProntuarios.setLocation(getClass().getResource("Prontuarios.fxml"));
		AnchorPane screenProntuarios = (AnchorPane) fxmlProntuarios.load();

		Scene scene = new Scene(screenProntuarios);
		primaryStage.setScene(scene);
		primaryStage.show();

		ProntuariosController controller = fxmlProntuarios.getController();
		controller.setMainApp(this);
	}
	
	public void telaAlgoritmos() throws IOException {
		FXMLLoader fxmlAlgoritmos = new FXMLLoader();
		fxmlAlgoritmos.setLocation(getClass().getResource("Algoritmos.fxml"));
		AnchorPane screenAlgoritmos = (AnchorPane) fxmlAlgoritmos.load();

		Scene scene = new Scene(screenAlgoritmos);
		primaryStage.setScene(scene);
		primaryStage.show();

		ProntuariosController controller = fxmlAlgoritmos.getController();
		controller.setMainApp(this);
	}
	
	public void telaResultados() throws IOException {
		FXMLLoader fxmlResultados = new FXMLLoader();
		fxmlResultados.setLocation(getClass().getResource("Resultados.fxml"));
		AnchorPane screenResultados = (AnchorPane) fxmlResultados.load();

		Scene scene = new Scene(screenResultados);
		primaryStage.setScene(scene);
		primaryStage.show();

		ProntuariosController controller = fxmlResultados.getController();
		controller.setMainApp(this);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
