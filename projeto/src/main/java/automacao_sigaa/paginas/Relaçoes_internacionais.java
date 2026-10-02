package automacao_sigaa.paginas;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Relaçoes_internacionais extends metodos {
    public void realizar_inscricao() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        navegarMenuDiscente("relações internacionais", "mobilidade");

        WebElement subMenuEditais = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(
                        "//tr[contains(@class, 'ThemeOfficeMenuItem') and .//td[contains(text(), 'Editais de Mobilidade')]]")));
        actions.moveToElement(subMenuEditais).perform();

        try {
            ((JavascriptExecutor) driver).executeScript(
                    "var ev = new MouseEvent('mouseover', {bubbles: true, cancelable: true, view: window});" +
                            "arguments[0].dispatchEvent(ev);",
                    subMenuEditais);
        } catch (Exception ignored) {
        }

        WebElement opcaoInscricao = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(
                        "//tr[contains(@class, 'ThemeOfficeMenuItem') and .//td[contains(text(), 'Realizar Inscrição')]] | //td[contains(text(), 'Realizar Inscrição')]")));
        opcaoInscricao.click();
        clicarBuscar();
        voltarAoMenuPrincipal();
    }

    public void consultarSolicitacaoMobilidade() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        navegarMenuDiscente("relações internacionais", "mobilidade");

        WebElement subMenuEditais = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(
                        "//tr[contains(@class, 'ThemeOfficeMenuItem') and .//td[contains(text(), 'Editais de Mobilidade')]]")));
        actions.moveToElement(subMenuEditais).perform();

        try {
            ((JavascriptExecutor) driver).executeScript(
                    "var ev = new MouseEvent('mouseover', {bubbles: true, cancelable: true, view: window});" +
                            "arguments[0].dispatchEvent(ev);",
                    subMenuEditais);
        } catch (Exception ignored) {
        }

        WebElement opcaoInscricao = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(
                        "//tr[contains(@class, 'ThemeOfficeMenuItem') and .//td[contains(text(), 'Visualizar Inscrição/Processo de Mobilidade')]] | //td[contains(text(), 'Visualizar Inscrição/Processo de Mobilidade')]")));
        opcaoInscricao.click();
        clicarBuscar();
        voltarAoMenuPrincipal();
    }

    public void mobilidade(){
        realizar_inscricao();
        consultarSolicitacaoMobilidade();
    }

}
