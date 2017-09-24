package br.com.slotshop.server.service.imp;

import br.com.slotshop.server.model.Category;
import br.com.slotshop.server.model.SubCategory;
import br.com.slotshop.server.model.dto.Navbar;
import br.com.slotshop.server.repository.data.SubCategoryData;
import br.com.slotshop.server.service.SubCategoryService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class SubCategoryServiceImpl extends CrudServiceImpl<SubCategory, Long> implements SubCategoryService {

    @Autowired private SubCategoryData subCategoryData;

    @Override
    protected JpaRepository<SubCategory, Long> getRepository() {
        return subCategoryData;
    }

    @Override
    public List<Navbar> getNavbar() {
        return groupNav(subCategoryData.findAll());
    }

    private List<Navbar> groupNav(List<SubCategory> subCategories) {
        List<Navbar> navbars = new ArrayList<>();
        Map<Category, List<SubCategory>> categoryListMap = subCategories.stream().collect(Collectors.groupingBy(SubCategory::getCategory));
        for (Category category : categoryListMap.keySet()) {
            List<SubCategory> subCategoryList = categoryListMap.get(category);
            navbars.add(Navbar.builder()
                    .category(category)
                    .subCategory(subCategoryList)
                    .build());
        }
        return navbars;
    }
}
