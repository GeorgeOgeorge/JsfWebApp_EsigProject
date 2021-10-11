package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "occupation")
@Entity
public class Occupation {

	@Id
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "name", nullable = false, length = 30)
	private String name;

	@Column(name = "active_status", nullable = false)
	private Boolean activeStatus = true;

	public Occupation(String name) {
		this.name = name;
	}



}