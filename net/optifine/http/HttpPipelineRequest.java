package net.optifine.http;

public class HttpPipelineRequest {
   private HttpRequest httpRequest = null;
   private HttpListener httpListener = null;
   private boolean closed = false;

   public boolean isClosed() {
      return this.closed;
   }

   public HttpRequest getHttpRequest() {
      return this.httpRequest;
   }

   public HttpListener getHttpListener() {
      return this.httpListener;
   }

   public HttpPipelineRequest(HttpRequest var1, HttpListener var2) {
      this.httpRequest = var1;
      this.httpListener = var2;
   }

   public void setClosed(boolean var1) {
      this.closed = var1;
   }
}
