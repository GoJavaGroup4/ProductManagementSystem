package ua.goit.java.dao;

import java.io.Serializable;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BasicDao<PK extends Serializable, T> {
     
	private final Class<T> persistentClass;
    
    @SuppressWarnings("unchecked")
    public BasicDao() {
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
     
    @Autowired 
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
    	return (T) getSession().get(persistentClass, key);
    }
 
    public void save(T entity) {
    	getSession().persist(entity);
    }
    
    public void delete(T entity) {
    	getSession().delete(entity);
    }
    
    public T get(String propertyName, Object value) {
    	return (T) getSession().createQuery("from " + persistentClass.getName() + " as model where model." + propertyName + " = ?").setParameter(0, value).getSingleResult(); 
	}
    
    public List<T> list() {
    	return getSession().createQuery("from " + persistentClass.getName()).getResultList();
	}
	
	public List<T> getList(String propertyName, Object value) {
		return getSession().createQuery("from " + persistentClass.getName() + " as model where model." + propertyName + " = ?").setParameter(0, value).getResultList();
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