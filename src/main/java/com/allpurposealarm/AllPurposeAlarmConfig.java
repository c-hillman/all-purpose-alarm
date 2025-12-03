package com.allpurposealarm;

import net.runelite.api.SoundEffectVolume;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

@ConfigGroup("allpurposealarm")
public interface AllPurposeAlarmConfig extends Config {

    // GENERAL SETTINGS
    @Range(
            max = SoundEffectVolume.HIGH
    )
    @ConfigItem(
            keyName = "general.alarmVolume",
            name = "Alarm volume",
            description = "Configures the volume of the alarm. A value of 0 will disable the alarm sound."
            //position = TODO
    )
    default int getAlarmVolume() {
        return SoundEffectVolume.MEDIUM_HIGH;
    }

    // PER ALARM SETTINGS
    // IDLE

    @ConfigItem(
            keyName = "idleAlarm.enabled",
            name = "Idle alarm enabled",
            description = "TODO"
    )
    default boolean isIdleAlarmEnabled() {
        return true; // TODO: default false
    }

    @ConfigItem(
            keyName = "idleAlarm.delay",
            name = "Idle alarm delay",
            description = "Configures the volume of the alarm. A value of 0 will disable the alarm sound."
    )
    default int getIdleAlarmDelay() {
        return 600; // TODO magic number
    }

    // HEALTH
    @ConfigItem(
            keyName = "healthAlarm.enabled",
            name = "Health alarm enabled",
            description = "TODO"
    )
    default boolean isHealthAlarmEnabled() {
        return true; // TODO: default false
    }

    @ConfigItem(
            keyName = "healthAlarm.threshold",
            name = "Health alarm threshold",
            description = "Configures the volume of the alarm. A value of 0 will disable the alarm sound."
    )
    default int getHealthAlarmThreshold() {
        return 50; // TODO magic number
    }

    // PRAYER
    @ConfigItem(
            keyName = "prayerAlarm.enabled",
            name = "Prayer alarm enabled",
            description = "TODO"
    )
    default boolean isPrayerAlarmEnabled() {
        return true; // TODO: default false
    }

    @ConfigItem(
            keyName = "prayerAlarm.threshold",
            name = "Prayer alarm threshold",
            description = "Configures the volume of the alarm. A value of 0 will disable the alarm sound."
    )
    default int getPrayerAlarmThreshold() {
        return 20; // TODO magic number
    }

    // STAMINA
    @ConfigItem(
            keyName = "staminaAlarm.enabled",
            name = "Stamina alarm enabled",
            description = "TODO"
    )
    default boolean isStaminaAlarmEnabled() {
        return true; // TODO: default false
    }

    @ConfigItem(
            keyName = "staminaAlarm.threshold",
            name = "Stamina alarm threshold",
            description = "Configures the volume of the alarm. A value of 0 will disable the alarm sound."
    )
    default int getStaminaAlarmThreshold() {
        return 20; // TODO magic number
    }

    // SPEC
    @ConfigItem(
            keyName = "specAlarm.enabled",
            name = "Spec alarm enabled",
            description = "TODO"
    )
    default boolean isSpecAlarmEnabled() {
        return true; // TODO: default false
    }

    @ConfigItem(
            keyName = "specAlarm.threshold",
            name = "Spec alarm threshold",
            description = "Configures the volume of the alarm. A value of 0 will disable the alarm sound."
    )
    default int getSpecAlarmThreshold() {
        return 80; // TODO magic number
    }
}
