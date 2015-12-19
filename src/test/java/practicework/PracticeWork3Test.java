package practicework;

import core.ChromeDriverTest;
import org.junit.Before;
import org.junit.Test;
import practicework.pages.ReserveConfirmPage;
import practicework.pages.ReserveInputPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PracticeWork3Test extends ChromeDriverTest {
    @Before
    public void setUp() {
        super.setUp();
        // ページ遷移の際に少し待機するため
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
    }

    @Test
    public void testReserveWith1Member() {
        //File html = new File("reserveApp/index.html");
        File html = new File("reserveApp_Renewal/index.html");

        String url = html.toURI().toString();
        driver.get(url);

        int A = 0;
        int B = 1;
        int AandB = 2;
        int def = 3;
        int plan = def;

        ReserveInputPage inputPage = new ReserveInputPage(driver);
        inputPage.setReserveDate("2015", "12", "27"); // TODO 明日以降直近の日曜日に変更してください
        inputPage.setReserveTerm("3");
        inputPage.setReserveHeadcount("1");
        inputPage.setReserveBf(Boolean.FALSE);
        inputPage.setReservePlan(plan);
        inputPage.setReserveGuestname("tttt");

        // TODO 残りの処理を記述してください

        ReserveConfirmPage confirmPage = inputPage.goToNext();
        
        // 2ページ目入力画面
        assertThat(confirmPage.getPrice(), is("22750"));
        assertThat(confirmPage.getDateFrom(), is("2015年12月27日")); // TODO 変更してください
        assertThat(confirmPage.getDateTo(), is("2015年12月30日")); // TODO 変更してください
        assertThat(confirmPage.getDaysCount(), is("3"));
        assertThat(confirmPage.getHeadcount(), is("1"));
        assertThat(confirmPage.getBfOrder(), is("なし"));

        switch (plan) {
            case 0:
                assertThat(confirmPage.getPlanAOrder(), is("昼からチェックインプラン"));
                break;
            case 1:
                assertThat(confirmPage.getPlanBOrder(), is("お得な観光プラン"));
                break;
            case 2:
                assertThat(confirmPage.getPlanAOrder(), is("昼からチェックインプラン"));
                assertThat(confirmPage.getPlanBOrder(), is("お得な観光プラン"));
                break;
            default:
                break;
        }

        assertThat(confirmPage.getGname(), is("tttt"));
        // TODO 残りの処理を記述してください
    }
}
