package br.com.slotshop.server.repository.data;

import br.com.slotshop.server.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ProductData extends JpaRepository<Product, Long> { }
