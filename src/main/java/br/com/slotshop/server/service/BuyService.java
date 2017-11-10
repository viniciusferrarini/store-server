package br.com.slotshop.server.service;

import br.com.slotshop.server.model.Buy;
import br.com.slotshop.server.model.User;
import br.com.slotshop.server.model.dto.BuyTotal;

import java.util.List;

public interface BuyService extends CrudService<Buy, Long> {

    List<Buy> findByUser(User user);

    List<Buy> findAllOrderByDateDesc();

    BuyTotal findBuyAndTotalValueLastTenDays();

}
