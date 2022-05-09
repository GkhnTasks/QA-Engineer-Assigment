package com.studocu.pages;

import com.studocu.utilities.BrowserUtils;
import com.studocu.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class QuestionPages {

    public QuestionPages(){
        PageFactory.initElements(Driver.get(),this);
    }


    @FindBy(className= "question__question")
    public WebElement howToAddQuestion;

    @FindBy(className= "question__answer")
    public WebElement howToAddAnswer;

    @FindBy(css= "[class='btn btn-primary']")
    public WebElement sortQuestionButton;

    @FindBy(css= "[class='btn btn-danger']")
    public WebElement removeQuestionsButton;

    @FindBy(id = "question")
    public WebElement questionsArea;

    @FindBy(id = "answer")
    public WebElement answerArea;

    @FindBy(css= "[class='btn btn-success']")
    public WebElement createQuestionButton;

    @FindBy(css= "[class='alert alert-danger']")
    public WebElement removeMessage;

    @FindBy(className= "sidebar")
    public WebElement sidebarText;






    public String readQuestion(){
//        List<WebElement> allQuestion=Driver.get().findElements(By.xpath("//li/div"));
//        WebElement questionAndAnswer=Driver.get().findElement(By.xpath("(//li)["+(allQuestion.size())+"]/div"));
        WebElement questionAndAnswer=Driver.get().findElement(By.xpath("(//li)[last()]/div"));
        return questionAndAnswer.getText();
    }

    public int sideBarNumber(){

        String sideBarText=sidebarText.getText();
        String[] text=sideBarText.split(" ");
        int number=Integer.parseInt(text[4]);
        return  number;

    }

    public int getSize(){
        return  Driver.get().findElements(By.xpath("//li/div")).size() ;
    }


    public List<String> getAllQuestion(){

        List<WebElement> allQuestion=Driver.get().findElements(By.xpath("//li/div"));
        return BrowserUtils.getElementsText(allQuestion);
    }



}
