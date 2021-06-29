package ikoin.microservices.orderservice.service;

import ikoin.microservices.orderservice.entity.Order;
import ikoin.microservices.orderservice.object.Payment;
import ikoin.microservices.orderservice.object.TransactionRequest;
import ikoin.microservices.orderservice.object.TransactionResponse;
import ikoin.microservices.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate template;

    private String url = "http://PAYMENT-SERVICE/payment/doPayment";

    public TransactionResponse saveOrder(TransactionRequest request) {
        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());

        Payment paymentResponse = template.postForObject(url, payment, Payment.class);
        String responseMessage = paymentResponse.getStatus().equals("success")?"payment success and order placed":"payment failure";

        orderRepository.save(order);
        return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), responseMessage);
    }
}
