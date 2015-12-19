package introwork;

import core.ChromeDriverTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

import java.io.File;

/**
 * 入門課題その9:「テキストが表示されるまで待機してみよう」
 */
public class IntroWork9Test extends ChromeDriverTest {
    @Test
    public void testClickOKButton() throws Exception {
        File html = new File("introwork/introWork9.html");
        String url = html.toURI().toString();
        driver.get(url);

        WebElement okButton = driver.findElement(By.id("ok_button"));
        okButton.click();

        // TODO 以下を削除して、代わりに3秒後に「「OK」ボタンがクリックされました!」が表示されることを確認する処理を記述してください

        WebElement text = driver.findElement(By.id("clicked_text"));
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.visibilityOf(text));
        } finally {
            assertThat(text.getText(), is("「OK」ボタンがクリックされました!"));
        }
        Thread.sleep(8000);
        // TODO ここまで削除してください
    }
}
