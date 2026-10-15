package automacao_sigaa.paginas;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;

public class verificaçao extends metodos {

    public void aguardarCarregamentoDaPagina() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }

    public boolean validarUrlAtual(String fragmentoEsperado) {
        aguardarCarregamentoDaPagina();

        String urlCompleta = driver.getCurrentUrl();
        String caminhoAtual = urlCompleta.replace("https://sigaatre-tst.uffs.edu.br", "");
        String caminhoNormalizado = caminhoAtual.replaceAll("^/|/$", "");
        String fragmentoNormalizado = fragmentoEsperado.replaceAll("^/|/$", "");
        boolean contemFragmento = caminhoNormalizado.contains(fragmentoNormalizado);

        if (contemFragmento) {
            System.out.println("URL atual contém: " + fragmentoEsperado + "SUCESSO");
            return true;
        } else {
            System.err.println("URL NÃO contém: " + fragmentoEsperado +
                    " | URL completa: " + urlCompleta);
            return false;
        }
    }

    public boolean validarTituloDaPagina(String tituloEsperado) {
        aguardarCarregamentoDaPagina();
        return driver.getTitle().trim().equalsIgnoreCase(tituloEsperado);
    }

    public boolean validarMensagemNaTela(String textoDesejado) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//*[contains(text(), '" + textoDesejado + "') or contains(@value, '"
                                    + textoDesejado + "')]")));

            System.out.println("Mensagem " + textoDesejado + " encontrada na página.");
            return true;

        } catch (TimeoutException e) {
            System.err.println("Mensagem " + textoDesejado + " NÃO encontrada.");
            return false;
        }
    }

    public boolean existeErroSistemicoNaPagina() {
        String codigoFonte = driver.getPageSource().toLowerCase();
        boolean erro500 = codigoFonte.contains("http status 500") || codigoFonte.contains("internal server error");
        boolean erro404 = codigoFonte.contains("http status 404") || codigoFonte.contains("página não encontrada");
        boolean stacktrace = codigoFonte.contains("java.lang.nullpointerexception")
                || codigoFonte.contains("exception in thread");
        boolean erroBanco = codigoFonte.contains("sql exception") || codigoFonte.contains("database error");
        return erro500 || erro404 || stacktrace || erroBanco;

    }
}
