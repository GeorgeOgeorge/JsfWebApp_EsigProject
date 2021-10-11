package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "project")
@Entity
public class Project {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 50)
    private String name;

    @Column(name = "dead_line", nullable = false)
    private LocalDate deadLine;

    @Column(name = "active_status", nullable = false)
    private Boolean activeStatus = true;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "project_tasks",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "tasks_id"))
    private List<Task> tasks;

}