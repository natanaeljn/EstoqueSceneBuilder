package Gui;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Gui.alerta.Alerta;
import application.Main;
import entidades.EstoqueClasse;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.exceçõesEstoque.elementoNulo;

public class RemoverControler implements Initializable {

	public estoqueControle estoqueControle;
	public EstoqueClasse estoqueClasse;

	@FXML
	private TextField escolhaId;

	@FXML
	private Button confir;
	@FXML
	private Button cancelar;

	public void onBtConfir() throws IOException {
		try {
			if (escolhaId.getText() == " ") {
				throw new elementoNulo("elemento esta nulo");
			}

			Integer id = Integer.parseInt(escolhaId.getText());

			estoqueControle.removerObs(id);
			estoqueControle.excluirArqu();
			estoqueControle.criarArqu();
			for (int i = 0; i < estoqueControle.obs.size(); i++) {
				String nome = estoqueControle.obs.get(i).getNome();
				int quant = estoqueControle.obs.get(i).getQuantidade();
				double val = estoqueControle.obs.get(i).getValor();
				int idd = estoqueControle.obs.get(i).getId();
				estoqueControle.obsId(nome + "," + quant + "," + val + "," + idd);
			}

		} catch (elementoNulo e) {
			Alerta.showAlert("erro de elemento vazio", null, e.getMessage(), AlertType.ERROR);
		} catch (NumberFormatException f) {
			Alerta.showAlert("Error", null, "digite um valor no campo", AlertType.ERROR);
		}
	}
    //Volta para tela inicial
	public void onBtCancer() {
		Main.trocar(1);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		estoqueControle.obs.getClass();

	}

}
