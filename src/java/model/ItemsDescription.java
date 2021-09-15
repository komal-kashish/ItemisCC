package java.model;

public enum ItemsDescription {

    //List of Items with Description: ItemName(Exempted: true/false, Imported: true/false)

    private boolean isExempted;
    private boolean isImported;

    private ItemsDescription(boolean exempted , boolean imported){
        isExempted = exempted;
        isImported = imported;
    }
}
