package arc;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

import javax.persistence.Entity;
import javax.persistence.Table;

@AnalyzeClasses(packages = "..models..")
public class Models {

    @ArchTest
    ArchRule model_classes_must_be_annotated_with_AllArgsConstructor_NoArgsConstructor_Table_Entity = ArchRuleDefinition
            .classes().that()
            .resideInAPackage("..models..")
            .should().beAnnotatedWith(Table.class)
            .andShould().beAnnotatedWith(Entity.class);

}
