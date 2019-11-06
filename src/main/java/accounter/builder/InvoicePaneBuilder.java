package accounter.builder;

import accounter.entity.Page;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class InvoicePaneBuilder implements Builder {
    private Page page;

    public InvoicePaneBuilder() {
        this.page = new Page();
    }

    @Override
    public void build() {
        Pane pane = page.getPane();
        Paint backgroundPaint = Color.YELLOW;
        pane.setBackground(new Background(new BackgroundFill(backgroundPaint, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    @Override
    public Page getPage() {
        return page;
    }
}
