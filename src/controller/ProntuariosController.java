package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import model.DataSet;
import model.utils.ReaderPDF;
import view.Main;

public class ProntuariosController {
	@FXML
	private Button btProntuarios;

	@FXML
	private Button btVoltar;

	@FXML
	private Button btMetricas;

	@FXML
	private Button btSimilaridade;

	@FXML
	private TableView<File> tvResultado;

	@FXML
	private TableColumn<File, String> colunaArquivo;

	@FXML
	private TableColumn<File, String> colunaCaminho;

	private ObservableList<File> observableList;
	private static int quantidade;
	private static List<File> arquivos;
	private Main mainApp;

	public Application getMainApp() {
		return mainApp;
	}

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}

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

	/////////////////////// Métodos ////////////////////////
	@FXML
	protected void selecionarProntuarios(ActionEvent event) throws InterruptedException, IOException {
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Selecionar arquivos");

		List<File> files;
		Alert dialog = new Alert(AlertType.ERROR);

		do {
			files = chooser.showOpenMultipleDialog(btProntuarios.getScene().getWindow());
			if (files.size() == 1) {

				dialog.setTitle("Error");
				dialog.setHeaderText(null);
				dialog.setContentText("É necessário selecionar no mínimo dois arquivos.");
				dialog.show();
			}
		} while (files.size() == 1);

		this.observableList = FXCollections.observableArrayList(files);
		preencherTabela();
		tvResultado.setItems(observableList);

		setQuantidade(files.size());
		setArquivos(files);
	}

	private void preencherTabela() {
		colunaArquivo.setCellValueFactory(new PropertyValueFactory<File, String>("name"));
		colunaCaminho.setCellValueFactory(new PropertyValueFactory<File, String>("path"));
	}

	@FXML
	protected void selecionarMetricas(ActionEvent event) throws IOException {
		if (getQuantidade() == 0) {
			Alert dialog = new Alert(AlertType.ERROR);
			dialog.setTitle("Error");
			dialog.setHeaderText(null);
			dialog.setContentText("É necessário selecionar arquivos para prosseguir.");
			dialog.show();
		} else {
			mainApp.telaAlgoritmos();
		}
	}

	@FXML
	protected void gerarSimilaridade(ActionEvent event) throws IOException {
		if (getQuantidade() > 2) {
			Alert dialog = new Alert(AlertType.ERROR);
			dialog.setTitle("Error");
			dialog.setHeaderText(null);
			dialog.setContentText("Só é possível selecionar 2 (dois) arquivos.");
			dialog.show();
		} else if (getQuantidade() == 0) {
			Alert dialog = new Alert(AlertType.ERROR);
			dialog.setTitle("Error");
			dialog.setHeaderText(null);
			dialog.setContentText("É necessário selecionar 2 (dois) arquivos para prosseguir.");
			dialog.show();
		} else {
			mainApp.telaSimilaridade();
		}
	}

	public static void minerandoArquivos(List<File> files) throws IOException {
		ReaderPDF rPDF = new ReaderPDF();
		int cont = 0;
		// Converto os arquivos pdf em txt
		for (File file : files) {
			rPDF.generateTxtFromPDF(file.getPath(), "_teste" + cont);
			cont++;
		}
	}

	public static String printArquivos() throws IOException {
		DataSet data = new DataSet();
		String arquivosMinerados = "";

		for (int i = 0; i < getQuantidade(); i++) {
			arquivosMinerados += "================================== " + getArquivos().get(i).getName()
					+ " ==================================\n"
					+ data.readerArchive(".\\dataset\\output\\pdf_anamnese_teste" + i + ".txt") + "\n";
		}

		return arquivosMinerados;
	}

	@FXML
	protected void voltarTela(ActionEvent event) throws IOException {
		mainApp.telaInicial();
	}

}
