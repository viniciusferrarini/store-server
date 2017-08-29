package br.com.slotshop.server.projection;

import br.com.slotshop.server.model.Category;
import br.com.slotshop.server.model.SubCategory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "subCategoryProjection", types = SubCategory.class)
public interface SubCategoryProjection {

    Long getId();

    String getName();

    Category getCategory();

}
