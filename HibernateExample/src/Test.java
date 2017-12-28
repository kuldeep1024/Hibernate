import org.hibernate.Session;

import com.test.model.Student;
import com.test.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Student s = getStudent();
		
		session.save(s);
	
		//will update into database
		s.setName("Kunwar");
		
		
		//will automatically update set** into database
		Student std=(Student) session.get(Student.class, 1l);
		std.setAge(1008);
	
		session.getTransaction().commit();
		std.setName("Kunwar11");
		
		HibernateUtil.shutdown();
		
		s.setName("Kunwar 0000");
		
	}
	
	public static Student getStudent(){
		Student s =new Student();
		s.setName("kuldeep 9090");
		s.setAge(20);
		s.setAddress("Noida");
		return s;
	}

}
