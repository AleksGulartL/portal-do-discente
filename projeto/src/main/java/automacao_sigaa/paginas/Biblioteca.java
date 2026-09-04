package automacao_sigaa.paginas;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Biblioteca extends metodos {
    public void cadastroBiblioteca(String senhaBiblioteca, String senhaSigaa) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='checkbox']"))).click();
        driver.findElement(By.cssSelector("input[value='Iniciar Cadastro >>']")).click();
        driver.findElement(By.cssSelector("input[name='senha1']")).sendKeys(senhaBiblioteca);
        driver.findElement(By.cssSelector("input[name='senha2']")).sendKeys(senhaBiblioteca);
        driver.findElement(By.cssSelector("input[value='senhaSigaa']")).sendKeys(senhaSigaa);
        driver.findElement(By.cssSelector("input[value='Cadastrar']")).click();
    }

    public void pesquisarArtigo(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement campoTituloArtigo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='formBuscaInternaArtigos:inputTextTituloArtigo']")));
        campoTituloArtigo.sendKeys("");
        driver.findElement(By.cssSelector("input[value='Pesquisar']")).click();
    } 

    public void emprestimos(){
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='Emitir Histórico']"))).click();
    }

    public void cadastrarInteresseAcervo(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        visualizarOpcaoSubSubMenu("cadastrar interesse");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='formMeuPerfilDeInteresse:checkReceberInformativoMensal']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='formMeuPerfilDeInteresse:cmdAtualizarPerfil']"))).click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    public void informacoesAosUsuarios(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        visualizarOpcaoSubSubMenu("visualizar meus vínculos no sistema");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='<< Voltar']"))).click();
        navegarMenuDiscente("biblioteca", "informações aos usuários");
        visualizarOpcaoSubSubMenu("visualizar as politicas de empréstimo");

    }

    // public void compraDeLivros(){
    //     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    //     visualizarOpcaoSubSubMenu("solicitar compra de livros");
    // } 
    // leva ao sipac, então deixei comentado

    




}
