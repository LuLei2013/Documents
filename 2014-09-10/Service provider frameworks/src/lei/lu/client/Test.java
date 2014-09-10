/**
 * 模拟客户端使用
 */

package lei.lu.client;

import lei.lu.declares.ServiceManager;

/**
 * @author lulei lei.a.lu@ericsson.com
 * @version Sep 10, 2014 4:53:15 PM
 */
public class Test {
	public static void main(String[] args) {
		try {
			Class.forName("lei.lu.thirdPart.ServiceImp");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		ServiceManager.service();
	}
}
