/*
 * Copyright 2010 sasc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sasc.iso7816;

import sasc.iso7816.IsoATR;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.common.Log;

import de.appwerft.feitian.FeitianModule;
import sasc.lookup.ATR_DB;

import sasc.util.Util;

/**
 * Answer To Reset (ATR)
 * 
 * contactless cards don't have ATRs. The ATR value is faked by the reader
 * ISO 14443-B cards have a PUPI (4 bytes)
 * ISO 14443-A cards have an UID (4,7 or 10 bytes)
 * this value is exchanged before the reader reports a fake-ATR.
 * 
 * Mostly the warm and cold reset will have the same value.
 * As per ISO7816 there are 2 supported modes of communication:
 * 1. Negotiable mode: Here the ATR indicates the maximum communication speed. 
 *    Hence the host can communicate with the card using speed not exceeding the mentioned limit
 * 2. Specific Mode: Here the ATR indicates the only communication speed to be used. 
 *    Hence the host should use this speed to communicate with the card.
 * This mode of communication might be a requirement for few domain like Banking.
 * There are smart cards available that support these 2 modes and on COLD reset the 
 * specific mode gets activated and this is indicated in the ATR bytes. (TA2)
 * Warm reset will always be available and the byte TA2 will not be present in it.
 * 
 * @author sasc
 */
public class ATR {
    private byte[] atrBytes;
    private IsoATR isoATR = null;
    private boolean isIsoCompliant = false;
    private String errorMsg = "";
    private String LCAT= FeitianModule.LCAT;

    public ATR(byte[] atrBytes){
        this.atrBytes = atrBytes;

        try{
            isoATR = IsoATR.parse(atrBytes);
            isIsoCompliant = true;
            Log.d(LCAT,"isIsoCompliant");
        }catch(IsoATR.ParseException ex){
        	 Log.e(LCAT,ex.getMessage());
            errorMsg = ex.getMessage();
        }

    }

    public boolean isIsoCompliant(){
        return isIsoCompliant;
    }

    /**
     * Get the ISO compliant ATR
     * @return the ISO compliant ATR, or null if the ATR is not ISO compliant
     */
    public IsoATR getIsoCompliantATR(){
        return isoATR;
    }
    
    public byte[] getBytes(){
        return atrBytes;
    }
 
    public KrollDict dump(){
    	KrollDict res = new KrollDict();
        Log.d(LCAT,"Answer To Reset (ATR)");
        ATR_DB.initialize();
        List<String> descriptiveText = ATR_DB.searchATR(atrBytes);
        if(descriptiveText != null){
        	res.put("descriptiveText", ATR_DB.searchATR(atrBytes).toArray());
        }
        if(isIsoCompliant()){
            isoATR.dump(res);
        }
        Log.d(LCAT,res.toString());
        return res;
    }

}