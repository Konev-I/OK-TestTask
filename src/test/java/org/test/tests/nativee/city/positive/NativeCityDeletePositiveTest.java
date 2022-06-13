package org.test.tests.nativee.city.positive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.test.pages.page.MainPage;
import org.test.pages.page.PersonalDataPage;
import org.test.pages.page.SettingsPage;
import org.test.tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NativeCityDeletePositiveTest extends BaseTest {
    private String nativeCity = "";

    @DisplayName("Test of delete user's native city")
    @Test
    public void nativeCityDeletePositiveTest() {
        MainPage mainPage = new MainPage();
        SettingsPage settingsPage = mainPage.openSettingsPage();
        PersonalDataPage personalDataPage= settingsPage.openPersonalDataPage();
        settingsPage = personalDataPage.deleteUserNativeCity().saveData();
        settingsPage = settingsPage.refreshPage();
        assertEquals(nativeCity, settingsPage.getUserNativeCity(), "Родной город удалён неверно!");
    }
}
