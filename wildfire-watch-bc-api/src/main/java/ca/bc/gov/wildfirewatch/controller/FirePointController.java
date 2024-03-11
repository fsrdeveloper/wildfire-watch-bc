package ca.bc.gov.wildfirewatch.controller;


import ca.bc.gov.wildfirewatch.model.FirePointResponse;
import ca.bc.gov.wildfirewatch.service.FirePointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling requests related to fire points.
 */
@RestController
public class FirePointController {

    private final FirePointService firePointService;

    @Autowired
    public FirePointController(FirePointService firePointService) {
        this.firePointService = firePointService;
    }

    /**
     * Retrieves fire points data filtered fire status, fire cause, and geographic description.
     *
     * @param fireStatus            The fire status for filtering fire points data.
     * @param fireCause             The fire cause for filtering fire points data.
     * @param geographicDescription The geographic description for filtering fire points data.
     * @return The response containing filtered fire points data.
     */
    @GetMapping("/fire-points")
    public FirePointResponse getFirePoints(
            @RequestParam(required = false) String fireStatus,
            @RequestParam(required = false) String fireCause,
            @RequestParam(required = false) String geographicDescription) {
        return firePointService.getFirePoints(fireStatus, fireCause, geographicDescription);
    }
}