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

package eu.veldsoft.twenty.eight.dummy;

import java.util.Random;

public class Globals {
	public static final int wxCOPY = 0;

	public static final wxFont wxNullFont = null;

	public static final wxColour wxNullColour = null;

	public static final int N32 = 32;

	public static final int raCONFIG_PREFS_PLAYCARDON_SCLICK = 0;

	public static final int raCONFIG_PREFS_PLAYCARDON_DCLICK = 1;

	public static final int raCONFIG_PREFS_CARDBACK_BLUE = 0;

	public static final int raCONFIG_PREFS_CARDBACK_RED = 1;

	public static final int raPLAYER_TYPE_HUMAN = 0;

	public static final int gmSUIT_INVALID = -1;

	public static final int gmTOTAL_PLAYERS = 4;

	public static final wxEvent raINFO_EVT = null;

	public static final String ra_APP_URL = "http://rosanne.sourceforge.net";

	public static final int raPREFS_PLAYCARDON_SCLICK = 0;

	public static final int raPREFS_PLAYCARDON_DCLICK = 1;

	public static final int raPREFS_CARDBACK_BLUE = 0;

	public static final int raPREFS_CARDBACK_RED = 1;

	public static final boolean slLOG_DEBUG_SETIMPCELLS = false;

	public static final int slTOTAL_SUITS = 4;

	public static final int slVACANT = -1;

	public static final int slTOTAL_HANDS = 4;

	public static final boolean slLOG_DEBUG_SETCELL = false;

	public static final int slLENGTH_MAX = 8;

	public static final long gmALL_CARDS = 0xFFFFFFFF;

	public static final long gmRULE_1 = 1;

	public static final long gmRULE_2 = 2;

	public static final long gmRULE_3 = 4;

	public static final long gmRULE_4 = 8;

	public static final long gmRULE_5 = 16;

	public static final int gmCARD_INVALID = -1;

	public static final Random PRNG = new Random();

	public static final int gmTOTAL_VALUES = 8;

	public static final String raCONFPATH_APP_DATA_X = null;

	public static final String raCONFPATH_APP_DATA_Y = null;

	public static final String raCONFPATH_APP_DATA_WIDTH = null;

	public static final String raCONFPATH_APP_DATA_HEIGHT = null;

	public static final String raCONFPATH_APP_DATA_MAX = null;

	public static final String raCONFPATH_GAME_DATA_CLOCK = null;

	public static final String raCONFPATH_GAME_DATA_MINBID3 = null;

	public static final String raCONFPATH_GAME_DATA_WAIVERULE4 = null;

	public static final String raCONFPATH_GAME_DATA_SLUFFJACKS = null;

	public static final String raCONFPATH_PREFS_PLAYCARDON = null;

	public static final String raCONFPATH_PREFS_CARDBACK = null;

	public static final String raCONFPATH_PREFS_AUTOPLAYSINGLE = null;

	public static final String raCONFPATH_PREFS_BIDBUBBLES = null;

	public static void wxLogError(String string, String file, int line) {
	}

	public static void wxLogMessage(String string) {
	}

	public static Object XRCCTRL(Object arg1, String arg2, Class arg3) {
		return null;
	}

	public static void wxLogDebug(String arg1, int arg2, int arg3, int arg4) {
	}

	public static void wxLogDebug(String arg1, int arg2, int arg3) {
	}

	public static void wxLogDebug(String arg1, String arg2) {
	}

	public static int gmGetSuit(int arg1) {
		return (arg1 / gmTOTAL_VALUES);
	}

	public static int gmGetValue(int arg1) {
		return (arg1 % gmTOTAL_VALUES);
	}
}
