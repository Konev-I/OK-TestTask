package org.test.pages.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;

public class SettingsPage extends BasePage{
    private By personalDataButton = By.xpath("//a[contains(@data-l,'t,profile_form')]");
    private By personalDataText = By.xpath("//a[contains(@data-l,'t,profile_form')]//div[contains(@class,'textWrap')]");
    private By postSkipButton = By.xpath("//input[contains(@class, 'form-actions_no')]");
    private String lastWordsBeforeCityName = "в городе ";

    public SettingsPage() {
        isLoaded();
    }

    @Override
    public void isLoaded() {
        $(personalDataText).shouldBe(visible.because("Не дождались загрузки элемента с информацией о пользователе!"));
        $(personalDataButton).shouldBe(visible.because("Не дождались загрузки кнопки для изменения информации о пользователе!"));
    }

    public PersonalDataPage openPersonalDataPage() {
        SelenideElement personalDataButtonElem = $(personalDataButton).shouldBe(visible.because("Кнопка изменения личных данных не отображается!"));
        personalDataButtonElem.click();
        return new PersonalDataPage();
    }

    public String getUserName() {
        SelenideElement personalDataTextElem = $(personalDataText).shouldBe(visible.because("Информация о пользователе не отображается!"));
        return personalDataTextElem.getText().split(",")[0].split(" ")[0];
    }

    public String getUserSurname() {
        SelenideElement personalDataTextElem = $(personalDataText).shouldBe(visible.because("Информация о пользователе не отображается!"));
        return personalDataTextElem.getText().split(",")[0].split(" ")[1];
    }

    public String getUserGender() {
        SelenideElement personalDataTextElem = $(personalDataText).shouldBe(visible.because("Информация о пользователе не отображается!"));
        if (personalDataTextElem.getText().split(",")[1].split(" ")[1].equals("родился")){
            return "мужской";
        }
        else {
            return "женский";
        }
    }

    public ArrayList<String> getUserBirthday() {
        SelenideElement personalDataTextElem = $(personalDataText).shouldBe(visible.because("Информация о пользователе не отображается!"));
        ArrayList<String> birthday = new ArrayList<>();
        String[] birthdayText = personalDataTextElem.getText().split(",")[1].split(" ");
        birthday.add(birthdayText[2]);
        birthday.add(birthdayText[3]);
        birthday.add(birthdayText[4]);
        return birthday;
    }

    public String getUserNativeCity() {
        SelenideElement personalDataTextElem = $(personalDataText).shouldBe(visible.because("Информация о пользователе не отображается!"));
        String nativeCityText = personalDataTextElem.getText().split(",")[1];
        if (nativeCityText.contains(lastWordsBeforeCityName)){
            int indexOfCityName = nativeCityText.indexOf(lastWordsBeforeCityName) + lastWordsBeforeCityName.length();
            return nativeCityText.substring(indexOfCityName);
        }
        else {
            return "";
        }
    }

    public String getUserCurrentCity() {
        SelenideElement personalDataTextElem = $(personalDataText).shouldBe(visible.because("Информация о пользователе не отображается!"));
        String currentCity = personalDataTextElem.getText().split(",")[2];
        int indexOfCityName = currentCity.indexOf(lastWordsBeforeCityName) + lastWordsBeforeCityName.length();
        return currentCity.substring(indexOfCityName);
    }

    public SettingsPage skipCityChangePost() {
        SelenideElement postSkipButtonElem = $(postSkipButton).shouldBe(visible.because("Не отображается кнопка пропуска создания поста о переезде!"));
        postSkipButtonElem.click();
        return this;
    }

    public SettingsPage refreshPage(){
        refresh();
        return new SettingsPage();
    }
}
