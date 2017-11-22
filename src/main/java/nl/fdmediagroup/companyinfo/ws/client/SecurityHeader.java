package nl.fdmediagroup.companyinfo.ws.client;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;

import nl.fdmediagroup.companyinfo.pojo.Authentication;

import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.soap.saaj.SaajSoapMessage;

/**
 * Class to create SOAP Header. Place holder of user name and password 
 * implementing WebServiceMessageCallback
 * 
 * @author dillipkumar.vp
 *
 */
public class SecurityHeader implements WebServiceMessageCallback {

	private Authentication authentication;
	
	private static final String QNAME = "http://schemas.xmlsoap.org/soap/envelope/";
	private static final String HEADERLOGIN = "HeaderLogin"; 
	private static final String SOAPSTRING = "soap";

	/**
	 * Default constructor
	 * @param authentication
	 */
	public SecurityHeader(Authentication authentication) {
		this.authentication = authentication;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.ws.client.core.WebServiceMessageCallback#doWithMessage(org.springframework.ws.WebServiceMessage)
	 */
	@Override
	public void doWithMessage(WebServiceMessage message) {
		try {
			SOAPMessage soapMessage = ((SaajSoapMessage)message).getSaajMessage();
			SOAPHeader header = soapMessage.getSOAPHeader();
			SOAPHeaderElement security = header.addHeaderElement(
							new QName(QNAME, HEADERLOGIN,SOAPSTRING));
			SOAPElement username = security.addChildElement("username",SOAPSTRING);
			SOAPElement password = security.addChildElement("password",SOAPSTRING);
			username.setTextContent(authentication.getUsername());
			password.setTextContent(authentication.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
