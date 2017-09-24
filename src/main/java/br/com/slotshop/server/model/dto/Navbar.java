package br.com.slotshop.server.model.dto;

import br.com.slotshop.server.model.Category;
import br.com.slotshop.server.model.SubCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Navbar {

    private Category category;

    private List<SubCategory> subCategory;

}
