// This is a test harness for your module
// You should do something interesting in this harness
// to test out the module and to provide instructions
// to users on how to use it by example.


// open a single window
var win = Ti.UI.createWindow({
	backgroundColor:'white',
	layout: 'vertical'
	
});
const Reader = require('de.appwerft.feitian');
const jniButton = Titanium.UI.createButton({title:"find",top:0});
win.add(jniButton);
jniButton.addEventListener('click',function(){
    Reader.find();
});

var label = Ti.UI.createLabel();
win.add(label);
win.open();

// TODO: write your module tests here




//Reader.Bluetooth.isAvailable();
/*
Reader.onConnect = function(device) {
     console.log(device);
};
Reader.addEventListener("onComplete",function(e){
    console.log(e);
});

Reader.find();

const type = Reader.getType();
*/