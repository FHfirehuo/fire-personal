package com.ciecc.fire.personal.domain.sessionfactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ciecc.fire.personal.domain.User;

@Repository
public class UserSessionFactory {

	@Autowired
	SessionFactory sessionFactory;

	public User getByUserName(String userName) {

		return (User) sessionFactory.openSession().createQuery("from User where username = ?").setString(0, userName).list().get(0);
	}

	/*public Customer updateCustomer(long id, String fn, String ln) {
		Query query = sessionFactory.openSession()
				.createQuery("update Customer set firstName=:fName, lastName=:lName where id=:id")
				.setParameter("fName", fn).setParameter("lName", ln).setParameter("id", id);
		query.executeUpdate();
		return null;
	}

	public Customer getCustomerById(long id) {
		return (Customer) sessionFactory.openSession().createQuery("from Customer where id=?").setLong(0, id).list()
				.get(0);
	}

	public Collection<Customer> getAllCustomers() {
		return (Collection<Customer>) sessionFactory.openSession().createQuery("from Customer").list();
	}

	public Customer createCustomer(String fn, String ln) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Customer c = new Customer();
		c.setFirstName(fn);
		c.setLastName(ln);
		session.save(c);
		tx.commit();
		session.close();
		return c;
	}

	public void deleteCustomer(long id) {
		Query query = sessionFactory.openSession().createQuery("delete Customer where id = :id").setParameter("id", id);
		query.executeUpdate();
	}

	public Customer createCustomer(Customer newCustomer) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(newCustomer);
		tx.commit();
		session.close();
		return newCustomer;
	}

	public int getTotalRecords() {
		String hql = "Select count(*) from Customer";
		Query query = sessionFactory.openSession().createQuery(hql);
		return ((Long) query.uniqueResult()).intValue();
	}*/

}
