package br.com.slotshop.server.enumeration;

public enum FreightType {

    SEDEX("SEDEX"),
    PAC("PAC");

    FreightType(String label){
        this.label = label;
    }

    private String label;

    public String getLabel(){
        return this.label;
    }

}
