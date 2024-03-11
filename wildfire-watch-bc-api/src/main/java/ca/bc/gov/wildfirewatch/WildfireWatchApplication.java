package ca.bc.gov.wildfirewatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Main class for the Wildfire Watch BC Application.
 */
@SpringBootApplication
public class WildfireWatchApplication {

    /**
     * Entry point of the application.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(WildfireWatchApplication.class, args);
    }

    /**
     * Configures CORS (Cross-Origin Resource Sharing) for the application.
     * This allows the application to be accessed by web pages from different origins.
     *
     * @return WebMvcConfigurer instance with CORS configuration
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*") // Allow requests from any origin
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow specific HTTP methods
                        .allowedHeaders("*"); // Allow all headers
            }
        };
    }
}