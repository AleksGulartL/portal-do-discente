package automacao_sigaa.paginas;

import java.time.Duration;
import java.util.List;

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
                    if (submenuTexto.equalsIgnoreCase(acessar)) { // fazer com que ignore os acentos e caixa alta/baixa
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
        List<WebElement> subsubMenus = driver.findElements(classeSubSubMenuSuspensao);
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

    public void trancamentoDeMatriculaCCR(String cpf, String senha, String dataDeNascimento) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> subsubMenus = driver.findElements(classeSubSubMenuSuspensao);
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
            }
        }
    }

}

// matricula extraordinaria
// Suspensão do Programa
// Trancamento de Matrícula em CCR
