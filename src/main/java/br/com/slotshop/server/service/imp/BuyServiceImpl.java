package br.com.slotshop.server.service.imp;

import br.com.slotshop.server.model.Buy;
import br.com.slotshop.server.model.User;
import br.com.slotshop.server.model.dto.BuyTotal;
import br.com.slotshop.server.model.dto.Chart;
import br.com.slotshop.server.repository.data.BuyData;
import br.com.slotshop.server.service.BuyService;
import br.com.slotshop.server.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BuyServiceImpl extends CrudServiceImpl<Buy, Long> implements BuyService {

    @Autowired private BuyData buyData;

    @Override
    protected JpaRepository<Buy, Long> getRepository() {
        return buyData;
    }

    @Override
    public List<Buy> findByUser(User user) {
        return buyData.findByUserOrderByIdDesc(user);
    }

    @Override
    public List<Buy> findAllOrderByDateDesc() {
        return buyData.findByOrderByDateDesc();
    }

    @Override
    public BuyTotal findBuyAndTotalValueLastTenDays() {
        List<Buy> buyList = buyData.findByDateIsGreaterThanEqual(DateUtil.getLowerDate(10));
        BuyTotal buyTotal = BuyTotal.builder()
                .totalAmount(buyList.stream().mapToLong(Buy::getId).count())
                .totalValue(buyList.stream().mapToDouble(Buy::getTotal).sum())
                .build();
        return chartFactory(buyTotal, buyList);

    }

    private BuyTotal chartFactory(BuyTotal buyTotal, List<Buy> buyList){
        List<Chart> chartList = new ArrayList<>();
        Map<String, List<Buy>> buyDates = buyList.stream().collect(Collectors.groupingBy(buy -> DateUtil.format(buy.getDate())));
        for (String date : buyDates.keySet()) {
            List<Buy> buys = buyDates.get(date);
            chartList.add(Chart.builder()
                    .category(date)
                    .totalDouble(buys.stream().mapToDouble(Buy::getTotal).sum())
                    .totalLong(buys.stream().mapToLong(Buy::getId).count())
                    .build());
        }
        chartList.sort(Comparator.comparing(Chart::getCategory));
        buyTotal.setChart(chartList);
        return buyTotal;
    }
}
