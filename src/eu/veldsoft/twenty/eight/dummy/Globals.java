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
import eu.veldsoft.twenty.eight.gm.gmUtil;

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

	public static final String raCONFPATH_APP_DATA_X = "application/x";

	public static final String raCONFPATH_APP_DATA_Y = "application/y";

	public static final String raCONFPATH_APP_DATA_WIDTH = "application/width";

	public static final String raCONFPATH_APP_DATA_HEIGHT = "application/height";

	public static final String raCONFPATH_APP_DATA_MAX = "application/maximized";

	public static final String raCONFPATH_GAME_DATA_CLOCK = "game/clockwise";

	public static final String raCONFPATH_GAME_DATA_MINBID3 = "game/minbid3";

	public static final String raCONFPATH_GAME_DATA_WAIVERULE4 = "game/waiverule4";

	public static final String raCONFPATH_GAME_DATA_SLUFFJACKS = "game/sluffjacks";

	public static final String raCONFPATH_PREFS_PLAYCARDON = "preferences/playcardon";

	public static final String raCONFPATH_PREFS_CARDBACK = "preferences/cardback";

	public static final String raCONFPATH_PREFS_AUTOPLAYSINGLE = "preferences/autoplaysingle";

	public static final String raCONFPATH_PREFS_BIDBUBBLES = "preferences/bidbubbles";

	public static final String RA_APP_MAJOR_VER = "1";

	public static final String RA_APP_MINOR_VER = "0";

	public static final String RA_APP_REL_TYPE = "b";

	public static final String RA_APP_REL_TYPE_VER = "1";

	public static final String RA_APP_NAME = "Rosanne";

	public static final String RA_APP_AUTHOR = "Todor Balabanov";

	public static final int gmBID_PASS = 0;

	public static final int gmBID_ALL = 1000;

	public static final int gmTOTAL_SUITS = 4;

	public static final int gmTOTAL_VALUES = 8;

	public static final int gmTOTAL_TRICKS = 8;

	public static final int gmTOTAL_TEAMS = 2;

	public static final int wxOK = 0x00000004;

	public static final int gmPLAYER_INVALID = -1;

	public static final int wxICON_INFORMATION = 0x00000800;

	public static final wxEventType raINFO_EVT = new wxNewEventType();

	public static final wxEventType raBID_EVT = new wxNewEventType();

	public static final wxEventType raUPDATE_EVT = new wxNewEventType();

	public static final boolean raAI_LOG_CHECKASSUMPTIONS = false;

	public static final String RA_APP_FULL_NAME = "";

	public static final String __DATE__ = "";

	public static final String __TIME__ = "";

	public static final String __GNUC__ = "";

	public static final String __GNUC_MINOR__ = "";

	public static final boolean aiLOG_GENERATESLPROBLEM = false;
	
	public static final boolean raAI_LOG_ESTIMATE_POINTS = false;
	
	public static final String raTEXT_CLOCKWISE = "Clockwise";
	
	public static final String raTEXT_ANTICLOCKWISE = "Anti-lockwise";
	
	public static final int raSBARPOS_GEN = 0;
	
	public static final int raSBARPOS_CLOCK = 1;
	
	public static final int gmSTATUS_NOT_STARTED = 0;

	//TODO Find true value of this constant.
	public static final int raBID_ROUND_3 = 3;

	public static final wxColour wxWHITE = null;
	
	public static final boolean raAI_LOG_MAKEMOVE = false;

	public static final String GG_CARD_XRS = "cards.xrs";
	
	public static final boolean raAI_LOG_GETBID = false;
	
	public static final int raPLAYER_TYPE_INVALID = 0;

	public static final int raPLAYER_TYPE_AI = 0;

	public static final int gmTOTAL_CARDS = 0;

	public static final boolean raGAME_HIDE_AI_HANDS = false;

	public static final wxCoord GG_CARD_WIDTH = null;

	public static final wxCoord GG_CARD_HEIGHT = null;

	public static final int gmINPUT_BID = 0;

	public static final int gmERR_BID_BY_WRONG_PLAYER = 0;

	public static final int gmERR_CANNOT_PASS = 0;

	public static final int gmERR_BID_LESS_THAN_MIN = 0;

	public static int gmOUTPUT_DEAL_END = 1;

	public static int gmINPUT_INVALID = -1;

	public static String SPACES20 = "                    ";

	public static Object wxThread;

	public static int gmERR_TRICK_MASK_MISMATCH = 8;
	
	public static final int gmINPUT_TRICK = 2;

	public static final int raINFO_CMD_NEW_DEAL = 0;

	public static final int raINFO_CMD_SHOW_TRUMP = 0;

	public static final String gmUtil = null;
	
	public static void wxLogError(String string, String file, int line) {
	}

	public static void wxLogError(String string) {
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

	public static void wxMessageBox(String arg0, String arg1, int arg2) {
	}

	public static int gmGetSuit(int arg1) {
		return (arg1 / gmTOTAL_VALUES);
	}

	public static int gmGetValue(int arg1) {
		return (arg1 % gmTOTAL_VALUES);
	}

	public static int gmGetOpponent(int x) {
		return ((x + 1) % gmTOTAL_TEAMS);
	}

	public static int gmGetOpponentOne(int x) {
		return ((x + 1) % gmTOTAL_PLAYERS);
	}

	public static int gmGetOpponentTwo(int x) {
		return ((x + 3) % gmTOTAL_PLAYERS);
	}

	public static void wxLogDebug(String string) {
	}

	public static String wxGetOsDescription() {
		return null;
	}

	public static boolean wxIsPlatform64Bit() {
		return false;
	}

	public static int gmTotalPoints(long X) {
		return gmUtil.m_total_points[(int) ((gmUtil.m_suit_mask[0] & X) >> gmUtil.m_suit_rs[0])]
				+ gmUtil.m_total_points[(int) ((gmUtil.m_suit_mask[1] & X) >> gmUtil.m_suit_rs[1])]
				+ gmUtil.m_total_points[(int) ((gmUtil.m_suit_mask[2] & X) >> gmUtil.m_suit_rs[2])]
				+ gmUtil.m_total_points[(int) ((gmUtil.m_suit_mask[3] & X) >> gmUtil.m_suit_rs[3])];
	}
	public static void GetClientSize(Integer x, Integer y) {
	}

	public static void wxLogError(String string, String res_name, String file,
			int line) {
	}

	public static void wxLogDebug(String arg1, String file, int line) {
	}

	public static boolean BlitToBack(int racardPanelRelief,
			int racardPanelRelief2, wxCoord ggCardWidth, wxCoord ggCardHeight,
			wxMemoryDC mdc, int i, int j, int wxcopy2, boolean b) {
		return false;
	}

	public static boolean BlitToBack(int x, int y, int raARROW_WIDTH,
			int raARROW_WIDTH2, wxMemoryDC mdc, int i, int j, int wxcopy2,
			boolean b) {
		return false;
	}

	public static void wxMessageBox(String string) {
		// TODO Auto-generated method stub
		
	}
}
