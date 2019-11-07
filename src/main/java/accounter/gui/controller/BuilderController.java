package accounter.gui.controller;

import accounter.gui.builder.Builder;
import accounter.gui.builder.InvoicePaneBuilder;
import accounter.gui.builder.NavigatorBuilder;
import accounter.gui.entity.Page;
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

}
