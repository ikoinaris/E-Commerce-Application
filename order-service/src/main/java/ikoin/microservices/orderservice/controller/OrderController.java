package ikoin.microservices.orderservice.controller;

import ikoin.microservices.orderservice.entity.Order;
import ikoin.microservices.orderservice.object.Payment;
import ikoin.microservices.orderservice.object.TransactionRequest;
import ikoin.microservices.orderservice.object.TransactionResponse;
import ikoin.microservices.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request) {
        return orderService.saveOrder(request);
    }
}
