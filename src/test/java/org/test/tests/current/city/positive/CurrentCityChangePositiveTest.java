package org.test.tests.current.city.positive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.test.pages.page.MainPage;
import org.test.pages.page.PersonalDataPage;
import org.test.pages.page.SettingsPage;
import org.test.tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrentCityChangePositiveTest extends BaseTest {
    @DisplayName("Test of сhange user's current city")
    @ParameterizedTest
    @ValueSource(strings = {"пос. Южный (г. Ессентуки)", "Санкт-Петербург"})
    public void currentCityChangePositiveTest(String city) {
        MainPage mainPage = new MainPage();
        SettingsPage settingsPage = mainPage.openSettingsPage();
        PersonalDataPage personalDataPage= settingsPage.openPersonalDataPage();
        settingsPage = personalDataPage.setUserCurrentCity(city).selectCurrentCityFromOptions().saveData();
        settingsPage.skipCityChangePost();
        settingsPage = settingsPage.refreshPage();
        assertEquals(city, settingsPage.getUserCurrentCity(), "Город проживания установлен неверно!");
    }
}
