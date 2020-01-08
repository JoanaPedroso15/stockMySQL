package pt.upacademy.stockManagementProjectMysql.models;


public class ShelfDTO extends EntityDTO {

	private static final long serialVersionUID = 1L; 
	
	private int capacidade;
	private Long produtoId;
	private float dailyPrice;
	
	
	
	public ShelfDTO() {
		
	}
	
	public ShelfDTO(int capacidade, float dailyPrice) {
		this.capacidade = capacidade;
		this.dailyPrice = dailyPrice;
	}

	public ShelfDTO(long id, int capacidade, Long produtoId, float dailyPrice) {
		this.id = id;
		this.capacidade = capacidade;
		this.produtoId = produtoId;
		this.dailyPrice = dailyPrice;
	}
	
	
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public Long getProdutoId() {
		return produtoId;
	}
	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}
	public float getDailyPrice() {
		return dailyPrice;
	}
	public void setDailyPrice(float dailyPrice) {
		this.dailyPrice = dailyPrice;
	}
	
	
	
}
