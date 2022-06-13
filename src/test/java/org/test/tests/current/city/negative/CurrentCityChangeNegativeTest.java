package org.test.tests.current.city.negative;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.test.pages.page.MainPage;
import org.test.pages.page.PersonalDataPage;
import org.test.pages.page.SettingsPage;
import org.test.tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrentCityChangeNegativeTest extends BaseTest {
    private String city = "Тест тест";
    private String expectedErrorText = "Пожалуйста, выберите место проживания из списка";

    @DisplayName("Test of сhange user's current city with wrong city name")
    @Test
    public void currentCityChangeNegativeTest() {
        MainPage mainPage = new MainPage();
        SettingsPage settingsPage = mainPage.openSettingsPage();
        PersonalDataPage personalDataPage = settingsPage.openPersonalDataPage();
        personalDataPage.setUserCurrentCity(city).saveData();
        assertEquals(expectedErrorText, personalDataPage.getCurrentCityError(), "Сообщение об ошибке не совпадает с ожидаемым!");
    }

    @AfterEach
    public void end() {
        new PersonalDataPage().closePage();
    }
}
