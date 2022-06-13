package org.test.tests.birthday.negative;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.test.pages.page.MainPage;
import org.test.pages.page.PersonalDataPage;
import org.test.pages.page.SettingsPage;
import org.test.tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BirthdayChangeLessThanFourteenYearsTest extends BaseTest {
    private String expectedErrorText = "Вам должно быть минимум 14 лет";
    private String birthdayDay = "31";
    private String birthdayMonthSet = "декабрь";
    private String birthdayYear = "2008";

    @DisplayName("Test of setting a date of birth less than 14 years ago")
    @Test
    public void birthdayChangeLessThanFourteenYearsTest() {
        MainPage mainPage = new MainPage();
        SettingsPage settingsPage = mainPage.openSettingsPage();
        PersonalDataPage personalDataPage= settingsPage.openPersonalDataPage();
        personalDataPage.setUserBirthday(birthdayDay, birthdayMonthSet, birthdayYear).saveData();
        assertEquals(expectedErrorText, personalDataPage.getBirthdayError(), "Полученная ошибка не совпадает с ожидаемой!");
    }

    @AfterEach
    public void end() {
        new PersonalDataPage().closePage();
    }
}
