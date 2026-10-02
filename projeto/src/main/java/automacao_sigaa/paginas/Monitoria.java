package automacao_sigaa.paginas;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Monitoria extends metodos {

    public void inscreverSeEmSelecaoDeMonitoria() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        navegarMenuDiscente("monitoria", "inscrever-se em seleção de monitoria");
        WebElement elementoSelect = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select[name='busca:tipo']")));
        new Select(elementoSelect).selectByIndex(1);
        clicarBuscar();
        voltarAoMenuPrincipal();
    }

    public void consultarProjetos() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        navegarMenuDiscente("monitoria", "consultar projetos");
        WebElement elementoSelect = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select[name='busca:tipo']")));
        new Select(elementoSelect).selectByIndex(1);
        clicarBuscar();
        voltarAoMenuPrincipal();
    }

    public void meusCertificados() {
        visualizarOpcaoSubSubMenu("certificados de projetos");
        voltarAoMenuPrincipal();
        navegarMenuDiscente("monitoria", "meus certificados");
        visualizarOpcaoSubSubMenu("certificados do sid");
        voltarAoMenuPrincipal();
    }

    public void navegarMonitoria() {
        inscreverSeEmSelecaoDeMonitoria();
        consultarProjetos();
        meusCertificados();
    }
}
