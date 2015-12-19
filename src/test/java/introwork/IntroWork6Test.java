package introwork;

import core.ChromeDriverTest;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

/**
 * 入門課題その6:「プルダウンを選択してみよう」
 */
public class IntroWork6Test extends ChromeDriverTest {
    @Test
    public void testSelectOptionByValue() throws Exception {
        File html = new File("introwork/introWork6.html");
        String url = html.toURI().toString();
        driver.get(url);
        
        // TODO 以下を削除して、代わりにチェックボックスを選択する処理を記述ください
        WebElement pullDown = driver.findElement(By.id("head_count")) ;
        Select select = new Select(pullDown);
        select.selectByValue("3");
        Thread.sleep(3000);
        // TODO ここまで削除してください
    }
}
