package universidad.project.mototaxis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TuctucApplication {

    public static void main(String[] args) {
        SpringApplication.run(TuctucApplication.class, args);
    }

}
