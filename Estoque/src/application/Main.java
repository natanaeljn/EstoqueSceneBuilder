package application;
	
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Servicos.addRemover;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application implements Initializable {
	private static Scene SceneEstoque;
	private static Stage primaryStage;
	private static Stage stage;
	private static Scene TelaAdd;
	private static Scene telaRemover;
	
	@Override
	public void start(Stage stage) {
		try {
			FXMLLoader estoqueImg = new FXMLLoader(getClass().getResource("/Gui/Estoquee.fxml"));
			primaryStage = stage;
			primaryStage.setTitle("Sibratec") ;
			Parent parentEstoque = estoqueImg.load();
			SceneEstoque = new Scene(parentEstoque, 680 , 400);
			
			Parent telaAdd = FXMLLoader.load(getClass().getResource("/Gui/TelaAdicionar.fxml"));
			TelaAdd = new Scene(telaAdd, 680 , 400) ; 
			Parent telaRemove = FXMLLoader.load(getClass().getResource("/Gui/RemoverEst.fxml"));
			telaRemover = new Scene(telaRemove, 341 , 329) ; 
			
			Parent parent = FXMLLoader.load(getClass().getResource("/Gui/EstoqueScene.fxml"));
	    		Scene scene = new Scene(parent);
	    		primaryStage  = stage;
	        	primaryStage.setScene(scene);
	        	stage.show();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	//Metodo para a troca de telas pelo SceneBuilder
	public static void trocar(int opcao) {
		switch(opcao) {
		case 1 :
			primaryStage.setScene(SceneEstoque);
			
		     break;
		case 2 :
			primaryStage.setScene(TelaAdd);
			
	        break;
		case 3 :
			primaryStage.setScene(telaRemover);
		break;
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
		
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}