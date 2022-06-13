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

public class BirthdayChangeEmptyFieldTest extends BaseTest {
    private String expectedErrorText = "День вашего рождения указан некорректно.";

    @DisplayName("Test of change date of birth to date with empty field")
    @ParameterizedTest
    @ValueSource(strings = {"день май 2000", "19 месяц 2000", "19 май год"})
    public void birthdayChangeEmptyFieldTest(String date) {
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
