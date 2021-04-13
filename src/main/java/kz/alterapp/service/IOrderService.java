package kz.alterapp.service;

import kz.alterapp.model.Order;

public interface IOrderService {
    void createOrder(Order order);
    void deleteOrder(Integer id);
    void updateOrder(Integer id, Order order);
}
