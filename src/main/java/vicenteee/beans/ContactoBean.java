package vicenteee.beans;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

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
	
	public String prepararEdicao(Long id) throws NotFoundException {
		contactoService = new ContactoService();
		Contacto contacto = contactoService.getContactoById(id);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
													 .getExternalContext()
													 .getSessionMap();
		sessionMap.
		return "faces/editar.xhtml";
	}
	
	
	public void atualizar(Contacto contacto, Long id) throws NotFoundException {
		contactoService = new ContactoService();
		contactoService.atualizar(contacto, id);
		System.out.println("########### "+id);
	}
	
	
	
}
