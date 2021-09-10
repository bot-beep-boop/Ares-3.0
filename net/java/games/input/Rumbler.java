package net.java.games.input;

public interface Rumbler {
   String getAxisName();

   Component.Identifier getAxisIdentifier();

   void rumble(float var1);
}
