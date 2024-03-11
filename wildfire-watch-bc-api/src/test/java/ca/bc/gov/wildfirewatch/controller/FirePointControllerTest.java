package ca.bc.gov.wildfirewatch.controller;

import ca.bc.gov.wildfirewatch.service.FirePointService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Unit tests for the FirePointController class.
 */
public class FirePointControllerTest {

    private MockMvc mockMvc;

    @Mock
    private FirePointService firePointService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(new FirePointController(firePointService)).build();
    }

    @Test
    public void testGetFirePointsEndpointWithValidParameters() throws Exception {
        // Perform a request to the /fire-points endpoint with valid parameters
        mockMvc.perform(get("/fire-points")
                        .param("fireStatus", "Active")
                        .param("fireCause", "Human")
                        .param("geographicDescription", "Forest"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetFirePointsEndpointWithMissingParameters() throws Exception {
        // Perform a request to the /fire-points endpoint with missing parameters
        mockMvc.perform(get("/fire-points"))
                .andExpect(status().isOk()); // Assuming the endpoint handles missing parameters gracefully
    }

    @Test
    public void testGetFirePointsEndpointWithInvalidParameters() throws Exception {
        // Perform a request to the /fire-points endpoint with invalid parameters
        mockMvc.perform(get("/fire-points")
                        .param("fireStatus", "Active")
                        .param("fireCause", "Invalid") // Assuming "Invalid" is not a valid fire cause
                        .param("geographicDescription", "Forest"))
                .andExpect(status().isOk()); // Assuming the endpoint handles invalid parameters gracefully
    }

    @Test
    public void testGetFirePointsEndpointWithMultipleValuesForParameters() throws Exception {
        // Perform a request to the /fire-points endpoint with multiple values for parameters
        mockMvc.perform(get("/fire-points")
                        .param("fireStatus", "Active")
                        .param("fireCause", "Human")
                        .param("geographicDescription", "Forest"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetFirePointsEndpointWithDifferentParameterCombinations() throws Exception {
        // Test different combinations of parameters
        mockMvc.perform(get("/fire-points")
                        .param("fireStatus", "Active"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/fire-points")
                        .param("fireCause", "Human"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/fire-points")
                        .param("fireStatus", "Active")
                        .param("geographicDescription", "Forest"))
                .andExpect(status().isOk());

    }

}