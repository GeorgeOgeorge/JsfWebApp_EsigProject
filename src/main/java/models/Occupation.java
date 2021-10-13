package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "occupation")
@Entity
public class Occupation {

	@Min(0)
	@NotNull
	@Id
	@Column(name = "id", nullable = false)
	private Long id;

	@Size(min = 3 , max = 30)
	@NotNull
	@Column(name = "name", nullable = false, length = 30)
	private String name;

	@NotNull
	@Column(name = "active_status", nullable = false)
	private Boolean activeStatus = true;

	public Occupation(String name) {
		this.name = name;
	}



}