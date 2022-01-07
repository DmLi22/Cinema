package by.shag.litvinov.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
@Endpoint(id = "customReadPom")
public class CustomGetPom {

    @ReadOperation
    public String readPom() {
        String str = "";
        try (BufferedReader br = new BufferedReader(new FileReader("pom.xml"))) {
            String s;
            while ((s = br.readLine()) != null) {
                str = str.concat(s).concat("\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return str;
    }
}
