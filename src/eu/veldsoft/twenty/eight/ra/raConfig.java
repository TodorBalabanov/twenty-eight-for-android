/*******************************************************************************
 *                                                                             *
 * Twenty-Eight for Android is port of popular Asian card game called Rosanne: *
 * Twenty-eight (28) <http://sourceforge.net/projects/rosanne/>. Project       *
 * development is done as NBU Java training course held in Sofia, Bulgaria.    *
 *                                                                             *
 * Copyright (C) 2013-2014 by Todor Balabanov  ( tdb@tbsoft.eu )               *
 *                                                                             *
 * This program is free software: you can redistribute it and/or modify        *
 * it under the terms of the GNU General Public License as published by        *
 * the Free Software Foundation, either version 3 of the License, or           *
 * (at your option) any later version.                                         *
 *                                                                             *
 * This program is distributed in the hope that it will be useful,             *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of              *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the               *
 * GNU General Public License for more details.                                *
 *                                                                             *
 * You should have received a copy of the GNU General Public License           *
 * along with this program. If not, see <http://www.gnu.org/licenses/>.        *
 *                                                                             *
 ******************************************************************************/

package eu.veldsoft.twenty.eight.ra;

import eu.veldsoft.twenty.eight.dummy.Globals;
import eu.veldsoft.twenty.eight.dummy.wxConfig;
import eu.veldsoft.twenty.eight.dummy.wxMutex;

public class raConfig {
	/**
	 * Dummy values.
	 */
	private static final String __FILE__ = "";

	/**
	 * Dummy values.
	 */
	private static final int __LINE__ = 0;
	private static raConfig s_instance;

	private static wxMutex s_mutex;

	private wxConfig m_config;

	private raConfData m_data;

	/**
	 * Constructor
	 * 
	 * @author Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 18 Oct 2013
	 */
	private static void Create() {
		raConfig the_instance = null;
		s_instance = the_instance;
	}

	/**
	 * Set value.
	 * 
	 * @param data
	 *            ...
	 * @author Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 18 Oct 2013
	 */
	private static void SetDefaultValues(raConfData data) {
		data.app_data.x = -1;
		data.app_data.y = -1;
		data.app_data.width = -1;
		data.app_data.height = -1;
		data.app_data.maximized = false;

		data.game_data.clockwise = true;
		data.game_data.min_bid3 = 23;
		data.game_data.waive_rule4 = false;
		data.game_data.sluff_jacks = true;

		data.prefs_data.play_card_on = Globals.raCONFIG_PREFS_PLAYCARDON_SCLICK;
		data.prefs_data.card_back = Globals.raCONFIG_PREFS_CARDBACK_BLUE;
		data.prefs_data.auto_play_single = true;
		data.prefs_data.show_bid_bubbles = true;

		return;
	}

	// Disallow copy finalructor/assignment operators
	private raConfig(final raConfig object) {
		// TODO To be done by INFM042 F___88 Ivan Dankinov ...
		// TODO To be done by INFM042 F___84 Mariya Kostadinova ...
		// TODO To be done by INFM032 F___05 Iliya Grozev ...
	}

	private raConfig assign(final raConfig object) {
		// TODO To be done by INFM042 F___84 Mariya Kostadinova ...
		// TODO To be done by INFM032 F___88 Ivan Dankinov ...
		// TODO To be done by INFM032 F___39 Shterion Yanev ...

		return (this);
	}

	private raConfig() {
		// TODO To be done by INFM042 F___67 Nevena Sirakova ...
		// TODO To be done by INFM032 F___94 Aleksandar Milev ...
		// TODO To be done by INFM032 F___06 Rosen Kaplanov ...
	}

	/**
	 * @author INFM042 F___00 Tsvetelina Hristova
	 * @author INFM042 F___94 Aleksandar Milev
	 * @author INFM042 F___06 Rosen Kaplanov
	 * @return
	 */
	private boolean Load() {

		if (!m_config.Read(Globals.raCONFPATH_APP_DATA_X, m_data.app_data.x)) {
			Globals.wxLogError("m_config->Read failed. %s:%d", __FILE__,
					__LINE__);
			return false;
		}

		if (!m_config.Read(Globals.raCONFPATH_APP_DATA_Y, m_data.app_data.y)) {
			Globals.wxLogError("m_config->Read failed. %s:%d", __FILE__,
					__LINE__);
			return false;
		}

		if (!m_config.Read(Globals.raCONFPATH_APP_DATA_WIDTH,
				m_data.app_data.width)) {
			Globals.wxLogError("m_config->Read failed. %s:%d", __FILE__,
					__LINE__);
			return false;
		}

		if (!m_config.Read(Globals.raCONFPATH_APP_DATA_HEIGHT,
				m_data.app_data.height)) {
			Globals.wxLogError("m_config->Read failed. %s:%d", __FILE__,
					__LINE__);
			return false;
		}

		if (!m_config.Read(Globals.raCONFPATH_APP_DATA_MAX,
				m_data.app_data.maximized)) {
			Globals.wxLogError("m_config->Read failed. %s:%d", __FILE__,
					__LINE__);
			return false;
		}

		if (!m_config.Read(Globals.raCONFPATH_GAME_DATA_CLOCK,
				m_data.game_data.clockwise)) {
			Globals.wxLogError("m_config->Read failed. %s:%d", __FILE__,
					__LINE__);
			return false;
		}

		if (!m_config.Read(Globals.raCONFPATH_GAME_DATA_MINBID3,
				m_data.game_data.min_bid3)) {
			Globals.wxLogError("m_config->Read failed. %s:%d", __FILE__,
					__LINE__);
			return false;
		}

		if (!m_config.Read(Globals.raCONFPATH_GAME_DATA_WAIVERULE4,
				m_data.game_data.waive_rule4)) {
			Globals.wxLogError("m_config->Read failed. %s:%d", __FILE__,
					__LINE__);
			return false;
		}

		if (!m_config.Read(Globals.raCONFPATH_GAME_DATA_SLUFFJACKS,
				m_data.game_data.sluff_jacks)) {
			Globals.wxLogError("m_config->Read failed. %s:%d", __FILE__,
					__LINE__);
			return false;
		}

		if (!m_config.Read(Globals.raCONFPATH_PREFS_PLAYCARDON,
				m_data.prefs_data.play_card_on)) {
			Globals.wxLogError("m_config->Read failed. %s:%d", __FILE__,
					__LINE__);
			return false;
		}
		if (!m_config.Read(Globals.raCONFPATH_PREFS_CARDBACK,
				m_data.prefs_data.card_back)) {
			Globals.wxLogError("m_config->Read failed. %s:%d", __FILE__,
					__LINE__);
			return false;
		}
		if (!m_config.Read(Globals.raCONFPATH_PREFS_AUTOPLAYSINGLE,
				m_data.prefs_data.auto_play_single)) {
			Globals.wxLogError("m_config->Read failed. %s:%d", __FILE__,
					__LINE__);
			return false;
		}
		if (!m_config.Read(Globals.raCONFPATH_PREFS_BIDBUBBLES,
				m_data.prefs_data.show_bid_bubbles)) {
			Globals.wxLogError("m_config->Read failed. %s:%d", __FILE__,
					__LINE__);
			return false;
		}
		return true;
	}

	public static raConfig GetInstance() {
		// TODO To be done by INFM032 F___94 Aleksandar Milev ...
		// TODO To be done by INFM042 F___68 Nikola Vushkov ...
		// TODO To be done by INFM042 F___84 Mariya Kostadinova ...

		return (null);
	}

	public boolean Save() {
		// TODO To be done by INFM032 F___88 Ivan Dankinov ...
		// TODO To be done by INFM042 F___93 Krasimir Chariyski ...
		// TODO To be done by INFM032 F___84 Mariya Kostadinova ...

		return (false);
	}

	public void GetData(raConfData data) {
		// TODO To be done by INFM042 F___68 Georgi Srebrov ...
		// TODO To be done by INFM042 F___88 Ivan Dankinov ...
		// TODO To be done by INFM032 F___00 Tsvetelina Hristova ...
	}

	public boolean SetData(raConfData data) {
		// TODO To be done by INFM032 F___05 Iliya Grozev ...
		// TODO To be done by INFM032 F___94 Aleksandar Milev ...
		// TODO To be done by INFM042 F___67 Nevena Sirakova ...

		return (false);
	}

	protected void finalize() {
		// TODO To be done by INFM042 F___94 Aleksandar Milev ...
		// TODO To be done by INFM032 F___68 Georgi Srebrov ...
		// TODO To be done by INFM042 F___00 Tsvetelina Hristova ...
	}
}
