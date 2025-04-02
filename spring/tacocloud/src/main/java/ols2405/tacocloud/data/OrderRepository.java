package ols2405.tacocloud.data;

import ols2405.tacocloud.Order;

public interface OrderRepository {
    Order save(Order order);
}
