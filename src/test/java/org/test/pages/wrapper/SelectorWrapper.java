package org.test.pages.wrapper;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SelectorWrapper {
    private By selector;
    private By elements;

    public SelectorWrapper(By selector, By elements) {
        this.selector = selector;
        this.elements = elements;
    }

    public SelectorWrapper openSelector() {
        SelenideElement selectorElem = $(selector).shouldBe(visible.because("Селектор не отображается!"));
        selectorElem.click();
        return this;
    }

    public void selectElement(int number) {
        ElementsCollection selectOptions = $$(elements).shouldHave(sizeGreaterThan(0).because("Элементы для выбора не отображаются!"));
        selectOptions.get(number).shouldBe(visible.because("Выбираемый элемент не отображается!")).click();
    }

    public void selectElement(String elementText) {
        ElementsCollection selectOptions = $$(elements).shouldHave(sizeGreaterThan(0).because("Элементы для выбора не отображаются!"));
        int num;
        for (num = 0; num < selectOptions.size(); num++){
            SelenideElement elem = $(selectOptions.get(num)).shouldBe(visible.because("Варианты для выбора не отображаются!"));
            if(elem.getText().equals(elementText)){
                selectElement(num);
            }
        }
    }
}
