import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.List;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.*;

public class SelenideAdvancedTest {
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
        books.stream().forEach(el->
                                   {actions().moveToElement(el.$(byClassName("mr-2")).$(byTagName("a"))).keyDown( Keys.CONTROL).click().perform(); });
    }
}
