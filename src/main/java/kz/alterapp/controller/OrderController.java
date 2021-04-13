package kz.alterapp.controller;

import kz.alterapp.model.Library;
import kz.alterapp.model.Order;
import kz.alterapp.service.ILibService;
import kz.alterapp.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")

public class OrderController {

    @Autowired
    IOrderService service;

    @PostMapping("/create")
    public void createOrder(@RequestBody Order order){
        service.createOrder(order);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable("id") Integer id){
        service.deleteOrder(id);
    }

    @PostMapping("/update/{id}")
    public void updateOrder(@PathVariable("id") Integer id, @RequestBody Order order){
        service.updateOrder(id, order);
    }

}
