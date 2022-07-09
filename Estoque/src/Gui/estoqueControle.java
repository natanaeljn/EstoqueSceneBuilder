package Gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class estoqueControle implements Initializable {

	@FXML
	public TableView<EstoqueClasse> tableViewProduto;
	@FXML
	private TableColumn<EstoqueClasse, String> tableColumnNome;
	@FXML
	private TableColumn<EstoqueClasse, Integer> tableColumnQuantidade;
	@FXML
	private TableColumn<EstoqueClasse, Double> tableColumnValor;
	@FXML
	private TableColumn<EstoqueClasse, Integer> tableColumnId;
	@FXML
	private Button adicionar;
	@FXML
	private Button remover;
	@FXML
	private Button att;

	public adicionarEstController adicionarEstController;

	//Diretorio do arquivo onde foi salvo as informaçoes do sistema, Ja que o mesmo nao possue banco de dados;
	public static String patch = "C:\\Users\\T-Gamer\\Documents\\projetoEstoque\\projeto.txt";
	public static boolean add;

	EstoqueClasse estoqueClasse = new EstoqueClasse();

	public static List<EstoqueClasse> listas = new ArrayList<EstoqueClasse>();
	//Lista de Produtos com quantidade abaixo de Vinte para o sistema alertar;
	public static List<String> listaMenores = new ArrayList<String>();

	//Obs para Iniciar nas colunas
	public static ObservableList<EstoqueClasse> obs = FXCollections.observableArrayList();

	//Metodo que Busca pelo arquivo os Produtos e coloca na ObservableList
	public static void addObs() throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(patch))) {
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				String nome = fields[0];
				Integer quant = Integer.parseInt(fields[1]);
				Double valor = Double.parseDouble(fields[2]);
				Integer id = Integer.parseInt(fields[3]);
				obs.add(new EstoqueClasse(nome, quant, valor, id));
				listas.add(new EstoqueClasse(nome, quant, valor, id));
				for (EstoqueClasse x : obs) {
					System.out.println(x);
				}
				line = br.readLine();
			}
		}
	}

	//Metodo para sobreescrever o arquivo inteiro 
	public static void ReescreverTxt(String algo) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(patch))) {
			bw.write(algo);
			bw.newLine();
		}
	}

	//Metodo para sobreescrever o arquivo sem perder dados do anterior
	public static void obsId(String algo) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(patch, true))) {
			bw.write(algo);
			bw.newLine();
		}
	}

	//Metodo para verificar se o Id ja existe na Obs
	public static boolean obsVeri(Integer ID) {
		boolean veri = true;
		for (int i = 0; i < obs.size(); i++) {
			if (obs.get(i).getId() != ID) {
				veri = true;
			} else {
				veri = false;
			}
		}
		return veri;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		try {
			addObs();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listaMenoresQuant();
		if (listaMenores.size() > 0) {
			Alerta.showAlert("Produtos Acabando", null, listaMenores.toString(), AlertType.INFORMATION);
		}

		tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tableColumnQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
		tableColumnValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));

		tableViewProduto.setItems(obs);

	}

	//Troca tela
	public void onBtAdd(ActionEvent event) {

		Main.trocar(2);

	}

	//Troca tela
	public void onBtRemover() {
		Main.trocar(3);

	}

	//Metodo para excluir o arquivo 
	public static void excluirArqu() {
		File file = new File(patch);
		file.delete();
	}

	//Metodo para criar um novo arquivo
	public static void criarArqu() throws IOException {
		File f = new File(patch);
		f.createNewFile();

	}

	//Metodo para listar os produtos que tem quantidade abaixo de 20 
	public static void listaMenoresQuant() {
		for (int i = 0; i < obs.size(); i++) {
			if (obs.get(i).getQuantidade() < 20) {
				listaMenores.add(obs.get(i).getNome());
			}
		}
	}

	//Metodo que mostra os nomes  dos produtos com quantidade menor que 20
	public void listarMenores() {

		for (String x : listaMenores) {
			System.out.println(x);

		}

	}

	//Metodo para remover um produto pelo ID desejado
	public static void removerObs(Integer ID) {
		for (int i = 0; i < obs.size(); i++) {
			if (ID == obs.get(i).getId()) {
				obs.remove(i);
			}

		}
	}

}
