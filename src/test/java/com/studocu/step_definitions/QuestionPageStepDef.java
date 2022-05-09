package com.studocu.step_definitions;

import com.studocu.pages.QuestionPages;
import com.studocu.utilities.BrowserUtils;
import com.studocu.utilities.ConfigurationReader;
import com.studocu.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Collections;
import java.util.List;

public class QuestionPageStepDef {

    QuestionPages questionPages=new QuestionPages();

    /**
     * Scenario: User should be see how to add a question answer
     */
    @Given("user open the website")
    public void user_open_the_website() {

        Driver.get().get(ConfigurationReader.get("url"));

    }
    @When("user click How to add a question? tab")
    public void user_click_how_to_add_a_question_tab() {
        BrowserUtils.waitForVisibility(questionPages.howToAddQuestion,10);
        questionPages.howToAddQuestion.click();

    }
    @Then("user should be able to see {string} message")
    public void user_should_be_able_to_see_message(String questionText) {
        BrowserUtils.waitForVisibility(questionPages.howToAddQuestion,10);
        Assert.assertEquals(questionText,questionPages.howToAddAnswer.getText());

    }

    /**
     * Scenario: User should be able to create question
     */

    @When("user type question in the Question area")
    public void user_type_question_in_the_question_area() {
        BrowserUtils.waitForVisibility(questionPages.questionsArea,10);
        questionPages.questionsArea.sendKeys(ConfigurationReader.get("question1"));

    }
    @When("user type answer in the answer area")
    public void user_type_answer_in_the_answer_area() {
        questionPages.answerArea.sendKeys(ConfigurationReader.get("answer1"));

    }
    @When("user click Create question button")
    public void user_click_create_question_button() {
        questionPages.createQuestionButton.click();

    }
    @Then("user should be see own question in the question section")
    public void user_should_be_see_own_question_in_the_question_section() {
        BrowserUtils.waitForVisibility(questionPages.questionsArea,10);
        Assert.assertEquals("What is your automation language?",questionPages.readQuestion());


    }
    @Then("user should see an increasing number of questions")
    public void user_should_see_an_increasing_number_of_questions() {
        BrowserUtils.waitForVisibility(questionPages.sidebarText,10);
        Assert.assertEquals(questionPages.getSize(),questionPages.sideBarNumber());

    }

    /**
     * Scenario: User should be able to sort question
     */

    List<String> expectedSortedQuestions;
    @When("user click sort question button")
    public void user_click_sort_question_button() {

        BrowserUtils.waitForVisibility(questionPages.sortQuestionButton,10);
        expectedSortedQuestions=questionPages.getAllQuestion();
        Collections.sort(expectedSortedQuestions);
        questionPages.sortQuestionButton.click();

    }
    @Then("user should be see sorted question")
    public void user_should_be_see_sorted_question() {
        BrowserUtils.waitForVisibility(questionPages.sortQuestionButton,10);
        Assert.assertEquals(expectedSortedQuestions,questionPages.getAllQuestion());



    }



    /**
     * Scenario: User should be able to delete questions
     */

    @When("user click Remove Questions button")
    public void user_click_remove_questions_button() {
        BrowserUtils.waitForVisibility(questionPages.removeQuestionsButton,10);
        questionPages.removeQuestionsButton.click();

    }
    @Then("user should be see {string} message")
    public void user_should_be_see_message(String message) {
        BrowserUtils.waitForVisibility(questionPages.removeMessage,10);
        Assert.assertEquals(message,questionPages.removeMessage.getText());

    }

    /**
     * Scenario: User should be able to see  error message
     */

    @When("user click Create question button without filling any fields")
    public void user_click_create_question_button_without_filling_any_fields() {
        BrowserUtils.waitForVisibility(questionPages.createQuestionButton,10);
        questionPages.createQuestionButton.click();

    }

    @Then("user should be see {string} messages")
    public void userShouldBeSeeMessages(String messages) {
        Assert.assertEquals(messages,questionPages.questionsArea.getAttribute("validationMessage"));
    }
}
