package nl.fdmediagroup.companyinfo.service;

import nl.fdmediagroup.companyinfo.exception.CarInfoException;
import nl.webservices.soap.Car;

/**
 * Functional Interface to fetch the Car details for given car Registration. 
 *  
 * @author dillipkumar.vp
 *
 */

@FunctionalInterface
public interface ICarInfoService {

	/**
	 * Interface to validate and fetch the details of the given car registration. 
	 * @param carRegNumber
	 * @return Car
	 */
	public Car validateCarInfo(String carRegNumber) throws CarInfoException;
	
}
