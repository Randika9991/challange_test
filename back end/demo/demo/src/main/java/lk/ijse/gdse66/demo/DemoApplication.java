package lk.ijse.gdse66.demo;

import lk.ijse.gdse66.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String user = userService.createUser();
		System.out.println(user);
		String user789 = userService.getUser("user789");
		System.out.println(user789);
		String json = "{\n" +
				"    \"uid\": \"user78090\",\n" +
				"    \"email\": \"jane.doe@example.com\",\n" +
				"    \"given_name\": \"kamala\",\n" +
				"    \"middle_name\": \"Elizabeth\",\n" +
				"    \"name\": \"Jane Elizabeth Smith\",\n" +
				"    \"family_name\": \"Smith\",\n" +
				"    \"nickname\": \"Janie\",\n" +
				"    \"phone_number\": \"+0987654321\",\n" +
				"    \"comment\": \"Account created for new project development.\",\n" +
				"    \"picture\": \"https://example.com/profile-pic-jane.jpg\",\n" +
				"    \"directory\": \"project-team\",\n" +
				"    \"metadata\": {\n" +
				"        \"color\": \"red\",\n" +
				"        \"size\": \"M\"\n" +
				"    },\n" +
				"    \"tags\": [\"developer\", \"team-lead\"],\n" +
				"    \"is_suspended\": true,\n" +
				"    \"is_bot\": true\n" +
				"}\n";
		String updateUser = userService.updateUser("user78090",json);
		System.out.println(updateUser);
	}
}
