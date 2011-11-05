package gnu.inet.https;

import gnu.inet.http.HTTPURLConnection;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public class Handler extends URLStreamHandler {

   public Handler() {}

   protected int getDefaultPort() {
      return 443;
   }

   public URLConnection openConnection(URL var1) throws IOException {
      return new HTTPURLConnection(var1);
   }
}
