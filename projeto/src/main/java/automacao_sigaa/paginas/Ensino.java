package automacao_sigaa.paginas;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ensino extends metodos {

    public void matriculaExtraordinaria(String campus, String cpf, String senha, String dataDeNascimento) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> subsubMenus = driver.findElements(classeSubSubMenuMatricula);
        for (WebElement subsubMenu : subsubMenus) {
            String subsubmenuText = subsubMenu.getText().trim();
            if (subsubmenuText.equalsIgnoreCase("Realizar Matrícula Extraordinária")) {
                wait.until(ExpectedConditions.elementToBeClickable(subsubMenu)).click();
                WebElement selectElementos = wait
                        .until(ExpectedConditions.presenceOfElementLocated(classeLugaresDisponiveis));
                Select lugaresDisponiveis = new Select(selectElementos);

                for (WebElement option : lugaresDisponiveis.getOptions()) {
                    if (option.getText().toUpperCase().contains(campus.toUpperCase())) {
                        lugaresDisponiveis.selectByVisibleText(option.getText());
                        driver.findElement(botaoBuscarMatricula).click();
                        wait.until(ExpectedConditions.elementToBeClickable(primeiraTurmaListagem)).click();
                        camposObrigatorios(cpf, dataDeNascimento, senha);
                        wait.until(ExpectedConditions.alertIsPresent()).accept();
                        voltarAoMenuPrincipal();
                        break;
                    }
                }

                break;
            }
        }
    }

    public void suspensaoDoPrograma(String cpf, String senha, String dataDeNascimento) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> subsubMenus = driver.findElements(classeSubSubMenuSuspenso);
        for (WebElement subsubMenu : subsubMenus) {
            String subsubmenuText = subsubMenu.getText().trim();
            if (subsubmenuText.equalsIgnoreCase("Suspensão Regular")) {
                wait.until(ExpectedConditions.elementToBeClickable(subsubMenu)).click();
                driver.findElement(estouCiente).click();
                driver.findElement(continuarSuspensao).click();
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

                if (necessitaCPF && cpf != null && !cpf.isBlank()) { 
                    driver.findElement(cpfMatricula).sendKeys(cpf);
                }

                if (necessitaDataNascimento && dataDeNascimento != null && !dataDeNascimento.isBlank()) {
                    driver.findElement(dataNascimentoMatricula).sendKeys(dataDeNascimento);
                }
                driver.findElement(senhaMatricula).sendKeys(senha);
                driver.findElement(confirmarSolicitacao).click();
                voltarAoMenuPrincipal();
            }
        }
    }

    public void trancamentoDeMatriculaCCR(String cpf, String senha, String dataDeNascimento, String acessar) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> subsubMenus = driver.findElements(classeSubSubMenuSuspenso);
        for (WebElement subsubMenu : subsubMenus) {
            String subsubmenuText = subsubMenu.getText().trim();
            if (subsubmenuText.equalsIgnoreCase("Trancar")) {
                wait.until(ExpectedConditions.elementToBeClickable(subsubMenu)).click();

                List<WebElement> checkboxes = driver.findElements(primeiroCCRListagem);
                for (WebElement checkbox : checkboxes) {
                    if (checkbox.isDisplayed() && checkbox.isEnabled()) {
                        checkbox.click();
                        break;
                    }
                }

                List<WebElement> motivos = driver.findElements(primeiroMotivo);
                for (WebElement motivo : motivos) {
                    if (motivo.isDisplayed() && motivo.isEnabled()) {
                        wait.until(ExpectedConditions.elementToBeClickable(motivo)).click();
                        break;
                    }
                }

                wait.until(ExpectedConditions.elementToBeClickable(botaoSolicitarTrancamento)).click();
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
                driver.findElement(confirmarSolicitacao).click();
                voltarAoMenuPrincipal();
            }
        }
    }
    public void consultasGerais(String acessar) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        visualizarOpcaoSubSubMenu(acessar);
        if (acessar.equalsIgnoreCase("Consultar Estrutura Curricular") || acessar.equalsIgnoreCase("Consultar Unidades Acadêmicas")) {

            WebElement elementoSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select[name='busca:curso']")));
            new Select(elementoSelect).selectByIndex(2);

        } else if (acessar.equalsIgnoreCase("Consultar Turma")) {

            WebElement elementoSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("form:selectUnidade")));
            new Select(elementoSelect).selectByIndex(2);
        }
        clicarBuscar();
    }
     
}
