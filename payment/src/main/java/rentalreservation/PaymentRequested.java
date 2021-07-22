package rentalreservation;

public class PaymentRequested extends AbstractEvent {

    private Long id;
    private Long reservId;
    private Float rentalPrice;
    private String reservStatus;

    public PaymentRequested(){
        super();
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
