package accounter.gui.builder;

import accounter.gui.controller.BuilderController;
import accounter.gui.entity.Page;
import javafx.scene.control.Button;
import javafx.scene.layout.*;


public class NavigatorBuilder implements Builder {

    private  Page page = new Page();
    /**
     * build main navigator buttons
     */
    @Override
    public void build() {
        Pane navigatorPane = new Pane();
        VBox buttonBox = getButtons();
        navigatorPane.getChildren().add(buttonBox);
        page.setPane(navigatorPane);
    }

    @Override
    public Page getPage() {
        return page;
    }

    // build the navigator buttons (invoice , add client)
    private VBox getButtons() {
        VBox vBox = new VBox(10);
        vBox.setLayoutX(10);
        vBox.setLayoutY(10);

        for (NavButtons value : NavButtons.values()) {
            Button button = new Button(value.getValue());
            button.setPrefSize(80, 20);
            button.setOnAction(e -> setButtonEvent(value));
            vBox.getChildren().add(button);
        }
        return vBox;
    }

    private void setButtonEvent(NavButtons event) {
        BuilderController.activate(event.getValue().toUpperCase());
    }

}
