package pt.upacademy.stockManagementProjectMysql.models;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class MyEntity implements Serializable {
	private static final long serialVersionUID = 1L; //L significa que e conversao para Long
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	public MyEntity() { //podemos deixar ter o construtor vazio
	}


	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	@Override
	public String toString() {
		return "Entity [ID=" + ID + "]";
	}
	

}
