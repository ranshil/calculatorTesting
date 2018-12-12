package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class CalculatorPage extends PageObject {

    @FindBy(id = "input")
    private WebElement inputBox;

    @FindBy(id = "BtnCalc")
    private WebElement btnCalc;

    @FindBy(id = "BtnPlus")
    private WebElement btnPlus;

    @FindBy(id = "BtnMinus")
    private WebElement btnMinus;

    @FindBy(id = "BtnMult")
    private WebElement btnMult;

    @FindBy(id = "BtnDiv")
    private WebElement btnDiv;

    @FindBy(id = "BtnClear")
    private WebElement btnClear;

    @FindBy(id = "result")
    private WebElement result;

    @FindBy(id = "BtnParanL")
    private WebElement btnParanL;

    @FindBy(id = "BtnParanR")
    private WebElement btnParanR;

    @FindBy(id = "BtnSin")
    private WebElement btnSin;

    @FindBy(xpath = "//*[@id='hist']/button[2]")
    private WebElement history;

    @FindBy(id = "histframe")
    private WebElement historyFrame;

    @FindBy(tagName = "h1")
    private WebElement header;

    @FindBy(xpath = "//*[@id='input']/@class)")
    private WebElement loadingResults;


    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isInitialized() {
        return ("Scientific Calculator".equals(header.getText()));
    }

    public void insertNumber(int num) {
        inputBox.sendKeys(Integer.toString(num));
    }

    public void pressClear() {
        btnCalc.click();
    }

    public void pressAdd() {
        btnPlus.click();
    }

    public void pressEquals() throws InterruptedException {
        btnCalc.click();
        sleep(1500);
            /* Should not be using sleep.
               Problem is that explicit wait in all its forms did not provide a solution.
            */
            // -- Examples --
            //   WebDriverWait wait = new WebDriverWait(driver, 5);
            //   wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//div/input/@class"),"loading") );
            //   wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div/input/[@class='loading']") )));


    }

    public double readResult() {
        String value = inputBox.getAttribute("value");
        return Double.parseDouble(value);
    }

    public void pressSubtract() {
        btnMinus.click();
    }

    public void pressLeftParentheses() {
        btnParanL.click();
    }

    public void pressRightParentheses() {
        btnParanR.click();
    }

    public void pressMultiply() {
        btnMult.click();
    }

    public void pressSin() {
        btnSin.click();
    }

    public void pressHistory() {
        history.click();
    }

    public String getResultString() {
        return result.getAttribute("title");
    }

    public Stack<String> readHistory() {
        List<WebElement> objList  = historyFrame.findElements(By.xpath("//ul/li/p[2][@title]"));
        Stack<String> historyStack = new Stack<>();

        for (WebElement item : objList) {
            historyStack.push(item.getText());
        }
        return historyStack;
    }


}
