package accounter.controlle;

import accounter.builder.Builder;
import accounter.builder.InvoicePaneBuilder;
import accounter.builder.NavigatorBuilder;
import accounter.entity.Page;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

/**
 * screen controller
 * main page which control all pge
 */
public enum BuilderController {

    NAVIGATOR(new NavigatorBuilder()),
    INVOICE(new InvoicePaneBuilder());

    private Builder builder;

    BuilderController(Builder builder) {
        this.builder = builder;
    }

    private static final Map<String, Builder> look = new HashMap<>();

    static {
        for (BuilderController b : BuilderController.values()) {
            look.put(b.toString(), b.builder);
        }
    }

    public static void activate(String name) {
        Builder builder =  look.get(name);
        builder.build();
        Page page = builder.getPage();
        Stage stage = page.getStage();
        stage.show();
    }


//
//
//
//
//
//
//    private static HashMap<String, Page> screenMap = new HashMap<>();
//    private static Scene main;
//
//    public Pages(Scene main) {
//        Pages.main = main;
//    }
//
//    public void addScreen(String name, Page page){
//        screenMap.put(name, page);
//    }
//
//    public void removeScreen(String name){
//        screenMap.remove(name);
//    }
//
//    public static void activate(String name){
//        Page page = screenMap.get(name);
//        Pane pane = page.getPane();
//        main.setRoot(pane );
//    }
}
