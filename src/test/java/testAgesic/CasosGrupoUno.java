package testAgesic;

import java.util.List;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

@Test
public class CasosGrupoUno {
  	
  public void abriendoBrowser() {
	  
	  String casosFirefox = System.getenv("Firefox"); //Se agarra el browser seleccionado por el usuario en jenkins
	  
	  String casosChrome = System.getenv("Chrome"); //Se agarra el browser seleccionado por el usuario en jenkins
	  
	  String casosExplorer = System.getenv("Explorer"); //Se agarra el browser seleccionado por el usuario en jenkins
	  
	  if (casosFirefox != null){
		  	System.setProperty("webdriver.gecko.driver","C:\\Users\\barce\\Desktop\\geckodriver.exe");  
		    WebDriver driver = new FirefoxDriver();
		    correrCasosDePruebaFirefox(driver, casosFirefox);
	  }
	  
	  if (casosChrome != null){
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		    WebDriver driver = new ChromeDriver();
		    correrCasosDePruebaChrome(driver, casosChrome);
	  }
	  
	  if (casosExplorer != null){
			System.setProperty("webdriver.ie.driver", "C:\\Program Files (x86)\\Internet Explorer\\IEDriverServer.exe");
			WebDriver driver = new InternetExplorerDriver();
			correrCasosDePruebaIE(driver, casosExplorer);
	  }	  
  }
  
  //Se recorren los checkboxes seleccionados por el usuario (casos de prueba) para Firefox, se separan de a uno y se ejecutan los que correspondan
  public static void correrCasosDePruebaFirefox(WebDriver driver, String casosFirefox){
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    
    try {
  	  //Se "duerme" al driver por 3000 milisegundos
  	  Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
           
    List<String> casesList = Arrays.asList(casosFirefox.split(",")); //Se agarra el String "casosFirefox" de formato (Caso1, Caso2, Caso3) y se separa por la coma en varios strings

    for (int j = 0; j < casesList.size(); j++) { //Se recorre la lista para ver cuales fueron los checkbox's seleccionados
    
    	String casoPrueba = casesList.get(j); //Se asignan uno a uno los casos de prueba seleccionados por el usuario
    	
		//A continuacion se usan if's porque al parecer el switch con strings no funciona en esta version. Intentar resolver
		
		if (casoPrueba.equals("Verificar navegación Google")){ //Se corre la funcion de acuerdo al caso de prueba
			abrirGoogle(driver);
		}
		
		if (casoPrueba.equals("Verificar login Outlook")){
			abrirFacebook(driver);
		}
		
		if (casoPrueba.equals("Verificar navegación YouTube")){
			abrirYoutube(driver);
		}
    } 
    driver.close();  
  }
  
//Se recorren los checkboxes seleccionados por el usuario (casos de prueba) para Internet Explorer, se separan de a uno y se ejecutan los que correspondan

  public static void correrCasosDePruebaIE(WebDriver driver, String casosExplorer){

    driver.manage().window().maximize();
    
    try {
  	  //Se "duerme" al driver por 3000 milisegundos
  	  Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
           
    List<String> casesList = Arrays.asList(casosExplorer.split(",")); //Se agarra el String "casosExplorer" de formato (Facebook,Google,ETC) y se separa por la coma en varios strings
    
    for (int j = 0; j < casesList.size(); j++) { //Se recorre la lista para ver cuales fueron los checkbox's seleccionados
    
    	String casoPrueba = casesList.get(j); //Se asignan uno a uno los test cases seleccionados por el usuario
    	
		//A continuacion se usan if's porque al parecer el switch con strings no funciona en esta version. Intentar resolver
				
		if (casoPrueba.equals("Verificar navegación Google")){ //Se corre la funcion de acuerdo al caso de prueba
			abrirGoogle(driver);
		}
		
		if (casoPrueba.equals("Verificar login Outlook")){
			abrirFacebook(driver);
		}
		
		if (casoPrueba.equals("Verificar navegación YouTube")){
			abrirYoutube(driver);
		}
    }  
    driver.close();	  
  }
  
//Se recorren los checkboxes seleccionados por el usuario (casos de prueba) para Chrome, se separan de a uno y se ejecutan los que correspondan

  public static void correrCasosDePruebaChrome(WebDriver driver, String casosChrome){

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    
	    try {
	  	  //Se "duerme" al driver por 3000 milisegundos
	  	  Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	           
	    List<String> casesList = Arrays.asList(casosChrome.split(",")); //Se agarra el String "casosChrome" de formato (Facebook,Google,ETC) y se separa por la coma en varios strings
	    
	    for (int j = 0; j < casesList.size(); j++) { //Se recorre la lista para ver cuales fueron los checkbox's seleccionados
	    
	    	String casoPrueba = casesList.get(j); //Se asignan uno a uno los test cases seleccionados por el usuario
	    	
			//A continuacion se usan if's porque al parecer el switch con strings no funciona en esta version. Intentar resolver
			
			if (casoPrueba.equals("Verificar navegación Google")){ //Se corre la funcion de acuerdo al caso de prueba
				abrirGoogle(driver);
			}
			
			if (casoPrueba.equals("Verificar login Outlook")){
				abrirFacebook(driver);
			}
			
			if (casoPrueba.equals("Verificar navegación YouTube")){
				abrirYoutube(driver);
			}

	    }
	 driver.close();
  }
    
  public static void abrirFacebook(WebDriver driver){
	  //driver.navigate().to("http://www.facebook.com");
	    driver.get("https://owa.pragmaconsultores.net");
	    driver.findElement(By.xpath("//*[@id='username']")).clear();
	    driver.findElement(By.xpath("//*[@id='username']")).sendKeys("pragmanet\\barce");
	    driver.findElement(By.xpath("//*[@id='password']")).clear();
	    driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Pragma1437");
	   
	    driver.findElement(By.xpath(".//*[@id='lgnDiv']/div[9]/div/span")).click();
  }
  
  public static void abrirGoogle(WebDriver driver){
	  driver.navigate().to("http://test01.simple.pge.red.uy/simple/tramites/disponibles");
  }
  
  public static void abrirYoutube(WebDriver driver){
	  driver.navigate().to("http://www.youtube.com");
  }
}
