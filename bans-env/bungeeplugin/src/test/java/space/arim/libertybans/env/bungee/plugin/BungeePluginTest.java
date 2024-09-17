/*
 * LibertyBans
 * Copyright © 2022 Anand Beh
 *
 * LibertyBans is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * LibertyBans is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with LibertyBans. If not, see <https://www.gnu.org/licenses/>
 * and navigate to version 3 of the GNU Affero General Public License.
 */

package space.arim.libertybans.env.bungee.plugin;

import org.junit.jupiter.api.Test;
import space.arim.libertybans.bootstrap.Platform;
import space.arim.libertybans.env.bungee.MockPlugin;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BungeePluginTest {

	@Test
	public void detectPlatform() {
		Platform platform = BungeePlugin.detectPlatform(MockPlugin.create());
		assertTrue(platform.hasSlf4jSupport());
		assertFalse(platform.hasKyoriAdventureSupport());
	}

}
