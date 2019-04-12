package de.appwerft.feitian;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollFunction;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.kroll.common.TiMessenger;
import org.appcelerator.titanium.TiApplication;
import org.appcelerator.titanium.util.TiActivityResultHandler;
import org.appcelerator.titanium.util.TiActivitySupport;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import de.appwerft.feitian.KrollCallbacks;

@Kroll.module(parentModule = FeitiansmartcardreaderModule.class, propertyAccessors = { "onSuccess" })
public class BluetoothModule extends FeitiansmartcardreaderModule {
	private Context ctx;
	
	boolean findDevicesRunning = false;
	boolean activityStopped = true;
	final static int REQUEST_CODE = 3667;

	BluetoothAdapter bAdapter;
	KrollCallbacks callbacks;
	@Kroll.constant
	final static int NOTAVAILABLE = 0;
	@Kroll.constant
	final static int DISABLED = 1;
	@Kroll.constant
	final static int ENABLED = 2;

	public static final String LCAT = FeitiansmartcardreaderModule.LCAT;

	public BluetoothModule() {
		super();

	}

	@Kroll.method
	public boolean isAvailable() {
		return (bluetoothAdapter == null) ? false : true;
	}
	
	@Kroll.method
	public int getAvailability() {
		if (bluetoothAdapter == null) return NOTAVAILABLE;
		return bluetoothAdapter.isEnabled() ? ENABLED : DISABLED;
	}

	@Kroll.method
	public boolean isEnabled() {
		if (bluetoothAdapter == null) {
			return false;
		} else {
			return (bluetoothAdapter.isEnabled()) ? true : false;
		}
	}
	private KrollFunction onSuccessCallback;
	@Kroll.method
	public boolean enable(@Kroll.argument(optional = true) KrollDict opts) {
		
		if (hasProperty("onSuccess")) {
			onSuccessCallback = (KrollFunction)getProperty("onSuccess");
		}
		if (opts == null) {
			return btAdapter.enable();
		} else {
			callbacks = new KrollCallbacks(this, opts);
			final Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
			final TiActivitySupport activitySupport = (TiActivitySupport) TiApplication.getInstance()
					.getCurrentActivity();

			if (TiApplication.isUIThread()) {
				activitySupport.launchActivityForResult(intent, REQUEST_CODE, new BTEnablerResultHandler());
			} else {
				TiMessenger.postOnMain(new Runnable() {
					@Override
					public void run() {
						activitySupport.launchActivityForResult(intent, REQUEST_CODE, new BTEnablerResultHandler());
					}
				});
			}
			return true;
		}
	}

	@Kroll.method
	public void disable() {
		BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		if (bluetoothAdapter.isEnabled()) {
			bluetoothAdapter.disable();
		}
		return;
	}

	private final class BTEnablerResultHandler implements TiActivityResultHandler {

		@Override
		public void onError(Activity activity, int requestCode, Exception ex) {
			KrollDict event = new KrollDict();
			event.put("message", ex.getLocalizedMessage());
			callbacks.call("onerror", event);
		}

		@Override
		public void onResult(Activity activity, int requestCode, int resultCode, Intent data) {
			if (requestCode == REQUEST_CODE) {
				KrollDict event = new KrollDict();
				event.put("result", resultCode);
				event.put("name", btAdapter.getName());
				event.put("address", btAdapter.getAddress());
				callbacks.call("onsuccess", event);
				if (onSuccessCallback != null) onSuccessCallback.callAsync(getKrollObject(),event);
			}
		}
	}
}