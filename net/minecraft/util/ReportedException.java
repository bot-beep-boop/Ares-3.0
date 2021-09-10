package net.minecraft.util;

import net.minecraft.crash.CrashReport;

public class ReportedException extends RuntimeException {
   private final CrashReport theReportedExceptionCrashReport;

   public CrashReport getCrashReport() {
      return this.theReportedExceptionCrashReport;
   }

   public Throwable getCause() {
      return this.theReportedExceptionCrashReport.getCrashCause();
   }

   public ReportedException(CrashReport var1) {
      this.theReportedExceptionCrashReport = var1;
   }

   public String getMessage() {
      return this.theReportedExceptionCrashReport.getDescription();
   }
}
