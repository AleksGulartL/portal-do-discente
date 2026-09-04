package automacao_sigaa.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Monitoria extends metodos {

    public void consultarProjetos() {
        WebElement elementoSelect = driver.findElement(By.cssSelector("select[name='busca:tipo']"));
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
