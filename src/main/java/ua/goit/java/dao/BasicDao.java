package ua.goit.java.dao;

import java.io.Serializable;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public abstract class BasicDao<PK extends Serializable, T> {
     
    private final Class<T> persistentClass;
     
    @SuppressWarnings("unchecked")
    public BasicDao() {
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
     
    private SessionFactory sessionFactory;
 
    protected Session getSession() {
    	Session session=sessionFactory.getCurrentSession();
    	if (session == null) {
			session = sessionFactory.openSession();
		}
    	
        return session;
    }
 
    public void setSession(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	    
    public T getById(PK key) {
    	Transaction	tx = getSession().beginTransaction();
    	T entity = (T) getSession().get(persistentClass, key);
    	tx.commit();
        return entity; 
    }
 
    public void save(T entity) {
    	Transaction	tx = getSession().beginTransaction();
        getSession().persist(entity);
        tx.commit();
    }
    
    public void delete(T entity) {
    	Transaction	tx = getSession().beginTransaction();
        getSession().delete(entity);
        tx.commit();
    }
    
    public T get(String propertyName, Object value) {
    	Transaction	tx = getSession().beginTransaction();
    	T entity = (T) getSession().createQuery("from " + persistentClass.getName() + " as model where model." + propertyName + " = ?").setParameter(0, value).getSingleResult();
    	tx.commit();
        return entity; 
	}
    
    public List<T> list() {
        //return createEntityCriteria().list();
    	Transaction	tx = getSession().beginTransaction();
    	List<T> list = getSession().createQuery("from " + persistentClass.getName()).getResultList();
    	tx.commit();
    	return list;
	}
	
	public List<T> getList(String propertyName, Object value) {
		Transaction	tx = getSession().beginTransaction();
		List<T> list = getSession().createQuery("from " + persistentClass.getName() + " as model where model." + propertyName + " = ?").setParameter(0, value).getResultList();
		tx.commit();
        return list;
	}   
	   
    public void flush() {  
        getSession().flush();  
    }  
  
    public void clear() {  
        getSession().clear();
    }  
 
    public void removeALL() {
        getSession().createQuery(" delete from " +persistentClass).executeUpdate();
    }

}