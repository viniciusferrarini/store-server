package br.com.slotshop.server.enumeration;

public enum PaymentType {

    NOTSELECTED("Não Selecionado"),
    TICKET("Boleto"),
    CREDITCARD("Cartão de Crédito");

    PaymentType(String label){
        this.label =label;
    }

    private String label;

    public String getLabel() {
        return label;
    }

}
