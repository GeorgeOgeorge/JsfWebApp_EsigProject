package bean;

import dao.GenericDao;
import lombok.Data;
import models.Employee;
import models.Task;
import org.primefaces.PrimeFaces;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Named
@ViewScoped
public class TaskBean implements Serializable {

    private GenericDao<Employee, Long> employeeDao;
    private GenericDao<Task, Long> taskDao;
    private Task task;
    private List<Task> activeTaskList;
    private List<Task> selectedTaskList;
    private List<Employee> activeEmployeeList;
    private List<Integer> invalidDays = Arrays.asList(0, 6);

    @PostConstruct
    public void init() {
        this.employeeDao = new GenericDao<>(Employee.class, Long.class);
        this.taskDao = new GenericDao<>(Task.class, Long.class);
        this.refreshData();
    }

    public void saveTask() {
        if (this.task.getId() == null) {
            this.taskDao.save(this.task);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Task Added"));
        } else {
            this.taskDao.save(this.task);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Task Updated"));
        }
        PrimeFaces.current().executeScript("PF('TaskDialog').hide()");
        this.refreshData();
    }

    public void softRemove() {
        if (this.getHasTaskSelected())
            this.selectedTaskList.forEach(this::setInactive);
        else
            this.setInactive(this.task);
        this.refreshData();
        this.getDeleteButtonMessage();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Task(s) now inactive"));
    }

    public String getDeleteButtonMessage() {
        if (this.getHasTaskSelected())
            return this.selectedTaskList.size() + " tasks selected ";
        else
            return "delete";
    }

    public Boolean getHasTaskSelected() {
        return !this.selectedTaskList.isEmpty();
    }

    private void refreshData() {
        this.task = new Task();
        this.selectedTaskList = List.of();
        this.activeEmployeeList = this.employeeDao.list().stream()
                .filter(e -> e.getActiveStatus())
                .collect(Collectors.toList());
        this.activeTaskList = this.taskDao.list().stream()
                .filter(t -> t.getActiveStatus())
                .collect(Collectors.toList());
    }

    private void setInactive(Task task) {
        task.setActiveStatus(false);
        this.taskDao.save(task);
    }

}
