package rentalreservation;

import rentalreservation.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired RentalRepository rentalRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationCanceled_RentalStatusChangePolicy(@Payload ReservationCanceled reservationCanceled){

        if(!reservationCanceled.validate()) return;

        System.out.println("\n\n##### listener RentalStatusChangePolicy : " + reservationCanceled.toJson() + "\n\n");

        // 리조트 상태를 예약 가능 상태로 변경
         rentalRepository.findById(reservationCanceled.getrentalId())
            .ifPresent(
                rental -> {
                    rental.setrentalStatus("Available");
                    rentalRepository.save(rental);
            }
        )
        ; 
            
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationRegistered_RentalStatusChangePolicy(@Payload ReservationRegistered reservationRegistered){

        if(!reservationRegistered.validate()) return;

        System.out.println("\n\n##### listener RentaltStatusChangePolicy : " + reservationRegistered.toJson() + "\n\n");

        // 리조트 상태를 예약 불가능 상태로 변경
        rentalRepository.findById(reservationRegistered.getrentalId())
            .ifPresent(
                rental -> {
                    rental.setrentalStatus("Not Available");
                    rentalRepository.save(rental);
            }
        )
        ;    
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}
