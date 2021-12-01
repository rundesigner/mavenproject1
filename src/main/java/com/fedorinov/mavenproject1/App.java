package com.fedorinov.mavenproject1;


import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.slf4j.Logger;

/**
 * JavaFX App
 */
public class App extends Application {

static final Logger log = getLogger(lookup().lookupClass);

    @Override
    public void start(javafx.stage.Stage stage) {


//        String javaVersion = SystemInfo.javaVersion();
//        String javafxVersion = SystemInfo.javafxVersion();
WebDriverManager.chromedriver().setup();
     WebDriver driver = new ChromeDriver();
 String sutUrl = "https://yandex.ru/";
String title = driver.getTitle();
log.debug("The title of {} is {}", sutUrl, title);
driver.get(sutUrl);
       Label label = new Label("Hello, JavaFX " + driver.getTitle() + ".");
driver.quit();


    //    Label label = new Label("Hello, JavaFX .");
        Scene scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}