package com.demozi.spring.boot.data;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableSkynetPandoraOgma
@Slf4j
@SpringBootApplication
public class SpringBootDataApplication implements CommandLineRunner {

//	@Autowired
//	private PlanetClient client;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		DbCreateParam param = new DbCreateParam();
//		param.setDbName("dbName");
//		Map<String, Object> props = new HashMap<>();
//		props.put("tag_str", "字符串");
//		props.put("tag_int", 20);
//		param.setProps(props);
//
//		PlanetRequest<DbCreateParam> request = new PlanetRequest<>();
//		request.setPayload(param);
//		PlanetResponse<Void> response = client.createDb(request);
//		log.info("response:{} ", response);
	}
}
