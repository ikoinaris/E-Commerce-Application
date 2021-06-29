package ikoin.microservices.paymentservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String status;

    private String transactionId;

    private int orderId;

    private double amount;
}
