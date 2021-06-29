package ikoin.microservices.paymentservice.service;

import ikoin.microservices.paymentservice.entity.Payment;
import ikoin.microservices.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment savePayment(Payment payment) {
        payment.setStatus(processPayment());
        payment.setTransactionId(UUID.randomUUID().toString());
        return paymentRepository.save(payment);
    }

    public String processPayment() {
        return new Random().nextBoolean() ? "success": "false";
    }
}
