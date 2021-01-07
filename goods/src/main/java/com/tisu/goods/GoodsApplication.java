package com.tisu.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p>商品服务类</p>
 *
 * @author deporation
 */
@EnableEurekaClient
@MapperScan(basePackages = {"com.tisu.goods.mapper"})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class GoodsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoodsApplication.class, args);
	}

}
