package cab.system.factory;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

import cab.system.bo.CabSystemBO;
import cab.system.bo.CabSystemBOImpl;
import cab.system.dao.CabSystemDao;
import cab.system.dao.CabSystemDaoImpl;
import cab.system.model.CabSystemModel;
import cab.system.validator.CabSystemValidator;
import cab.system.view.CabSystemView;

public final class CabSystemFactory {
	
	// Static Block ****************************8

	private static final Logger logger = Logger.getLogger(CabSystemFactory.class.getName());
	private static final CabSystemFactory  factory  =  new CabSystemFactory();
	private static final CabSystemView cabSystemView = new CabSystemView();
	private static final CabSystemModel cabSystemModel =  new CabSystemModel();
	private static final CabSystemValidator cabSystemValidator = new CabSystemValidator();
	private static final CabSystemDao cabSystemDao = new CabSystemDaoImpl();
	private static final CabSystemBO cabSystemBO = new CabSystemBOImpl(cabSystemDao);

	private static final AtomicInteger userRequestIdGenerator= new AtomicInteger(100);
	
	static{
		logger.info("Initialising CabSystemFactory..");
	}
	
	public static CabSystemFactory getCabSystemFactory(){
		return factory;
	}
	
	// Instance Block ****************************8
	
	
	private CabSystemFactory(){
		// Avoiding instantiation of this factory
	}
	
	public CabSystemView getCabSystemView() {
		return cabSystemView;
	}
	public CabSystemModel getCabsystemmodel() {
		return cabSystemModel;
	}

	public CabSystemDao getCabSystemDao() {
		return cabSystemDao;
	}
	
	public int getUserrequestid() {
		return userRequestIdGenerator.incrementAndGet();
	}

	public CabSystemValidator getCabSystemValidator() {
		return cabSystemValidator;
	}

	public static Logger getLogger() {
		return logger;
	}

	public static CabSystemFactory getFactory() {
		return factory;
	}

	public static CabSystemView getCabsystemview() {
		return cabSystemView;
	}

	public static CabSystemValidator getCabsystemvalidator() {
		return cabSystemValidator;
	}

	public static CabSystemDao getCabsystemdao() {
		return cabSystemDao;
	}

	public static CabSystemBO getCabSystemBO() {
		return cabSystemBO;
	}

	public static AtomicInteger getUserrequestidgenerator() {
		return userRequestIdGenerator;
	}
	
}
