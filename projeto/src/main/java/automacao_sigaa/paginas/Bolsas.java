package automacao_sigaa.paginas;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Bolsas extends metodos {
    public void cadastroUnico() {
        visualizarOpcaoSubSubMenu("aderir");
        // cadastro nao é possivel de ser feito ainda
        voltarAoMenuPrincipal();
        navegarMenuDiscente("bolsas", "cadastro único");
        visualizarOpcaoSubSubMenu("consultar adesões");
        voltarAoMenuPrincipal();
        navegarMenuDiscente("bolsas", "cadastro único");
        visualizarOpcaoSubSubMenu("declaração de discente prioritário");
        voltarAoMenuPrincipal();
    }

    public void declaracaoBolsista(String cpf, String senha, String dataDeNascimento) {
        visualizarOpcaoSubSubMenu("assinar declaração");
        camposObrigatorios(cpf, senha, dataDeNascimento);
        navegarMenuDiscente("bolsas", "declaração de bolsista");
        visualizarOpcaoSubSubMenu("visualizar assinaturas");
        voltarAoMenuPrincipal();
    }

    public void oportunidadesDeBolsa() {
        navegarMenuDiscente("bolsas", "oportunidades de bolsa");
        WebElement elementoSelect = driver.findElement(By.cssSelector("select[name='busca:tipo']"));
        new Select(elementoSelect).selectByIndex(1);
        clicarBuscar();
        voltarAoMenuPrincipal();
    }


    



}
