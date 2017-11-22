package nl.fdmediagroup.companyinfo.service.impl;

import javax.xml.bind.JAXBElement;

import nl.fdmediagroup.companyinfo.exception.CarInfoException;
import nl.fdmediagroup.companyinfo.pojo.Authentication;
import nl.fdmediagroup.companyinfo.service.ICarInfoService;
import nl.fdmediagroup.companyinfo.ws.client.SecurityHeader;
import nl.webservices.soap.Car;
import nl.webservices.soap.CarRDWCarDataRequestType;
import nl.webservices.soap.CarRDWCarDataResponseType;
import nl.webservices.soap.ObjectFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 * Implementation service to fetch the Car details for the given Car plate 
 * 
 * @author dillipkumar.vp
 *
 */

@Service
public class CarInfoService implements ICarInfoService  {

	@Autowired
	private WebServiceTemplate webServiceTemplate;

	//WS-User Name
	@Value("#{'${ws.user.id}'}")
	private String serviceUserId;
		
	//WS-User password
	@Value("#{'${ws.user.password}'}")
	private String serviceUserPassword;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * nl.fdmediagroup.companyinfo.service.ICarInfoService#validateCarInfo(java.lang.String)
	 * 
	 */
	@Override
	@Cacheable("cars")
	@SuppressWarnings("unchecked")
	public Car validateCarInfo(String carRegNumber) throws CarInfoException{
		try{
			ObjectFactory factory = new ObjectFactory();
			// Request object construction
			CarRDWCarDataRequestType carDataRequestType = new CarRDWCarDataRequestType();
			carDataRequestType.setLicensePlate(carRegNumber);
			// Invoking the web service using Spring WS template
			JAXBElement<CarRDWCarDataResponseType> element =  (JAXBElement<CarRDWCarDataResponseType>) webServiceTemplate
					.marshalSendAndReceive(factory
							.createCarRDWCarData(carDataRequestType),
							new SecurityHeader(new Authentication(serviceUserId,
									serviceUserPassword)));
			CarRDWCarDataResponseType carDataResponseType = element.getValue();
			return carDataResponseType.getOut();
		}
		catch(Exception e){
			throw new CarInfoException(e);
		}
	}
}
