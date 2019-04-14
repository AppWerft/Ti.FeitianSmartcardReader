package kawa;

import gnu.kawa.io.OutPort;
import gnu.kawa.io.Path;
import gnu.kawa.io.TtyInPort;
import java.io.IOException;
import java.io.Reader;



class GuiInPort
  extends TtyInPort
{
  ReplDocument document;
  
  public GuiInPort(Reader in, Path path, OutPort tie, ReplDocument document)
  {
    super(in, path, tie);
    this.document = document;
  }
  
  public void emitPrompt(String prompt) throws IOException
  {
    document.write(prompt, ReplDocument.promptStyle);
  }
}
