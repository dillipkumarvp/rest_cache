package nl.fdmediagroup.companyinfo.ws.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

/**
 * Base Spring-WS configuration class. Instead of XML file configuration, 
 * JAVA class configuration is implemented using Annotations 
 * 
 * @author dillipkumar.vp
 *
 */

@Configuration
public class ClientWSConfiguration {

	//End Point URL
	@Value("${ws.endpoint.url}")
    private String servicePort;
	
	/**
	 * Method to simplify the security header. So that SOAP Header 
	 * version is ignored
	 * 
	 * @return SaajSoapMessageFactory
	 */
	@Bean
	public SaajSoapMessageFactory messageFactory() {
		SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory();
		messageFactory.setSoapVersion(SoapVersion.SOAP_11);
		messageFactory.afterPropertiesSet();
		return messageFactory;
	}

	/**
	 * Marshaller for JAVA-XML and XML-JAVA
	 * 
	 * @return Jaxb2Marshaller
	 */
	@Bean
	Jaxb2Marshaller jaxb2Marshaller() {
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setContextPath("nl.webservices.soap");
		return jaxb2Marshaller;
	}

	/**
	 * Method to instantiate the Spring-WS Template. Client Interceptor 
	 * are added to add security header as the WS is secured.
	 *  
	 * @return WebServiceTemplate
	 */
	@Bean
	public WebServiceTemplate webServiceTemplate() {
		WebServiceTemplate webServiceTemplate = new WebServiceTemplate(messageFactory());
		//XML-JAVA / JAVA-XML convertion.
		webServiceTemplate.setMarshaller(jaxb2Marshaller());
		webServiceTemplate.setUnmarshaller(jaxb2Marshaller());
		webServiceTemplate.setDefaultUri(servicePort);
		return webServiceTemplate;
	}

}
