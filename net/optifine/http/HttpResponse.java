package net.optifine.http;

import java.util.LinkedHashMap;
import java.util.Map;

public class HttpResponse {
   private byte[] body = null;
   private String statusLine = null;
   private int status = 0;
   private Map<String, String> headers = new LinkedHashMap();

   public byte[] getBody() {
      return this.body;
   }

   public String getHeader(String var1) {
      return (String)this.headers.get(var1);
   }

   public Map getHeaders() {
      return this.headers;
   }

   public HttpResponse(int var1, String var2, Map var3, byte[] var4) {
      this.status = var1;
      this.statusLine = var2;
      this.headers = var3;
      this.body = var4;
   }

   public int getStatus() {
      return this.status;
   }

   public String getStatusLine() {
      return this.statusLine;
   }
}
