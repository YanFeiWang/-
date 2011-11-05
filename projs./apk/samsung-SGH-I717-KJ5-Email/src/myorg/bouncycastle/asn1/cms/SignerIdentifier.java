package myorg.bouncycastle.asn1.cms;

import myorg.bouncycastle.asn1.ASN1Choice;
import myorg.bouncycastle.asn1.ASN1Encodable;
import myorg.bouncycastle.asn1.ASN1OctetString;
import myorg.bouncycastle.asn1.ASN1TaggedObject;
import myorg.bouncycastle.asn1.DEREncodable;
import myorg.bouncycastle.asn1.DERObject;
import myorg.bouncycastle.asn1.DERTaggedObject;
import myorg.bouncycastle.asn1.cms.IssuerAndSerialNumber;

public class SignerIdentifier extends ASN1Encodable implements ASN1Choice {

   private DEREncodable id;


   public SignerIdentifier(ASN1OctetString var1) {
      DERTaggedObject var2 = new DERTaggedObject((boolean)0, 0, var1);
      this.id = var2;
   }

   public SignerIdentifier(DERObject var1) {
      this.id = var1;
   }

   public SignerIdentifier(IssuerAndSerialNumber var1) {
      this.id = var1;
   }

   public static SignerIdentifier getInstance(Object var0) {
      SignerIdentifier var1;
      if(var0 != null && !(var0 instanceof SignerIdentifier)) {
         if(var0 instanceof IssuerAndSerialNumber) {
            IssuerAndSerialNumber var2 = (IssuerAndSerialNumber)var0;
            var1 = new SignerIdentifier(var2);
         } else if(var0 instanceof ASN1OctetString) {
            ASN1OctetString var3 = (ASN1OctetString)var0;
            var1 = new SignerIdentifier(var3);
         } else {
            if(!(var0 instanceof DERObject)) {
               StringBuilder var5 = (new StringBuilder()).append("Illegal object in SignerIdentifier: ");
               String var6 = var0.getClass().getName();
               String var7 = var5.append(var6).toString();
               throw new IllegalArgumentException(var7);
            }

            DERObject var4 = (DERObject)var0;
            var1 = new SignerIdentifier(var4);
         }
      } else {
         var1 = (SignerIdentifier)var0;
      }

      return var1;
   }

   public DEREncodable getId() {
      Object var1;
      if(this.id instanceof ASN1TaggedObject) {
         var1 = ASN1OctetString.getInstance((ASN1TaggedObject)this.id, (boolean)0);
      } else {
         var1 = this.id;
      }

      return (DEREncodable)var1;
   }

   public boolean isTagged() {
      return this.id instanceof ASN1TaggedObject;
   }

   public DERObject toASN1Object() {
      return this.id.getDERObject();
   }
}
