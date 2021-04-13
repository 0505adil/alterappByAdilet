package kz.alterapp.service.impl;

import kz.alterapp.model.Order;
import kz.alterapp.repository.OrderRepository;
import kz.alterapp.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class OrderServiceImpl implements IOrderService {

    @Autowired
    OrderRepository repository;

    @Override
    public void createOrder(Order order) {
        repository.save(order);
    }

    @Override
    public void deleteOrder(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void updateOrder(Integer id, Order order) {
        Order newOrder = repository.findById(id).get();
        newOrder.setBook_id(newOrder.getBook_id());
        newOrder.setLibrary_id(newOrder.getLibrary_id());
        newOrder.setCustomer_id(newOrder.getCustomer_id());
        repository.save(newOrder);
    }
}
