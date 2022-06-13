package org.test.tests.username.positive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.test.pages.page.MainPage;
import org.test.pages.page.PersonalDataPage;
import org.test.pages.page.SettingsPage;
import org.test.tests.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameChangePositiveTest extends BaseTest {

    @DisplayName("Test of сhange user's name using space and tab characters")
    @ParameterizedTest
    @ValueSource(strings = {"technopolisbot7", " technopolisbot7", "technopolisbot7 ", "technopolisbot7    "})
    public void nameChangePositiveTest(String name) {
        MainPage mainPage = new MainPage();
        SettingsPage settingsPage = mainPage.openSettingsPage();
        PersonalDataPage personalDataPage = settingsPage.openPersonalDataPage();
        settingsPage = personalDataPage.setUserName(name).saveData();
        settingsPage = settingsPage.refreshPage();
        assertEquals(name.trim(), settingsPage.getUserName(), "Имя установлено неверно!");
    }
}
