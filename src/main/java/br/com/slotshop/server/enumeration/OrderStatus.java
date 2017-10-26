package br.com.slotshop.server.enumeration;

public enum OrderStatus {

    CANCELED("Cancelado"),
    ACCOMPLISHED("Pedido Realizado"),
    PAYMENTAPPROVED("Pagamento Aprovado"),
    SEPARATION("Em Separação"),
    SENT("Enviado"),
    COMPLETED("Finalizado");

    OrderStatus(String label){
        this.label = label;
    }

    private String label;

    public String getLabel(){
        return this.label;
    }

}
