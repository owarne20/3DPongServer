package com.a3DPong.serverBrowser.networkInterfaces;

import com.a3DPong.serverBrowser.ServerBrowserToServer;
import com.zeroc.Ice.Current;

import a3DPongServerBrowser.GameServer;
import a3DPongServerBrowser.Server;


public class GameServerI implements GameServer{

	//TODO: add servers to ServerBrowserToServer
	
	private ServerBrowserToServer serverBrowserToServer;
	
	public GameServerI(ServerBrowserToServer serverBrowserToServer)
	{
		this.serverBrowserToServer = serverBrowserToServer;
	}
	
	@Override
	public void sendServerDetails(Server server, Current current) {
		serverBrowserToServer.addServer(server);
		System.out.println("New Server Update:");
		System.out.println("Address: " + server.address + "\nName: " + server.name + "\nPlayers: " + server.players + "\nPort: " + server.port + "\nUUID: " + server.UUID);
	}

}
