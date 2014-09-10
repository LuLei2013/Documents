/**
 * 模拟第三方实现官方的接口的定义
 */

package lei.lu.thirdPart;

import lei.lu.declares.Service;
import lei.lu.declares.ServiceManager;

/**
 * @author lulei lei.a.lu@ericsson.com
 * @version Sep 10, 2014 4:51:54 PM
 */
public class ServiceImp implements Service {

	static {
		ServiceManager.setInstance(new ServiceImp());
	}

	private ServiceImp() {
	}

	@Override
	public void doSomething() {
		System.out.println("do my own things");
	}
}
