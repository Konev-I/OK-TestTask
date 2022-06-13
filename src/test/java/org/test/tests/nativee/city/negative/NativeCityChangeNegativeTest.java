package org.test.tests.nativee.city.negative;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.test.pages.page.MainPage;
import org.test.pages.page.PersonalDataPage;
import org.test.pages.page.SettingsPage;
import org.test.tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NativeCityChangeNegativeTest extends BaseTest {
    private String city = "Тест тест";
    private String expectedErrorText = "Пожалуйста, выберите родной город из списка.";

    @DisplayName("Test of сhange user's native city with wrong city name")
    @Test
    public void currentCityChangeNegativeTest() {
        MainPage mainPage = new MainPage();
        SettingsPage settingsPage = mainPage.openSettingsPage();
        PersonalDataPage personalDataPage = settingsPage.openPersonalDataPage();
        personalDataPage.setUserNativeCity(city).saveData();
        assertEquals(expectedErrorText, personalDataPage.getNativeCityError(), "Сообщение об ошибке не совпадает с ожидаемым!");
    }

    @AfterEach
    public void end() {
        new PersonalDataPage().closePage();
    }
}
