package gnu.ecmascript;

import gnu.kawa.io.InPort;

class Prompter extends gnu.mapping.Procedure1 {
  Prompter() {}
  
  String prompt(InPort port) {
    return "(EcmaScript:" + (port.getLineNumber() + 1) + ") ";
  }
  
  public Object apply1(Object arg)
  {
    return prompt((InPort)arg);
  }
}
