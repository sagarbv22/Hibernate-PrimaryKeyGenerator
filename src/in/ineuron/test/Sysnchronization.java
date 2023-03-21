package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class Sysnchronization {

	public static void main(String[] args) throws IOException {

		Session session = null;
		Integer id = 1;
		try {

			session = HibernateUtil.getSession();
			if (session != null) {

				Employee employee = session.get(Employee.class, id);

				System.out.println(employee);
				System.in.read(); // go and update something in DB
				session.refresh(employee);// this line generate select query again..
				System.out.println(employee);

			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
