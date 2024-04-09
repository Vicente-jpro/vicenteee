package vicenteee.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Entity;

import lombok.Data;

@Data
@Entity
@Table( name = "contactos")
public class Contacto {
	
	@Id
	@Column(name = "id")
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column( name = "email")
	private String email;
	
	@Column( name = "favorito")
	private String favorito;
	
	@Column( name = "name")
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataRegistro; 

}
