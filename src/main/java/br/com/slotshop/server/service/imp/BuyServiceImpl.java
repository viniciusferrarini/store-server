package br.com.slotshop.server.service.imp;

import br.com.slotshop.server.model.Buy;
import br.com.slotshop.server.repository.data.BuyData;
import br.com.slotshop.server.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BuyServiceImpl extends CrudServiceImpl<Buy, Long> implements BuyService {

    @Autowired private BuyData buyData;

    @Override
    protected JpaRepository<Buy, Long> getRepository() {
        return buyData;
    }

}
