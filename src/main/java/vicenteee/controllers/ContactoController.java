package vicenteee.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;

import vicenteee.model.Contacto;
import vicenteee.service.ContactoService;

@RequestScoped
@ManagedBean("contactoController")
public class ContactoController {

	private ContactoService contactoService;
	
	public List<Contacto> getContactos(){
		contactoService = new ContactoService();
		return contactoService.getContactos();
		
	}
}
