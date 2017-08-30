package br.com.slotshop.server.enumeration;

public enum  YesNo {

    Y("Yes"),
    N("No");

    private String label;

    YesNo(String label){
        this.label = label;
    }

    public String getLabel(){
        return this.label;
    }

}
