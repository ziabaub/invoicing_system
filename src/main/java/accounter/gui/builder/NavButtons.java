package accounter.gui.builder;

public enum NavButtons {
    INVOICE("invoice"), ADD_CLIENT("add client");
    private String value;

    private NavButtons(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
