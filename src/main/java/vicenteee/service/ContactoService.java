package vicenteee.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import vicenteee.model.Contacto;
import vicenteee.utils.JPAUtil;

public class ContactoService {
	
	private EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	
	public void salvar(Contacto contacto) {
		entityManager.getTransaction().begin();
		entityManager.persist(contacto);
		entityManager.getTransaction().commit();
		JPAUtil.shutdown();	
	}
	
	public void atualizar(Contacto contacto, Long id) {
		entityManager.getTransaction().begin();
		entityManager.merge(contacto);
		entityManager.getTransaction().commit();
		JPAUtil.shutdown();	
	}
	
	public Contacto getContactoById(Long id) {
		Contacto contacto = new Contacto();
		contacto = entityManager.find(Contacto.class, id);
		JPAUtil.shutdown();	
	    return contacto;
	}
	
	public List<Contacto> getContactos() {
		List<Contacto> contactos = new ArrayList<Contacto>();
		Query query = entityManager.createQuery("SELECT * FROM contactos");
		
		contactos = query.getResultList();
		JPAUtil.shutdown();	
	    return contactos;
	}

}
