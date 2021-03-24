package models;

public class FoundWord {
    public final int index;
    public final int row;
    public final String value;

    public FoundWord(String value, int index, int row){
        this.value = value;
        this.index = index;
        this.row = row;
    }

    @Override
    public String toString() {
        return "FoundWord{" +
            "index=" + index +
            ", row=" + row +
            ", value='" + value + '\'' +
            '}';
    }
}
