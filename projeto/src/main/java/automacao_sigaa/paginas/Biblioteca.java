package automacao_sigaa.paginas;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Biblioteca extends metodos {
    String senhaBiblioteca = "123456";
    String senhaSigaa = "Mudar123";

    public void cadastroBiblioteca() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        navegarMenuDiscente("biblioteca", "Cadastrar para Utilizar os Serviços da Biblioteca");
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='Iniciar Cadastro >>']")),
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='senha1']"))));

        if (!driver.findElements(By.cssSelector("input[value='Iniciar Cadastro >>']")).isEmpty()) {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='checkbox']"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Iniciar Cadastro >>']")))
                    .click();
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='senha1']")))
                .sendKeys(senhaBiblioteca);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='senha2']")))
                .sendKeys(senhaBiblioteca);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input[id='senhaSigaa'], input[name='senhaSigaa'], input[value='senhaSigaa']")))
                .sendKeys(senhaSigaa);
        WebElement botao = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("input[value='Cadastrar'], input[value='Alterar']")));
        if ("Cadastrar".equalsIgnoreCase(botao.getAttribute("value"))) {
            botao.click();
        } else if ("Alterar".equalsIgnoreCase(botao.getAttribute("value"))) {
            botao.click();
        }
        voltarAoMenuPrincipal();
    }

    public void pesquisarMaterial() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        navegarMenuDiscente("biblioteca", "pesquisar material no acervo");
        WebElement elementoSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("select[name='formBuscaInternaMultiCampo:j_id_jsp_548632613_54']")));
        new Select(elementoSelect).selectByIndex(1);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Pesquisar']"))).click();
        voltarAoMenuPrincipal();
    }

    public void pesquisarArtigo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        navegarMenuDiscente("biblioteca", "pesquisar artigo no acervo");
        WebElement campoTituloArtigo = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input[name='formBuscaInternaArtigos:inputTextTituloArtigo']")));
        campoTituloArtigo.sendKeys("");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Pesquisar']"))).click();
        voltarAoMenuPrincipal();
    }

    public void emprestimos() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        visualizarOpcaoSubSubMenu("visualizar empréstismos ativos");
        voltarAoMenuPrincipal();
        navegarMenuDiscente("biblioteca", "empréstimos");
        visualizarOpcaoSubSubMenu("renovar meus empréstimos");
        voltarAoMenuPrincipal();
        navegarMenuDiscente("biblioteca", "empréstimos");
        visualizarOpcaoSubSubMenu("agendamento de empréstimo");
        voltarAoMenuPrincipal();
        navegarMenuDiscente("biblioteca", "empréstimos");
        visualizarOpcaoSubSubMenu("meu histórico de empréstimos");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='Emitir Histórico']")))
                .click();
        voltarAoMenuPrincipal();
    }

    public void cadastrarInteresseAcervo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        visualizarOpcaoSubSubMenu("cadastrar interesse");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input[name='formMeuPerfilDeInteresse:checkReceberInformativoMensal']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input[name='formMeuPerfilDeInteresse:cmdAtualizarPerfil']"))).click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        voltarAoMenuPrincipal();
    }

    public void informacoesAosUsuarios() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        visualizarOpcaoSubSubMenu("visualizar meus vínculos no sistema");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='<< Voltar']"))).click();
        navegarMenuDiscente("biblioteca", "informações aos usuários");
        visualizarOpcaoSubSubMenu("visualizar as politicas de empréstimo");
        voltarAoMenuPrincipal();
    }

    public void compraDeLivros() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        navegarMenuDiscente("biblioteca", "Compras de Livro");
        visualizarOpcaoSubSubMenu("solicitar compra de livros");
        wait.until(ExpectedConditions.urlContains("sipac"));
        driver.navigate().back();
        wait.until(ExpectedConditions.urlContains("discente.jsf"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(classeMenu));
        navegarMenuDiscente("biblioteca", "Compras de Livro");
        visualizarOpcaoSubSubMenu("Acompanhar Solicitações de Compra de Livros");
        wait.until(ExpectedConditions.urlContains("sipac"));
        driver.navigate().back();
        wait.until(ExpectedConditions.urlContains("discente.jsf"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(classeMenu));
    }

    public void navegarBiblioteca() {
        cadastroBiblioteca();
        pesquisarMaterial();
        pesquisarArtigo();
        emprestimos();
        cadastrarInteresseAcervo();
        informacoesAosUsuarios();
        compraDeLivros();
    }
}
