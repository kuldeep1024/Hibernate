import org.hibernate.Session;

import com.test.model.Student;
import com.test.util.HibernateUtil;

public class TestGetVsLoad {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
/*
		System.out.println("********GET********");
		Student std=(Student) session.get(Student.class, 1l);
		System.out.println("Get called");
		System.out.println(std.getId());
		System.out.println(std.getName());

		
		Student std2=(Student) session.get(Student.class, 112313l);
		System.out.println(std2.getId());
		System.out.println(std2.getName());
		*/
		
		System.out.println("********LOAD********");
		Student std5=(Student) session.load(Student.class, new Long(1));
		System.out.println("Load called");
		System.out.println(std5.getId());
		//System.out.println(std5.getName());

		/*
		Student std6=(Student) session.load(Student.class, 10l);
		System.out.println(std6.getId());
		System.out.println(std6.getName());

		
		*/
		
		HibernateUtil.shutdown();
		

		
	}
	

}
