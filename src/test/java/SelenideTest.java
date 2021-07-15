import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class SelenideTest {

    @Test
    public void radioButtonCheck(){
        open("http://the-internet.herokuapp.com/checkboxes ");
        SelenideElement clcl= $(byXpath("//*[@id='checkboxes']/input[1]"));
        clcl.click();
        sleep(5000);
        if(clcl.isSelected()){
            System.out.println("button is selected");
        }else {
            System.out.println("plz select the button");
        }
        $(byXpath("//*[@id='checkboxes']/input[1]")).shouldHave( Condition.attribute("type","checkbox")) ;
        $(byXpath("//*[@id='checkboxes']/input[2]")).shouldHave( Condition.attribute("type","checkbox")) ;
        // Assert.assertTrue($("#checkboxes input").isSelected());
    }

    @Test
    public void dropDownCheck() {
        open("http://the-internet.herokuapp.com/dropdown");
        SelenideElement dropelement= $("#dropdown");
        $("#dropdown").shouldHave(text("Please select an option"));
        System.out.println(dropelement.getText());
        String firstText="Please select an option";
        if(dropelement.getText().equals(firstText)){
            System.out.println("first text is fine");
        }
        dropelement.selectOption("Option 2");
        sleep(5000);
        $("#dropdown").shouldHave(text("Option 2"));
    }

    @Test
    public void textBox(){
        open("https://demoqa.com/text-box");
        $("#userName").setValue("mariam");
        $(byAttribute( "type", "email" )).setValue("mariamazaladze@yahoo.com");
        $(by("placeholder","Current Address")).setValue("Tbilisi");
        $("#permanentAddress").setValue("didi digomi");
        $("#submit").click();
        System.out.println($$(".border").get(0).getText());

        $$(".border").shouldHave(texts("Name:mariam"));
        $$(".border").shouldHave(texts("Email:mariamazaladze@yahoo.com"));
        $$(".border").shouldHave(texts("Current Address :Tbilisi"));
        $$(".border").shouldHave(texts("Permananet Address :didi digomi"));
    }

}
