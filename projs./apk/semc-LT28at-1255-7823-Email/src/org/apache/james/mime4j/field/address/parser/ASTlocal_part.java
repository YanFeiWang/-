package org.apache.james.mime4j.field.address.parser;

import org.apache.james.mime4j.field.address.parser.AddressListParser;
import org.apache.james.mime4j.field.address.parser.AddressListParserVisitor;
import org.apache.james.mime4j.field.address.parser.SimpleNode;

public class ASTlocal_part extends SimpleNode {

   public ASTlocal_part(int var1) {
      super(var1);
   }

   public ASTlocal_part(AddressListParser var1, int var2) {
      super(var1, var2);
   }

   public Object jjtAccept(AddressListParserVisitor var1, Object var2) {
      return var1.visit(this, var2);
   }
}
