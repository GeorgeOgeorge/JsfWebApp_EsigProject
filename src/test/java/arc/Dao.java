package arc;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

@AnalyzeClasses(packages = "..java..")
public class Dao {

    @ArchTest
    static ArchRule dao_classes_must_be_at_Dao_package = ArchRuleDefinition
            .classes().that()
            .haveSimpleNameEndingWith("Dao")
            .should().resideInAPackage("..dao..");

    @ArchTest
    static ArchRule dao_classes_must_depend_on_util = ArchRuleDefinition
            .classes().that()
            .resideInAPackage("..dao..")
            .should().dependOnClassesThat().resideInAPackage("..util..");

}
