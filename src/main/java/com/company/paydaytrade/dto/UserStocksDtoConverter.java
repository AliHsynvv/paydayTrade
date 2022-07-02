package com.company.paydaytrade.dto;

import com.company.paydaytrade.entity.UserStocks;
import org.springframework.stereotype.Component;

@Component
public class UserStocksDtoConverter {
    public static UserStocksDto converter(UserStocks userStocks) {
        UserStocksDto userStocksDto = UserStocksDto.builder()
                .stockName(userStocks.getStockName())
                .stockPrice(userStocks.getStockPrice())
                .userId(userStocks.getUserId())
                .build();
        return userStocksDto;
    }
}