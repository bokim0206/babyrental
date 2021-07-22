package rentalreservation;

public class ReservationCanceled extends AbstractEvent {

    private Long id;
    private Long rentalId;
    private String rentalName;
    private String rentalStatus;
    private String rentalType;
    private String rentalPeriod;
    private Float rentalPrice;
    private String memberName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getrentalId() {
        return rentalId;
    }

    public void setrentalId(Long rentalId) {
        this.rentalId = rentalId;
    }
    public String getrentalName() {
        return rentalName;
    }

    public void setrentalName(String rentalName) {
        this.rentalName = rentalName;
    }
    public String getrentalStatus() {
        return rentalStatus;
    }

    public void setrentalStatus(String rentalStatus) {
        this.rentalStatus = rentalStatus;
    }
    public String getrentalType() {
        return rentalType;
    }

    public void setrentalType(String rentalType) {
        this.rentalType = rentalType;
    }
    public String getrentalPeriod() {
        return rentalPeriod;
    }

    public void setrentalPeriod(String rentalPeriod) {
        this.rentalPeriod = rentalPeriod;
    }
    public Float getrentalPrice() {
        return rentalPrice;
    }

    public void setrentalPrice(Float rentalPrice) {
        this.rentalPrice = rentalPrice;
    }
    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}