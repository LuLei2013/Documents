/**
 * 模拟官方的工具类定义
 */
package lei.lu.declares;

/**
 * @author lulei lei.a.lu@ericsson.com
 * @version Sep 10, 2014 4:48:37 PM
 */
public class ServiceManager {
	static private Service service;

	public static void setInstance(Service serviceP) {
		if (null == service)
			// pay attention to here, if service ,it will throw
			// NullPointerException
			synchronized (ServiceManager.class) {
				if (null == service) {
					service = serviceP;
				}
			}
	}

	public static void service() {
		service.doSomething();
	}
}
