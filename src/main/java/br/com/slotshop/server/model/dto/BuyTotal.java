package br.com.slotshop.server.model.dto;

import br.com.slotshop.server.util.DoubleUtil;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuyTotal {

    private Long totalAmount;

    private Double totalValue;

    private List<Chart> chart;

    public String getTotalValueFormatted(){
        return DoubleUtil.formatRealWithSimbol(this.totalValue);
    }


}
