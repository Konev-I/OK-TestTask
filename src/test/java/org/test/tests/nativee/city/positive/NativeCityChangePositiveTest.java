package org.test.tests.nativee.city.positive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.test.pages.page.MainPage;
import org.test.pages.page.PersonalDataPage;
import org.test.pages.page.SettingsPage;
import org.test.tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NativeCityChangePositiveTest extends BaseTest {
    @DisplayName("Test of сhange user's native city")
    @ParameterizedTest
    @ValueSource(strings = {"пос. Южный (г. Ессентуки)", "Санкт-Петербург"})
    public void nativeCityChangePositiveTest(String city) {
        MainPage mainPage = new MainPage();
        SettingsPage settingsPage = mainPage.openSettingsPage();
        PersonalDataPage personalDataPage= settingsPage.openPersonalDataPage();
        settingsPage = personalDataPage.setUserNativeCity(city).selectNativeCityFromOptions().saveData();
        settingsPage = settingsPage.refreshPage();
        assertEquals(city, settingsPage.getUserNativeCity(), "Родной город установлен неверно!");
    }
}
