package vicenteee.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javassist.NotFoundException;
import vicenteee.model.Contacto;
import vicenteee.service.ContactoService;

@ManagedBean(name = "contactoBean")
@RequestScoped
public class ContactoBean {

	private ContactoService contactoService;
	
	public List<Contacto> getContactos(){
		contactoService = new ContactoService();
		return contactoService.getContactos();
		
	}
	
	public void atualizar(Contacto contacto, Long id) throws NotFoundException {
		contactoService = new ContactoService();
		contactoService.atualizar(contacto, id);
	}
	
	
	
}
