package rentalreservation;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="Payment_table")
public class Payment {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long reservId;
    private Float rentalPrice;
    private String reservStatus;

    @PostPersist
    public void onPostPersist(){
        PaymentRequested paymentRequested = new PaymentRequested();
        BeanUtils.copyProperties(this, paymentRequested);
        paymentRequested.publishAfterCommit();


    }

    @PostUpdate
    public void onPostUpdate(){
        PaymentApproved paymentApproved = new PaymentApproved();
        BeanUtils.copyProperties(this, paymentApproved);
        paymentApproved.publishAfterCommit();


        PaymentCancelled paymentCancelled = new PaymentCancelled();
        BeanUtils.copyProperties(this, paymentCancelled);
        paymentCancelled.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getReservId() {
        return reservId;
    }

    public void setReservId(Long reservId) {
        this.reservId = reservId;
    }
    public Float getrentalPrice() {
        return rentalPrice;
    }

    public void setrentalPrice(Float rentalPrice) {
        this.rentalPrice = rentalPrice;
    }
    public String getReservStatus() {
        return reservStatus;
    }

    public void setReservStatus(String reservStatus) {
        this.reservStatus = reservStatus;
    }




}
