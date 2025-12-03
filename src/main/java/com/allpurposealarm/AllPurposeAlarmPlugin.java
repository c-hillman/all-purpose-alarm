package com.allpurposealarm;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.ClientTick;
import net.runelite.api.gameval.VarPlayerID;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import javax.inject.Inject;

import static net.runelite.api.AnimationID.IDLE;

@Slf4j
@PluginDescriptor(name = "All Purpose Alarm")
public class AllPurposeAlarmPlugin extends Plugin {
    @Inject
    private Client client;

    @Inject
    private AllPurposeAlarmConfig config;

    @Provides
    AllPurposeAlarmConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(AllPurposeAlarmConfig.class);
    }

    @Override
    protected void startUp() throws Exception {
        log.debug("AllPurposeAlarm started!");
    }

    @Override
    protected void shutDown() throws Exception {
        log.debug("AllPurposeAlarm stopped!");
    }

    @Subscribe
    public void onClientTick(ClientTick tick) {
        Player localPlayer = client.getLocalPlayer();

        if (config.isIdleAlarmEnabled() && isIdle(localPlayer)) {
            playAlarm();
        } else if (config.isHealthAlarmEnabled() && isLowHealth()) {
            playAlarm();
        } else if (config.isPrayerAlarmEnabled() && isLowPrayer()) {
            playAlarm();
        } else if (config.isStaminaAlarmEnabled() && isLowStamina()) {
            playAlarm();
        } else if (config.isSpecAlarmEnabled() && isHighSpec()) {
            playAlarm();
        }
    }

    private boolean isIdle(Player player) {
        int idlePose = player.getIdlePoseAnimation();
        int pose = player.getPoseAnimation();
        int animation = player.getAnimation();

        return animation == IDLE && pose == idlePose;
    }

    private boolean isLowHealth() {
        // TODO consider maxHealth? consider NMZ absorb?
        return client.getBoostedSkillLevel(Skill.HITPOINTS) <= config.getHealthAlarmThreshold();
    }

    private boolean isLowPrayer() {
        // TODO consider maxPrayer?
        return client.getBoostedSkillLevel(Skill.PRAYER) <= config.getPrayerAlarmThreshold();
    }

    private boolean isLowStamina() {
        // getEnergy in 1/100ths of a percent
        return client.getEnergy() / 100 <= config.getStaminaAlarmThreshold();
    }

    private boolean isHighSpec() {
        // getVarpValue in 1/10th of a percent?
        return client.getVarpValue(VarPlayerID.SA_ENERGY) / 10 >= config.getSpecAlarmThreshold();
    }

    private void playAlarm() {
        if (config.getAlarmVolume() > 0) {
            Preferences preferences = client.getPreferences();
            int previousVolume = preferences.getSoundEffectVolume();

            preferences.setSoundEffectVolume(config.getAlarmVolume());
            client.playSoundEffect(SoundEffectID.GE_INCREMENT_PLOP, config.getAlarmVolume());

            preferences.setSoundEffectVolume(previousVolume);
        }
    }
}
