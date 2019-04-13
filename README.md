# Ti.FeitianSmartcardReader

Axway Titanium module for communication with Feitians Smartcardreader.

![](https://avatars1.githubusercontent.com/u/9547938?s=460&v=4)

Demo app from provider:

![](https://api.qrserver.com/v1/create-qr-code/?data=http%3A%2F%2Fbit.ly%2F2GlDj5T&size=220x220&margin=0)


## Methods


### find()
Find the reader, this method will scan BT  to list the reader found

### open()
Connect the reader

### close()
Close the reader 

### powerOn()
Do power on on card

### powerOff()
Do power off on card

### readXfr()
Transfer APDU to card and get return data back

### getSlotStatus()
Get slot status, for example, card absent/present

### getType()
Returns serial number, firmware version and other

## Usage

```js
const Reader = require('de.appwerft.feitian');
Reader.Bluetooth.isAvailable();

Reader.onConnect = function(device) {
	
};
Reader.addEventListener("onComplete",function(e){
	console.log(e);
});
Reader.find();
const type = Reader.getType();

```