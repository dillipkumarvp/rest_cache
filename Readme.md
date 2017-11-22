------------------------------------------------------------
Car Information UseCase: (For fdmediagroup/companyinfo.nl)
-------------------------------------------------------------

Requirement FullfillMent:
-------------------------

100% requirement fullfillment.

Skipped the following which is part of best practises (Due to time constraints)

1. Junit testcases are not written as part of the time constraints
2. Logging is not handled. (Did not see any scope of logging)

Technical approach / Best Practises:
-------------------------------------

1. 5-10-20 rule followed (5 classes in a package, 10 Methods in a class, 20 Lines per Method)
2. Interface to hide the service agreements.
3. Custom exception thrown by wrapping the original exception 
4. Code is ran through SonarLint, to ensure no major deviations from coding principles.
5. Adopted SPR principles.

Technology Stack:
------------------

1. Basic JAVA 8 features.
2. Spring Boot.(1.5.4)
3. Spring Web Services
4. Spring WS Security
5. Maven
6. Spring-boot-starter-cache
7. Caffeine

Information about the packaging:-
-----------------------------------

1. Application is packed as FAT jar. (This mean all dependencies are part of the jar itself)
2. JAR is executable JAR.
3. Compiled with JAVA 8. 

How to Run the Program:
------------------------

1.	Need to have JRE 8.
2.  Copy the jar to any folder.
3.  Issue the following command from the windows command prompt. 

	java -jar companyinfo-0.0.1-SNAPSHOT.jar
	
How to manipulate Caching
----------------------------------

You will find the following parameter in application.properties.
expireAfterAccess variable will determine the duration of cache. Now it is set to 10 Min/600s. (Please use seconds factor to manipulate)

spring.cache.cache-names=cars
spring.cache.caffeine.spec=maximumSize=1000,expireAfterAccess=600s	
	
Sample Output:
-------------------

C:\Users\dillipkumar.vp\Desktop\Carinfo>java -jar companyinfo-0.0.1-SNAPSHOT.jar
Picked up _JAVA_OPTIONS: -Dcom.oracle.usagetracker.config.file="C:\ProgramData\Oracle\Java_AMC_2\jutConfig.txt"

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.5.4.RELEASE)

2017-09-19 18:45:56.100  INFO 9460 --- [           main] n.f.companyinfo.SpringWsApplication      : Starting SpringWsApplication v0.0.1-SNAPSHOT on dillip with P
2017-09-19 18:45:56.112  INFO 9460 --- [           main] n.f.companyinfo.SpringWsApplication      : No active profile set, falling back to default profiles: default
2017-09-19 18:45:56.350  INFO 9460 --- [           main] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApp
2017-09-19 18:46:00.317  WARN 9460 --- [           main] o.h.v.m.ParameterMessageInterpolator     : HV000184: ParameterMessageInterpolator has been chosen, EL interpolat
2017-09-19 18:46:00.886  WARN 9460 --- [           main] o.h.v.m.ParameterMessageInterpolator     : HV000184: ParameterMessageInterpolator has been chosen, EL interpolat
2017-09-19 18:46:01.122  INFO 9460 --- [           main] o.s.ws.soap.saaj.SaajSoapMessageFactory  : Creating SAAJ 1.3 MessageFactory with SOAP 1.1 Protocol
2017-09-19 18:46:01.210  INFO 9460 --- [           main] o.s.oxm.jaxb.Jaxb2Marshaller             : Creating JAXBContext with context path [nl.webservices.soap]
2017-09-19 18:46:11.550  INFO 9460 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
 -- Vehicle License [1SXS51] Brand [VOLKSWAGEN] Model [GOLF] APK Date [20180104] ---
 -- Vehicle License [03RGXL] Brand [VOLVO] Model [V70] APK Date [20180111] ---
 -- Vehicle License [SJVT62] Brand [VOLVO] Model [V70] APK Date [20180822] ---
 -- Vehicle License [93KDL1] Brand [RENAULT] Model [TWINGO] APK Date [20180419] ---
 -- Vehicle License [AE8890] Brand [MERCURY] Model [COUGAR] APK Date [20171203] ---
 -- Vehicle License [65RBP2] Brand [MERCEDES-BENZ] Model [A 170 CDI] APK Date [20170421] ---
 -- Vehicle License [KP640V] Brand [PORSCHE] Model [PANAMERA TURBO] APK Date [20201101] ---
 -- Vehicle License [JV817R] Brand [BMW] Model [M5] APK Date [20201006] ---
 -- Vehicle License [57-12-QQ] not found ---
 -- Vehicle License [HB001P] Brand [BMW] Model [750LI XDRIVE] APK Date [20191002] ---
 -- Vehicle License [KT189V] Brand [BMW I] Model [I8] APK Date [20210706] ---
 -- Vehicle License [7KSL74] Brand [VOLKSWAGEN] Model [LUPO] APK Date [20171116] ---
 -- Vehicle License [34ZNGT] Brand [VOLVO] Model [V50] APK Date [20180703] ---
 -- Vehicle License [57GVBZ] Brand [CITROEN] Model [SAXO] APK Date [20180504] ---
 -- Vehicle License [21GLRH] Brand [NISSAN] Model [NISSAN ALMERA] APK Date [20180501] ---
2017-09-19 18:46:20.048  INFO 9460 --- [           main] n.f.companyinfo.SpringWsApplication      : Started SpringWsApplication in 25.643 seconds (JVM running for 27.752
2017-09-19 18:46:20.051  INFO 9460 --- [       Thread-2] s.c.a.AnnotationConfigApplicationContext : Closing org.springframework.context.annotation.AnnotationConfigApplic
2017-09-19 18:46:20.054  INFO 9460 --- [       Thread-2] o.s.j.e.a.AnnotationMBeanExporter        : Unregistering JMX-exposed beans on shutdown






