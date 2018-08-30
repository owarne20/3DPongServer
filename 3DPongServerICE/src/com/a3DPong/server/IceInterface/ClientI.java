package com.a3DPong.server.IceInterface;

import com.a3DPong.server.ServerMain;
import com.zeroc.Ice.Current;
import com.zeroc.Ice.Identity;

import a3DPong.Client;
import a3DPong.ServerPrx;

public class ClientI implements Client{
	
	public ClientI()
	{
		
	}
	

	@Override
	public void sendPaddlePositionX(float x, Current current) 
	{
		ServerMain.setPaddlePositionX(x, current.con._toString());
	}

	@Override
	public void disconnect(String reason, Current current) 
	{
		ServerMain.clientDisconnected(current.con._toString());
		System.out.println(current.con._toString() + " disconnected: " + reason);
	}



	@Override
	public void sendServerCallback(ServerPrx server, Current current) {
		System.out.println("Callback Recieved from: " + current.con._toString());
		ServerMain.addClientProxy(server.ice_fixed(current.con), current.con._toString());
		
	}


}
