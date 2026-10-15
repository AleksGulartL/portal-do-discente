package automacao_sigaa.paginas;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;

public class metodos extends Elementos {

    String usuario = "aleksander.lopes";
    String senha = "Aleks15872704";
    String email = "aleksander.lopes@estudante.uffs.edu.br";
    String cpf = "03854413041";
    String dataDeNascimento = "03112005";
    String campus = "Chapecó";

    public void aceitarCookiesSeVisivel() {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
            List<WebElement> botoes = driver.findElements(botaoCienteCookie);
            for (WebElement botao : botoes) {
                if (botao.isDisplayed()) {
                    botao.click();
                    break;
                }
            }
        } catch (Exception e) {
            
        } finally {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    public void fecharAvisoDeCookies() {
        aceitarCookiesSeVisivel();
    }

    public void logarSigaa() {
        aceitarCookiesSeVisivel();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoUsuario)).sendKeys(usuario);
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoSenha)).sendKeys(senha);
        wait.until(ExpectedConditions.elementToBeClickable(botaoLogin)).click();

    }

    // so é preciso no sigaa treinamentos
    public void logarSigaaTreinamentos(String usuario, String senha) {
        aceitarCookiesSeVisivel();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoUsuario)).sendKeys(usuario);
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoSenha)).sendKeys(senha);
        wait.until(ExpectedConditions.elementToBeClickable(botaoLogin)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"portais\"]/ul/li[2]"))).click();

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
                        return;
                    }
                }
                break;
            }
        }
    }

    public void voltarAoMenuPrincipal() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
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

    public void fecharAbaEVoltarParaAnterior(String janelaOriginal) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String janela : driver.getWindowHandles()) {
            if (!janela.equals(janelaOriginal)) {
                driver.switchTo().window(janela);
                break;
            }
        }
        driver.close();
        driver.switchTo().window(janelaOriginal);
    }

    public void camposObrigatorios(String cpf, String dataDeNascimento, String senha) {
        List<WebElement> elementosObrigatorios = driver.findElements(classeObrigatorio);
        boolean necessitaCPF = false;
        boolean necessitaDataNascimento = false;

        for (WebElement elementoObrigatorio : elementosObrigatorios) {
            String textoElementoObrigatorio = elementoObrigatorio.getText().trim();
            if (textoElementoObrigatorio.contains("CPF")) {
                necessitaCPF = true;
            } else if (textoElementoObrigatorio.contains("Data de Nascimento")) {
                necessitaDataNascimento = true;
            }
        }

        if (necessitaCPF && !cpf.isEmpty()) {
            driver.findElement(cpfMatricula).sendKeys(cpf);
        }

        if (necessitaDataNascimento && !dataDeNascimento.isEmpty()) {
            driver.findElement(dataNascimentoMatricula).sendKeys(dataDeNascimento);
        }

        driver.findElement(senhaMatricula).sendKeys(senha);
        driver.findElement(botaoConfirmarMatricula).click();
    }

}
