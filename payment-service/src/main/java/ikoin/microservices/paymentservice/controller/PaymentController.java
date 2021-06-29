package ikoin.microservices.paymentservice.controller;

import ikoin.microservices.paymentservice.entity.Payment;
import ikoin.microservices.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/doPayment")
    public Payment bookPayment(@RequestBody Payment payment){
        return paymentService.savePayment(payment);
    }
}
