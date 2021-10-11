package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "task")
@Entity
public class Task {

	@Id
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Column(name = "dead_line", nullable = false)
	private LocalDate deadLine;

	@Column(name = "priority", nullable = false, length = 100)
	private String priority;

	@Column(name = "active_status", nullable = false)
	private Boolean activeStatus = true;

	@Column(name = "description", nullable = false, length = 256)
	private String description;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "task_employees", joinColumns = @JoinColumn(name = "task_id"), inverseJoinColumns = @JoinColumn(name = "employees_id"))
	private List<Employee> employees;

}