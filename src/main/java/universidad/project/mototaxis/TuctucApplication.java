package universidad.project.mototaxis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableJpaAuditing
public class TuctucApplication implements CommandLineRunner {

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(TuctucApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        String pass = "12345";
        for (int i = 0; i < 4; i++){
            String passBCrypt = passwordEncoder.encode(pass);
            System.out.println(passBCrypt);
        }
    }
}
