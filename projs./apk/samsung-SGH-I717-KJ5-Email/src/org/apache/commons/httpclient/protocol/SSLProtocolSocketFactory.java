package org.apache.commons.httpclient.protocol;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLSocketFactory;
import org.apache.commons.httpclient.ConnectTimeoutException;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.protocol.ControllerThreadSocketFactory;
import org.apache.commons.httpclient.protocol.ReflectionSocketFactory;
import org.apache.commons.httpclient.protocol.SecureProtocolSocketFactory;

public class SSLProtocolSocketFactory implements SecureProtocolSocketFactory {

   private static final SSLProtocolSocketFactory factory = new SSLProtocolSocketFactory();


   public SSLProtocolSocketFactory() {}

   static SSLProtocolSocketFactory getSocketFactory() {
      return factory;
   }

   public Socket createSocket(String var1, int var2) throws IOException, UnknownHostException {
      return SSLSocketFactory.getDefault().createSocket(var1, var2);
   }

   public Socket createSocket(String var1, int var2, InetAddress var3, int var4) throws IOException, UnknownHostException {
      return SSLSocketFactory.getDefault().createSocket(var1, var2, var3, var4);
   }

   public Socket createSocket(String var1, int var2, InetAddress var3, int var4, HttpConnectionParams var5) throws IOException, UnknownHostException, ConnectTimeoutException {
      if(var5 == null) {
         throw new IllegalArgumentException("Parameters may not be null");
      } else {
         int var6 = var5.getConnectionTimeout();
         Socket var7;
         if(var6 == 0) {
            var7 = this.createSocket(var1, var2, var3, var4);
         } else {
            Socket var12 = ReflectionSocketFactory.createSocket("javax.net.ssl.SSLSocketFactory", var1, var2, var3, var4, var6);
            if(var12 == null) {
               var12 = ControllerThreadSocketFactory.createSocket(this, var1, var2, var3, var4, var6);
            }

            var7 = var12;
         }

         return var7;
      }
   }

   public Socket createSocket(Socket var1, String var2, int var3, boolean var4) throws IOException, UnknownHostException {
      return ((SSLSocketFactory)SSLSocketFactory.getDefault()).createSocket(var1, var2, var3, var4);
   }

   public boolean equals(Object var1) {
      boolean var4;
      if(var1 != null) {
         Class var2 = var1.getClass();
         Class var3 = this.getClass();
         if(var2.equals(var3)) {
            var4 = true;
            return var4;
         }
      }

      var4 = false;
      return var4;
   }

   public int hashCode() {
      return this.getClass().hashCode();
   }
}
