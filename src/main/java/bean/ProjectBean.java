package bean;

import dao.ProjectDao;
import dao.TaskDao;
import lombok.Data;
import models.Project;
import models.Task;
import org.primefaces.PrimeFaces;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Named
@ViewScoped
public class ProjectBean implements Serializable {

    private TaskDao taskDao;
    private ProjectDao projectDao;
    private Project project;
    private List<Project> activeProjectList;
    private List<Project> selectedProjectList;
    private List<Task> activeTaskList;

    @PostConstruct
    public void init() {
        this.projectDao = new ProjectDao();
        this.taskDao = new TaskDao();
        this.refreshData();
    }

    public void saveProject() {
        this.project.getTasks().forEach(task -> {
            task.setAssigned(true);
            this.taskDao.update(task);
        });
        if (this.project.getId() == null) {
            this.projectDao.insert(this.project);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Project Added"));
        } else {
            this.projectDao.update(this.project);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Project Updated"));
        }
        PrimeFaces.current().executeScript("PF('ProjectDialog').hide()");
        this.refreshData();
    }

    public void softRemove() {
        if (this.getHasProjectSelect())
            this.selectedProjectList.forEach(p -> this.setInactive(p));
        else
            this.setInactive(this.project);
        this.refreshData();
        this.getDeleteButtonMessage();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Projects(s) now inactive"));
    }

    public String getDeleteButtonMessage() {
        if (this.getHasProjectSelect())
            return this.selectedProjectList.size() + " projects selected ";
        else
            return "delete";
    }

    public Boolean getHasProjectSelect() {
        return !this.selectedProjectList.isEmpty();
    }

    private void refreshData() {
        this.project = new Project();
        this.selectedProjectList = List.of();
        this.activeProjectList = this.projectDao.list().stream()
                .filter(p -> p.getActiveStatus())
                .collect(Collectors.toList());
        this.activeTaskList = this.taskDao.list().stream()
                .filter(t -> t.getActiveStatus() && !t.getAssigned())
                .collect(Collectors.toList());
    }

    private void setInactive(Project project) {
        project.getTasks().forEach(task -> {
            task.setActiveStatus(false);
            this.taskDao.update(task);
        });
        project.setActiveStatus(false);
        this.projectDao.update(project);
    }

}
