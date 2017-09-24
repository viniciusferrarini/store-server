package br.com.slotshop.server.service;

import br.com.slotshop.server.model.SubCategory;
import br.com.slotshop.server.model.dto.Navbar;

import java.util.List;

public interface SubCategoryService extends CrudService<SubCategory, Long> {

    List<Navbar> getNavbar();

}
