package vicenteee.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import javassist.NotFoundException;
import vicenteee.model.Contacto;
import vicenteee.utils.JPAUtil;

public class ContactoService {
	
	private EntityManager entityManager;
	
	public ContactoService() {
		entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
	}
	public void salvar(Contacto contacto) {
		entityManager.getTransaction().begin();
		entityManager.persist(contacto);
		entityManager.getTransaction().commit();
		JPAUtil.close();	
	}
	
	public void atualizar(Contacto contacto, Long id) throws NotFoundException{
		Contacto cont = getContactoById(id);
		contacto.setId(id);
		
		entityManager.getTransaction().begin();
		entityManager.merge(contacto);
		entityManager.getTransaction().commit();
	}
	
	public Contacto getContactoById(Long id) throws NotFoundException{
		Contacto contacto = new Contacto();
		contacto = entityManager.find(Contacto.class, id);
		if (contacto == null) {
			System.out.println("Contacto não foi encontrado: +"+id);
			throw new NotFoundException("Contacto não foi encontrado: +"+id);
		}
	    return contacto;
	}
	
	
	public void eliminar(Long id) throws NotFoundException {
		Contacto contacto = getContactoById(id);
		
		entityManager.getTransaction().begin();
		entityManager.remove(contacto);
		entityManager.getTransaction().commit();
		
	}
	public List<Contacto> getContactos() {
		List<Contacto> contactos = new ArrayList<Contacto>();
		Query query = entityManager.createQuery("SELECT c FROM contactos c ORDER BY c.id");
		contactos = query.getResultList();
	    return contactos;
	}

}
