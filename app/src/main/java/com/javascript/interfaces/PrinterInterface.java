package com.javascript.interfaces;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.RemoteException;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.callbacks.MCallback;
import com.drivers.MPrinterDriver;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.models.Order;
import com.models.enums.FontSize;
import com.services.MServiceConnection;
import com.xuzh.demowebviewjs.R;

import java.lang.reflect.Type;
import java.util.Date;


import woyou.aidlservice.jiuiv5.ICallback;
import woyou.aidlservice.jiuiv5.IWoyouService;

public class PrinterInterface {

    private MPrinterDriver mPrinterDriver;
    private Context context;
    private IWoyouService woyouService;
    private Gson gson;
    private byte[] buffer;
    private ICallback callback;
    private Order order;

    public void setConnService(MServiceConnection connService) {
        this.connService = connService;
    }

    private MServiceConnection connService;

    public PrinterInterface(Context context) {
        this.context = context;
        this.callback = new MCallback();
        mPrinterDriver = new MPrinterDriver();
    }

    public void pushIntent() {
        Intent intent = new Intent();
        intent.setPackage("woyou.aidlservice.jiuiv5");
        intent.setAction("woyou.aidlservice.jiuiv5.IWoyouService");
        context.startService(intent);
        context.bindService(intent, connService, Context.BIND_AUTO_CREATE);
    }

    @JavascriptInterface
    public void print(final String orderJson) {
        Toast.makeText(context, orderJson,	Toast.LENGTH_SHORT).show();

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong());
            }
        });

        gson = gsonBuilder.create();
        order = gson.fromJson(orderJson, Order.class);
        woyouService = connService.getWoyouService();
        try {
            printLogo();
            printOrder();
            printEnd();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void printLogo() throws Exception{
        woyouService.printerInit(callback);
        woyouService.setAlignment(1, callback);
        Bitmap bm = BitmapFactory.decodeResource(context.getResources(), R.drawable.logo);
        woyouService.printBitmap(bm, callback);
        woyouService.lineWrap(1, null);

    }

    private void printOrder() throws Exception {
        printOrderPickupTime();
        printOrderCode();
        printOrderFields();
    }

     private void printOrderPickupTime() throws RemoteException {
        woyouService.printTextWithFont(order.getPickupTimeAsstring(), "gh" , FontSize.PICKUP_TIME, callback);
        woyouService.lineWrap(1, callback);
    }

    private void printOrderCode() throws RemoteException {
        woyouService.setAlignment(0, callback);
        String tiquetOwner = context.getResources().getString(R.string.ticket_owner);
        printAsterisk(FontSize.NUM_ASTERISK, FontSize.CODE);
        woyouService.printTextWithFont(lefMargin(1) + tiquetOwner + " " + order.getCode(),"bold", FontSize.CODE , callback);
        woyouService.lineWrap(1, callback);
        printAsterisk(FontSize.NUM_ASTERISK, FontSize.CODE);
    }

    private void printOrderFields() throws RemoteException {
        woyouService.printTextWithFont(order.getCourier().toString(), "gh", FontSize.COURIER, callback);
    }
    
      private void printAsterisk(int i, float fontSize) throws RemoteException {
        woyouService.printTextWithFont(lefMargin(1) + asterics(i) + newLine(), "gh", fontSize, callback);
    }

    private void printEnd() throws RemoteException {
        woyouService.lineWrap(FontSize.END, null);
    }

    private String lefMargin(int times){
        String margin = "";
        for (int i = 0; i < times; ++i)
            margin += " ";
        return margin;
    }

    private String asterics(int n) {
        String margin = "";
        for (int i = 0; i < n; ++i)
            margin += "*";
        return margin;
    }

    private String newLine() {
        return "\n";
    }



}
