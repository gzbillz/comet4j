/*
 *  不了了之之了之  http://blog.csdn.net/howareyoutodaysoft
 *  
 */
package com;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.comet4j.core.CometContext;
import org.comet4j.core.CometEngine;

/**
 * @description HelloWorld
 * @author 不了了之之了之
 * @data 2013-5-29
 */
public class HelloWorld implements ServletContextListener {
	private static final String CHANNEL = "hello";

	public void contextInitialized(ServletContextEvent arg0) {
		CometContext cc = CometContext.getInstance();
		cc.registChannel(CHANNEL);// 注册应用的channel
		Thread helloAppModule = new Thread(new HelloAppModule(),
				"Sender App Module");
		helloAppModule.setDaemon(true);
		helloAppModule.start();

	}

	class HelloAppModule implements Runnable {
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				CometEngine engine = CometContext.getInstance().getEngine();
				long msg = Runtime.getRuntime().freeMemory() / 1024;
				engine.sendToAll(CHANNEL, msg);
				System.out.println("测试：" + msg);
			}
		}
	}

	public void contextDestroyed(ServletContextEvent arg0) {

	}
}