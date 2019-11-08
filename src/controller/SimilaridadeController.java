package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import model.utils.ConfusionMatrix;
import view.Main;

public class SimilaridadeController implements Initializable {

	@FXML
	private Button btVoltar;

	@FXML
	private Button btHome;

	@FXML
	private BarChart<String, Number> bcGrafico;

	@FXML
	private CategoryAxis xAlgoritmos;

	@FXML
	private NumberAxis yPorcentagem;

	@FXML
	private BarChart<String, Number> bcGrafico2;

	@FXML
	private CategoryAxis xAlgoritmo;

	@FXML
	private NumberAxis yPalavra;

	private Main mainApp;
	private int quantidadeArquivos;
	private List<File> arquivos;
	private boolean exibir = false;

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

	public Application getMainApp() {
		return mainApp;
	}

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}

	@FXML
	protected void voltarTela(ActionEvent event) throws IOException {
		mainApp.telaProntuarios();
	}

	private void exibirGrafico() throws IOException {

		try {
			Thread.sleep(60);
			this.exibir = true;
		} catch (InterruptedException ex) {
		}

		if (this.exibir) {
			bcGrafico.setTitle(getArquivos().get(0).getName() + " vs " + getArquivos().get(1).getName());
			bcGrafico2.setTitle(getArquivos().get(0).getName() + " vs " + getArquivos().get(1).getName());
			ConfusionMatrix cm = new ConfusionMatrix();

			XYChart.Series<String, Number> cosine = new XYChart.Series<String, Number>();
			cosine.setName("Cosine");
			cosine.getData().add(new XYChart.Data<String, Number>("", cm.resultadoMatrix(getArquivos(), "cosine")));
			this.bcGrafico.getData().add(cosine);

			XYChart.Series<String, Number> levenshtein = new XYChart.Series<String, Number>();
			levenshtein.setName("Levenshtein");
			levenshtein.getData().add(new XYChart.Data<String, Number>("", cm.resultadoMatrix(getArquivos(), "levenshtein")));
			this.bcGrafico2.getData().add(levenshtein);

			XYChart.Series<String, Number> trigram = new XYChart.Series<String, Number>();
			trigram.setName("Trigram");
			trigram.getData().add(new XYChart.Data<String, Number>("", cm.resultadoMatrix(getArquivos(), "trigram")));
			this.bcGrafico.getData().add(trigram);

			XYChart.Series<String, Number> jaro = new XYChart.Series<String, Number>();
			jaro.setName("Jaro-Winkler");
			jaro.getData().add(new XYChart.Data<String, Number>("", cm.resultadoMatrix(getArquivos(), "jaro")));
			this.bcGrafico.getData().add(jaro);
		}
	}

	@FXML
	void voltarHome(ActionEvent event) throws IOException {
		mainApp.telaInicial();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setQuantidadeArquivos(ProntuariosController.getQuantidade());
		setArquivos(ProntuariosController.getArquivos());
		this.exibir = true;

		try {
			exibirGrafico();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
