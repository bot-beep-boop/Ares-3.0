package net.optifine.http;

import java.net.Proxy;
import java.util.LinkedHashMap;
import java.util.Map;

public class HttpRequest {
   public static final String METHOD_POST = "POST";
   private String file;
   private String host = null;
   public static final String METHOD_GET = "GET";
   public static final String METHOD_HEAD = "HEAD";
   public static final String HTTP_1_0 = "HTTP/1.0";
   private int redirects;
   private Proxy proxy;
   private String method;
   public static final String HTTP_1_1 = "HTTP/1.1";
   private Map<String, String> headers;
   private String http;
   private int port = 0;
   private byte[] body;

   public Proxy getProxy() {
      return this.proxy;
   }

   public String getHost() {
      return this.host;
   }

   public String getHttp() {
      return this.http;
   }

   public Map<String, String> getHeaders() {
      return this.headers;
   }

   public String getMethod() {
      return this.method;
   }

   public String getFile() {
      return this.file;
   }

   public int getPort() {
      return this.port;
   }

   public HttpRequest(String var1, int var2, Proxy var3, String var4, String var5, String var6, Map<String, String> var7, byte[] var8) {
      this.proxy = Proxy.NO_PROXY;
      this.method = null;
      this.file = null;
      this.http = null;
      this.headers = new LinkedHashMap();
      this.body = null;
      this.redirects = 0;
      this.host = var1;
      this.port = var2;
      this.proxy = var3;
      this.method = var4;
      this.file = var5;
      this.http = var6;
      this.headers = var7;
      this.body = var8;
   }

   public byte[] getBody() {
      return this.body;
   }

   public void setRedirects(int var1) {
      this.redirects = var1;
   }

   public int getRedirects() {
      return this.redirects;
   }
}
