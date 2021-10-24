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

import static javax.persistence.GenerationType.SEQUENCE;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "project")
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Size(min = 3, max = 50)
    @NotNull
    @Column(name = "name", nullable = false, unique = true, length = 50)
    private String name;

    @Future
    @NotNull
    @Column(name = "dead_line", nullable = false)
    private LocalDate deadLine;

    @NotNull
    @Column(name = "active_status", nullable = false)
    private Boolean activeStatus = true;

    @NotNull
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name = "project_tasks",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "tasks_id"))
    private List<Task> tasks;

}