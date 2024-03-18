package com.emil.catering.Controller;

import com.emil.catering.Dto.Request.OrderRequest;
import com.emil.catering.Dto.Response.CommonResponse;
import com.emil.catering.Entity.Order;
import com.emil.catering.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<CommonResponse<Order>> create(@RequestBody OrderRequest request) {
        Order order = orderService.create(request);

        CommonResponse<Order> response = CommonResponse.<Order>builder()
                .statusCode(HttpStatus.CREATED.value())
                .message("successfully create order")
                .data(order)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping
    public ResponseEntity<CommonResponse<Order>> update(@RequestBody OrderRequest request) {
        Order order = orderService.update(request);

        CommonResponse<Order> response = CommonResponse.<Order>builder()
                .statusCode(HttpStatus.CREATED.value())
                .message("successfully update order")
                .data(order)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
