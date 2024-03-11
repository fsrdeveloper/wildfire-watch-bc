package ca.bc.gov.wildfirewatch.service;

import ca.bc.gov.wildfirewatch.model.FirePointResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FirePointServiceTest {

    @Mock
    private RestTemplate restTemplateMock;

    @Mock
    private RedisTemplate<String, Object> redisTemplateMock;


    @InjectMocks
    private FirePointService firePointService;

    @BeforeEach
    public void setUp() {
        // Mock behavior for RedisTemplate opsForHash() method
        HashOperations<String, Object, Object> hashOperationsMock = mock(HashOperations.class);
        when(redisTemplateMock.opsForHash()).thenReturn(hashOperationsMock);
    }


    @Test
    public void testGetFirePoints_CacheHit() {
        // Mock cache hit scenario
        FirePointResponse cachedResponse = new FirePointResponse(); // Create a dummy cached response
        String fireStatus = "Active";
        String fireCause = "Unknown";
        String geographicDescription = "Urban";

        // Mock Redis cache to return a cached response
        when(redisTemplateMock.opsForHash().hasKey(anyString(), anyString())).thenReturn(true);
        when(redisTemplateMock.opsForHash().get(anyString(), anyString())).thenReturn(cachedResponse);

        // Call the method
        FirePointResponse response = firePointService.getFirePoints(fireStatus, fireCause, geographicDescription);

        // Verify behavior
        assertEquals(cachedResponse, response); // Assert that the response is the same as the cached response
    }

}