package org.test.tests.username.positive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.test.pages.page.MainPage;
import org.test.pages.page.PersonalDataPage;
import org.test.pages.page.SettingsPage;
import org.test.tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SurnameChangePositiveTest extends BaseTest {

    @DisplayName("Test of сhange user's surname using space and tab characters")
    @ParameterizedTest
    @ValueSource(strings = {"technopolisbot7", " technopolisbot7", "technopolisbot7 ", "technopolisbot7    "})
    public void surnameChangePositiveTest(String surname) {
        MainPage mainPage = new MainPage();
        SettingsPage settingsPage = mainPage.openSettingsPage();
        PersonalDataPage personalDataPage = settingsPage.openPersonalDataPage();
        settingsPage = personalDataPage.setUserSurname(surname).saveData();
        settingsPage = settingsPage.refreshPage();
        assertEquals(surname.trim(), settingsPage.getUserSurname(), "Фамилия установлена неверно!");
    }
}
