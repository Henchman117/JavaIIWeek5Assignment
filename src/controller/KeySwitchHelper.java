package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.KeySwitch;

public class KeySwitchHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JavaIIWeek3Assignment");
	public void insertKey(KeySwitch key) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(key);
		em.getTransaction().commit();
		em.close();
	}
	public List<KeySwitch> showAllKeys(){
		EntityManager em = emfactory.createEntityManager();
		List<KeySwitch> allKeys = em.createQuery("SELECT I FROM KeySwitch i").getResultList();
		return allKeys;
	}
	public void deleteKey(KeySwitch toDelete) {
		EntityManager em = emfactory.createEntityManager(); em.getTransaction().begin();
		TypedQuery<KeySwitch> typedQuery = em.createQuery("select key from KeySwitch key where key.store = :selectedStore and key.item = :selectedItem", KeySwitch.class);
		//Substitute parameter with actual data from the toDelete item 
		typedQuery.setParameter("selectedColor", toDelete.getColor()); 
		typedQuery.setParameter("selectedOperatingForce", toDelete.getOperatingForce());
		typedQuery.setParameter("selectedTactile", toDelete.getTactile());
		//we only want one result 
		typedQuery.setMaxResults(1);
		//get the result and save it into a new list item 
		KeySwitch result = typedQuery.getSingleResult();
		//remove it 
		em.remove(result); 
		em.getTransaction().commit(); 
		em.close();
	}
	public KeySwitch searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin();
		KeySwitch found = em.find(KeySwitch.class, idToEdit); 
		em.close();
		return found;
	}
	public void updateItem(KeySwitch toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin();
		em.merge(toEdit); 
		em.getTransaction().commit(); 
		em.close();
	}
	public List<KeySwitch> searchForColor(String color) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin();
		TypedQuery<KeySwitch> typedQuery = em.createQuery("select li from KeySwitch li where li.item = :selectedStore", KeySwitch.class); 
		typedQuery.setParameter("selectedStore", color);
		List<KeySwitch> foundItems = typedQuery.getResultList(); em.close();
		return foundItems;
	}
	public List<KeySwitch> searchForOperatingForce(int operatingForce) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager(); em.getTransaction().begin();
		TypedQuery<KeySwitch> typedQuery = em.createQuery("select li from KeySwitch li where li.item = :selectedItem", KeySwitch.class); 
		typedQuery.setParameter("selectedItem", operatingForce);
		List<KeySwitch> foundItems = typedQuery.getResultList(); em.close();
		return foundItems;
	}
	public List<KeySwitch> searchForTactile(boolean tactile) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager(); em.getTransaction().begin();
		TypedQuery<KeySwitch> typedQuery = em.createQuery("select li from KeySwitch li where li.item = :selectedItem", KeySwitch.class); 
		typedQuery.setParameter("selectedItem", tactile);
		List<KeySwitch> foundItems = typedQuery.getResultList(); em.close();
		return foundItems;
	}
}
