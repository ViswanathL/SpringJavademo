package exp.vis.javademo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * SpringJavaDemo - exp.vis.javademo.controller
 *
 * @author Viswanath Lekshmanan
 *
 *         Apr 22, 2015
 */

@RestController
public class HelloController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json")
	public String displayHello(@RequestParam("name") String name) {
		return "Hi " + name;
	}

}
