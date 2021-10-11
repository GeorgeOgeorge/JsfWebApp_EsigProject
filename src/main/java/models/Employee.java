package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "employee")
@Entity
public class Employee {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "age", nullable = false)
    private Short age;

    @Column(name = "gender", nullable = false, length = 20)
    private String gender;

    @Column(name = "active_status", nullable = false)
    private Boolean activeStatus = true;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "employee_occupations",
            joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "occupations_id", referencedColumnName = "id"))
    private List<Occupation> occupations;

}