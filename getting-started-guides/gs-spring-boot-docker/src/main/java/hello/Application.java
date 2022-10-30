package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 应用程序启动入口。
 *
 * @author lihuagang
 */
@SpringBootApplication
@RestController
public class Application {

	@RequestMapping("/")
	public String home() {
		return "Hello, Docker World!";
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
