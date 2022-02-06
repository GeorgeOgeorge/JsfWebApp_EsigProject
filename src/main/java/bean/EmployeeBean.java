package bean;

import dao.GenericDao;
import lombok.Data;
import models.Employee;
import models.Occupation;
import org.primefaces.PrimeFaces;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Named
@ViewScoped
public class EmployeeBean implements Serializable {

    private GenericDao<Occupation, Long> occupationDao;
    private GenericDao<Employee, Long> employeeDao;
    private Employee employee;
    private List<Employee> activeEmployeeList;
    private List<Employee> selectedEmployeeList;
    private List<Occupation> activeOccupationList;

    @PostConstruct
    public void init() {
        this.employeeDao = new GenericDao<>(Employee.class, Long.class);
        this.occupationDao = new GenericDao<>(Occupation.class, Long.class);
        this.refreshData();
    }

    @Transactional
    public void saveEmployee() {
        if (this.employee.getId() == null) {
            this.employeeDao.save(this.employee);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Employee Added"));
        } else {
            this.employeeDao.save(this.employee);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Employee Updated"));
        }
        PrimeFaces.current().executeScript("PF('EmployeeDialog').hide()");
        this.refreshData();
    }

    @Transactional
    public void softRemove() {
        if (this.getHasEmployeeSelected())
            this.selectedEmployeeList.forEach(this::setInactive);
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
        this.selectedEmployeeList = List.of();
        this.activeEmployeeList = this.employeeDao.list().stream()
                .filter(e -> e.getActiveStatus())
                .collect(Collectors.toList());
        System.out.println(this.activeEmployeeList);
        this.activeOccupationList = this.occupationDao.list().stream()
                .filter(o -> o.getActiveStatus()).
                collect(Collectors.toList());
    }

    private void setInactive(Employee employee) {
        employee.setActiveStatus(false);
        this.employeeDao.save(employee);
    }
}
