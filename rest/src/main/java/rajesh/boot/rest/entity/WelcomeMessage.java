package rajesh.boot.rest.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "xml")
@XmlType(propOrder={"type", "message"})
@XmlAccessorType(XmlAccessType.FIELD)
public class WelcomeMessage implements Serializable {

	private String message;
	private String type;
	
	public WelcomeMessage(String message, String type) {
		this.message = message;
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public String getType() {
		return type;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setType(String type) {
		this.type = type;
	}
}
