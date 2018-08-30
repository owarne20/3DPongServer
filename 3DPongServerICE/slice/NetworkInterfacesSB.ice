module a3DPongServerBrowser
{
	
	class Server
	{
		string name;
		string address;
		string port;
		string UUID;
		short players;
	}
	
	sequence<Server> Servers;
	
	class ServerList
	{
		Servers servers;
	}
	
    interface ServerBrowserServer
    {
		void sendServerList(ServerList sl);
    }
    interface ServerBrowserClient
    {
        void sendServerCallback(ServerBrowserServer* server);
    }
    interface GameServer
    {
    	void sendServerDetails(Server server);
    }
    
}