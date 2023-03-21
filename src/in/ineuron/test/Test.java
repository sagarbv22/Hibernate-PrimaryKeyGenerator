package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		Integer row = 0;

		try {

			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {

				Employee employee = new Employee();
				employee.setEid(10);
				employee.setEname("Vijayakumar");
				employee.setEcompany("Agr");
				employee.setEcity("Blr");

				row = (Integer) session.save(employee);
				flag = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object inserted successfully");
			} else {
				transaction.rollback();
				System.out.println("Object insertion failed!..");
			}

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
