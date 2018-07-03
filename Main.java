package com.company;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        method1();
    }
    public static void method1(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ori\\IdeaProjects\\browserAutomationNewsWebsite\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.dailynews.co.zw/articles/news");
        WebElement leadTitle =  driver.findElement(By.className("lead"));
        List <WebElement> otherTitles= driver.findElements(By.className("article-row"));
        otherTitles.add(0, leadTitle);

        System.out.println(leadTitle.getText());

        for(WebElement eachElement:otherTitles){
            System.out.println(eachElement.getText());
        }
        forward(leadTitle, otherTitles);

        System.out.println("page Title: " + driver.getTitle());
        System.out.println("Current URl: " + driver.getCurrentUrl());
        System.out.println("Length of page Source: " + driver.getPageSource().toString().length());

        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }

        driver.close();
    }
    public static void forward(WebElement leadTitle, List<WebElement> otherTitles){
        ArrayList<String> allInOne = new ArrayList<String>();

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ori\\IdeaProjects\\autotest\\chromedriver.exe");
        WebDriver driver1 = new ChromeDriver();

        driver1.get("localhost:8000");
        WebElement divLead = driver1.findElement(By.id("leadTitle"));
        divLead.sendKeys(leadTitle.getText());

        for(WebElement eachElement:otherTitles) {
            String eachDiv = eachElement.getText();
            allInOne.add(eachDiv);
        }
        WebElement otherDivs = driver1.findElement(By.id("otherTitles"));
        otherDivs.sendKeys(allInOne.toString());


//        WebElement allDiv = driver.findElement(By.id("all"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        for(WebElement eachElement:otherTitles){
//            String eachDiv = eachElement.getText();
//            js.executeScript("var node = document.createElement('DIV');");
//            js.executeScript("var textNode = document.createTextNode('this is the frist div that i am gonna create');");
//            js.executeScript("node.appendChild(textNode);");
//            js.executeScript("document.getElementById('all').appendChild(node);");
//
//        }


    }
}
