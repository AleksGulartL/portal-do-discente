package automacao_sigaa.paginas;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Outros extends metodos {

    public void buscarComunidade() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        navegarMenuDiscente("outros", "Ambientes Virtuais");
        WebElement subMenuOutros = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(
                        "//tr[contains(@class, 'ThemeOfficeMenuItem') and .//td[contains(text(), 'Comunidades Virtuais')]]")));
        actions.moveToElement(subMenuOutros).perform();

        try {
            ((JavascriptExecutor) driver).executeScript(
                    "var ev = new MouseEvent('mouseover', {bubbles: true, cancelable: true, view: window});" +
                            "arguments[0].dispatchEvent(ev);",
                    subMenuOutros);
        } catch (Exception ignored) {
        }

        WebElement opcaoComunidade = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(
                        "//tr[contains(@class, 'ThemeOfficeMenuItem') and .//td[contains(text(), 'Buscar Comunidades Virtuais')]] | //td[contains(text(), 'Buscar Comunidades Virtuais')]")));
        opcaoComunidade.click();
        clicarBuscar();
        voltarAoMenuPrincipal();

    }

    public void minhasComunidades() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        navegarMenuDiscente("outros", "Ambientes Virtuais");
        WebElement subMenuOutros = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(
                        "//tr[contains(@class, 'ThemeOfficeMenuItem') and .//td[contains(text(), 'Comunidades Virtuais')]]")));
        actions.moveToElement(subMenuOutros).perform();

        try {
            ((JavascriptExecutor) driver).executeScript(
                    "var ev = new MouseEvent('mouseover', {bubbles: true, cancelable: true, view: window});" +
                            "arguments[0].dispatchEvent(ev);",
                    subMenuOutros);
        } catch (Exception ignored) {
        }

        WebElement opcaoComunidade = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(
                        "//tr[contains(@class, 'ThemeOfficeMenuItem') and .//td[contains(text(), 'Minhas Comunidades')]] | //td[contains(text(), 'Minhas Comunidades')]")));
        opcaoComunidade.click();
        voltarAoMenuPrincipal();

    }

    public void ambientesVirtuais() {
        minhasComunidades();
        buscarComunidade();
    }

    public void notificarAusenciaProfessor() {
        navegarMenuDiscente("outros", "avisar ausência do professor");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement elementoSelect = wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(By.cssSelector("select[name='formDenuncia:disciplina']")));
        new Select(elementoSelect).selectByIndex(1);
        WebElement elementoSelect2 = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select[name='formDenuncia:docente']")));
        new Select(elementoSelect2).selectByIndex(1);
        WebElement elementoSelect3 = wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(By.cssSelector("select[name='formDenuncia:data']")));
        new Select(elementoSelect3).selectByIndex(1);
        WebElement campoObservacao = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("textarea[name='formDenuncia:observacao']")));
        campoObservacao.sendKeys("Professor ausente");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='formDenuncia:btn_notificar']")))
                .click();

        voltarAoMenuPrincipal();

    }

    public void validarEmail() {
        navegarMenuDiscente("outros", "validar e-mail");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='formValidaEmail:btn_enviar']")))
                .click();
        voltarAoMenuPrincipal();
    }

    public void atendimentoAoAluno() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        navegarMenuDiscente("outros", "coordenação de curso");
        visualizarOpcaoSubSubMenu("atendimento ao aluno");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id='novaPergunta:titulo']"))).click();
        WebElement campoTitulo = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='novaPergunta:titulo']")));
        campoTitulo.sendKeys("Teste");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("textarea[id='novaPergunta:pergunta']")))
                .click();
        WebElement campoPergunta = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[id='novaPergunta:pergunta']")));
        campoPergunta.sendKeys("Teste");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id='novaPergunta:gravar']"))).click();
        voltarAoMenuPrincipal();
    }

    public void forumDeCursos() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        navegarMenuDiscente("outros", "coordenação de curso");
        visualizarOpcaoSubSubMenu("fórum de cursos");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#listagem > div.infoAltRem > a"))).click();
        WebElement campoTitulo = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='form:titulo']")));
        campoTitulo.sendKeys("Teste");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("textarea[id='form:descricao']"))).click();
        WebElement campoPergunta = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[id='form:descricao']")));
        campoPergunta.sendKeys("Teste");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id='form:cadTopicos']"))).click();
        voltarAoMenuPrincipal();
    }

    public void paginaDoCurso() {
        String abaOriginal = driver.getWindowHandle();
        navegarMenuDiscente("outros", "coordenação de curso");
        visualizarOpcaoSubSubMenu("página do curso");
        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }  
        fecharAbaEVoltarParaAnterior(abaOriginal);
        voltarAoMenuPrincipal();
    }

    public void coordenacaoDeCurso() {
        atendimentoAoAluno();
        forumDeCursos();
        paginaDoCurso();
    }

    public void entrarEmContato() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        navegarMenuDiscente("outros", "ouvidoria");
        visualizarOpcaoSubSubMenu("entrar em contato");
        // WebElement elementoSelect = wait.until(
        //         ExpectedConditions
        //                 .visibilityOfElementLocated(By.cssSelector("select[id='formManifestacao:categoria']")));
        // new Select(elementoSelect).selectByIndex(1);
        // WebElement elementoSelect2 = wait.until(
        //         ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select[id='formManifestacao:assunto']")));
        // new Select(elementoSelect2).selectByIndex(1);
        WebElement campoTitulo = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("input[id='formManifestacao:titulo']")));
        campoTitulo.sendKeys("Teste");
        WebElement campoMensagem = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("textarea[id='formManifestacao:mensagem']")));
        campoMensagem.sendKeys("Teste");
        // wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='formManifestacao:btn_notificar']"))).click(); 
        voltarAoMenuPrincipal();
    }
    public void acompanharManifestaçoes(){
        navegarMenuDiscente("outros", "ouvidoria");
        visualizarOpcaoSubSubMenu("acompanhar manifestações");
        voltarAoMenuPrincipal();
    }

    public void ouvidoria(){
        entrarEmContato();
        acompanharManifestaçoes();
    }

    public void acervoDosDocentes(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        navegarMenuDiscente("outros", "produções intelectuais");
        visualizarOpcaoSubSubMenu("acervo dos docentes");
        WebElement elementoSelect = wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(By.cssSelector("select[id='formBusca:departamento']")));
        new Select(elementoSelect).selectByVisibleText("COORDENAÇÃO ACADÊMICA - CHAPECÓ");
        clicarBuscar();
        voltarAoMenuPrincipal();
    }

    public void consultarDefesas(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        navegarMenuDiscente("outros", "produções intelectuais");
        visualizarOpcaoSubSubMenu("Consultar Defesas de Pós-graduação");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id='formulario:checkPrograma']"))).click();
        clicarBuscar();
        voltarAoMenuPrincipal();
    }

    public void producoesIntelectuais(){
        acervoDosDocentes();
        consultarDefesas();
    }

    public void auxilioFinanceiroAssinaturaDocumentosSIPAC(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        navegarMenuDiscente("outros", "auxílio financeiro/assinatura de documentos no sipac");
        wait.until(ExpectedConditions.urlContains("sipac"));
        driver.navigate().back();
        wait.until(ExpectedConditions.urlContains("discente.jsf"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(classeMenu));
        voltarAoMenuPrincipal();
    }


    public void psicologia(){
        navegarMenuDiscente("outros", "psicologia");
        visualizarOpcaoSubSubMenu("Inscrições para Atividades em Grupo");
        voltarAoMenuPrincipal();
        navegarMenuDiscente("outros","psicologia");
        visualizarOpcaoSubSubMenu("Confirmar Presença em Entrevista");
        voltarAoMenuPrincipal();
    }

    public void atendimentoMedicoOdontologico(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        navegarMenuDiscente("outros", "Atendimento Médico/Odontológico");
        visualizarOpcaoSubSubMenu("Solicitar Atendimento Médico/Odontológico");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#conteudo > center > a"))).click();
        navegarMenuDiscente("outros", "atendimento médico/odontológico");
        visualizarOpcaoSubSubMenu("acompanhar solicitação");
        voltarAoMenuPrincipal();
    }

    public void RelatoriodeCargaHorariaDocente(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        navegarMenuDiscente("outros", "Relatório de Carga Horária Docente");
        WebElement docente = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='form:nomeDocente']")));
        docente.sendKeys("Teste");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id='form:btnGerar']"))).click();
        voltarAoMenuPrincipal();
    }

    public void criarSenhaDeAcesso(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        navegarMenuDiscente("outros", "Criar senha de acesso por Celular");
        WebElement campoSenha = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='senha1']")));
        campoSenha.sendKeys("123456");
        WebElement campoConfirmacaoSenha = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='senha2']")));
        campoConfirmacaoSenha.sendKeys("123456");

        //mudar a senha de acordo com a senha do sigaa para o teste funcionar 
        WebElement sigaaSenha = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='senhaSigaa']")));
        sigaaSenha.sendKeys("Mudar123");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Criar senha']"))).click();
        voltarAoMenuPrincipal();
    }

    public void ConsultarProcessosdoAluno(){
        navegarMenuDiscente("outros", "Consultar Processos do Aluno");
        voltarAoMenuPrincipal();
    }

    public void mesarioVoluntario(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        navegarMenuDiscente("outros", "mesário voluntário");
        WebElement tituloEleitor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='j_id_jsp_1393923095_1:tituloEleitor']")));
        tituloEleitor.sendKeys("999999999999");
        WebElement zonaEleitoral = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='j_id_jsp_1393923095_1:zona']")));
        zonaEleitoral.sendKeys("9999");
        WebElement secaoEleitoral = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='j_id_jsp_1393923095_1:secao']")));
        secaoEleitoral.sendKeys("9999");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Inscrever-se']"))).click();
        voltarAoMenuPrincipal();
    }

    public void dossieEletronico(){
        navegarMenuDiscente("outros", "dossiê eletrônico do aluno");
        voltarAoMenuPrincipal();
    }

    public void navegarOutros() {
        ambientesVirtuais();
        notificarAusenciaProfessor();
        validarEmail();
        coordenacaoDeCurso();
        ouvidoria();
        producoesIntelectuais();
        auxilioFinanceiroAssinaturaDocumentosSIPAC();
        psicologia();
        atendimentoMedicoOdontologico();
        RelatoriodeCargaHorariaDocente();
        criarSenhaDeAcesso();
        ConsultarProcessosdoAluno();
        mesarioVoluntario();
        dossieEletronico();
    }

}
