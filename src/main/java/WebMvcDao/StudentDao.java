package WebMvcDao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import WebMvcEntities.Student;

@Repository
public class StudentDao extends Dao<Student, Long> {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Student").list();
	}

	@Override
	public Student get(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (Student) session.get(Student.class, id);
	}

	@Override
	public Student add(Student t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(t);
		return t;
	}

	@Override
	public Boolean update(Student t) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(t);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}

	@Override
	public Boolean delete(Student t) {
		Session session = this.sessionFactory.getCurrentSession();
		if (null != t) {
			try {
				session.delete(t);
				return Boolean.TRUE;
			} catch (Exception e) {
				return Boolean.FALSE;
			}
		}
		return Boolean.FALSE;
	}

	@Override
	public Boolean delete(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Student student = (Student) session.load(Student.class, id);
		if (null != student) {
			session.delete(student);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

}
