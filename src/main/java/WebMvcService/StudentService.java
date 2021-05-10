package WebMvcService;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebMvcDao.StudentDao;
import WebMvcEntities.Student;

@Transactional
@Service
public class StudentService {
	public StudentService() {
		super();
	}

	@Autowired
	private StudentDao studentDao;

	public List<Student> getAll() {
		return studentDao.getAll();
	}

	public Student get(Long id) {
		return studentDao.get(id);
	}

	public Student add(Student student) {
		return studentDao.add(student);
	}

	public Boolean update(Student student) {
		return studentDao.update(student);
	}

	public Boolean delete(Student student) {
		return studentDao.delete(student);
	}

	public Boolean delete(Long id) {
		return studentDao.delete(id);
	}
}
