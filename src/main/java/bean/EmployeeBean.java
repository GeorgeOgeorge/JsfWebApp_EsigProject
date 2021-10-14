package bean;

import dao.EmployeeDao;
import dao.OccupationDao;
import lombok.Data;
import models.Employee;
import models.Occupation;
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
public class EmployeeBean implements Serializable {

    private EmployeeDao employeeDao;
    private Employee employee;
    private List<Employee> activeEmployeeList;
    private List<Employee> selectedEmployeeList;
    private OccupationDao occupationDao;
    private List<Occupation> activeOccupationList;

    @PostConstruct
    public void init() {
        this.employeeDao = new EmployeeDao();
        this.occupationDao = new OccupationDao();
        this.refreshData();
    }

    public void saveEmployee() {
        if (this.employeeDao.isPresent(this.employee)) {
            this.employeeDao.update(this.employee);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Employee Updated"));
        } else {
            this.employeeDao.insert(this.employee);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Employee Added"));
        }
        PrimeFaces.current().executeScript("PF(' ').hide()");
        this.refreshData();
    }

    public void softRemove() {
        if (this.getHasEmployeeSelected())
            this.selectedEmployeeList.forEach(e -> this.setInactive(e));
        else
            this.setInactive(this.employee);
        this.refreshData();
        this.getDeleteButtonMessage();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Employee(s) now inactive"));
    }

    public String getDeleteButtonMessage() {
        if (this.getHasEmployeeSelected())
            return this.selectedEmployeeList.size() + "employees selected";
        else
            return "delete";
    }

    public Boolean getHasEmployeeSelected() {
        return !this.selectedEmployeeList.isEmpty();
    }

    private void refreshData() {
        this.employee = new Employee();
        this.selectedEmployeeList = Arrays.asList();
        this.activeEmployeeList = this.employeeDao.list().stream()
                .filter(e -> e.getActiveStatus())
                .collect(Collectors.toList());
        this.activeOccupationList = this.occupationDao.list().stream()
                .filter(o -> o.getActiveStatus()).
                collect(Collectors.toList());
    }

    private void setInactive(Employee employee) {
        employee.setActiveStatus(false);
        this.employeeDao.update(employee);
    }


}
