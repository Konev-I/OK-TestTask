package org.test.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.test.pages.page.LoginPage;
import org.test.pages.page.MainPage;
import org.test.utils.User;

import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {
    private String urlOK = "https://ok.ru";
    private static String userLogin = "technopolisBot72";
    private static String userPassword = "technopolis16";

    @BeforeEach
    public void initBase(){
        open(urlOK);
        LoginPage loginPage = new LoginPage();
        loginPage.login(new User(userLogin, userPassword));
    }

    @AfterEach
    public void endBase(){
        new MainPage().logout();
    }
}
