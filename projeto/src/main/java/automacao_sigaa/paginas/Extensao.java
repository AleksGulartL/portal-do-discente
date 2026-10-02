package automacao_sigaa.paginas;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Extensao extends metodos {

    public void consultarAcoes() {
        navegarMenuDiscente("extensão", "consultar ações");
        clicarBuscar();
        voltarAoMenuPrincipal();
    }

    public void consultarProjetos() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        navegarMenuDiscente("extensão", "consultar projetos");
        WebElement elementoSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("select[name='formBusca:j_id_jsp_1232863066_761']")));
        new Select(elementoSelect).selectByIndex(1);
        clicarBuscar();
        voltarAoMenuPrincipal();
    }

    public void consultarAcoesAssociadas() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        navegarMenuDiscente("extensão", "consultar ações associadas");
        WebElement elementoSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("select[name='form:buscaUnidade']")));
        new Select(elementoSelect).selectByIndex(1);
        clicarBuscar();
        voltarAoMenuPrincipal();
    }
    public void inscriçaoOnlineEmAçõesDeExtensao() {
        navegarMenuDiscente("extensão", "inscrição on-line em ações de extensão");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("input[id='formLoginCursosEventosExtensao:email")))
                .sendKeys(email);
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("input[id='formLoginCursosEventosExtensao:senha")))
                .sendKeys(senha);
        wait.until(ExpectedConditions.elementToBeClickable(botaoLogin)).click();
        voltarAoMenuPrincipal();
    }

    public void extensao(String opcao) {
        if (opcao == null)
            return;
        switch (opcao.trim().toLowerCase()) {
            case "consultar ações":
                consultarAcoes();
                break;
            case "Meus Planos de Trabalho":
                navegarMenuDiscente("extensao", "Meus Planos de Trabalho");
                voltarAoMenuPrincipal();
                break;
            case "Minhas Ações como Membro da Equipe":
                navegarMenuDiscente("extensao", "Minhas Ações como Membro da Equipe");
                voltarAoMenuPrincipal();
                break;
            case "Meus Relatórios":
                navegarMenuDiscente("extensao", "Meus Relatórios");
                voltarAoMenuPrincipal();
                break;
            case "Certificados e Declarações":
                navegarMenuDiscente("extensao", "Certificados e Declarações");
                voltarAoMenuPrincipal();
                break;
            case "Visualizar Resultados das Inscrições":
                navegarMenuDiscente("extensao", "Visualizar Resultados das Inscrições");
                break;
            case "inscrição on-line em ações de extensão":
                inscriçaoOnlineEmAçõesDeExtensao();
                break;
            default:
                navegarExtensao();
                break;
        }
    }

    

    public void navegarExtensao() {
        extensao("consultar ações");
        extensao("Meus Planos de Trabalho");
        extensao("Minhas Ações como Membro da Equipe");
        extensao("Meus Relatórios");
        extensao("Certificados e Declarações");
        extensao("Visualizar Resultados das Inscrições");
        extensao("inscrição on-line em ações de extensão");
    }
}
