package automacao_sigaa.paginas;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Biblioteca extends metodos {
    public void cadastroBiblioteca(String senhaBiblioteca, String senhaSigaa) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='checkbox']"))).click();
        driver.findElement(By.cssSelector("input[value='Iniciar Cadastro >>']")).click();
        driver.findElement(By.cssSelector("input[name='senha1']")).sendKeys(senhaBiblioteca);
        driver.findElement(By.cssSelector("input[name='senha2']")).sendKeys(senhaBiblioteca);
        driver.findElement(By.cssSelector("input[value='senhaSigaa']")).sendKeys(senhaSigaa);
        driver.findElement(By.cssSelector("input[value='Cadastrar']")).click();
    } 

}
