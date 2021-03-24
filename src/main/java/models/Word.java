package models;

public class Word {
    private boolean isRead = false;
    private final String value;

    public Word(String value){
        this.value = value;
    }

    public boolean isRead(){
        return this.isRead;
    }

    public void markAsRead(){
        this.isRead = true;
    }

    public String getValue(){
        return this.value;
    }

    @Override
    public String toString() {
        return "Word{" +
            "isRead=" + isRead +
            ", value='" + value + '\'' +
            '}';
    }
}
