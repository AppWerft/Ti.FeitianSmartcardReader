package gnu.kawa.xslt;

import gnu.mapping.Procedure;

class TemplateEntry
{
  Procedure procedure;
  double priority;
  String pattern;
  TemplateEntry next;
  
  TemplateEntry() {}
}
