package rajesh.boot.rest.beans;

import java.util.Random;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
public class SessionId {

	private String sessionId = "" + new Random().nextInt();

	public SessionId() {
		sessionId = "" + new Random().nextInt();
	}
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
}
