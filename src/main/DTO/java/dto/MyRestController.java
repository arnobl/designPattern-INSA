package dto;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class MyRestController {
	private MyData data;
	private MyDTOFactory dtoFactory;

	public MyRestController() {
		data = new MyData();
		dtoFactory = new MyDTOFactory();
	}

	@GetMapping(path = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
	public MyDTO giveMeSomeData() {
		return dtoFactory.toMyDTO(data);
	}
}
