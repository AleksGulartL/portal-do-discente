package automacao_sigaa.paginas;

import org.openqa.selenium.By;


public class Elementos extends Navegador {
    protected By campoUsuario = By.name("user.login");
    protected By campoSenha = By.name("user.senha");
    protected By botaoLogin = By.cssSelector("form[name='loginForm'] input[value='Entrar']");
    protected By classeMenu = By.className("ThemeOfficeMainItem");
    protected By classeSubmenu = By.className("ThemeOfficeMenuItem");
    protected By botaoAtestadoMatricula = By.xpath("//*[@id=\"relatorio-rodape\"]/p/table/tbody/tr/td[4]/a");
    protected By classeSubSubMenuMatricula = By.className("ThemeOfficeMenuItemText");
    protected By classeSubSubMenuSuspenso = By.className("ThemeOfficeMenuItemText");
    protected By classeLugaresDisponiveis = By.id("form:comboDepartamento");
    protected By botaoBuscarMatricula = By.xpath("//*[@id=\"form:buscar\"]");
    protected By primeiraTurmaListagem = By.cssSelector(".listagem a[title='Selecionar turma']");
    protected By classeObrigatorio = By.className("obrigatorio");
    protected By senhaMatricula = By.cssSelector("input[id$=':senha']");
    protected By cpfMatricula = By.cssSelector("input[id$=':cpf']");
    protected By dataNascimentoMatricula = By.cssSelector("input[id$=':Data']");
    protected By botaoConfirmarMatricula = By.cssSelector("input[id$=':btnConfirmar']");
    protected By botaoRealizarOutraMatricula = By.cssSelector("input[id$=':btnRealizarNovaMatricula']");
    protected By estouCiente = By.cssSelector("input[type='checkbox']");
    protected By continuarSuspensao = By.cssSelector("input[value='Continuar >>']");
    protected By confirmarSolicitacao = By.cssSelector("input[value='Confirmar Solicitação']");
    protected By voltarParaMenuPrincipal = By.linkText("Portal do Discente");
    protected By primeiroCCRListagem = By.cssSelector("input[type='checkbox']");
    protected By primeiroMotivo = By.cssSelector("input[type='radio']");
    protected By botaoSolicitarTrancamento = By.cssSelector("input[type='submit']");
    protected By botaoBuscarGenerico = By.cssSelector("input[value='Buscar']");
} 
 