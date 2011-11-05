package com.google.wireless.gdata.parser.xml;

import com.google.wireless.gdata.data.Entry;
import com.google.wireless.gdata.data.Feed;
import com.google.wireless.gdata.data.MediaEntry;
import com.google.wireless.gdata.parser.ParseException;
import com.google.wireless.gdata.parser.xml.XmlGDataParser;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;

public class XmlMediaEntryGDataParser extends XmlGDataParser {

   public XmlMediaEntryGDataParser(InputStream var1, XmlPullParser var2) throws ParseException {
      super(var1, var2);
   }

   protected Entry createEntry() {
      return new MediaEntry();
   }

   protected Feed createFeed() {
      throw new UnsupportedOperationException("there is no such thing as a feed of media entries");
   }
}
