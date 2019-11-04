package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
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
	
	@FXML
	private TableView<File> tvResultado;
	
	@FXML
	private TableColumn<File, String> colunaArquivo;
	
	@FXML
	private TableColumn<File, String> colunaCaminho;

	private Main mainApp;
	
	private ObservableList<File> observableList;

	private static int quantidade;
	
	private static List<File> arquivos;

	public static List<File> getArquivos() {
		return arquivos;
	}

	public static void setArquivos(List<File> arquivos) {
		ProntuariosController.arquivos = arquivos;
	}

	public static int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		ProntuariosController.quantidade = quantidade;
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
			if (files.size() == 1) {
				taResultado.clear();

				dialog.setTitle("Error");
				dialog.setHeaderText(null);
				dialog.setContentText("É necessário selecionar no mínimo dois arquivos.");
				dialog.show();
			}
		} while (files.size() == 1);

		this.observableList = FXCollections.observableArrayList(files);
		preencherTabela(files);

		setQuantidade(files.size());
		setArquivos(files);
	}

	private void preencherTabela(List<File> files) {
		for (File file : files) {
			colunaArquivo.setCellValueFactory(new PropertyValueFactory<File, String>(file.getName()));
			colunaCaminho.setCellValueFactory(new PropertyValueFactory<File, String>(file.getPath()));
			
			System.out.println(file.getName() + " " + file.getPath());
		}

		tvResultado.setItems(observableList);
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
