package nl.fdmediagroup.companyinfo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import nl.fdmediagroup.companyinfo.constants.CompanyInfoConstants;
import nl.fdmediagroup.companyinfo.exception.CarInfoException;
import nl.fdmediagroup.companyinfo.service.ICarInfoService;
import nl.webservices.soap.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * 
 * Class to load the Spring boot starter. Class implements CLR to call the
 * CarInfoService.
 * 
 * @author dillipkumar.vp
 *
 */

@SpringBootApplication
@EnableCaching
public class SpringWsApplication implements CommandLineRunner {

	@Autowired
	private ICarInfoService carInfoService;

	@Autowired
	private ResourceLoader resourceLoader;

	/**
	 * Loads the Spring Application Context
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringWsApplication.class, args);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... arg0) throws Exception {
		Resource resource = resourceLoader.getResource(CompanyInfoConstants.RESOURCE_INPUT_FILENAME);
		BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
		String carRegNumber;
		while ((carRegNumber = br.readLine()) != null) {
			//Service Invocation to fetch the car details from WS
			try{
				Car car = carInfoService.validateCarInfo(carRegNumber);
				System.out.println(String.format(" -- Vehicle License [%s] Brand [%s] Model [%s] APK Date [%s] ---", car.getLicensePlate(), car.getBrand(), car.getModel(), car.getApkDueDate()));	
			}catch(CarInfoException e){
				System.out.println(String.format(" -- Vehicle License [%s] not found ---", carRegNumber));
			}
		}
		br.close();
	}
}
