package com.callbacks;

import android.os.RemoteException;
import woyou.aidlservice.jiuiv5.ICallback;


public class MCallback extends ICallback.Stub  {

    @Override
    public void onRunResult(boolean isSuccess) throws RemoteException {

    }

    @Override
    public void onReturnString(String result) throws RemoteException {

    }

    @Override
    public void onRaiseException(int code, String msg) throws RemoteException {

    }
}
