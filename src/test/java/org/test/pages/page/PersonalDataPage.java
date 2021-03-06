package org.test.pages.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.test.pages.wrapper.SelectorWrapper;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PersonalDataPage extends BasePage {
    private By nameTextInput = By.xpath("//input[contains(@id,'field_name')]");
    private By nameError = By.xpath("//div[contains(@data-l,'t,name')]/span[contains(@class,'input-e')]");
    private By surnameTextInput = By.xpath("//input[contains(@id,'field_surname')]");
    private By surnameError = By.xpath("//div[contains(@data-l,'t,surname')]/span[contains(@class,'input-e')]");
    private By birthdayDaySelect = By.xpath("//select[contains(@id,'field_bday')]");
    private By birthdayDayOptions = By.xpath("//select[contains(@id,'field_bday')]/option");
    private By birthdayError = By.xpath("//div[contains(@data-l,'t,birthday')]/span[contains(@class,'input-e')]");
    private SelectorWrapper birthdayDay;
    private By birthdayMonthSelect = By.xpath("//select[contains(@id,'field_bmonth')]");
    private By birthdayMonthOptions = By.xpath("//select[contains(@id,'field_bmonth')]/option");
    private SelectorWrapper birthdayMonth;
    private By birthdayYearSelect = By.xpath("//select[contains(@id,'field_byear')]");
    private By birthdayYearOptions = By.xpath("//select[contains(@id,'field_byear')]/option");
    private SelectorWrapper birthdayYear;
    private By maleGenderSelect = By.xpath("//input[contains(@id,'field_gender_1')]");
    private By femaleGenderSelect = By.xpath("//input[contains(@id,'field_gender_2')]");
    private By currentCityTextInput = By.xpath("//input[contains(@id,'field_citySugg_SearchInput')]");
    private By cityOptions = By.xpath("//div[contains(@class, 'caption')]/div[contains(@class, 'ellip')]");
    private By currentCityError = By.xpath("//div[contains(@id,'citySugg')]/following-sibling::span[contains(@class,'input-e')]");
    private By nativeCityTextInput = By.xpath("//input[contains(@id,'field_cityBSugg_SearchInput')]");
    private By nativeCityError = By.xpath("//div[contains(@id,'cityBSugg')]/following-sibling::span[contains(@class,'input-e')]");
    private By saveButton = By.xpath("//input[contains(@id,'hook_FormButton_button_savePopLayerEditUserProfileNew')]");
    private By closeButton = By.xpath("//a[contains(@class,'modal-new_close_ico')]");

    public PersonalDataPage() {
        isLoaded();
        birthdayDay = new SelectorWrapper(birthdayDaySelect, birthdayDayOptions);
        birthdayMonth = new SelectorWrapper(birthdayMonthSelect, birthdayMonthOptions);
        birthdayYear = new SelectorWrapper(birthdayYearSelect, birthdayYearOptions);
    }

    @Override
    public void isLoaded() {
        $(nameTextInput).shouldBe(visible.because("???? ?????????????????? ???????????????? ???????? ?????? ?????????? ??????????!"));
        $(surnameTextInput).shouldBe(visible.because("???? ?????????????????? ???????????????? ???????? ?????? ?????????? ??????????????!"));
        $(birthdayDaySelect).shouldBe(visible.because("???? ?????????????????? ???????????????? ?????????????????? ?????? ???????????? ?????? ????????????????!"));
        $(birthdayMonthSelect).shouldBe(visible.because("???? ?????????????????? ???????????????? ?????????????????? ?????? ???????????? ???????????? ????????????????!"));
        $(birthdayYearSelect).shouldBe(visible.because("???? ?????????????????? ???????????????? ?????????????????? ?????? ???????????? ???????? ????????????????!"));
        $(maleGenderSelect).shouldBe(visible.because("???? ?????????????????? ???????????????? ???????????? ???????????? ???????????????? ????????!"));
        $(femaleGenderSelect).shouldBe(visible.because("???? ?????????????????? ???????????????? ???????????? ???????????? ???????????????? ????????!"));
        $(currentCityTextInput).shouldBe(visible.because("???? ?????????????????? ???????????????? ?????????????????? ???????????? ???????????? ????????????????????!"));
        $(nativeCityTextInput).shouldBe(visible.because("???? ?????????????????? ???????????????? ?????????????????? ???????????? ?????????????? ????????????!"));
    }

    public PersonalDataPage setUserName(String name) {
        SelenideElement nameTextInputElem = $(nameTextInput).shouldBe(visible.because("???????? ?????? ?????????? ?????????? ???? ????????????????????????!"));
        nameTextInputElem.setValue(name);
        return this;
    }

    public PersonalDataPage setUserSurname(String surname) {
        SelenideElement surnameTextInputElem = $(surnameTextInput).shouldBe(visible.because("???????? ?????? ?????????? ?????????? ???? ????????????????????????!"));
        surnameTextInputElem.setValue(surname);
        return this;
    }

    public PersonalDataPage setUserFullName(String name, String surname) {
        setUserName(name);
        setUserSurname(surname);
        return this;
    }

    public String getNameError() {
        SelenideElement nameErrorElem = $(nameError).shouldBe(visible.because("???????????? ?????????????????? ?????????? ???? ????????????????????????!"));
        return nameErrorElem.getText();
    }

    public String getSurnameError() {
        SelenideElement surnameErrorElem = $(surnameError).shouldBe(visible.because("???????????? ?????????????????? ?????????????? ???? ????????????????????????!"));
        return surnameErrorElem.getText();
    }

    public PersonalDataPage setUserBirthdayDay(String day) {
        birthdayDay.openSelector().selectElement(day);
        return this;
    }

    public PersonalDataPage setUserBirthdayMonth(String month) {
        birthdayMonth.openSelector().selectElement(month);
        return this;
    }

    public PersonalDataPage setUserBirthdayYear(String year){
        birthdayYear.openSelector().selectElement(year);
        return this;
    }

    public PersonalDataPage setUserBirthday(String day, String month, String year) {
        setUserBirthdayDay(day);
        setUserBirthdayMonth(month);
        setUserBirthdayYear(year);
        return this;
    }

    public String getBirthdayError() {
        SelenideElement birthdayErrorElem = $(birthdayError).shouldBe(visible.because("???????????? ?????????????????? ???????? ???????????????? ???? ????????????????????????!"));
        return birthdayErrorElem.getText();
    }

    public PersonalDataPage setUserGender(String gender){
        SelenideElement genderElem;
        if (gender.equals("??????????????")) {
            genderElem = $(maleGenderSelect).shouldBe(visible.because("???? ???????????????????????? ???????????? ???????????? ???????????????? ????????!"));
            genderElem.click();
        }
        else {
            genderElem = $(femaleGenderSelect).shouldBe(visible.because("???? ???????????????????????? ???????????? ???????????? ???????????????? ????????!"));
            genderElem.click();
        }
        return this;
    }

    public PersonalDataPage setUserCurrentCity(String city) {
        SelenideElement currentCityElem = $(currentCityTextInput).shouldBe(visible.because("???? ???????????????????????? ???????? ?????? ?????????? ???????????????? ???????????? ????????????????????!"));
        currentCityElem.setValue(city);
        $$(cityOptions).shouldHave(sizeGreaterThan(0).because("???? ???????????????????????? ???????????????? ?????????????????? ???????????? ????????????????????!"));
        currentCityElem.pressEscape();
        return this;
    }

    public PersonalDataPage selectCurrentCityFromOptions(){
        $(currentCityTextInput).click();
        ElementsCollection options = $$(cityOptions).shouldHave(sizeGreaterThan(0).because("???? ???????????????????????? ???????????????? ?????????????????? ???????????? ????????????????????!"));
        SelenideElement cityOptionElem = options.get(0);
        cityOptionElem.shouldBe(visible.because("???? ???????????????????????? ?????????????? ?????????????????? ???????????? ????????????????????!")).click();
        return this;
    }

    public String getCurrentCityError() {
        SelenideElement currentCityErrorElem = $(currentCityError).shouldBe(visible.because("???? ???????????????????????? ???????????? ???????????? ???????????? ????????????????????!"));
        return currentCityErrorElem.getText();
    }

    public PersonalDataPage deleteUserNativeCity() {
        SelenideElement nativeCityElem = $(nativeCityTextInput).shouldBe(visible.because("???? ???????????????????????? ???????? ?????? ?????????? ???????????????? ?????????????? ????????????!"));
        nativeCityElem.setValue("");
        return this;
    }

    public PersonalDataPage setUserNativeCity(String city) {
        SelenideElement nativeCityElem = $(nativeCityTextInput).shouldBe(visible.because("???? ???????????????????????? ???????? ?????? ?????????? ???????????????? ?????????????? ????????????!"));
        nativeCityElem.setValue(city);
        $$(cityOptions).shouldHave(sizeGreaterThan(0).because("???? ???????????????????????? ???????????????? ?????????????????? ?????????????? ????????????!"));
        nativeCityElem.pressEscape();
        return this;
    }

    public PersonalDataPage selectNativeCityFromOptions(){
        $(nativeCityTextInput).click();
        ElementsCollection options = $$(cityOptions).shouldHave(sizeGreaterThan(0).because("???? ???????????????????????? ???????????????? ?????????????????? ?????????????? ????????????!"));
        SelenideElement cityOptionElem = options.get(0);
        cityOptionElem.shouldBe(visible.because("???? ???????????????????????? ?????????????? ?????????????????? ?????????????? ????????????!")).click();
        return this;
    }

    public String getNativeCityError() {
        SelenideElement nativeCityErrorElem = $(nativeCityError).shouldBe(visible.because("???? ???????????????????????? ???????????? ???????????? ?????????????? ????????????!"));
        return nativeCityErrorElem.getText();
    }

    public SettingsPage saveData() {
        SelenideElement saveButtonElem = $(saveButton).shouldBe(visible.because("???? ???????????????????????? ???????????? ?????? ???????????????????? ????????????????????!"));
        saveButtonElem.click();
        return new SettingsPage();
    }

    public SettingsPage closePage() {
        SelenideElement closeButtonElem = $(closeButton).shouldBe(visible.because("???? ???????????????????????? ???????????? ?????? ???????????????? ????????????????!"));
        closeButtonElem.click();
        return new SettingsPage();
    }
}
