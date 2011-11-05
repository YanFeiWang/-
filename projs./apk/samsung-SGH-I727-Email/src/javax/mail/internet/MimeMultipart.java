package javax.mail.internet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import javax.activation.DataSource;
import javax.mail.BodyPart;
import javax.mail.MessageAware;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.MultipartDataSource;
import javax.mail.Part;
import javax.mail.internet.ContentType;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeUtility;
import javax.mail.internet.ParameterList;

public class MimeMultipart extends Multipart {

   private boolean complete;
   protected DataSource ds;
   protected boolean parsed;
   private String preamble;


   public MimeMultipart() {
      this("mixed");
   }

   public MimeMultipart(String var1) {
      String var2 = MimeUtility.getUniqueBoundaryValue();
      ContentType var3 = new ContentType("multipart", var1, (ParameterList)null);
      var3.setParameter("boundary", var2);
      String var4 = var3.toString();
      this.contentType = var4;
      this.parsed = (boolean)1;
   }

   public MimeMultipart(DataSource var1) throws MessagingException {
      if(var1 instanceof MessageAware) {
         Part var2 = ((MessageAware)var1).getMessageContext().getPart();
         this.setParent(var2);
      }

      if(var1 instanceof MultipartDataSource) {
         MultipartDataSource var3 = (MultipartDataSource)var1;
         this.setMultipartDataSource(var3);
         this.parsed = (boolean)1;
      } else {
         this.ds = var1;
         String var4 = var1.getContentType();
         this.contentType = var4;
         this.parsed = (boolean)0;
      }
   }

   private static String trim(String var0) {
      String var1;
      if(var0 == null) {
         var1 = null;
      } else {
         var1 = var0.trim();
         int var2 = var1.length();
         if(var2 > 0) {
            int var3 = var2 - 1;
            if(var1.charAt(var3) == 13) {
               int var4 = var2 - 1;
               var1 = var1.substring(0, var4);
            }
         }
      }

      return var1;
   }

   protected InternetHeaders createInternetHeaders(InputStream var1) throws MessagingException {
      return new InternetHeaders(var1);
   }

   protected MimeBodyPart createMimeBodyPart(InputStream var1) throws MessagingException {
      return new MimeBodyPart(var1);
   }

   protected MimeBodyPart createMimeBodyPart(InternetHeaders var1, byte[] var2) throws MessagingException {
      return new MimeBodyPart(var1, var2);
   }

   public BodyPart getBodyPart(int var1) throws MessagingException {
      synchronized(this) {
         this.parse();
         BodyPart var2 = super.getBodyPart(var1);
         return var2;
      }
   }

   public BodyPart getBodyPart(String var1) throws MessagingException {
      synchronized(this) {
         this.parse();
         int var2 = this.getCount();
         int var3 = 0;

         MimeBodyPart var4;
         while(true) {
            if(var3 >= var2) {
               var4 = null;
               break;
            }

            var4 = (MimeBodyPart)this.getBodyPart(var3);
            String var5 = var4.getContentID();
            if(var5 != null && var5.equals(var1)) {
               break;
            }

            ++var3;
         }

         return var4;
      }
   }

   public int getCount() throws MessagingException {
      synchronized(this) {
         this.parse();
         int var1 = super.getCount();
         return var1;
      }
   }

   public String getPreamble() throws MessagingException {
      return this.preamble;
   }

   public boolean isComplete() throws MessagingException {
      return this.complete;
   }

   protected void parse() throws MessagingException {
      // $FF: Couldn't be decompiled
   }

   public void setPreamble(String var1) throws MessagingException {
      this.preamble = var1;
   }

   public void setSubType(String var1) throws MessagingException {
      String var2 = this.contentType;
      ContentType var3 = new ContentType(var2);
      var3.setSubType(var1);
      String var4 = var3.toString();
      this.contentType = var4;
   }

   protected void updateHeaders() throws MessagingException {
      if(this.parts != null) {
         Vector var1 = this.parts;
         synchronized(var1) {
            int var2 = this.parts.size();

            for(int var3 = 0; var3 < var2; ++var3) {
               ((MimeBodyPart)this.parts.get(var3)).updateHeaders();
            }

         }
      }
   }

   public void writeTo(OutputStream param1) throws IOException, MessagingException {
      // $FF: Couldn't be decompiled
   }
}
