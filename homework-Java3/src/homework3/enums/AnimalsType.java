package homework3.enums;

public enum AnimalsType {
    WILD("Дикий"),
    DOMESTIC("Домашний");

    private final String value;

    AnimalsType(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}