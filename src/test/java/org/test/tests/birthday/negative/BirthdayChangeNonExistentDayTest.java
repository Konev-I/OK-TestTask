package org.test.tests.birthday.negative;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.test.pages.page.MainPage;
import org.test.pages.page.PersonalDataPage;
import org.test.pages.page.SettingsPage;
import org.test.tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BirthdayChangeNonExistentDayTest extends BaseTest {
    private String expectedErrorText = "День вашего рождения указан некорректно.";

    @DisplayName("Test of change date of birth to non-exist date")
    @ParameterizedTest
    @ValueSource(strings = {"31 февраль 2000", "31 апрель 2000", "31 июнь 2000", "31 сентябрь 2000", "31 ноябрь 2000", "29 февраль 2001"})
    public void birthdayChangeNonExistentDayTest(String date) {
        String birthdayDay = date.split(" ")[0];
        String birthdayMonthSet = date.split(" ")[1];
        String birthdayYear = date.split(" ")[2];

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
