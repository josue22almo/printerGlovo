package com.services;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

import woyou.aidlservice.jiuiv5.IWoyouService;


public class MServiceConnection implements ServiceConnection{

    public IWoyouService getWoyouService() {
        return woyouService;
    }

    private IWoyouService woyouService;

    public MServiceConnection(IWoyouService woyouService) {
        this.woyouService = woyouService;
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        woyouService = null;
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        woyouService = IWoyouService.Stub.asInterface(service);
    }
}
