package ikoin.microservices.orderservice.object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    private int id;

    private String status;

    private String transactionId;

    private int orderId;

    private double amount;
}
