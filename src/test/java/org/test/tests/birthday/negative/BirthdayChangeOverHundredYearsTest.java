package org.test.tests.birthday.negative;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.test.pages.page.MainPage;
import org.test.pages.page.PersonalDataPage;
import org.test.pages.page.SettingsPage;
import org.test.tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BirthdayChangeOverHundredYearsTest extends BaseTest {
    private String expectedErrorText = "Вы побили рекорд долголетия!";

    String birthdayDay = "1";
    String birthdayMonthSet = "январь";
    String birthdayYear = "1912";

    @DisplayName("Test of setting a date of birth more than 100 years ago")
    @Test
    public void birthdayChangeOverHundredYearsTest() {
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
