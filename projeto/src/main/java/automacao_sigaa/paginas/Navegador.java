package automacao_sigaa.paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Navegador {
    public static WebDriver driver;

    public static void abrirNavegador(String url) {

        // Configurações do Chrome para salvar PDF automaticamente  
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("printing.print_preview_sticky_settings.appState",
                "{\"typedCamping\":true,\"selectedDestinationId\":\"Save as PDF\",\"version\":2}");
 

        ChromeOptions chromeOpts = new ChromeOptions();
        chromeOpts.setExperimentalOption("prefs", prefs); 
        chromeOpts.addArguments("--start-maximized");
        chromeOpts.addArguments("--kiosk-printing");
        driver = new ChromeDriver(chromeOpts);
        driver.manage().window().maximize();
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void fecharNavegador() {
        try {
            if (driver != null) {
                Thread.sleep(5000);
                driver.quit(); 
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
