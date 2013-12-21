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

package eu.veldsoft.twenty.eight.gm;

import eu.veldsoft.twenty.eight.dummy.Globals;
import eu.veldsoft.twenty.eight.dummy.wxFrame;
import eu.veldsoft.twenty.eight.dummy.wxStatusBar;
import eu.veldsoft.twenty.eight.dummy.wxTheApp;

public class  gmUtil {
	public static final int gmTOTAL_CARDS = 32;

	public static final int gmTOTAL_PLAYERS = 4;

	public static final int gmTOTAL_BID_ROUNDS = 3;

	public static final int gmPLAYER_INVALID = -1;

	public static final int gmSUIT_INVALID = -1;

	public static final int gmCARD_INVALID = -1;

	public static final int gmBID_PASS = 0;

	public static final int gmBID_ALL = 1000;

	public static final int gmTOTAL_SUITS = 4;

	public static final int gmTOTAL_VALUES = 8;

	public static final int gmTOTAL_TRICKS = 8;

	public static final int gmTOTAL_TEAMS = 2;

	public static int m_value_trans[] = { 6, 7, 11, 12, 9, 0, 8, 10 };

	public static int BitsSetTable256[] = { 0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3,
			2, 3, 3, 4, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 1, 2,
			2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 2, 3, 3, 4, 3, 4, 4, 5,
			3, 4, 4, 5, 4, 5, 5, 6, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4,
			4, 5, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 2, 3, 3, 4,
			3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 3, 4, 4, 5, 4, 5, 5, 6, 4, 5,
			5, 6, 5, 6, 6, 7, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5,
			2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 2, 3, 3, 4, 3, 4,
			4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6,
			5, 6, 6, 7, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 3, 4,
			4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7, 3, 4, 4, 5, 4, 5, 5, 6,
			4, 5, 5, 6, 5, 6, 6, 7, 4, 5, 5, 6, 5, 6, 6, 7, 5, 6, 6, 7, 6, 7,
			7, 8 };

	public static int LogTable256[] = { 0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3,
			3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5,
			5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
			5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,
			6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,
			6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,
			6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
			7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
			7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
			7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
			7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
			7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7 };

	public static String m_suits[];

	public static String m_values[];

	public static String m_short_locs[];

	public static String m_long_locs[];

	public static long m_suit_mask[];

	public static long m_suit_rs[];

	public static int m_points[];

	public static int m_total_points[];

	public static String m_short_teams[];

	/**
	 * 
	 * @param array
	 * @param n
	 * 
	 * @author INFM032 F___39 Shterion Yanev
	 * @author INFM042 F___68 Georgi Srebrov
	 * @author INFM042 F___81 Marina Rangelova
	 */
	public static void ShuffleArray(int array[], long n) {
		if (n <= 1) {
			return;
		}

		for (int i = (int) (n - 1); i >= 1; i--) {
			// TODO Non linear distribution. To be corrected.
			int j = Globals.PRNG.nextInt(i + 1);
			int t = array[j];
			array[j] = array[i];
			array[i] = t;
		}
	}

	/**
	 * 
	 * @param cards
	 * 
	 * @return
	 * 
	 * @author INFM032 F___81 Marina Rangelova
	 * @author INFM042 F___68 Nikola Vushkov
	 * @author INFM032 F___06 Rosen Kaplanov
	 */
	public static String PrintLong(long cards) {
		String out = "";
		for (int i = 0; i < 32; i++) {
			if ((cards & (1 << i)) != 0) {
				out = out + m_suits[i / 8] + m_values[i % 8] + (",");
			}
		}

		String finish = "";
		if (out != null && out.equals("") == false) {
			finish = out.substring(0, out.length() - 1);
		}

		return finish;
	}

	/**
	 * 
	 * @param hands
	 * 
	 * @return
	 * 
	 * @author INFM032 F___39 Shterion Yanev
	 * @author INFM042 F___06 Rosen Kaplanov
	 * @author INFM032 F___47 Kostadin Bulakiev
	 */
	public static String PrintHands(long hands[]) {
		String finish;
		String out;
		long temp;

		/*
		 * Print North first
		 */
		String ret_val = "";
		ret_val += (Globals.SPACES20 + m_long_locs[2]);
		ret_val += ("\n");

		for (int i = 0; i < 4; i++) {
			temp = (hands[2] & m_suit_mask[i]) >> m_suit_rs[i];
			out = "%s - " + m_suits[i];
			for (int j = 7; j >= 0; j--) {
				if ((temp & (1 << j)) != 0) {
					out = out + m_values[j % 8] + ",";
				}
			}

			finish = out.substring(0, out.length() - 1);

			ret_val += Globals.SPACES20 + finish;
			ret_val += "\n";
		}

		/*
		 * Print East and West in the same line :D
		 */
		ret_val += "%-40s%-40s" + m_long_locs[1] + m_long_locs[3];
		ret_val += "\n";

		for (int i = 0; i < 4; i++) {
			temp = (hands[1] & m_suit_mask[i]) >> m_suit_rs[i];
			out = "%s - " + m_suits[i];

			for (int j = 7; j >= 0; j--) {
				if ((temp & (1 << j)) != 0) {
					out = out + m_values[j % 8] + ",";
				}
			}

			finish = "%-40s" + out.substring(0, out.length() - 1);

			temp = (hands[3] & m_suit_mask[i]) >> m_suit_rs[i];
			out = "%s - " + m_suits[i];

			for (int j = 7; j >= 0; j--) {
				if ((temp & (1 << j)) != 0) {
					out = out + m_values[j % 8] + ",";
				}
			}

			finish += "%-40s" + out.substring(0, out.length() - 1);

			ret_val += (finish);
			ret_val += "\n";
		}

		/*
		 * Finally print South
		 */
		ret_val += (Globals.SPACES20 + m_long_locs[0]);
		ret_val += "\n";

		for (int i = 0; i < 4; i++) {
			temp = (hands[0] & m_suit_mask[i]) >> m_suit_rs[i];
			out = "%s - " + m_suits[i];

			for (int j = 7; j >= 0; j--) {
				if ((temp & (1 << j)) != 0) {
					out = out + m_values[j % 8] + ",";
				}
			}

			finish = out.substring(0, out.length() - 1);
			ret_val += Globals.SPACES20 + finish;
			ret_val += "\n";
		}

		return ret_val;
	}

	public static int GetCardIndex(String text) {
		// TODO To be done by INFM032 F___68 Nikola Vushkov ...
		// TODO To be done by INFM042 F___56 Daniel Nikolov ...
		// TODO To be done by INFM032 F___48 Georgi Ivanov ...

		return (0);
	}

	public static boolean SetStatusText(final String text) {
		return (SetStatusText(text, 0));
	}

	/**
	 * 
	 * @param text
	 * @param i
	 * @return
	 * @author INFM032 F___81 Marina Rangelova
	 * @author INFM032 F___06 Rosen Kaplanov
	 * @author INFM042 F___39 Shterion Yanev
	 */
	public static boolean SetStatusText(final String text, int i) {
		wxFrame main_frame;
		wxStatusBar status_bar;

		main_frame = null;
		main_frame = (wxFrame) wxTheApp.GetTopWindow();

		if (main_frame == null) {
			return false;
		}

		status_bar = null;
		status_bar = main_frame.GetStatusBar();

		if (status_bar == null) {
			return false;
		}

		status_bar.SetStatusText(text, i);
		status_bar.Update();

		return true;
	}

	/**
	 * 
	 * @param v
	 * @return
	 * 
	 * @author INFM042 F___52 Mihail Stankov
	 * @author INFM042 F___93 Krasimir Chariyski
	 * @author INFM032 F___39 Shterion Yanev
	 */
	public static long CountBitsSet(long v) {
		return BitsSetTable256[(int) (v & 0xff)]
				+ BitsSetTable256[(int) ((v >> 8) & 0xff)]
				+ BitsSetTable256[(int) ((v >> 16) & 0xff)]
				+ BitsSetTable256[(int) (v >> 24)];
	}

	public static long HighestBitSet(long v) {
		// TODO To be done by INFM042 F___68 Georgi Srebrov ...
		// TODO To be done by INFM042 F___05 Iliya Grozev ...
		// TODO To be done by INFM032 F___48 Georgi Ivanov ...

		return (0);
	}
}
