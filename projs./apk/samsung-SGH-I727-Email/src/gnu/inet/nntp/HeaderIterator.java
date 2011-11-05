package gnu.inet.nntp;

import gnu.inet.nntp.HeaderEntry;
import gnu.inet.nntp.LineIterator;
import gnu.inet.nntp.NNTPConnection;
import java.io.IOException;
import java.util.NoSuchElementException;

public class HeaderIterator extends LineIterator {

   HeaderIterator(NNTPConnection var1) {
      super(var1);
   }

   public Object next() {
      try {
         HeaderEntry var1 = this.nextHeaderEntry();
         return var1;
      } catch (IOException var6) {
         StringBuilder var3 = (new StringBuilder()).append("I/O error: ");
         String var4 = var6.getMessage();
         String var5 = var3.append(var4).toString();
         throw new NoSuchElementException(var5);
      }
   }

   public HeaderEntry nextHeaderEntry() throws IOException {
      String var1 = this.nextLine();
      int var2 = var1.indexOf(32, 0);
      String var3 = var1.substring(0, var2);
      int var4 = var2 + 1;
      String var5 = var1.substring(var4);
      return new HeaderEntry(var3, var5);
   }
}
