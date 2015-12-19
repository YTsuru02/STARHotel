package practicework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ReserveInputPage {
    private final WebDriver driver;
    private final By reserveYear = By.id("reserve_year");
    private final By reserveMonth = By.id("reserve_month");
    private final By reserveDay = By.id("reserve_day");
    private final By reserveDate = By.id("datePick");
    private final By reserveTerm = By.id("reserve_term");
    private final By reserveHeadcount = By.id("headcount");
    private final By reserveBf_on = By.id("breakfast_on");
    private final By reserveBf_off = By.id("breakfast_off");
    private final By reservePlan_a = By.id("plan_a");
    private final By reservePlan_b = By.id("plan_b");
    private final By reserveGuestname = By.id("guestname");
    private final By goToNext = By.id("agree_and_goto_next");

    public ReserveInputPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setReserveDate(String year, String month, String day) {
        WebElement element = driver.findElement(reserveDate);

        element.clear();
        element.sendKeys(year + "/" + month + "/" + day);
        element.sendKeys(Keys.RETURN);
    }

    public void setReserveTerm(String value) {
        WebElement element = driver.findElement(reserveTerm);
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void setReserveHeadcount(String value) {
        WebElement element = driver.findElement(reserveHeadcount);
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void setReserveBf(Boolean on) {
        WebElement element_on = driver.findElement(reserveBf_on);
        WebElement element_off = driver.findElement(reserveBf_off);
        if (on) {
            element_on.click();
        } else {
            element_off.click();
        }
    }

    public void setReservePlan(int plan) {
        WebElement element_a = driver.findElement(reservePlan_a);
        WebElement element_b = driver.findElement(reservePlan_b);

        switch (plan) {
            case 0:
                element_a.click();
                break;
            case 1:
                element_b.click();
                break;
            case 2:
                element_a.click();
                element_b.click();
                break;
            default:
                break;
        }
    }

    public void setReservePlan_a(Boolean on) {
        WebElement element_a = driver.findElement(reservePlan_a);
    }

    public void setReservePlan_b(Boolean on) {
        WebElement element_b = driver.findElement(reservePlan_b);
    }

    public void setReserveGuestname(String value) {
        WebElement element = driver.findElement(reserveGuestname);
        element.clear();
        element.sendKeys(value);
    }


    public String getDefaultDate() {
        WebElement element_y = driver.findElement(reserveYear);
        WebElement element_m = driver.findElement(reserveMonth);
        WebElement element_d = driver.findElement(reserveDay);

        return element_y.getAttribute("value") + "/" + element_m.getAttribute("value") + "/" +element_d.getAttribute("value");
    }

    public String getDefaultTerm() {
        int target = 0;

        List<WebElement> elements = driver.findElements(reserveTerm);
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).isSelected()) {
                target = i;
            }
        }

        return elements.get(target).getAttribute("value");
    }

    public String getDefaultHeadcount() {
        int target = 0;

        List<WebElement> elements = driver.findElements(reserveHeadcount);
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).isSelected()) {
                target = i;
            }
        }

        return elements.get(target).getAttribute("value");

    }

    public Boolean getDefaultBf() {
        WebElement element_on = driver.findElement(reserveBf_on);
        if (element_on.isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    public int getDefaultPlan() {
        WebElement element_a = driver.findElement(reservePlan_a);
        WebElement element_b = driver.findElement(reservePlan_b);

        if (element_a.isSelected()) {

            if (element_b.isSelected()) {
                return 2;
            } else {
                return 0;
            }

        } else if (element_b.isSelected()) {
            return 1;
        } else {
            return 3;
        }
    }

    public String getDefaultGuestname() {
        WebElement element = driver.findElement(reserveGuestname);
        return element.getAttribute("value");
    }


    public ReserveConfirmPage goToNext() {
        driver.findElement(goToNext).click();
        return new ReserveConfirmPage(driver);
    }

}

/*
public class ReserveInputPage {
    private final WebDriver driver;
    private final By reserveYear = By.id("reserve_year");
    private final By reserveMonth = By.id("reserve_month");
    private final By reserveDay = By.id("reserve_day");
    private final By reserveTerm = By.id("reserve_term");
    private final By reserveHeadcount = By.id("headcount");
    private final By reserveBf_on = By.id("breakfast_on");
    private final By reserveBf_off = By.id("breakfast_off");
    private final By reservePlan_a = By.id("plan_a");
    private final By reservePlan_b = By.id("plan_b");
    private final By reserveGuestname = By.id("guestname");
    private final By goToNext = By.id("goto_next");

    public ReserveInputPage(WebDriver driver) {
        this.driver = driver;
    }

    private void setReserveYear(String value) {
        WebElement element = driver.findElement(reserveYear);
        element.clear();
        element.sendKeys(value);
    }

    private void setReserveMonth(String value) {
        WebElement element = driver.findElement(reserveMonth);
        element.clear();
        element.sendKeys(value);
    }

    private void setReserveDay(String value) {
        WebElement element = driver.findElement(reserveDay);
        element.clear();
        element.sendKeys(value);
    }
    
    public void setReserveDate(String year, String month, String day) {
        setReserveYear(year);
        setReserveMonth(month);
        setReserveDay(day);
    }

    public void setReserveTerm(String value) {
        WebElement element = driver.findElement(reserveTerm);
        element.clear();
        element.sendKeys(value);
    }

    public void setReserveHeadcount(String value) {
        WebElement element = driver.findElement(reserveHeadcount);
        element.clear();
        element.sendKeys(value);
    }

    public void setReserveBf(Boolean on) {
        WebElement element_on = driver.findElement(reserveBf_on);
        WebElement element_off = driver.findElement(reserveBf_off);
        if (on) {
            element_on.click();
        } else {
            element_off.click();
        }
    }

    public void setReservePlan(int plan) {
        WebElement element_a = driver.findElement(reservePlan_a);
        WebElement element_b = driver.findElement(reservePlan_b);

        switch (plan) {
            case 0:
                element_a.click();
                break;
            case 1:
                element_b.click();
                break;
            case 2:
                element_a.click();
                element_b.click();
                break;
            default:
                break;
        }
    }

    public void setReservePlan_a(Boolean on) {
        WebElement element_a = driver.findElement(reservePlan_a);
    }

    public void setReservePlan_b(Boolean on) {
        WebElement element_b = driver.findElement(reservePlan_b);
    }

    public void setReserveGuestname(String value) {
        WebElement element = driver.findElement(reserveGuestname);
        element.clear();
        element.sendKeys(value);
    }

    public ReserveConfirmPage goToNext() {
        driver.findElement(goToNext).click();
        return new ReserveConfirmPage(driver);
    }


}
*/
