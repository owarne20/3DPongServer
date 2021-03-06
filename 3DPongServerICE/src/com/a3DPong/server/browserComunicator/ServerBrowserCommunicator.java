package com.a3DPong.server.browserComunicator;

import com.a3DPong.server.util.ServerInfo;
import com.zeroc.Ice.Communicator;

import a3DPongServerBrowser.GameServerPrx;
import a3DPongServerBrowser.Server;

public class ServerBrowserCommunicator implements Runnable{

	private Thread thread;
	private boolean running;
	private Communicator communicator;
	private int players = 0;
	
	@Override
	public void run() 
	{
		//Connect to ServerBrowser and send details.
		communicator = com.zeroc.Ice.Util.initialize();
        GameServerPrx clientPrx = GameServerPrx.checkedCast(
                communicator.stringToProxy("client:default -h 58.167.142.74 -p 10002")).ice_twoway().ice_secure(false).ice_collocationOptimized(false).ice_compress(true);

        if(clientPrx == null)
        {
            //If connection is failed due to server problems
            System.err.println("SB Connect: " + "Invalid proxy");
            return;
        }
        System.out.println("SB Connect: " + "Connected");
        Server server = new Server();
        server.address = ServerInfo.ADDRESS;
        server.UUID = ServerInfo.UUID;
        server.port = ServerInfo.PORT;
        server.name = ServerInfo.NAME;
        server.players = (short) players;
		clientPrx.sendServerDetails(server);
		System.out.println("SB Connect: " + "Data sent");
	}
	
	public synchronized void push(int players)
	{
		if(!running)
		{
			this.players = players;
			thread = new Thread(this);
			thread.start();
		}
	}

}
