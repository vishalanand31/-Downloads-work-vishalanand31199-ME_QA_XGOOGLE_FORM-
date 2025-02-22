 package demo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap; 

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestCases {
    ChromeDriver driver;

    @BeforeClass(alwaysRun = true)
    public void stratBrowser()
    {
        System.out.println("Constructor: TestCases");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

   
    @Test (alwaysRun = true)
    public  void testCase01() throws InterruptedException{

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try{
            driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");

            wait.until(ExpectedConditions.urlToBe("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        Thread.sleep(4000);

        WebElement inputTextbox1 = driver.findElement(By.xpath("//*[@id='mG61Hd']/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div[1]/div/div[1]/input"));

        inputTextbox1.sendKeys("Crio Learner");

        WebElement inputTextbox2 = driver.findElement(By.xpath("//*[@id='mG61Hd']/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/textarea"));

        long epochTime = System.currentTimeMillis() / 1000;
        String inputText = "I want to be the best QA Engineer! " + epochTime;

        inputTextbox2.sendKeys(inputText);

        //Thread.sleep(5000);
        // 4 automate
        WebElement automationExp = driver.findElement(By.xpath("(//div[@class='AB7Lab Id5V1'])[4]"));
        automationExp.click();
        Thread.sleep(5000);

        // 5
        WebElement javaCheckbox = driver.findElement(By.xpath("(//div[@class='uHMk6b fsHoPb'])[1]"));
        javaCheckbox.click();
        WebElement seleniumCheckbox = driver.findElement(By.xpath("(//div[@class='uHMk6b fsHoPb'])[2]"));
        seleniumCheckbox.click();
        WebElement testngCheckbox = driver.findElement(By.xpath("(//div[@class='uHMk6b fsHoPb'])[4]"));
        testngCheckbox.click();
        Thread.sleep(9000);
        // 6
        WebElement dropDown = driver.findElement(By.xpath("(//span[@class='vRMGwf oJeWuf'])[1]"));
        dropDown.click();
        Thread.sleep(4000);
        WebElement option = driver.findElement(By.xpath("(//span[@class='vRMGwf oJeWuf'])[8]"));
        option.click();
        Thread.sleep(8000);

        // 7
        // Get current date
        LocalDate currentDate = LocalDate.now();

        // Subtract 7 days
        LocalDate sevenDaysAgo = currentDate.minusDays(7);

        // Format the date as required (MM/dd/yyyy)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String sevenDaysAgoString = sevenDaysAgo.format(formatter);

        // Fill the date field
        WebElement dateField = driver.findElement(By.xpath("//input[@type='date']"));

        dateField.sendKeys(sevenDaysAgoString);

        Thread.sleep(5000);

        // 8
        // Get current time
        LocalTime currentTime = LocalTime.now();

        // Format the time as required (hh:mm)
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("hh:mm");
        String formattedTime = currentTime.format(formatter1);

        // Fill the time field
        WebElement timeField = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        timeField.sendKeys(formattedTime);
        Thread.sleep(8000);
        WebElement timeField2 = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
        timeField2.sendKeys(formattedTime);
        // Close the browser
        Thread.sleep(10000);

        // 9 their is not popup showing at the time of gradle run so I COMMENT THE CODE
        // driver.navigate().to("https://www.amazon.in");
        // Alert alert = driver.switchTo().alert();
        // alert.dismiss();
        // 10
        WebElement submit = driver.findElement(By.xpath("(//span[@class='NPEfkd RveJvd snByac'])[1]"));
        submit.click();

        Thread.sleep(3000);

        // 11
        // Verifying the content after submit the form
        WebElement finalCheck = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[3]"));
        
        String qwe = finalCheck.getText();
        if(qwe.contains("Thanks for your response"))
        System.out.println(finalCheck.getText());
        // Thread.sleep(1000);
    }

    @AfterClass(alwaysRun = true)
    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }





























































































































 // private static String IST(){
    //     long epochTime = 171057201L; // Exam Time
    //     // Convert epoch time to LocalDateTime in GMT
    //     LocalDateTime gmtDateTime = LocalDateTime.ofEpochSecond(epochTime / 1000, 0, ZoneOffset.UTC);

        
    //     // Convert GMT time to IST
    //     ZonedDateTime gmtZonedDateTime = ZonedDateTime.of(gmtDateTime, ZoneOffset.UTC);
    //     ZonedDateTime istZonedDateTime = gmtZonedDateTime.withZoneSameInstant(ZoneId.of("Asia/Kolkata"));
    //     LocalDateTime istDateTime = istZonedDateTime.toLocalDateTime();

    //     // Define the date-time format
    //     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    //     // Format the converted time
    //     String formattedISTDateTime = istDateTime.format(formatter);
    //     return formattedISTDateTime;
    // }

    // private String DATE(){

    //     LocalDate currentDate = LocalDate.now();
    //     LocalDate locateAfter7Days = currentDate.minusDays(7);
    //     DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/YYYY");
    //     String formattedDate = dateFormat.format(locateAfter7Days);
    
    //     System.out.println("Date After 7 Days:"+formattedDate); 
       
    //     return formattedDate;
    // }
    
    // public String Time(){
    //     LocalTime currentTime = LocalTime.now();
    //     DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm a");
    //     System.out.println("Time:=" +timeFormat.format(currentTime));
    //     return timeFormat.format(currentTime);
    // }

    // public static  void selectLearning(ChromeDriver driver,String str){
        
    //     HashMap<String, String> selectTextBox = new HashMap<String, String>();

    //     selectTextBox.put("java", "i30");
    //     selectTextBox.put("selenium", "i33");
    //     selectTextBox.put("testng", "i39");
    //     selectTextBox.put("springboot", "i36");

    //     WebElement selectCheackBox = WrapperMethods.wrap_findElement(driver, By.xpath("//div/label[@for='"+selectTextBox.get(str)+"']"));
    //     WrapperMethods.wrap_click(selectCheackBox);

    // }

    // public static void selectExperianceBtn(ChromeDriver driver , String exp){

    //     HashMap<String, String> selectRadio = new HashMap<String, String>();
    //     selectRadio.put("0_to_2", "0 - 2");
    //     selectRadio.put("3_to_5", "3 - 5");
    //     selectRadio.put("6_to_10", "6 - 10");
    //     selectRadio.put("10_more", "> 10");

           
    //     WebElement radioSelect = WrapperMethods.wrap_findElement(driver,By.xpath("//div[@aria-label='"+selectRadio.get(exp)+"']"));
    //     WrapperMethods.wrap_click(radioSelect);
        

    // }

    // private static String AddresSelect(ChromeDriver driver, String str){
      
    //     HashMap<String, String> addresSelect = new HashMap<String, String>();
    //     addresSelect.put("Mr","Mr");
    //     addresSelect.put("Ms", "Ms");
    //     addresSelect.put("Mrs", "Mrs");
    //     addresSelect.put("None", "Rather not say");
        
      
    //     return addresSelect.get(str);
    // }


}
