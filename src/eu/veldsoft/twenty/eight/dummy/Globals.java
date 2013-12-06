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

import eu.veldsoft.twenty.eight.gg.ggCard;

public class Globals {

	public static final Random PRNG = new Random();
	
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

	public static final int gmTOTAL_VALUES = 8;

	public static final int gmSTATUS_TRICKS = 0;

	public static final int raHAND_VERTICAL = 0;

	public static final int raHAND_HORIZONTAL = 1;

	public static final int raGAME_ORIENT_ALL_HORZ = 0;

	public static final int raGAME_ORIENT_MIXED = 1;

	public static final int raTOTAL_CARD_BACKS = 2;

	public static final int raMAX_CARDS_PER_HAND = 8;

	public static final int raCARD_VERT_RELIEF = (12);

	public static final int raCARD_HORZ_RELIEF = (ggCard.GG_CARD_WIDTH / 4);

	public static final int raCARD_PANEL_RELIEF = 20;

	public static final int raGAME_CARD_BACK_SEL = 0;

	public static final int raGAME_ARROW_RELIEF = 8;

	public static final int raGAME_FOUR_JACKS = (0x80808080);

	public static final int raGAME_ALL_LOW_CARDS = (0x0F0F0F0F);

	public static final int raGAME_ALL_HIGH_CARDS = (0xF0F0F0F0);

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
