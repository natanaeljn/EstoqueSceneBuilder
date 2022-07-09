package Gui;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Gui.alerta.Alerta;
import application.Main;
import entidades.EstoqueClasse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.exceçõesEstoque.elementoNulo;

public class adicionarEstController implements Initializable {

	@FXML
	private TextField nomee = null;
	@FXML
	private TextField quantidadee;
	@FXML
	private TextField valorr;
	@FXML
	private TextField idd;
	@FXML
	private Button conf;
	@FXML
	private Button canc;

	public static List<EstoqueClasse> lis = new ArrayList<EstoqueClasse>();

	public estoqueControle estoqueControle;
	public EstoqueClasse estoqueClasse;

	public void onBtConf() throws IOException {
		try {
			String nome = nomee.getText();
			Integer quant = Integer.parseInt(quantidadee.getText());
			Double valor = Double.parseDouble(valorr.getText());
			Integer id = Integer.parseInt(idd.getText());
			if (nome == " ") {
				throw new elementoNulo("elemento esta vazio");
			}

			EstoqueClasse est = new EstoqueClasse(nome, quant, valor, id);
			estoqueControle.obsVeri(id);
			if (estoqueControle.obsVeri(id) == true) {
				estoqueControle.obsId(est.toString());
				estoqueControle.obs.add(est);
			} else {
				Alerta.showAlert("erro", "erro de ID", "ID JA EXISTENTE", AlertType.ERROR);
			}

		} catch (elementoNulo e) {
			Alerta.showAlert("erro", "erro", e.getMessage(), AlertType.ERROR);
		} catch (NullPointerException f) {
			Alerta.showAlert("erro", "null", f.getMessage(), AlertType.ERROR);
		} catch (NumberFormatException g) {
			Alerta.showAlert("erro", "elemento vazio", g.getMessage(), AlertType.ERROR);
		}
	}

	public void obBtCanc(ActionEvent event) {
		Main.trocar(1);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		estoqueControle.obs.getClass();
	}
}
