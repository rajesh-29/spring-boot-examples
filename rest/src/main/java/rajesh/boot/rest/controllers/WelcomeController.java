package rajesh.boot.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import rajesh.boot.rest.beans.AppName;
import rajesh.boot.rest.beans.SessionId;
import rajesh.boot.rest.entity.RequestMessage;
import rajesh.boot.rest.entity.WelcomeMessage;

@RestController
public class WelcomeController {
	
	@Autowired
	private SessionId sessionId;
	
	@RequestMapping(value = "/sessionId", method = RequestMethod.GET)
	public @ResponseBody WelcomeMessage showId() {
		System.out.println("*** BEAN sessionId object " + sessionId);
		return new WelcomeMessage("Session Id is ", "" + sessionId.getSessionId());
	}
	
	@Autowired
	private AppName appName;
	
	@Bean
	public AppName getAppName(@Value("${app.name}") String appName) {

	    return new AppName() {

	        @Override
	        public String getName() {
	            return appName;
	        }
	    };
	}
	
	
	@Value("${env.value}")
	private String thisEnv;
	
	@Autowired
	private Environment env;
	
	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public @ResponseBody WelcomeMessage details() {
		System.out.println("*** BEAN appName object " + appName);
		System.out.println("*** Bean AppName " + appName.getName());
		return new WelcomeMessage("Env " + thisEnv, "Env " + env.getProperty("env.value"));
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public @ResponseBody WelcomeMessage showMessage() {
		return new WelcomeMessage("Hi", "Greeting");
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<WelcomeMessage> welcomeMessage() {
		
		return ResponseEntity.ok(new WelcomeMessage("Hi", "Greeting"));
	}
	
	
	@RequestMapping(value = "/postExample", method = RequestMethod.POST)
	// @RequestMapping(value = "/postExample", method = RequestMethod.POST)
	public @ResponseBody WelcomeMessage postExample(@RequestHeader("Content-Type") String content, @RequestBody RequestMessage requestMessage) {
		
		System.out.println("*** Content-Type Header " + content);
		return new WelcomeMessage("Hi " + requestMessage.getName(), "Greeting");
	}
	
	@RequestMapping(value = "/postExampleXml", method = RequestMethod.POST, consumes=MediaType.APPLICATION_XML_VALUE , produces=MediaType.APPLICATION_XML_VALUE)
	// @RequestMapping(value = "/postExample", method = RequestMethod.POST)
	public @ResponseBody WelcomeMessage postExampleXml(@RequestBody RequestMessage requestMessage) {
		
		return new WelcomeMessage("Hi " + requestMessage.getName(), "Greeting");
	}
	
	@RequestMapping(value = "/postExampleJson", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE , produces=MediaType.APPLICATION_JSON_VALUE)
	// @RequestMapping(value = "/postExample", method = RequestMethod.POST)
	public @ResponseBody WelcomeMessage postExampleJson(@RequestBody RequestMessage requestMessage) {
		
		return new WelcomeMessage("Hi " + requestMessage.getName(), "Greeting");
	}
}
