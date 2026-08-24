package automacao_sigaa.paginas;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;


public class Pesquisa extends metodos{
    public void projetoDePesquisa(String opcao) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        visualizarOpcaoSubSubMenu(opcao);
        if (opcao.equalsIgnoreCase("Consultar projetos")) {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='button'][value='Buscar']"))).click();
        }
    }
}
