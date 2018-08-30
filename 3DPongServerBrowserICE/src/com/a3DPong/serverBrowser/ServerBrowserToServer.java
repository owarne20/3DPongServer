package com.a3DPong.serverBrowser;

import java.util.ArrayList;

import com.a3DPong.serverBrowser.networkInterfaces.GameServerI;
import com.a3DPong.serverBrowser.networkInterfaces.ServerBrowserClientI;
import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;

import a3DPongServerBrowser.Server;


public class ServerBrowserToServer implements Runnable{

	private boolean running;
	private Thread thread;
	
	public ServerBrowserToServer()
	{
		
	}
	
	@Override
	public void run() {
		// TODO Port forward correct ports for ServerBrowser
		String address = "10.0.0.61";
		String port = "10002";
		try(Communicator communicator = Util.initialize())
		{
			ObjectAdapter adapter = 
					communicator.createObjectAdapterWithEndpoints("ClientCommunicationAdapter", "default -h " + address + " -p " + port + " ");
			adapter.add(new GameServerI(this), com.zeroc.Ice.Util.stringToIdentity("client"));
			adapter.activate();
			System.out.println("SB to server started on " + address + ":" + port + "\nWaiting for clients...");
			communicator.waitForShutdown();
		}
		
	}
	
	public void addServer(Server server)
	{
		Main.addServer(server);
	}
	
	public synchronized void start()
	{
		if(!running && thread == null){
			thread = new Thread(this);
			thread.start();
			running = true;
		}
		
	}
	public synchronized void stop()
	{
		System.out.println("Stopping");
		if(running && thread != null){
			running = false;
			try {
				thread.join(1);
			} catch (InterruptedException e) {
				System.err.println("Failed to end thread!!!!");
				e.printStackTrace();
			}
		}
	}

}
