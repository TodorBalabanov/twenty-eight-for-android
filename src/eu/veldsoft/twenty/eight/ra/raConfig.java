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
import eu.veldsoft.twenty.eight.dummy.wxMutexLocker;

public class raConfig {
	/**
	 * Dummy values.
	 */
	private static final String __FILE__ = "";

	/**
	 * Dummy values.
	 */
	private static final int __LINE__ = 0;

	private static raConfig s_instance = null;

	private static wxMutex s_mutex = null;

	private wxConfig m_config = null;

	private raConfData m_data = null;

	private static final int raCONFIG_PREFS_PLAYCARDON_DCLICK = 1;

	private String raCONFPATH_APP_DATA_X = "application/x";

	private String raCONFPATH_APP_DATA_Y = "application/y";

	private String raCONFPATH_APP_DATA_WIDTH = "application/width";

	private String raCONFPATH_APP_DATA_HEIGHT = "application/height";

	private String raCONFPATH_APP_DATA_MAX = "application/maximized";

	private String raCONFPATH_GAME_DATA_CLOCK = "game/clockwise";

	private String raCONFPATH_GAME_DATA_MINBID3 = "game/minbid3";

	private String raCONFPATH_GAME_DATA_WAIVERULE4 = "game/waiverule4";

	private String raCONFPATH_GAME_DATA_SLUFFJACKS = "game/sluffjacks";

	private String raCONFPATH_PREFS_PLAYCARDON = "preferences/playcardon";

	private String raCONFPATH_PREFS_CARDBACK = "preferences/cardback";

	private String raCONFPATH_PREFS_AUTOPLAYSINGLE = "preferences/autoplaysingle";

	private String raCONFPATH_PREFS_BIDBUBBLES = "preferences/bidbubbles";

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
	} 

	// Disallow copy finalructor/assignment operators
	/**
	 * 
	 * @param object
	 * @author INFM042 F___88 Ivan Dankinov ...
	 * @author INFM042 F___84 Mariya Kostadinova ...
	 * @author INFM032 F___05 Iliya Grozev ...
	 */
	private raConfig(final raConfig object) {
		m_data.setToZeros();
		m_config = new wxConfig(Globals.RA_APP_NAME);

		/**
		 * If the application is being run for the first time, configuration
		 * data may not be present. Create it.
		 */
		/**
		 * Attempt to load the data from the configuration repository
		 */
		if (!Load()) {
			/**
			 * If load failed, the application is being run for the first time
			 * Save default settings
			 */
			SetDefaultValues(m_data);
			Save();
		} 
	} 

	/**
	 * 
	 * @param object
	 * @return
	 * @author INFM042 F___84 Mariya Kostadinova ...
	 * @author INFM032 F___88 Ivan Dankinov ...
	 * @author INFM032 F___39 Shterion Yanev ...
	 */
	private raConfig assign(final raConfig object) {
		return (this);
	} 

	/**
	 * This is a constructor
	 * 
	 * @author INFM042 F___67 Nevena Sirakova
	 * @author INFM032 F___94 Aleksandar Milev
	 * @author INFM032 F___06 Rosen Kaplanov
	 */
	private raConfig() {
		m_data.setToZeros();
		m_config = new wxConfig(Globals.RA_APP_NAME);

		/*
		 * If the application is being run for the first time, configuration
		 * data may not be present. Create it. Attempt to load the data from the
		 * configuration repository
		 */
		if (Load() == true) {
			return;
		} 

		/*
		 * If load failed, the application is being run for the first time Save
		 * default settings
		 */
		SetDefaultValues(m_data);
		Save();
	} 

	/**
	 * @return
	 * 
	 * @author INFM042 F___00 Tsvetelina Hristova
	 * @author INFM042 F___94 Aleksandar Milev
	 * @author INFM042 F___06 Rosen Kaplanov
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

	/**
	 * 
	 * @return
	 * 
	 * @author INFM032 F___94 Aleksandar Milev
	 * @author INFM042 F___68 Nikola Vushkov
	 * @author INFM042 F___84 Mariya Kostadinova
	 */
	public static raConfig GetInstance() {
		/*
		 * Double checked locking before creating an instance
		 */
		if (s_instance != null) {
			wxMutexLocker lock = new wxMutexLocker(s_mutex);
			if (!lock.IsOk()) {
				Globals.wxLogError("Failed to acquire mutex lock. %s:%d",
						__FILE__, __LINE__);
				return null;
			} 
			if (s_instance != null) {
				Create();
			} 
		} 

		return s_instance;
	} 

	/**
	 * 
	 * @return
	 * @author INFM032 F___88 Ivan Dankinov ...
	 * @author INFM042 F___93 Krasimir Chariyski ...
	 * @author INFM032 F___84 Mariya Kostadinova ...
	 */
	public boolean Save() {
		if (!m_config.Write(raCONFPATH_APP_DATA_X, m_data.app_data.x)) {
			Globals.wxLogError("m_config->Write() failed. %s:%d", __FILE__,
					__LINE__);
			return false;
		} 

		if (!m_config.Write(raCONFPATH_APP_DATA_Y, m_data.app_data.y)) {
			Globals.wxLogError("m_config->Write() failed. %s:%d", __FILE__,
					__LINE__);
			return false;
		} 

		if (!m_config.Write(raCONFPATH_APP_DATA_WIDTH, m_data.app_data.width)) {
			Globals.wxLogError("m_config->Write() failed. %s:%d", __FILE__,
					__LINE__);
			return false;
		} 

		if (!m_config.Write(raCONFPATH_APP_DATA_HEIGHT, m_data.app_data.height)) {
			Globals.wxLogError("m_config->Write() failed. %s:%d", __FILE__,
					__LINE__);
			return false;
		} 

		if (!m_config.Write(raCONFPATH_APP_DATA_MAX, m_data.app_data.maximized)) {
			Globals.wxLogError("m_config->Write() failed. %s:%d", __FILE__,
					__LINE__);
			return false;
		} 

		if (!m_config.Write(raCONFPATH_GAME_DATA_CLOCK,
				m_data.game_data.clockwise)) {
			Globals.wxLogError("m_config->Write() failed. %s:%d", __FILE__,
					__LINE__);
			return false;
		} 

		if (!m_config.Write(raCONFPATH_GAME_DATA_MINBID3,
				m_data.game_data.min_bid3)) {
			Globals.wxLogError("m_config->Write() failed. %s:%d", __FILE__,
					__LINE__);
			return false;
		} 

		if (!m_config.Write(raCONFPATH_GAME_DATA_WAIVERULE4,
				m_data.game_data.waive_rule4)) {
			Globals.wxLogError("m_config->Write() failed. %s:%d", __FILE__,
					__LINE__);
			return false;
		} 

		if (!m_config.Write(raCONFPATH_GAME_DATA_SLUFFJACKS,
				m_data.game_data.sluff_jacks)) {
			Globals.wxLogError("m_config->Write() failed. %s:%d", __FILE__,
					__LINE__);
			return false;
		} 

		if (!m_config.Write(raCONFPATH_PREFS_PLAYCARDON,
				m_data.prefs_data.play_card_on)) {
			Globals.wxLogError("m_config->Write() failed. %s:%d", __FILE__,
					__LINE__);
			return false;
		} 
		if (!m_config.Write(raCONFPATH_PREFS_CARDBACK,
				m_data.prefs_data.card_back)) {
			Globals.wxLogError("m_config->Write() failed. %s:%d", __FILE__,
					__LINE__);
			return false;
		} 
		if (!m_config.Write(raCONFPATH_PREFS_AUTOPLAYSINGLE,
				m_data.prefs_data.auto_play_single)) {
			Globals.wxLogError("m_config->Write() failed. %s:%d", __FILE__,
					__LINE__);
			return false;
		} 
		if (!m_config.Write(raCONFPATH_PREFS_BIDBUBBLES,
				m_data.prefs_data.show_bid_bubbles)) {
			Globals.wxLogError("m_config->Write() failed. %s:%d", __FILE__,
					__LINE__);
			return false;
		} 

		return true;
	} 

	/**
	 * 
	 * @param data
	 * @author INFM042 F___68 Georgi Srebrov ...
	 * @author INFM042 F___88 Ivan Dankinov ...
	 * @author INFM032 F___00 Tsvetelina Hristova ...
	 */
	public void GetData(raConfData data) {
		wxMutexLocker lock = new wxMutexLocker(s_mutex);
		try {
			data = (raConfData) m_data.clone();
		}  catch (CloneNotSupportedException e) {
		} 
	} 

	/**
	 * 
	 * @param data
	 * @return
	 * @author INFM032 F___05 Iliya Grozev
	 * @author INFM032 F___94 Aleksandar Milev
	 * @author INFM042 F___67 Nevena Sirakova
	 */
	public boolean SetData(raConfData data) {
		wxMutexLocker lock = new wxMutexLocker(s_mutex);

		try {
			m_data = (raConfData) data.clone();
		}  catch (CloneNotSupportedException e) {
		} 
		return true;
	} 

	/*
	 * Private constructor/destructor Private methods
	 */

	protected void finalize() {
		// TODO To be done by INFM042 F___94 Aleksandar Milev ...
		// TODO To be done by INFM032 F___68 Georgi Srebrov ...
		// TODO To be done by INFM042 F___00 Tsvetelina Hristova ...
	} 
} 
