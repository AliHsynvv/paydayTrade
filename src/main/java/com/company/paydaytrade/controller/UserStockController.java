package com.company.paydaytrade.controller;

import com.company.paydaytrade.dto.request.BuyUserStockRequest;
import com.company.paydaytrade.dto.response.ResponseDto;
import com.company.paydaytrade.dto.request.SellUserStockRequest;
import com.company.paydaytrade.service.UserStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/paydaytrade/user/stocks")
public class UserStockController {

    private final UserStockService userStocksService;

    @GetMapping
    public ResponseEntity<ResponseDto> getAllUserStocks() {
        return ResponseEntity.ok(ResponseDto.of(userStocksService.getAllUserStocks()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findUserStockByUserId(@PathVariable Integer id) {
        return ResponseEntity.ok(ResponseDto.of(userStocksService.findUserStockByUserId(id)));

    }

    @PostMapping("/buy/{id}")
    public ResponseEntity<ResponseDto> buyStockTargetPrice(@PathVariable Integer id, @RequestBody BuyUserStockRequest
            buyUserStockRequest) throws IOException {
        return ResponseEntity.ok(ResponseDto.of(userStocksService.buyStockTargetPrice(id, buyUserStockRequest)));
    }

    @PutMapping("/sell/{id}")
    public ResponseEntity<ResponseDto> sellStockTargetPrice(@PathVariable Integer id, @RequestBody SellUserStockRequest
            sellUserStockRequest) throws IOException {
        return ResponseEntity.ok(ResponseDto.of(userStocksService.sellTargetPrice(id, sellUserStockRequest)));
    }
}
