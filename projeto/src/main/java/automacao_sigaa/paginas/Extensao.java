package automacao_sigaa.paginas;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

public class Extensao extends metodos {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public void navegarExtensao(String opcao) {
        visualizarOpcaoSubSubMenu(opcao); 
        if (opcao.equalsIgnoreCase("consultar ações")) {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='submit'][value='Buscar']"))).click();
        }   
        
    }
   
}
