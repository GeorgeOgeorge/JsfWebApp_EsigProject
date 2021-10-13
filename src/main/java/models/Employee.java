package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "employee")
@Entity
public class Employee {

    @Min(0)
    @NotNull
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(min = 3, max = 50)
    @NotNull
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Max(100)
    @Min(18)
    @NotNull
    @Column(name = "age", nullable = false)
    private Short age;

    @Size(min = 4, max = 20)
    @NotNull
    @Column(name = "gender", nullable = false, length = 20)
    private String gender;

    @NotNull
    @Column(name = "active_status", nullable = false)
    private Boolean activeStatus = true;

    @NotNull
    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "employee_occupations",
            joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "occupations_id", referencedColumnName = "id"))
    private List<Occupation> occupations;

}