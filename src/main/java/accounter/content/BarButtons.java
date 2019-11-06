package accounter.content;

public enum BarButtons {
    INVOICE("invoice"), ADD_CLIENT("add client");
    private String value;

    private BarButtons(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
