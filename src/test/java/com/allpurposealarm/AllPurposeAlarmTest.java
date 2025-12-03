package com.allpurposealarm;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class AllPurposeAlarmTest {
    public static void main(String[] args) throws Exception {
        ExternalPluginManager.loadBuiltin(AllPurposeAlarmPlugin.class);
        RuneLite.main(args);
    }
}