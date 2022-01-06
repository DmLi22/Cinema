package by.shag.litvinov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableMBeanExport;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableMBeanExport
@EnableSwagger2
@SpringBootApplication
public class Runner {

    public static void main(String[] args) {
        SpringApplication.run(Runner.class);
    }
}
