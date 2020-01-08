package pt.upacademy.stockManagementProjectMysql.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQueries({
	@NamedQuery(name = Product.GET_ALL_PRODUCTS, query = "SELECT p FROM Product p"),
	@NamedQuery(name = Product.GET_ALL_PRODUCTS_IDS, query = "SELECT p.ID FROM Product p"),
	@NamedQuery(name = Product.GET_PRODUCTS_COUNT, query = "SELECT COUNT(p.ID) FROM Product p")})

public class Product extends MyEntity<ProductDTO> implements Serializable {

	public static final String GET_ALL_PRODUCTS = "getAllProducts";
	public static final String GET_ALL_PRODUCTS_IDS = "getAllProductsIds";
	public static final String GET_PRODUCTS_COUNT = "getProductsCount";
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "produto", fetch = FetchType.EAGER)
	private List<Shelf> shelves;
	private int discount;
	private int iva;
	private float pvp;
	
	

	public Product(List<Shelf> shelves, int discount, int iva, float pvp) {
		
		this.shelves = shelves;
		this.discount = discount;
		this.iva = iva;
		this.pvp = pvp;
	}
	
	

	public Product() {
	
	}


	public List<Shelf> getShelvesIds() {
		return shelves;
	}

	public void setShelvesIds(List<Shelf> shelvesIds) {
		this.shelves = shelvesIds;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public float getPvp() {
		return pvp;
	}

	public void setPvp(float pvp) {
		this.pvp = pvp;
	}
	
	public ProductDTO toDTO() {
		ProductDTO p = new ProductDTO (
				this.getID(),
				this.getShelvesIds().stream().map(Shelf::getID).collect(Collectors.toList()),
				this.getDiscount(),
				this.getIva(),
				this.getPvp()
				);
		return p;
	}

	@Override
	public String toString() {
		return "Product [shelvesØ=" + shelves + ", discount=" + discount + ", iva=" + iva + ", pvp=" + pvp + "]";
	}

	public static String getName() {
		return "Product";
	}

}
