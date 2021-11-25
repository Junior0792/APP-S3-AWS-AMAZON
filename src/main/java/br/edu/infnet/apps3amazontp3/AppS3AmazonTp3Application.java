package br.edu.infnet.apps3amazontp3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppS3AmazonTp3Application {

	public static void main(String[] args) {
		SpringApplication.run(AppS3AmazonTp3Application.class, args);
	}
	

}
