package cab.system.context;


/**
 * This class acts as a container to our thread local variables.
 * @author Swaraj
 *
 */
public class CabSystemContextWrapper {

    private static final ThreadLocal threadLocal = new ThreadLocal();
	
	public static void setCabSystemContext(CabSystemContext obj){
		threadLocal.set(obj);
	}
	
	public static CabSystemContext getCabSystemContext(){
		return (CabSystemContext)threadLocal.get();
	}
}
