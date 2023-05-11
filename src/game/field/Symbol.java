package game.field;

public enum Symbol {
    X('X'),
    O('О'),
    EMPTY('~');

    private final char uiValue;

    Symbol(char uiValue) {
        this.uiValue = uiValue;
    }

    public char getUiValue() {
        return uiValue;
    }
}
