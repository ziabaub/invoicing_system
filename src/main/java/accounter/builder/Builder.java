package accounter.builder;

import accounter.entity.Page;
import javafx.scene.layout.Pane;

public interface Builder {
    public void build();
    public Page getPage();
}
