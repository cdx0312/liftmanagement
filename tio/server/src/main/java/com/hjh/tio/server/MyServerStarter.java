package com.hjh.tio.server;

import java.io.IOException;

import com.hjh.tio.common.Const;
import org.tio.server.TioServer;
import org.tio.server.ServerGroupContext;
import org.tio.server.intf.ServerAioHandler;
import org.tio.server.intf.ServerAioListener;

/**
 *
 * @author tanyaowu
 * 2017年3月27日 上午12:16:31
 */
public class MyServerStarter {
	static ServerAioHandler aioHandler = new MyServerAioHandler();
	static ServerAioListener aioListener = new MyServerAioListener();
	static ServerGroupContext serverGroupContext = new ServerGroupContext(aioHandler, aioListener);
	static TioServer tioServer = new TioServer(serverGroupContext); //可以为空

	static String serverIp = null;
	static int serverPort = Const.PORT;

	public static void main(String[] args) throws IOException {
		tioServer.start(serverIp, serverPort);
	}
}