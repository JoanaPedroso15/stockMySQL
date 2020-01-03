package pt.upacademy.stockManagementProjectMysql.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = Shelf.GET_ALL_SHELVES, query = "SELECT s FROM Shelf s") })
public class Shelf extends MyEntity {
	
	private static final long serialVersionUID = 1L;
	public static final String GET_ALL_SHELVES = "getAllShelves";
	
	private int capacidade;
	@ManyToOne
	private Product produto;
	private float dailyPrice;
	


	
public int getCapacidade() {
		return capacidade;
	}

public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

public Product getProduto() {
		return produto;
	}

public void setProduto(Product produto) {
		this.produto = produto;
	}

public float getDailyPrice() {
		return dailyPrice;
	}

public void setDailyPrice(float dailyPrice) {
		this.dailyPrice = dailyPrice;
	}

public static String getName() {
	return "Shelf";
}

@Override
public String toString() {
	return "Shelf [capacidade=" + capacidade + ", produto=" + produto + ", dailyPrice=" + dailyPrice + "]";
}


	
}





