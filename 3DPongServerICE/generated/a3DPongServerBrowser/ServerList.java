// **********************************************************************
//
// Copyright (c) 2003-2018 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.7.1
//
// <auto-generated>
//
// Generated from file `NetworkInterfacesSB.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package a3DPongServerBrowser;

public class ServerList extends com.zeroc.Ice.Value
{
    public ServerList()
    {
    }

    public ServerList(Server[] servers)
    {
        this.servers = servers;
    }

    public Server[] servers;

    public ServerList clone()
    {
        return (ServerList)super.clone();
    }

    public static String ice_staticId()
    {
        return "::a3DPongServerBrowser::ServerList";
    }

    @Override
    public String ice_id()
    {
        return ice_staticId();
    }

    public static final long serialVersionUID = -970735890L;

    @Override
    protected void _iceWriteImpl(com.zeroc.Ice.OutputStream ostr_)
    {
        ostr_.startSlice(ice_staticId(), -1, true);
        ServersHelper.write(ostr_, servers);
        ostr_.endSlice();
    }

    @Override
    protected void _iceReadImpl(com.zeroc.Ice.InputStream istr_)
    {
        istr_.startSlice();
        servers = ServersHelper.read(istr_);
        istr_.endSlice();
    }
}
