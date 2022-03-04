package main.java.controller;

import java.util.List;

import javax.persistence.*;

import main.java.model.Creator;

public class CreatorHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JavaIIWeek3Assignment");
	
	public void insertCreator(Creator c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Creator> showAllCreators() {
		EntityManager em = emfactory.createEntityManager();
		List<Creator> allCreators = em.createQuery("SELECT c FROM Creator c").getResultList();
		return allCreators;
	}
}
