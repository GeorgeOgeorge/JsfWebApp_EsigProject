package bean;

import dao.OccupationDao;
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


    private OccupationDao occupationDao;

    private Occupation occupation;
    private List<Occupation> activeOccupationList;
    private List<Occupation> selectedOccupationList;

    @PostConstruct
    public void init() {
        this.occupation = new Occupation();
        this.occupationDao = new OccupationDao();
        this.activeOccupationList = this.occupationDao.list().stream()
                .filter(o -> o.getActiveStatus()).
                collect(Collectors.toList());
    }

    public void newOccupation() {
        this.occupation = new Occupation();
    }

    public void saveOccupation() {
        if (!this.occupationDao.isPresent(this.occupation)) {
            this.occupationDao.insert(this.occupation);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Occupation Added"));
        } else {
            this.occupationDao.update(this.occupation);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Occupation updated"));
        }
        PrimeFaces.current().executeScript("PF('OccupationDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages");/*add table update*/
    }

    public String deleteButtonMessage() {
        if (this.selectedOccupationList.isEmpty())
            return this.selectedOccupationList.size() + " occupations selected";
        else
            return "delete";
    }

    public void hardRemove() {
        this.selectedOccupationList.forEach(o -> this.occupationDao.remove(o.getId()));

    }

    public void setInactive() {
        this.occupation.setActiveStatus(true);
        this.occupationDao.update(this.occupation);
    }

}
