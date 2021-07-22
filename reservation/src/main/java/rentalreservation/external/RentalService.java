
package rentalreservation.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;

@FeignClient(name="rental", url="${feign.rental.url}")
public interface RentalService {

    //@PatchMapping(path="/rentals/{id}")
    //@RequestMapping(method= RequestMethod.PATCH, path="/rentals/{id}")
    //public void rentalStatusChange(@RequestParam("id") Long id, @RequestBody rental rental);

    @RequestMapping(method= RequestMethod.GET, value="/rentals/{id}", consumes = "application/json")
    public Rental getrentalStatus(@PathVariable("id") Long id);

}