package vicenteee.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import vicenteee.model.Contacto;
import vicenteee.service.ContactoService;

@RequestScoped
@ManagedBean(name = "contactoController")
public class ContactoController {

	private ContactoService contactoService;
	
	public List<Contacto> getContactos(){
		contactoService = new ContactoService();
		return contactoService.getContactos();
		
	}
}
