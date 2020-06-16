package tc.oc.pgm.api;

import java.util.UUID;
import tc.oc.pgm.api.map.MapActivity;
import tc.oc.pgm.api.player.Username;
import tc.oc.pgm.api.setting.Settings;
import tc.oc.pgm.loadouts.preferences.LoadoutPreferences;

/** A fast, persistent datastore that provides synchronous responses. */
public interface Datastore {

  /**
   * Get the username for a given player {@link UUID}.
   *
   * @param uuid The {@link UUID} of a player.
   * @return A {@link Username}.
   */
  Username getUsername(UUID uuid);

  /**
   * Get the settings for a given player {@link UUID}.
   *
   * @param uuid The {@link UUID} of a player.
   * @return A {@link Settings}.
   */
  Settings getSettings(UUID uuid);

  /**
   * Get the activity related to a defined map pool.
   *
   * @param poolName The name of a defined map pool.
   * @return A {@link MapActivity}.
   */
  MapActivity getMapActivity(String poolName);

  /**
   * Gets the loadout preferences of a given player {@link UUID}
   *
   * @param uuid the {@link UUID} of a player.
   * @return A {@link LoadoutPreferences}
   */
  LoadoutPreferences getLoadoutPreferences(UUID uuid);

  /** Cleans up any resources or connections. */
  void close();
}
