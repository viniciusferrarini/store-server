package br.com.slotshop.server.config;

import br.com.slotshop.server.model.Category;
import br.com.slotshop.server.model.Product;
import br.com.slotshop.server.model.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
public class DataRestConfiguration extends RepositoryRestMvcConfiguration {

    @Override
    public RepositoryRestConfiguration config() {
        RepositoryRestConfiguration config = super.config();
        config.setDefaultPageSize(50);
        //config.setBasePath("/data");
        config.exposeIdsFor(User.class, Product.class);
        config.exposeIdsFor(User.class, Category.class);
        return config;
    }

}