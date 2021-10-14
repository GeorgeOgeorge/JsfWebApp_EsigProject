package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "task")
@Entity
public class Task {

    @Min(0)
    @NotNull
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(min = 3, max = 50)
    @NotNull
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Future
    @NotNull
    @Column(name = "dead_line", nullable = false)
    private LocalDate deadLine;

    @Size(min = 3, max = 6)
    @NotNull
    @Column(name = "priority", nullable = false, length = 6)
    private String priority;

    @NotNull
    @Column(name = "active_status", nullable = false)
    private Boolean activeStatus = true;

    @Size(min = 5, max = 256)
    @NotNull
    @Column(name = "description", nullable = false, length = 256)
    private String description;

    @NotNull
    @Fetch(FetchMode.JOIN)
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "task_employees",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "employees_id"))
    private List<Employee> employees;

}