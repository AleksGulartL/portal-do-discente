package automacao_sigaa.paginas;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class metodos extends Elementos {

    public void logarSigaa(String usuario, String senha) {
        driver.findElement(campoUsuario).sendKeys(usuario);
        driver.findElement(campoSenha).sendKeys(senha);
        driver.findElement(botaoLogin).click();
    }

    public void navegarMenuDiscente(String opcaoDeNavegacao, String acessar) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> elementos = driver.findElements(classeMenu);
        for (WebElement elemento : elementos) {
            String textoElemento = elemento.getText().trim().toLowerCase();
            if (textoElemento.equalsIgnoreCase(opcaoDeNavegacao.toLowerCase())) {
                elemento.click();
                List<WebElement> submenus = driver.findElements(classeSubmenu);
                for (WebElement submenu : submenus) {
                    String submenuTexto = submenu.getText().trim();
                    if (submenuTexto.equalsIgnoreCase(acessar)) { 
                        wait.until(ExpectedConditions.elementToBeClickable(submenu)).click();
                        if (acessar.equalsIgnoreCase("Emitir Atestado de Matrícula")) {
                            driver.findElement(botaoAtestadoMatricula).click();
                        }
                        return;
                    }
                }
                break;
            }
        }
    }

    public void voltarAoMenuPrincipal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(voltarParaMenuPrincipal)).click();
    }

   

    public void visualizarOpcaoSubSubMenu(String opcao) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> subsubMenus = driver.findElements(classeSubSubMenuSuspenso);
        for (WebElement subsubMenu : subsubMenus) {
            String subsubmenuText = subsubMenu.getText().trim();
            if (subsubmenuText.equalsIgnoreCase(opcao)) {
                wait.until(ExpectedConditions.elementToBeClickable(subsubMenu)).click();
                break;
            }
        }
    }


   




}
