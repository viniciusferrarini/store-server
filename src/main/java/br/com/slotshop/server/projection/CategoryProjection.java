package br.com.slotshop.server.projection;

import br.com.slotshop.server.model.Category;
import br.com.slotshop.server.model.SubCategory;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "categoryProjection", types = Category.class)
public interface CategoryProjection {

    Long getId();

    String getName();


}
