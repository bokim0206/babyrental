package rentalreservation.external;

import org.springframework.stereotype.Component;


@Component
public class RentalServiceFallback implements RentalService {

    @Override
    public Rental getrentalStatus(Long id) {
        System.out.println("Circuit breaker has been opened. Fallback returned instead.");
        return null;
    }

}
