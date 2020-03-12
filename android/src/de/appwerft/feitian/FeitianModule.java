/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2018 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package de.appwerft.feitian;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollFunction;
import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.titanium.TiApplication;

import com.ftsafe.DK;
import com.ftsafe.Utility;
import com.ftsafe.readerScheme.FTException;
import com.ftsafe.readerScheme.FTReader;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;

@Kroll.module(name = "Feitian", id = "de.appwerft.feitian", propertyAccessors = { "onConnect", "onError" })
public class FeitianModule extends KrollModule {

	public static final String LCAT = "🧩TiFeitian";

	KrollDict callbacks = new KrollDict();

	public FTReader ftReader;
	private int testi = 0;
	private Context ctx = TiApplication.getInstance().getApplicationContext();

	ArrayList<BluetoothDevice> arrayForBlueToothDevice = new ArrayList<BluetoothDevice>();
	ArrayList<DeviceProxy> arrayForBlueToothDeviceProxy = new ArrayList<DeviceProxy>();

	@Kroll.constant
	public static final int USB_LOG = DK.USB_LOG;
	@Kroll.constant
	public static final int USB_IN = DK.USB_IN;
	@Kroll.constant
	public static final int USB_OUT = DK.USB_OUT;
	@Kroll.constant
	public static final int CARD_IN_MASK = DK.CARD_IN_MASK;
	@Kroll.constant
	public static final int CARD_OUT_MASK = DK.CARD_OUT_MASK;
	@Kroll.constant
	public static final int CCIDSCHEME_LOG = DK.CCIDSCHEME_LOG;
	@Kroll.constant
	public static final int FTREADER_LOG = DK.FTREADER_LOG;
	@Kroll.constant
	public static final int PCSCSERVER_LOG = DK.PCSCSERVER_LOG;
	@Kroll.constant
	public static final int BT3_LOG = DK.BT3_LOG;
	@Kroll.constant
	public static final int BT3_NEW = DK.BT3_NEW;
	@Kroll.constant
	public static final int BT4_LOG = DK.BT4_LOG;
	@Kroll.constant
	public static final int BT4_NEW = DK.BT4_NEW;
	@Kroll.constant
	public static final int BT4_ACL_DISCONNECTED = DK.BT4_ACL_DISCONNECTED;
	@Kroll.constant
	public static final int FTREADER_TYPE_USB = DK.FTREADER_TYPE_USB;
	@Kroll.constant
	public static final int FTREADER_TYPE_BT3 = DK.FTREADER_TYPE_BT3;
	@Kroll.constant
	public static final int FTREADER_TYPE_BT4 = DK.FTREADER_TYPE_BT4;
	@Kroll.constant
	public static final int CARD_PRESENT_ACTIVE = DK.CARD_PRESENT_ACTIVE;
	@Kroll.constant
	public static final int CARD_PRESENT_INACTIVE = DK.CARD_PRESENT_INACTIVE;
	@Kroll.constant
	public static final int CARD_NO_PRESENT = DK.CARD_NO_PRESENT;
	@Kroll.constant
	public static final int READER_R301E = DK.READER_R301E;
	@Kroll.constant
	public static final int READER_BR301FC4 = DK.READER_BR301FC4;
	@Kroll.constant
	public static final int READER_BR500 = DK.READER_BR500;
	@Kroll.constant
	public static final int READER_R502_CL = DK.READER_R502_CL;
	@Kroll.constant
	public static final int READER_R502_DUAL = DK.READER_R502_DUAL;
	@Kroll.constant
	public static final int READER_BR301 = DK.READER_BR301;
	@Kroll.constant
	public static final int READER_IR301_LT = DK.READER_IR301_LT;
	@Kroll.constant
	public static final int READER_IR301 = DK.READER_IR301;
	@Kroll.constant
	public static final int READER_VR504 = DK.READER_VR504;
	@Kroll.constant
	public static final int READER_UNKNOW = DK.READER_UNKNOW;

	@Kroll.constant
	public static final int MODUS_JNI = 1;
	@Kroll.constant
	public static final int MODUS_JAR = 0;

	final static int PORT = 0x096e;
	KrollFunction onRecv;
	
	public FeitianModule() {
		super();
		Log.d(LCAT, "Construct FeitianModule");

	}

	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app) {
		Log.d(LCAT, "onAppCreate FeitianModule");
	}

	@Kroll.method
	public FeitianModule readerFind() {
		try {
			arrayForBlueToothDevice.clear();
			ftReader = new FTReader(ctx, mHandler, DK.FTREADER_TYPE_BT3);
			if (ftReader != null)
				ftReader.readerFind();
			else
				Log.w(LCAT, "ftReader is null");
			return this;
		} catch (FTException e) {
			e.printStackTrace();
			return this;
		}
	}

	@Kroll.method
	public String[] readerOpen(Object o) {
		return openDevice(o);
	}

	@Kroll.method
	public String[] openDevice(Object o) {
		if (o instanceof DeviceProxy) {
			try {
				Log.d(LCAT, "try to openDevice …");
				BluetoothDevice device = ((DeviceProxy) o).device;
				String[] result = ftReader.readerOpen(device);
				return result;
			} catch (FTException e) {
				Log.e(LCAT, e.getLocalizedMessage());
				e.printStackTrace();
				return null;
			}
		}
		Log.w(LCAT, "property isn't device");
		return null;
	}
	
	@Kroll.method
	public void readXfr(String cmd, Object o) {
		if (o instanceof KrollFunction)
		onRecv = (KrollFunction)o;
		AsyncTask<String, Void, byte[]> doRequest = new AsyncAdapter();
		doRequest.execute(cmd);
		
	}
	
	@Kroll.method
	public String powerOn() {
		try {
			byte[] bytes = ftReader.readerPowerOn(0);
			return null;
		} catch (FTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			boolean devicefound = false;
			KrollDict event = new KrollDict();
			event.put("msgwhat", msg.what);
			switch (msg.what) {
			case -1:
				return;
			case 0:
				Log.d(LCAT, msg.obj.toString());
				break;

			case DK.BT3_LOG:
				Log.d(LCAT, "[BT3Log]:" + msg.obj);
				break;
			case DK.BT4_LOG:
				Log.d(LCAT, "[BT4Log]:" + msg.obj);
				break;
			case DK.FTREADER_LOG:
				Log.d(LCAT, "[FTReaderLog]:" + msg.obj);
				break;
			case DK.CCIDSCHEME_LOG:
				event.put("type", "CCIDSchemeLog");
				Log.d(LCAT, "[CCIDSchemeLog]:" + msg.obj);
				break;
			case DK.BT3_NEW:
			case DK.BT4_NEW:
				BluetoothDevice dev = (BluetoothDevice) msg.obj;
				Log.d(LCAT, "Device found: " + dev.getName());
				devicefound = true;
				event.put("type", msg.what == DK.BT3_NEW ? "BT" : "BLE");
				event.put("device", new DeviceProxy(dev));
				arrayForBlueToothDevice.add(dev);
				break;
			case DK.BT4_ACL_DISCONNECTED:
				BluetoothDevice dev3 = (BluetoothDevice) msg.obj;
				break;
			default:
				Log.d(LCAT,"default Result " + msg.what);
				if ((msg.what & DK.CARD_IN_MASK) == DK.CARD_IN_MASK) {
					return;
				} else if ((msg.what & DK.CARD_OUT_MASK) == DK.CARD_OUT_MASK) {
					return;
				}
				break;
			}
			if (devicefound && hasListeners("onfound")) {
				fireEvent("onfound", event);
			}
			Log.d(LCAT,"device found " + devicefound);
			if (devicefound && hasProperty("onFound")) {
				Log.d(LCAT,"device found and onFound");
				if (getProperty("onFound") instanceof KrollFunction) {
					KrollFunction onFound = (KrollFunction) (getProperty("onFound"));
					onFound.callAsync(getKrollObject(), event);
				} else Log.w(LCAT, "onFound != KrollFunction");
			} else Log.w(LCAT, "onFound missing");
		}
	};

	private void readCallbacks() {
		Iterator it = getProperties().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			if (pair.getValue() instanceof KrollFunction) {
				callbacks.put((String) pair.getKey(), pair.getValue());
			}
			it.remove(); // avoids a ConcurrentModificationException
		}
	}
	
	private class AsyncAdapter extends AsyncTask<String, Void, byte[]>{
		
		@Override
		protected byte[] doInBackground(String[] input) {
			byte[] send = Utility.hexStrToBytes(input[0]);
			byte[] recv= null;
			try {
				recv = ftReader.readerXfr(0,send);
				Utility.bytes2HexStr(recv);
			} catch (FTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return recv;
		}
		protected void onPostExecute(byte[] result) {
			if (onRecv != null) {
				KrollDict res = new KrollDict();
				res.put("data",Utility.bytes2HexStr(result));
				onRecv.call(getKrollObject(), res);
				
			}
		}
	}

}
