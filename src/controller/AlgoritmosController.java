package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import model.utils.ConfusionMatrix;
import model.utils.NewArchive;
import view.Main;

public class AlgoritmosController implements Initializable {
	@FXML
	private Button btVoltar;

	@FXML
	private Button btResultado;

	@FXML
	private Button btHome;

	@FXML
	private Label lbSelecionarAlgoritmos;

	@FXML
	private CheckBox cbCosine;

	@FXML
	private CheckBox cbTrigram;

	@FXML
	private CheckBox cbLevenshtein;

	@FXML
	private CheckBox cbJaroWinkler;

	@FXML
	private TextArea taResultados;

	@FXML
	private Button btImportar;

	@FXML
	private TextArea taProntuarios;

	private int quantidadeArquivos;
	private int index = 1;
	private List<File> arquivos;
	private String arquivosMinerados;
	private Main mainApp;

	public Application getMainApp() {
		return mainApp;
	}

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}

	public List<File> getArquivos() {
		return arquivos;
	}

	public void setArquivos(List<File> arquivos) {
		this.arquivos = arquivos;
	}

	public int getQuantidadeArquivos() {
		return quantidadeArquivos;
	}

	public void setQuantidadeArquivos(int quantidadeArquivos) {
		this.quantidadeArquivos = quantidadeArquivos;
	}

	/////////////////////// Metodos ////////////////////////
	@FXML
	protected void verResultados(ActionEvent event) throws IOException {
		// Imprimo o resultado da matriz com o algoritmo selecionado
		ConfusionMatrix cm = new ConfusionMatrix();
		int qFiles = getQuantidadeArquivos();

		List<File> files = getArquivos();

		if (cbCosine.isSelected())
			taResultados.setText("Cosine: \n" + cm.printMatrix(qFiles, "cosine", files));

		if (cbTrigram.isSelected())
			taResultados.setText("Trigram: \n" + cm.printMatrix(qFiles, "trigram", files));

		if (cbJaroWinkler.isSelected())
			taResultados.setText("Jaro-Winkler: \n" + cm.printMatrix(qFiles, "jaro", files));

		if (cbLevenshtein.isSelected())
			taResultados.setText("Levenshtein: \n" + cm.printMatrix(qFiles, "levenshtein", files));

	}

	@FXML
	protected void exportarResultados(ActionEvent event) throws FileNotFoundException {
		// Gero um novo arquivo com os resultados minerados e a matriz
		NewArchive na = new NewArchive();
		na.generateFile(taProntuarios.getText() + "\n" + taResultados.getText(), index);
		index++;

		// Exibo um dialog apenas para informar ao usuario
		Alert dialog = new Alert(AlertType.CONFIRMATION);
		dialog.setTitle("Exportacao completa!");
		dialog.setHeaderText(null);
		dialog.setContentText("Dados exportados com sucesso! Confira na pasta '\\dataset\\resultados\\'.");
		dialog.show();
	}

	@FXML
	protected void voltarTela(ActionEvent event) throws IOException {
		mainApp.telaProntuarios();
	}

	@FXML
	void voltarHome(ActionEvent event) throws IOException {
		mainApp.telaInicial();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Recupero a quantidade de arquivos selecionados na pagina anterior e os
		// arquivos
		setQuantidadeArquivos(ProntuariosController.getQuantidade());
		setArquivos(ProntuariosController.getArquivos());

		try {
			ProntuariosController.minerandoArquivos(getArquivos());
			arquivosMinerados = ProntuariosController.printArquivos();
		} catch (IOException e) {
			e.printStackTrace();
		}

		taProntuarios.setText(arquivosMinerados);
	}
}
