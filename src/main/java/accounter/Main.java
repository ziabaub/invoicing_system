package accounter;

import accounter.builder.NavigatorBuilder;
import accounter.entity.document.InvoiceList;
import accounter.file.reader.JsonParser;
import accounter.file.writer.JsonWriter;
import accounter.singelton.data.SingletonResources;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class Main extends Application {
    private final Logger logger = LogManager.getLogger(Main.class);

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("MSR");

        // build the navigator
        NavigatorBuilder navigatorBuilder = new NavigatorBuilder();
        navigatorBuilder.build();
        Pane navigatorPane = navigatorBuilder.getPage().getPane();

        primaryStage.setScene(new Scene(navigatorPane, 100, 800));
        primaryStage.setX(primaryStage.getX());
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("Stage is start");
        JsonParser parser = new JsonParser();
        try {
            InvoiceList invoiceList = parser.parse("data.json");
            SingletonResources.init(invoiceList);
        } catch (Exception ex) {
            logger.error("error during parsing Json file ");
        }
    }

    @Override
    public void stop() {
        JsonWriter writer = new JsonWriter();
        try {
            InvoiceList invoiceList = SingletonResources.getInstance();
            writer.write(invoiceList,"data.json");
            writer = new JsonWriter();
            writer.write(invoiceList,"reserve.json");
        } catch (Exception ex) {
            logger.error("error during writing Json file ");
        }
        System.out.println("Stage is closing");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
