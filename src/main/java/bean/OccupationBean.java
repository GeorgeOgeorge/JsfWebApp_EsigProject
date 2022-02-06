package bean;

import dao.GenericDao;
import lombok.Data;
import models.Occupation;
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
public class OccupationBean implements Serializable {

    private GenericDao<Occupation, Long> occupationDao;
    private Occupation occupation;
    private List<Occupation> activeOccupationList;
    private List<Occupation> selectedOccupationList;

    @PostConstruct
    public void init() {
        this.occupationDao = new GenericDao<>(Occupation.class, Long.class);
        this.refreshData();
    }

    public void saveOccupation() {
        if (this.occupation.getId() == null) {
            this.occupationDao.save(this.occupation);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Occupation Added"));
        } else {
            this.occupationDao.save(this.occupation);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Occupation updated"));
        }
        PrimeFaces.current().executeScript("PF('OccupationDialog').hide()");
        this.refreshData();
    }

    public void softRemove() {
        if (this.getHasOccupationsSelected())
            this.selectedOccupationList.forEach(this::setInactive);
        else
            this.setInactive(this.occupation);
        this.refreshData();
        this.getDeleteButtonMessage();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Occupation(s) now inactive"));
    }

    public String getDeleteButtonMessage() {
        if (this.getHasOccupationsSelected())
            return this.selectedOccupationList.size() + " occupations selected";
        else
            return "delete";
    }

    public Boolean getHasOccupationsSelected() {
        return !this.selectedOccupationList.isEmpty();
    }

    private void refreshData() {
        this.occupation = new Occupation();
        this.selectedOccupationList = List.of();
        this.activeOccupationList = this.occupationDao.list().stream()
                .filter(o -> o.getActiveStatus()).
                collect(Collectors.toList());
    }

    private void setInactive(Occupation occupation) {
        occupation.setActiveStatus(false);
        this.occupationDao.save(occupation);
    }

}
