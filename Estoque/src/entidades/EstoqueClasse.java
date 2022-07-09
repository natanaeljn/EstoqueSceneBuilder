package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EstoqueClasse {

	public String nome;
	public Integer quantidade;
	public Double valor;
	public Integer id;

	public EstoqueClasse() {

	}

	public EstoqueClasse(String nome, int quantidade, double valor, int id) {
		super();
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = valor;
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;

	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;

	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, quantidade, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstoqueClasse other = (EstoqueClasse) obj;
		return id == other.id && Objects.equals(nome, other.nome) && quantidade == other.quantidade
				&& Double.doubleToLongBits(valor) == Double.doubleToLongBits(other.valor);
	}

	@Override
	public String toString() {
		return nome + "," + quantidade + "," + valor + "," + id;
	}

}