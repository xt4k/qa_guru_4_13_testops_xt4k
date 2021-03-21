package tests;

import config.WebConfig;
import helpers.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.aeonbits.owner.ConfigFactory;
import po.BasePageObject;
import pojo.Student;

@Epic("QA_guru")
@Feature("number 4")
public class StudentRegistrationScenario extends BaseTest {
    BasePageObject po = new BasePageObject( );
    final WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

    @Step("student form register scenario")
    void successStudentRegisterScenario(Student student) {
        po.openForm(config.getBaseUrl())
                .validateFormOpen( )
                .fillRegForm(student)
                .submitForm( );
        po.registeredFormVerification(student);
    }


    @Step("Success student form register scenario")
    void unSuccessStudentRegisterScenario(Student student, String field) {
        po.openForm(config.getBaseUrl())
                .validateFormOpen( )
                .fillRegForm(student)
                .submitForm( );
        po.validateFormOpen( )
                .emptyField(field);
    }

    @Step("Success student form register scenario")
    void unSuccessStudentRegisterScenario2(Student student, String field,String field2) {
        po.openForm(config.getBaseUrl())
                .validateFormOpen( )
                .fillRegForm(student)
                .submitForm( );
        po.validateFormOpen( )
                .emptyField(field)
                .emptyField(field2);
    }

    @Step("Failed scenario")
    public void failedTest( ) {
        po.openForm(config.getBaseUrl())
                .validateFormOpen( )
                .submitForm( );
        po.validateFormOpen( );
        failStep( );
    }
}