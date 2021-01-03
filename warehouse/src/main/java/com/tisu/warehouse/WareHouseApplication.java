package com.tisu.warehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author deporation
 */
@EnableEurekaClient
@EnableSwagger2
@EnableMongoRepositories("com.tisu.warehouse.mapper")
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class WareHouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(WareHouseApplication.class, args);
	}

}
