package automacao_sigaa.paginas;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Monitoria extends metodos {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void consultarProjetos() {
        WebElement elementoSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select[name='formBusca:j_id_jsp_1232863066_761']")));
        new Select(elementoSelect).selectByIndex(1);
        clicarBuscar();

    }
    public void meusCertificados() {
        visualizarOpcaoSubSubMenu("certificados de projetos");
        voltarAoMenuPrincipal();
        navegarMenuDiscente("monitoria", "meus certificados");
        visualizarOpcaoSubSubMenu("certificados do sid");


    }
        
    

}
