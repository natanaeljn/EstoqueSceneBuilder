package Gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GeralController implements Initializable {
	estoqueControle estoquer;
	@FXML
	private MenuItem verificar;
	@FXML
	private MenuItem verificarVendedor;
	@FXML
	private MenuItem verificarEncarregados;

	//Troca tela
	@FXML
	protected void onBtNew(ActionEvent event) {
		Main.trocar(1);

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

}
