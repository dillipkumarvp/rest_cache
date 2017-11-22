package nl.fdmediagroup.companyinfo.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Place Holder for user name and password for SOAP security header.
 * 
 * @author dillipkumar.vp
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace = Authentication.AUTH_NS)
public class Authentication {
	
	public static final String AUTH_NS = "http://schemas.xmlsoap.org/soap/envelope/";

	@XmlElement(namespace = AUTH_NS)
	private String Username;
	@XmlElement(namespace = AUTH_NS)
	private String Password;

	public Authentication(){}
	
	public Authentication(String username, String password) {
		this.Username = username;
		this.Password = password;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		this.Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}
}
