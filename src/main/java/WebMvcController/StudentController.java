package WebMvcController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import WebMvcEntities.Student;
import WebMvcService.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/students", method = RequestMethod.GET, headers = "Accept=application/json")
	public ModelAndView getStudents(ModelAndView model) {
		model.setViewName("students");
		List<Student> list = studentService.getAll();
		list.forEach(e -> {
			System.out.println(e.getFirstName());
		});
		model.addObject("abc",list);
		return model;
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.GET)
	public ModelAndView addStudent(ModelAndView model) {
		model.setViewName("studentDetail");
		model.addObject("student", new Student());
		return model;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("student") Student student) {
		if (student.getId() == null) {
			studentService.add(student);
		} else {
			studentService.update(student);
		}
		return "redirect:/views/student/";
	}

	@RequestMapping(value = "/getStudent", method = RequestMethod.GET)
	public ModelAndView getStudent(@RequestParam("id") Long id, @RequestParam("mode") String mode, ModelAndView model) {
		model.setViewName("studentDetail");
		model.addObject("student", studentService.get(id));
		model.addObject("mode", mode);
		return model;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		studentService.delete(id);
	}
}
