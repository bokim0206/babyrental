package rentalreservation;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="rental_table")
public class Rental {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String rentalName;
    private String rentalStatus;
    private String rentalType;
    private String rentalPeriod;
    private Float rentalPrice;

    @PostPersist
    public void onPostPersist(){
        RentalRegistrated rentalRegistrated = new RentalRegistrated();
        BeanUtils.copyProperties(this, rentalRegistrated);
        rentalRegistrated.publishAfterCommit();


    }

    @PostUpdate
    public void onPostUpdate(){
        RentalStatusChanged rentalStatusChanged = new RentalStatusChanged();
        BeanUtils.copyProperties(this, rentalStatusChanged);
        rentalStatusChanged.publishAfterCommit();


    }

    @PostRemove
    public void onPostRemove(){
        RentalRemoved rentalRemoved = new RentalRemoved();
        BeanUtils.copyProperties(this, rentalRemoved);
        rentalRemoved.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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




}
