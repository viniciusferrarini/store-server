package br.com.slotshop.server.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Chart {

    private String category;

    private Long totalLong;

    private Double totalDouble;

}
