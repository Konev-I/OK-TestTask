package org.test.pages.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {
    private By userCard = By.xpath("//div[contains(@class, 'toolbar_ucard')]");
    private By userChangeSettingsButton = By.xpath("//li/a[contains(@href,'/settings')]");
    private By logoutButton = By.xpath("//a[contains(@data-l,'t,logout')]");
    private By confirmLogoutButton = By.xpath("//input[contains(@id,'hook_FormButton_logoff.confirm_not_decorate')]");

    public MainPage(){
        isLoaded();
    }

    @Override
    public void isLoaded() {
        $(userCard).shouldBe(visible.because("Не дождались загрузки элемента с карточкой пользователя!"));
    }

    public SettingsPage openSettingsPage() {
        SelenideElement userCardElem = $(userCard).shouldBe(visible.because("Карточка пользователя не отображается!"));
        userCardElem.click();
        SelenideElement settingsButtonElem = $(userChangeSettingsButton).shouldBe(visible.because("Кнопка изменения настроек не отображается!"));
        settingsButtonElem.click();
        return new SettingsPage();
    }

    public LoginPage logout() {
        SelenideElement userCardElem = $(userCard).shouldBe(visible.because("Карточка пользователя не отображается!"));
        userCardElem.click();
        SelenideElement logoutButtonElem = $(logoutButton).shouldBe(visible.because("кнопка выхода не отображается!"));
        logoutButtonElem.click();
        SelenideElement confirmLogoutButtonElem = $(confirmLogoutButton).shouldBe(visible.because("кнопка подтверждения выхода не отображается!"));
        confirmLogoutButtonElem.click();
        return new LoginPage();
    }

}