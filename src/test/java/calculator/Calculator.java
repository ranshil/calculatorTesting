package calculator;

import org.junit.Assert;
import pageObjects.CalculatorPage;

import java.util.Stack;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static scenarios.FunctionalTest.historyCalcStack;

public class Calculator {

    CalculatorPage calculatorPage;


    public Calculator(CalculatorPage calculatorPage){
        this.calculatorPage = calculatorPage;
    }

    public double addition(int a, int b) throws InterruptedException {

        assertTrue(calculatorPage.isInitialized());
        calculatorPage.pressClear();
        calculatorPage.insertNumber(a);
        calculatorPage.pressAdd();
        calculatorPage.insertNumber(b);
        calculatorPage.pressEquals();
        historyCalcStack.push(calculatorPage.getResultString());
        return calculatorPage.readResult();
    }

    public double subtraction(int a, int b) throws InterruptedException {

        assertTrue(calculatorPage.isInitialized());
        calculatorPage.pressClear();
        calculatorPage.insertNumber(a);
        calculatorPage.pressSubtract();
        calculatorPage.insertNumber(b);
        calculatorPage.pressEquals();
        historyCalcStack.push(calculatorPage.getResultString());
        return calculatorPage.readResult();
    }

    public double complexEquation(int a, int b) throws InterruptedException {

        assertTrue(calculatorPage.isInitialized());
        calculatorPage.pressClear();
        calculatorPage.pressLeftParentheses();
        calculatorPage.insertNumber(a);
        calculatorPage.pressSubtract();
        calculatorPage.insertNumber(b);
        calculatorPage.pressRightParentheses();
        calculatorPage.pressMultiply();
        calculatorPage.insertNumber(b);
        calculatorPage.pressEquals();
        historyCalcStack.push(calculatorPage.getResultString());
        return calculatorPage.readResult();
    }

    public double sin(int a) throws InterruptedException {
        assertTrue(calculatorPage.isInitialized());
        calculatorPage.pressClear();
        calculatorPage.pressSin();
        calculatorPage.insertNumber(a);
        calculatorPage.pressEquals();
        historyCalcStack.push(calculatorPage.getResultString());
        return calculatorPage.readResult();
    }

    public void verifyHistory(Stack<String> historyCalcStack) {
        Assert.assertTrue(calculatorPage.isInitialized());
        calculatorPage.pressHistory();
        Stack<String> history = calculatorPage.readHistory();
        for (String s : history) {
            assertEquals(s, historyCalcStack.pop());
        }
    }
}
