# Ti.FeitianSmartcardReader

Axway Titanium module for communication with Feitians Smartcardreader.

![](https://avatars1.githubusercontent.com/u/9547938?s=460&v=4)

Demo app from provider:

![](https://api.qrserver.com/v1/create-qr-code/?data=http%3A%2F%2Fbit.ly%2F2GlDj5T&size=220x220&margin=0)


## Module methods

### readerFind()

Find the reader, this method will scan BT to list the reader found. The response you can catch in property `onFound`:

### readerOpen(device)
Returns a reader list.

```javascript
const FTReader = require('de.appwerft.feitian');
FTReader.onFound = function(reader) {
	const device  = reader.device;
	console.log(reader.what);
	console.log(reader.type);
	const readerlist = FTReader.readerOpen(device);
	console.log(readerlist);
}
FTReader.readerFind();
``` 



### readerOpen()
Connect the reader

### readerClose()
The API will close all opened reader.

### powerOn()
Do power on on card

### powerOff()
Do power off on card

### readXfr(String payload,function onLoad)
Transfer APDU to card and get return data back in callback

### getSlotStatus()
Get slot status, for example, card absent/present

### getType()
Returns serial number, firmware version and other


## Communication with German eGK

``` javascript
const COMMANDS = {
    'SELECT_MF': "00A4040C07D2760001448000",
    'SELECT_HCA': "00A4040C06D27600000102",
    'EF_VERSION_1': "00B2018400",
    'EF_VERSION_2': "00B2028400",
    'EF_VERSION_3': "00B2038400",
    'SELECT_FILE_PD': "00B0810002",
    'SELECT_FILE_VD': "00B0820008"
};
FTreader.readEgk(COMMANDS.SELECT_MF,function(e){
	console.log(e.data)
});

```