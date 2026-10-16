package automacao_sigaa.paginas;

import java.time.Duration;
import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ensino extends metodos {

    public void consultarNotas() {
        navegarMenuDiscente("ensino", "Consultar Minhas Notas");
        voltarAoMenuPrincipal();
    }

    public void consultarIndiceAcademico() {
        navegarMenuDiscente("ensino", "Consultar Índices Acadêmicos");
        voltarAoMenuPrincipal();
    }

    public void emitirAtestadoDeMatricula() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        navegarMenuDiscente("ensino", "emitir atestado de matrícula");
        wait.until(ExpectedConditions.elementToBeClickable(botaoAtestadoMatricula)).click();
        voltarAoMenuPrincipal();
    }

    public void emitirAtestadoDeMatriculaPeriodoSuplementar() {
        navegarMenuDiscente("ensino", " Emitir Atestadode Matrícula para Período Suplementar");
        voltarAoMenuPrincipal();
    }

    public void emitirHistoricoEdeclaracao() {
        navegarMenuDiscente("ensino", "emitir histórico");
        navegarMenuDiscente("ensino", "Emitir Declaração de Vínculo");
    }

    public void impressaoDiplomaDigital() {
        navegarMenuDiscente("ensino", "Impressão de Diploma Digital");
        voltarAoMenuPrincipal();
    }

    public void alunosAptosAColarGrau() {
        navegarMenuDiscente("ensino", "Alunos Aptos a Colar Grau");
        //////////
    }

    public void solicitarValidacaoDeDocumentosRegistroDeDiploma(String caminhoPdfEnsinoMedio,
            String caminhoPdfIdentificacao) {
        navegarMenuDiscente("ensino", "Solicitar Validação de Documentos para Registro de Diploma");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        File fileEnsinoMedio = new File(caminhoPdfEnsinoMedio);
        File fileIdentificacao = new File(caminhoPdfIdentificacao);

        if (!fileEnsinoMedio.exists()) {
            throw new IllegalArgumentException("Arquivo não encontrado: " + fileEnsinoMedio.getAbsolutePath());
        }
        if (!fileIdentificacao.exists()) {
            throw new IllegalArgumentException("Arquivo não encontrado: " + fileIdentificacao.getAbsolutePath());
        }

        WebElement campoEnsinoMedio = wait
                .until(ExpectedConditions.presenceOfElementLocated(inputComprovanteEnsinoMedio));
        campoEnsinoMedio.sendKeys(fileEnsinoMedio.getAbsolutePath());

        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//tr[th[contains(., 'Ensino Médio')]]//a[contains(text(), '" + fileEnsinoMedio.getName() + "')]")));

        WebElement campoIdentificacao = wait
                .until(ExpectedConditions.presenceOfElementLocated(inputDocumentoIdentificacao));
        campoIdentificacao.sendKeys(fileIdentificacao.getAbsolutePath());
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//tr[th[contains(., 'Identificação')]]//a[contains(text(), '" + fileIdentificacao.getName() + "')]")));

        wait.until(ExpectedConditions.elementToBeClickable(botaoSubmeterValidacaoDiploma)).click();

    }

    public void SolicitarAproveitamentoIncorporacaoEstudos() {
        navegarMenuDiscente("ensino", "Solicitar Aproveitamento/Incorporação de Estudos");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[id$=':opcaoAproveitamentoAutomatico']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[id$=':opcaoAproveitamentoManualInterno']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[id$=':opcaoAproveitamentoManualExterno']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='<< Voltar']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[id$=':opcaoIncorporacaoEstudos']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='<< Voltar']"))).click();
        voltarAoMenuPrincipal();
    }

    public void minhasSolicitacoesDeAproveitamento() {
        navegarMenuDiscente("ensino", "Minhas Solicitações de Aproveitamento");
        voltarAoMenuPrincipal();
    }

    public void AvaliaçaoInstitucional() {
        navegarMenuDiscente("ensino", "Avaliação Institucional");
        visualizarOpcaoSubSubMenu("Preencher a Avaliação Institucional");
        voltarAoMenuPrincipal();
        navegarMenuDiscente("ensino", "Avaliação Institucional");
        visualizarOpcaoSubSubMenu("Rever a Avaliação Anterior");
        voltarAoMenuPrincipal();
        navegarMenuDiscente("ensino", "Avaliação Institucional");
        visualizarOpcaoSubSubMenu("Consultar o Resultado da Avaliação");
        voltarAoMenuPrincipal();
        navegarMenuDiscente("ensino", "Avaliação Institucional");
        visualizarOpcaoSubSubMenu("Observações dos Docentes Sobre Minhas Turmas");
        voltarAoMenuPrincipal(); 
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
        if (acessar.equalsIgnoreCase("Consultar Estrutura Curricular")) {
            navegarMenuDiscente("ensino", "consultas gerais");
            visualizarOpcaoSubSubMenu(acessar);
            WebElement elementoSelect = wait
                    .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select[name='busca:curso']")));
            new Select(elementoSelect).selectByIndex(2);

        } else if (acessar.equalsIgnoreCase("Consultar Unidades Acadêmicas")) {
            navegarMenuDiscente("ensino", "consultas gerais");
            visualizarOpcaoSubSubMenu(acessar);
            WebElement elementoSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipo")));
            new Select(elementoSelect).selectByIndex(2);

        } else if (acessar.equalsIgnoreCase("Consultar Turma")) {
            navegarMenuDiscente("ensino", "consultas gerais");
            visualizarOpcaoSubSubMenu(acessar);
            WebElement elementoSelect = wait
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id("form:selectUnidade")));
            new Select(elementoSelect).selectByIndex(2);
        }
        clicarBuscar();
        voltarAoMenuPrincipal();
    }

    public void navegarEnsino() {
        matriculaExtraordinaria(campus, cpf, senha, dataDeNascimento);
        suspensaoDoPrograma(cpf, senha, dataDeNascimento);
        trancamentoDeMatriculaCCR(cpf, senha, dataDeNascimento, "trancar");
        consultasGerais("Consultar Estrutura Curricular");
        consultasGerais("Consultar Unidades Acadêmicas");
        consultasGerais("Consultar Turma");
        emitirAtestadoDeMatricula();
    }

}
