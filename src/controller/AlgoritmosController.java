package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import model.DataSet;
import model.utils.ConfusionMatrix;
import model.utils.NewArchive;
import model.utils.ReaderPDF;
import view.Main;

public class AlgoritmosController implements Initializable {
	@FXML
	private Button btVoltar;

	@FXML
	private Button btResultado;

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
	private Label lbMostrarDados;

	@FXML
	private CheckBox cdDadosPaciente;

	@FXML
	private CheckBox cdDadosAtendimento;

	@FXML
	private CheckBox cbAnamnese;

	@FXML
	private CheckBox cbNotasAdicionais;

	@FXML
	private Button btImportar;

	@FXML
	private BarChart<String, Number> bcGrafico;

	private Main mainApp;

	private int quantidadeArquivos;
	
	private int index = 1;

	private List<File> arquivos;

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

	public Main getMainApp() {
		return mainApp;
	}

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}

	/////////////////////// Métodos ////////////////////////
	@FXML
	protected void gerarResultado(ActionEvent event) throws IOException {
		ConfusionMatrix cm = new ConfusionMatrix();

		int qFiles = getQuantidadeArquivos();
		List<File> files = getArquivos();

		// TODO selecionar mais do que um algoritmo

		if (cbCosine.isSelected())
			taResultados.setText("Cosine: \n"
					+ cm.printMatrix(qFiles, files, "cosine"));

		if (cbTrigram.isSelected())
			taResultados.setText("Resultados Trigram: \n"
					+ cm.printMatrix(qFiles, files, "trigram"));

		if (cbJaroWinkler.isSelected())
			taResultados.setText("Resultados Jaro-Winkler: \n"
					+ cm.printMatrix(qFiles, files, "jaro"));

		if (cbLevenshtein.isSelected())
			taResultados.setText("Resultados Levenshtein: \n"
					+ cm.printMatrix(qFiles, files, "levenshtein"));
		
	}

	@FXML
	protected void exportarResultados(ActionEvent event) throws FileNotFoundException {
		// TODO corrigir a importacao adicionando os dados na hora de importar
		NewArchive na = new NewArchive();
		na.generateFile(taResultados.getText(), index);
		index++;
		
		Alert dialog = new Alert(AlertType.CONFIRMATION);
		dialog.setTitle("Exportação completa!");
		dialog.setHeaderText(null);
		dialog.setContentText("Dados exportados com sucesso! Confira na pasta '\\dataset\\resultados\\'.");
		dialog.show();
	}
	
	@FXML
    void exibirResultados(MouseEvent event) throws IOException {
		minerarProntuario(getArquivos());
    }
	
	private String minerarProntuario(List<File> files) throws IOException {
		DataSet ds = new DataSet();
		ReaderPDF readerPDF = new ReaderPDF();
		int cont = 1;

		for (File file : files) {
			readerPDF.generateTxtFromPDF(file.getPath(), cont);
			cont++;
		}
		
		String text = "";

		for (File file : files) {
			String path = ".\\dataset\\output\\pdf_anamnese" + cont + ".txt";
			cont++;
			text += "================================== " + file.getName()
			+ " ==================================\n" + ds.readerArchive(path) + "\n";
		}
		
		return text;
	}

	@FXML
	protected void voltarTela(ActionEvent event) throws IOException {
		mainApp.telaProntuarios();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		setQuantidadeArquivos(ProntuariosController.getQuantidade());
		setArquivos(ProntuariosController.getArquivos());

		System.out.println(getArquivos());
	}
}
