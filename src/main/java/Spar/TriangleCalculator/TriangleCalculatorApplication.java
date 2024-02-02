package Spar.TriangleCalculator;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Triangle Calculator",
				description = "Triangle Calculator API",
				version = "1.0.0"
		)
)
public class TriangleCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TriangleCalculatorApplication.class, args);
	}
}
