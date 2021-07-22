import com.codeborne.selenide.*;
import com.codeborne.selenide.junit.SoftAsserts;
import com.codeborne.selenide.testng.ScreenShooter;
import org.eclipse.jetty.util.component.Container;
import org.openqa.selenium.Keys;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.List;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.*;


@Listeners({ ScreenShooter.class})
public class SelenideAdvancedTest {

    public SelenideAdvancedTest(){
        Configuration.startMaximized=true;
        Configuration.savePageSource=false;
        Configuration.reportsFolder="src/main/resources/Reports";
        ScreenShooter.captureSuccessfulTests = true;
        Configuration.screenshots=true;
    }

    @Test
    public void booksFound() {
        SoftAssert softAssert=new SoftAssert();
        open("https://demoqa.com/books");
        ElementsCollection books = $(".rt-tbody").findAll(".rt-tr-group").filterBy(text( "O'Reilly Media" )).filterBy(text( "JavaScript" ));
        List<String> result = books.texts();
        System.out.println(result);
        softAssert.assertEquals(result.size(),10);
        System.out.println(books.first().getText());
        String firstbook=books.first().getText();

        if (firstbook.contains("Learning JavaScript Design Patterns")){
            System.out.println("good");
        }
        // (OR)
        // books.first().shouldHave( Condition.text( "Learning JavaScript Design Patterns" ) );
        books.stream().forEach(el->
                                   {actions().moveToElement(el.$(byClassName("mr-2")).$(byTagName("a"))).keyDown( Keys.CONTROL).click().perform(); });

        softAssert.assertEquals(Configuration.reportsFolder,"src/main/resources/Reports");

    }


}
