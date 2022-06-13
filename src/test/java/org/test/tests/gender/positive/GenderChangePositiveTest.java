package org.test.tests.gender.positive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.test.pages.page.MainPage;
import org.test.pages.page.PersonalDataPage;
import org.test.pages.page.SettingsPage;
import org.test.tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenderChangePositiveTest extends BaseTest {
    @DisplayName("Test of сhange user's gender")
    @ParameterizedTest
    @ValueSource(strings = {"мужской", "женский"})
    public void genderChangePositiveTest(String gender) {
        MainPage mainPage = new MainPage();
        SettingsPage settingsPage = mainPage.openSettingsPage();
        PersonalDataPage personalDataPage= settingsPage.openPersonalDataPage();
        settingsPage = personalDataPage.setUserGender(gender).saveData();
        settingsPage = settingsPage.refreshPage();
        assertEquals(gender, settingsPage.getUserGender(), "Пол установлен неверно!");
    }
}
