import com.codeborne.selenide.*;
import com.codeborne.selenide.impl.SelenideElementListIterator;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class SelenideBasics2Test {


    @Test
    public void booksFound() { open("https://demoqa.com/books");
        ElementsCollection books = $(".rt-tbody").$$(".rt-tr-group");
        ElementsCollection bookPublisher=books.filterBy( text( "O'Reilly Media" ) );
        ElementsCollection bookNameJavaScript=bookPublisher .filterBy( text( "JavaScript" ) );
        List<String> result = bookNameJavaScript.texts();
        System.out.println(result);
        }
    @Test
    public void booksSize() { open("https://demoqa.com/books");
       ElementsCollection books = $(".rt-tbody").$$(".rt-tr-group");
       books.filterBy(Condition.text( "O'Reilly Media" )).filterBy(Condition.text("JavaScript")).shouldHave(CollectionCondition.size(10));
    }
    @Test
    public void booksimg() { open("https://demoqa.com/books");
        ElementsCollection books = $(".rt-tbody").$$(".rt-tr-group").filterBy(text( "O'Reilly Media" )).filterBy(text( "JavaScript" ));
        Assert.assertTrue(books.first().getAttribute("src").length()>0 );

    }



    }
