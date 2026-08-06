package automacao_sigaa.paginas;

import org.openqa.selenium.By;


public class Elementos extends Navegador {
    protected By botaoCiente = By.className("btn-primary");
    protected By campoUsuario = By.name("user.login");
    protected By campoSenha = By.name("user.senha");
    protected By botaoLogin = By.cssSelector("form[name='loginForm'] input[value='Entrar']");
    protected By classeMenu = By.className("ThemeOfficeMainItem");
    protected By classeSubmenu = By.className("ThemeOfficeMenuItem");
    protected By botaoAtestadoMatricula = By.xpath("//*[@id=\"relatorio-rodape\"]/p/table/tbody/tr/td[4]/a"); 
    
}
 