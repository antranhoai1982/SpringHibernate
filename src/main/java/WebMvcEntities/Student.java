package WebMvcEntities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "student", catalog = "website")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String firstName;
	private String lastName;
	private Integer age;
	private Address address;
	private List<Course> courses;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STUDENT_ID", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "FIRST_NAME", length = 20)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LAST_NAME", length = 20)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "AGE")
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "STUDENT_COURSE", joinColumns = { @JoinColumn(name = "STUDENT_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "COURSE_ID") })
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}
