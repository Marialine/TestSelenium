package ExercicioAutomacao2;

import com.sun.xml.internal.ws.policy.sourcemodel.AssertionData;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;

@RunWith(JUnit4.class)


    public class SignTest {

    private WebDriver navegador;

        @Before
        public void setUp() {
            System.setProperty("webdriver.chrome.driver","/Users/marialine.campos/Documents/Projetos_Aprendizado_Automacao/LicaoDeCasaMaven/src/test/java/resources/chromedriver.exe");
            navegador = new ChromeDriver( );
            navegador.get("https://the-internet.herokuapp.com/login");

        }

        @After
        public void tchau(){
            navegador.close();
    }

        @Test
        public void  login(){
            navegador.findElement(By.id("username")).clear();
            navegador.findElement(By.id("username")).sendKeys("tomsmith");
            navegador.findElement(By.id("password")).clear();
            navegador.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
            navegador.findElement(By.className("radius")).click();

            String URL = navegador.getCurrentUrl();
            Assert.assertEquals(URL,"https://the-internet.herokuapp.com/secure");
        }

        @Test
        public void logininvalido(){
            navegador.findElement(By.id("username")).clear();
            navegador.findElement(By.id("username")).sendKeys("tomsmith");
            navegador.findElement(By.id("password")).clear();
            navegador.findElement(By.id("password")).sendKeys("test");
            navegador.findElement(By.className("radius")).click();

           Assert.assertEquals("Your username is invalid!", "Your username is invalid!");
        }

}
