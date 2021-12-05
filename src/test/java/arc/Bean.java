package arc;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@AnalyzeClasses(packages = "..bean..")
public class Bean {

    @ArchTest
    ArchRule bean_classes_must_have_Bean_at_name_end = ArchRuleDefinition
            .classes().that()
            .resideInAPackage("..bean..")
            .should().haveSimpleNameEndingWith("Bean");

    @ArchTest
    ArchRule bean_classes_must_be_at_bean_package = ArchRuleDefinition
            .classes().that()
            .haveSimpleNameEndingWith("Bean")
            .should().resideInAPackage("..bean..");

    @ArchTest
    ArchRule bean_classes_must_depend_on_dao = ArchRuleDefinition
            .classes().that()
            .resideInAPackage("..bean..")
            .should().dependOnClassesThat()
            .resideInAPackage("..dao..");

    @ArchTest
    ArchRule bean_classes_must_implement_serializable = ArchRuleDefinition
            .classes().that()
            .haveSimpleNameEndingWith("Bean")
            .should().implement(Serializable.class);

    @ArchTest
    ArchRule bean_classes_must_be_annotated_as_data_named_viewscoped = ArchRuleDefinition
            .classes().that()
            .resideInAPackage("..bean..")
            .should().beAnnotatedWith(Named.class)
            .andShould().beAnnotatedWith(ViewScoped.class);

    @ArchTest
    ArchRule projectBean_must_depend_on_taskDao_projectDao_project_Task = ArchRuleDefinition
            .classes().that()
            .haveSimpleName("ProjectBean")
            .should().dependOnClassesThat().haveSimpleName("TaskDao")
            .andShould().dependOnClassesThat().haveSimpleName("ProjectDao")
            .andShould().dependOnClassesThat().haveSimpleName("Task")
            .andShould().dependOnClassesThat().haveSimpleName("Project");

    @ArchTest
    ArchRule TaskBean_must_depend_on_EmployeeDao_TaskDao_Employee_Task = ArchRuleDefinition
            .classes().that()
            .haveSimpleName("TaskBean")
            .should().dependOnClassesThat().haveSimpleName("EmployeeDao")
            .andShould().dependOnClassesThat().haveSimpleName("TaskDao")
            .andShould().dependOnClassesThat().haveSimpleName("Employee")
            .andShould().dependOnClassesThat().haveSimpleName("Task");

    @ArchTest
    ArchRule EmployeeBean_must_depend_on_OccupationDao_EmployeeDao_Occupation_Employee = ArchRuleDefinition
            .classes().that()
            .haveSimpleName("EmployeeBean")
            .should().dependOnClassesThat().haveSimpleName("OccupationDao")
            .andShould().dependOnClassesThat().haveSimpleName("EmployeeDao")
            .andShould().dependOnClassesThat().haveSimpleName("Occupation")
            .andShould().dependOnClassesThat().haveSimpleName("Employee");

    @ArchTest
    ArchRule OccupationBean_must_depend_on_OccupationDao_EmployeeDao_Occupation_Employee = ArchRuleDefinition
            .classes().that()
            .haveSimpleName("EmployeeBean")
            .should().dependOnClassesThat().haveSimpleName("OccupationDao")
            .andShould().dependOnClassesThat().haveSimpleName("EmployeeDao")
            .andShould().dependOnClassesThat().haveSimpleName("Occupation")
            .andShould().dependOnClassesThat().haveSimpleName("Employee");
}
