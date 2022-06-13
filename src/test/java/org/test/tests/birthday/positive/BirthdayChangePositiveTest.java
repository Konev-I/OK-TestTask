package org.test.tests.birthday.positive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.test.pages.page.MainPage;
import org.test.pages.page.PersonalDataPage;
import org.test.pages.page.SettingsPage;
import org.test.tests.BaseTest;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BirthdayChangePositiveTest extends BaseTest {
    @DisplayName("Test of сhange date of birth to correct date")
    @ParameterizedTest
    @ValueSource(strings = {"1 январь января 1913", "31 декабрь декабря 2007", "29 февраль февраля 2000"})
    public void birthdayChangePositiveTest(String date) {
        String birthdayDay = date.split(" ")[0];
        String birthdayMonthSet = date.split(" ")[1];
        String birthdayMonthCheck = date.split(" ")[2];
        String birthdayYear = date.split(" ")[3];

        MainPage mainPage = new MainPage();
        SettingsPage settingsPage = mainPage.openSettingsPage();
        PersonalDataPage personalDataPage= settingsPage.openPersonalDataPage();
        settingsPage = personalDataPage.setUserBirthday(birthdayDay, birthdayMonthSet, birthdayYear).saveData();
        settingsPage = settingsPage.refreshPage();
        ArrayList<String> birthday = settingsPage.getUserBirthday();
        assertAll(
                () -> assertEquals(birthdayDay, birthday.get(0), "День рождения установлен неверно!"),
                () -> assertEquals(birthdayMonthCheck, birthday.get(1), "Месяц рождения установлен неверно!"),
                () -> assertEquals(birthdayYear, birthday.get(2), "Год рождения установлен неверно!")
        );
    }
}
