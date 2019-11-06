package view;

import java.io.IOException;

import controller.AlgoritmosController;
import controller.InitialController;
import controller.ProntuariosController;
import controller.SimilaridadeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	private Stage primaryStage;
	public AnchorPane rootLayout;

	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("MT-MR");
		this.primaryStage.setResizable(false);
		
		telaInicial();
	}

	public void telaInicial() throws IOException {
		FXMLLoader fxmlInicial = new FXMLLoader();
		fxmlInicial.setLocation(Main.class.getResource("Initial.fxml"));
		rootLayout = (AnchorPane) fxmlInicial.load();
		
		Scene scene = new Scene(rootLayout);		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		InitialController controller = fxmlInicial.getController();		
		controller.setMainApp(this);
	}

	public void telaProntuarios() throws IOException {
		FXMLLoader fxmlProntuarios = new FXMLLoader();
		fxmlProntuarios.setLocation(Main.class.getResource("Prontuarios.fxml"));
		AnchorPane screenProntuarios = (AnchorPane) fxmlProntuarios.load();

		Scene scene = new Scene(screenProntuarios);
		primaryStage.setScene(scene);
		primaryStage.show();

		ProntuariosController controller = fxmlProntuarios.getController();
		controller.setMainApp(this);
	}
	
	public void telaAlgoritmos() throws IOException {
		FXMLLoader fxmlAlgoritmos = new FXMLLoader();
		fxmlAlgoritmos.setLocation(Main.class.getResource("Algoritmos.fxml"));
		AnchorPane screenAlgoritmos = (AnchorPane) fxmlAlgoritmos.load();

		Scene scene = new Scene(screenAlgoritmos);
		primaryStage.setScene(scene);
		primaryStage.show();

		AlgoritmosController controller = fxmlAlgoritmos.getController();
		controller.setMainApp(this);
	}
	
	public void telaSimilaridade() throws IOException {
		FXMLLoader fxmlSimilaridade = new FXMLLoader();
		fxmlSimilaridade.setLocation(Main.class.getResource("Similaridade.fxml"));
		AnchorPane screenSimilaridade = (AnchorPane) fxmlSimilaridade.load();

		Scene scene = new Scene(screenSimilaridade);
		primaryStage.setScene(scene);
		primaryStage.show();

		SimilaridadeController controller = fxmlSimilaridade.getController();
		controller.setMainApp(this);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
