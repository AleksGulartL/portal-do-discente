package automacao_sigaa.paginas;

import java.util.List;

import org.openqa.selenium.WebElement;

public class metodos extends Elementos {

    public void logarSigaa(String usuario, String senha) {
        driver.findElement(campoUsuario).sendKeys(usuario);
        driver.findElement(campoSenha).sendKeys(senha);
        driver.findElement(botaoLogin).click();
    }

   public void navegarMenuDiscente(String opcaoDeNavegacao, String acessar) {
    List<WebElement> elementos = driver.findElements(classeMenu);
    for (WebElement elemento : elementos) {
        String textoElemento = elemento.getText().trim();
        if (textoElemento.equalsIgnoreCase(opcaoDeNavegacao)) {
            elemento.click();
            
            List<WebElement> submenus = driver.findElements(classeSubmenu);
            for (WebElement submenu : submenus) {
                String submenuTexto = submenu.getText().trim();
                if (submenuTexto.equalsIgnoreCase(acessar)) {
                    if (submenuTexto.equalsIgnoreCase("Emitir Atestado de Matrícula")) {
                        submenu.click();
                        driver.findElement(botaoAtestadoMatricula).click();
                        break;
                    } else {
                        submenu.click();
                        break;
                    }
                }
            }
            break;
        }
    }
}


}