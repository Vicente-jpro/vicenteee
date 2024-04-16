package vicenteee.beans;

import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import javassist.NotFoundException;
import vicenteee.model.Contacto;
import vicenteee.service.ContactoService;

@ViewScoped
@RequestScoped
@ManagedBean(name = "contactoBean")
public class ContactoBean {

	private ContactoService contactoService;
	private FacesMessage facesMessage;
	
	private List<Contacto> contactos;
	
	public List<Contacto> getContactos(){
		contactoService = new ContactoService();
		this.contactos = contactoService.getContactos();
		return contactos;
		
	}
	
	public String prepararEdicao(Long id) throws NotFoundException {
		contactoService = new ContactoService();
		Contacto contacto = contactoService.getContactoById(id);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
													 .getExternalContext()
													 .getSessionMap();
		sessionMap.put("contacto", contacto);
		return "/faces/editar.xhtml";
	}
	
	
	public String atualizar(Contacto contacto, Long id) throws NotFoundException {
		contactoService = new ContactoService();
		contactoService.atualizar(contacto, id);

		return "/faces/index.xhtml";
	}
	
	public String eliminar(Long id) throws NotFoundException {
		contactoService = new ContactoService();
		contactoService.eliminar(id);
		return "/faces/index.xhtml";
	}
	
	
}
