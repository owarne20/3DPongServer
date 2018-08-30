package com.a3DPong.serverBrowser;

import java.util.ArrayList;

import com.a3DPong.serverBrowser.networkInterfaces.ServerBrowserClientI;
import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;

import a3DPongServerBrowser.ServerBrowserServerPrx;



public class ServerBrowserToClient implements Runnable{

	private boolean running;
	private Thread thread;
	
	public ServerBrowserToClient()
	{
		
	}
	
	@Override
	public void run() {
		// TODO Port forward correct ports for ServerBrowser
		String address = "10.0.0.61";
		String port = "10001";
		try(Communicator communicator = Util.initialize())
		{
			ObjectAdapter adapter = 
					communicator.createObjectAdapterWithEndpoints("ClientCommunicationAdapter", "default -h " + address + " -p " + port + " ");
			adapter.add(new ServerBrowserClientI(this), com.zeroc.Ice.Util.stringToIdentity("client"));
			adapter.activate();
			System.out.println("SB to client started on " + address + ":" + port + "\nWaiting for clients...");
			communicator.waitForShutdown();
		}
		
	}
	
	public void addClientProxy(ServerBrowserServerPrx client)
	{
		System.out.println("Client has been sent servers");
		client.sendServerListAsync(Main.getServers());
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
