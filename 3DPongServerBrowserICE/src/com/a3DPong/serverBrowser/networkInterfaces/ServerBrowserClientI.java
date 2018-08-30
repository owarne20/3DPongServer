package com.a3DPong.serverBrowser.networkInterfaces;

import com.a3DPong.serverBrowser.ServerBrowserToClient;
import com.zeroc.Ice.Current;

import a3DPongServerBrowser.ServerBrowserClient;
import a3DPongServerBrowser.ServerBrowserServerPrx;

public class ServerBrowserClientI implements ServerBrowserClient{

	private ServerBrowserToClient serverBrowserToClient;
	
	public ServerBrowserClientI(ServerBrowserToClient serverBrowserToClient)
	{
		this.serverBrowserToClient = serverBrowserToClient;
	}
	
	@Override
	public void sendServerCallback(ServerBrowserServerPrx server, Current current) 
	{
		serverBrowserToClient.addClientProxy(server.ice_fixed(current.con));
	}

}
