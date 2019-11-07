package accounter.gui.entity;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Page {
    private Stage stage;
    private Scene scene;
    private Pane pane;

    public Page() {
        stage = new Stage();
        pane = new Pane();
        scene = new Scene(pane,1250, 800);
        stage.setScene(scene);
        stage.setX(110);
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Pane getPane() {
        return pane;
    }

    public void setPane(Pane pane) {
        this.pane = pane;
    }
}
