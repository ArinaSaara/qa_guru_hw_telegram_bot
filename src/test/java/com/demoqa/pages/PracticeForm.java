package com.demoqa.pages;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeForm {

    private final SelenideElement firstNameInput = $("#firstName"),
            secondNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            mobileNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            monthOfBirthOption = $(".react-datepicker__month-select"),
            yearOfBirthOption = $(".react-datepicker__year-select"),
            subjectInput = $("#subjectsInput"),
            uploadPictureButton = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            createStudentButton = $("#submit");

    @Step("Open automation-practice-form\"")
    public PracticeForm openPage() {
        open("https://demoqa.com/automation-practice-form");
        return this;
    }

    @Step("Enter last_name")
    public PracticeForm enterLastName(String userLastName) {
        secondNameInput.setValue(userLastName);
        return this;
    }

    @Step("Enter first_name")
    public PracticeForm enterFirstName(String userName) {
        firstNameInput.setValue(userName);
        return this;
    }

    @Step("Enter email")
    public PracticeForm enterEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    @Step("Select gender")
    public PracticeForm selectGender(String gender) {
        $(byText(gender)).click();
        return this;
    }

    @Step("Select Date Of Birthday")
    public PracticeForm selectDateOfBirthday(int month, int year, int day) {
        dateOfBirthInput.click();
        monthOfBirthOption.selectOption(month - 1);
        yearOfBirthOption.selectOption(String.valueOf(year));
        $(".react-datepicker__day--0" + day).click();
        return this;
    }

    @Step("Enter modile number")
    public PracticeForm enterMobileNumber(String mobileNumber) {
        mobileNumberInput.setValue(mobileNumber);
        return this;
    }

    @Step("Enter subject")
    public PracticeForm enterSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    @Step("Enter address")
    public PracticeForm enterAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    @Step("Choose a hobby")
    public PracticeForm checkHobby(String hobby) {
        $(withText(hobby)).click();
        return this;
    }

    @Step("Upload image")
    public PracticeForm uploadImage(String imagePath) {
        uploadPictureButton.uploadFromClasspath(imagePath);
        return this;
    }

    @Step("Select state and city")
    public PracticeForm selectStateAndCity(String state, String city) {
        stateInput.setValue(state).pressEnter();
        cityInput.setValue(city).pressEnter();
        return this;
    }

    @Step("Click on Create button")
    public void clickOnCreateStudentButton() {
        createStudentButton.shouldBe(enabled).click();
    }
}

