package com.emil.catering.Service;

import com.emil.catering.Dto.Request.OrderRequest;
import com.emil.catering.Entity.Order;

public interface OrderService {
    Order create(OrderRequest order);

    Order update(OrderRequest order);

    Order findById(String id);
}
