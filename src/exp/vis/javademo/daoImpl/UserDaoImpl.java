package exp.vis.javademo.daoImpl;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import exp.vis.javademo.dao.UserDao;
import exp.vis.javademo.persistence.User;

/**
 * JavaSpringDemo - exp.vis.javademo.dao.impl
 *
 * @author Viswanath L
 *
 * Jan 10, 2015
 */

@Repository
@Component(value="userDao")
public class UserDaoImpl extends HibernateDaoSupport implements UserDao, UserDetailsService {

	public UserDaoImpl() {
	}

	@Autowired
	public UserDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = null;
		String queryString = "from User user where user.username = :username";
		try {
			Session session = this.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createQuery(queryString);
			query.setString("username", username);
			user = (User) query.uniqueResult();
			transaction.commit();
			session.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}

