package org.test.tests.username.negative;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.test.pages.page.MainPage;
import org.test.pages.page.PersonalDataPage;
import org.test.pages.page.SettingsPage;
import org.test.tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SurnameChangeNegativeTest extends BaseTest {
    private String expectedErrorText = "Пожалуйста, укажите вашу фамилию.";

    @DisplayName("Test of сhange user's surname with empty surname using space and tab characters")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void surnameChangeNegativeTest(String surname) {
        MainPage mainPage = new MainPage();
        SettingsPage settingsPage = mainPage.openSettingsPage();
        PersonalDataPage personalDataPage = settingsPage.openPersonalDataPage();
        personalDataPage.setUserSurname(surname).saveData();
        assertEquals(expectedErrorText, personalDataPage.getSurnameError(), "Сообщение об ошибке не совпадает с ожидаемым!");
    }

    @AfterEach
    public void end() {
        new PersonalDataPage().closePage();
    }
}
