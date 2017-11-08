package br.com.biblioteca.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DAO<T> {

	private Session session;
	
	public DAO(){
		
	}
	
	public T save(T entity){
		Session sessao = getSession();
		try{
			Transaction t = sessao.beginTransaction();
			sessao.save(entity);
			if(!t.wasCommitted()){
				sessao.getTransaction().commit();
			}
			sessao.close();
			return entity;
			
		}catch(Exception e){
			sessao.getTransaction().rollback();
			sessao.close();
			return null;
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	public List findAll(Class entity){
		Session sessao = getSession();
		try{
			Transaction t = sessao.beginTransaction();
			Query query = sessao.createQuery("Select t from "+entity.getSimpleName()+" t");
			List list = query.list();
			if(!t.wasCommitted()){
				sessao.getTransaction().commit();
			}
			sessao.close();
			if(list== null){
				return new ArrayList<>();
			}
			return list;
			
		}catch(Exception e){
			sessao.getTransaction().rollback();
			sessao.close();
			return null;
		}
		
	}
	
	public T update(T entity){
		try{
			getSession().beginTransaction();
			getSession().merge(entity);
			getSession().getTransaction().commit();
			getSession().close();
			return entity;
			
		}catch(Exception e){
			getSession().getTransaction().rollback();
			getSession().close();
			return null;
		}
		
	}
	public void delete(T entity){
		try{
			getSession().beginTransaction();
			getSession().delete(entity);
			getSession().getTransaction().commit();
			
		}catch(Exception e){
			getSession().getTransaction().rollback();
		}finally{
			getSession().close();
		}
		
	}
	
	private Session getSession(){
		if(session == null || !session.isOpen()){ 
			session = HibernateUtil.getSessioFactory().openSession();
		}
		return session;
	}
}
