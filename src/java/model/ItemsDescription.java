package java.model;

public enum ItemsDescription {

    //List of Items with Description: ItemName(Exempted: true/false, Imported: true/false)

    BOOK(true,false),
    MEDICAL(true,false),   //including pills, bandaids etc.
    FOOD(true,false),       //chocolate, chips etc.
    IMPORTED_BOOK(true,true),
    IMPORTED_MEDICAL(true,true),
    IMPORTED_FOOD(true,true),

    //remaining products put in the non exempted category
    OTHERS (false,false),
    IMPORTED_OTHERS(false,true);


    private final boolean isExempted;
    private final boolean isImported;

    ItemsDescription(boolean exempted, boolean imported){
        isExempted = exempted;
        isImported = imported;
    }

    //return labels
    public boolean isImported(){
        return isImported;
    }
    public boolean isExempted(){
        return isExempted;
    }
}
