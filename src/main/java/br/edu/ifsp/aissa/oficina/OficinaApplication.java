package br.edu.ifsp.aissa.oficina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class OficinaApplication {

    public static void main(String[] args) {
        SpringApplication.run(OficinaApplication.class, args);
    }

}
