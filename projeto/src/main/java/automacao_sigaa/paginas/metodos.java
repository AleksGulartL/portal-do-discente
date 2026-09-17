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
            case "emitir atestado de matrícula": // ensino
                wait.until(ExpectedConditions.elementToBeClickable(botaoAtestadoMatricula)).click();
                break;

            case "consultar ações": // extensao
                clicarBuscar();
                break;

            case "inscrição on-line em ações de extensão": // extens
                logarSigaa("aleksander.lopes", "Aleks15872704");
                break;

            case "consultar projetos": // extensao
                WebElement elementoSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("select[name='formBusca:j_id_jsp_1232863066_761']")));
                new Select(elementoSelect).selectByIndex(1);
                clicarBuscar();
                voltarAoMenuPrincipal();
                break;

            case "inscrever-se em seleção de monitoria": // monitoria
                WebElement elementoSelect2 = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select[name='busca:tipo'")));
                new Select(elementoSelect2).selectByIndex(1);
                clicarBuscar();
                break;

            case "plano de trabalho": // pesquisa
                visualizarOpcaoSubSubMenu("meus planos de trabalho");
                break;

            case "consultar ações associadas": // açoes associadas 
                WebElement elementoSelect3 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("select[name='form:buscaUnidade']")));
                new Select(elementoSelect3).selectByIndex(1);
                clicarBuscar();
                break;

            case "pesquisar material no acervo": // biblioteca
                WebElement elementoSelect4 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("select[name='formBuscaInternaMultiCampo:j_id_jsp_548632613_54']")));
                new Select(elementoSelect4).selectByIndex(1);
                driver.findElement(By.cssSelector("input[value='Pesquisar']")).click();
                break;

            case "pesquisar artigo no acervo": // biblioteca
                WebElement campoTituloArtigo = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("input[name='formBuscaInternaArtigos:inputTextTituloArtigo']")));
                campoTituloArtigo.sendKeys("");
                driver.findElement(By.cssSelector("input[value='Pesquisar']")).click();
                break;

            case "oportunidades de bolsa": // bolsas
                WebElement elementoSelect5 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("select[name='busca:tipo']")));
                new Select(elementoSelect5).selectByIndex(1);
                clicarBuscar();
                break;

            default:
                break;
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
