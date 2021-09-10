package net.java.games.input;

import java.io.IOException;

abstract class LinuxForceFeedbackEffect implements Rumbler {
   private final LinuxForceFeedbackEffect.WriteTask write_task = new LinuxForceFeedbackEffect.WriteTask(this);
   private final int ff_id;
   private final LinuxForceFeedbackEffect.UploadTask upload_task = new LinuxForceFeedbackEffect.UploadTask(this);
   private final LinuxEventDevice device;

   static LinuxEventDevice access$300(LinuxForceFeedbackEffect var0) {
      return var0.device;
   }

   protected abstract int upload(int var1, float var2) throws IOException;

   public LinuxForceFeedbackEffect(LinuxEventDevice var1) throws IOException {
      this.device = var1;
      this.ff_id = this.upload_task.doUpload(-1, 0.0F);
   }

   public final synchronized void rumble(float var1) {
      try {
         if (var1 > 0.0F) {
            this.upload_task.doUpload(this.ff_id, var1);
            this.write_task.write(1);
         } else {
            this.write_task.write(0);
         }
      } catch (IOException var3) {
         LinuxEnvironmentPlugin.logln("Failed to rumble: " + var3);
      }

   }

   public final Component.Identifier getAxisIdentifier() {
      return null;
   }

   static int access$200(LinuxForceFeedbackEffect var0) {
      return var0.ff_id;
   }

   protected final LinuxEventDevice getDevice() {
      return this.device;
   }

   public final String getAxisName() {
      return null;
   }

   private final class UploadTask extends LinuxDeviceTask {
      private final LinuxForceFeedbackEffect this$0;
      private float intensity;
      private int id;

      UploadTask(LinuxForceFeedbackEffect var1, Object var2) {
         this(var1);
      }

      private UploadTask(LinuxForceFeedbackEffect var1) {
         this.this$0 = var1;
      }

      protected final Object execute() throws IOException {
         this.id = this.this$0.upload(this.id, this.intensity);
         return null;
      }

      public final int doUpload(int var1, float var2) throws IOException {
         this.id = var1;
         this.intensity = var2;
         LinuxEnvironmentPlugin.execute(this);
         return this.id;
      }
   }

   private final class WriteTask extends LinuxDeviceTask {
      private int value;
      private final LinuxForceFeedbackEffect this$0;

      public final void write(int var1) throws IOException {
         this.value = var1;
         LinuxEnvironmentPlugin.execute(this);
      }

      WriteTask(LinuxForceFeedbackEffect var1, Object var2) {
         this(var1);
      }

      protected final Object execute() throws IOException {
         LinuxForceFeedbackEffect.access$300(this.this$0).writeEvent(21, LinuxForceFeedbackEffect.access$200(this.this$0), this.value);
         return null;
      }

      private WriteTask(LinuxForceFeedbackEffect var1) {
         this.this$0 = var1;
      }
   }
}
