package org.codehaus.jackson.node;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.node.NumericNode;

public final class BigIntegerNode extends NumericNode {

   final BigInteger _value;


   public BigIntegerNode(BigInteger var1) {
      this._value = var1;
   }

   public static BigIntegerNode valueOf(BigInteger var0) {
      return new BigIntegerNode(var0);
   }

   public boolean equals(Object var1) {
      boolean var2;
      if(var1 == this) {
         var2 = true;
      } else if(var1 == null) {
         var2 = false;
      } else {
         Class var3 = var1.getClass();
         Class var4 = this.getClass();
         if(var3 != var4) {
            var2 = false;
         } else {
            BigInteger var5 = ((BigIntegerNode)var1)._value;
            BigInteger var6 = this._value;
            if(var5 == var6) {
               var2 = true;
            } else {
               var2 = false;
            }
         }
      }

      return var2;
   }

   public BigInteger getBigIntegerValue() {
      return this._value;
   }

   public BigDecimal getDecimalValue() {
      BigInteger var1 = this._value;
      return new BigDecimal(var1);
   }

   public double getDoubleValue() {
      return this._value.doubleValue();
   }

   public int getIntValue() {
      return this._value.intValue();
   }

   public long getLongValue() {
      return this._value.longValue();
   }

   public Number getNumberValue() {
      return this._value;
   }

   public String getValueAsText() {
      return this._value.toString();
   }

   public int hashCode() {
      return this._value.hashCode();
   }

   public boolean isBigInteger() {
      return true;
   }

   public boolean isIntegralNumber() {
      return true;
   }

   public final void serialize(JsonGenerator var1, SerializerProvider var2) throws IOException, JsonProcessingException {
      BigInteger var3 = this._value;
      var1.writeNumber(var3);
   }
}
