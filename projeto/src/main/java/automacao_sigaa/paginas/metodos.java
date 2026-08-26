package automacao_sigaa.paginas;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
                        verificarEAcessarOpcao(acessar);
                        return;
                    }
                }
                break;
            }
        }
    }

    private void verificarEAcessarOpcao(String acessar) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if (acessar == null)
            return;

        switch (acessar.trim().toLowerCase()) {
            case "emitir atestado de matrícula":
                wait.until(ExpectedConditions.elementToBeClickable(botaoAtestadoMatricula)).click();
                break;

            case "consultar ações":
                clicarBuscar();
                break;

            case "inscrição on-line em ações de extensão":
                logarSigaa("aleksander.lopes", "Aleks15872704");
                break;

            case "consultar projetos":
                WebElement elementoSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select[name='formBusca:j_id_jsp_1232863066_761']")));
                new Select(elementoSelect).selectByIndex(1);
                clicarBuscar();
                break;
            
            case "inscrever-se em seleção de monitoria":
                WebElement elementoSelect2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select[name='busca:tipo'")));
                new Select(elementoSelect2).selectByIndex(1);
                clicarBuscar();
                break;
            
            case "plano de trabalho":
                visualizarOpcaoSubSubMenu("meus planos de trabalho");
                break;

            case "consultar ações associadas":
                WebElement elementoSelect3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select[name='formBusca:j_id_jsp_1232863066_761']")));
                new Select(elementoSelect3).selectByIndex(1);
                clicarBuscar();
                break;
        
            default:
                break;
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

    public void clicarBuscar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(botaoBuscarGenerico)).click();
    }
}
