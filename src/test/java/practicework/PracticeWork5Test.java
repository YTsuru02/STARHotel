package practicework;

import core.ChromeDriverTest;
import org.junit.Before;
import org.junit.Test;
import practicework.pages.ReserveInputPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PracticeWork5Test extends ChromeDriverTest {
    @Before
    public void setUp() {
        super.setUp();
        // ページ遷移の際に少し待機するため
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
    }
    
    @Test
    public void testCheckInitialScreen() {
        File html = new File("reserveApp_Renewal/index.html");
        String url = html.toURI().toString();
        driver.get(url);

        // TODO 初期値チェック処理を記述してください

        ReserveInputPage inputPage = new ReserveInputPage(driver);
        assertThat(inputPage.getDefaultDate(), is("2015/12/19"));
        assertThat(inputPage.getDefaultTerm(), is("1"));
        assertThat(inputPage.getDefaultHeadcount(), is("1"));
        assertThat(inputPage.getDefaultBf(), is(true));
        assertThat(inputPage.getDefaultPlan(), is(3));
        assertThat(inputPage.getDefaultGuestname(), is(""));

    }
}
