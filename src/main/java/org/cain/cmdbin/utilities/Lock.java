package org.cain.cmdbin.utilities;

import java.util.HashMap;

public class Lock
{
  public static HashMap<String, Boolean> lockhash = new HashMap<String, Boolean>();

  public static void enableLock() {
    lockhash.put("yes", Boolean.valueOf(true));
    Chat.broadcastMessage("Server has enabled lockdown mode.");
  }

  public static void disableLock() {
    lockhash.remove("yes");
    Chat.broadcastMessage("Server has disabled lockdown mode.");
  }
}