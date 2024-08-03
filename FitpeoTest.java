import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class FitpeoTest {
    public static void main(String[] args){
        //Navigate to the FitPeo Homepage:
        //Open the web browser and navigate to FitPeo Homepage.
        System.setProperty("webdriver.chrome.driver","C:\\Users\\nooka\\Desktop\\chromedriver-win32 (3)\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.fitpeo.com/");

        //Navigate to the Revenue Calculator Page:
        //From the homepage, navigate to the Revenue Calculator Page.

        WebElement navBarEle=driver.findElement(By.className("MuiButtonBase-root"));
        navBarEle.click();
        WebElement revenueCalEle=driver.findElement(By.xpath("//span[text()='Revenue Calculator']"));
        Actions action=new Actions(driver);
        action.moveToElement(navBarEle);
        action.click(revenueCalEle);
        action.build().perform();
        //Scroll Down to the Slider section:
        //Scroll down the page until the revenue calculator slider is visible.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 500);");
        //Adjust the Slider:
        //Adjust the slider to set its value to 820. we’ve highlighted the slider in red color, Once the slider is moved the bottom text field value should be updated to 820
        WebElement sliderEl=driver.findElement(By.cssSelector("span.MuiSlider-thumb"));
        Point point=sliderEl.getLocation();
        action.dragAndDropBy(sliderEl,94,0).perform();
        //Update the Text Field:
        //Click on the text field associated with the slider.
        //Enter the value 560 in the text field. Now the slider also should change accordingly

        WebElement textFieldEl=driver.findElement(By.cssSelector("input[type='number']"));
        js.executeScript("arguments[0].value='560'",textFieldEl);
        //Select CPT Codes:
        //Scroll down further and select the checkboxes for CPT-99091, CPT-99453, CPT-99454, and CPT-99474.
        List<WebElement> cptCodes=driver.findElements(By.cssSelector("div.css-1p19z09> *>p:first-of-type"));
        List<WebElement> checkBoxes=driver.findElements(By.cssSelector("div.css-1p19z09> *>label input"));
        for (int i=0;i<cptCodes.size();i++){
            //System.out.println(1);
            String code=cptCodes.get(i).getText();
            if(code.equals("CPT-99091") || code.equals("CPT-99453")||code.equals("CPT-99454")||code.equals("CPT-99474")){

                checkBoxes.get(i).click();
                //System.out.println(1);

                //System.out.println(1);
            }
        }
        //Validate Total Recurring Reimbursement:
        //Verify that the header displaying Total Recurring Reimbursement for all Patients Per Month: shows the value $110700.

        WebElement totalRecurringReimbursement=driver.findElement(By.cssSelector("div.css-m1khva>p:nth-of-type(2)"));
        String total= totalRecurringReimbursement.getText();
        String expecectedTotal="$110700";
        if(total.equals(expecectedTotal)){
            System.out.println(true);
        }else{
            System.out.println(false);
        }




        }

    }

