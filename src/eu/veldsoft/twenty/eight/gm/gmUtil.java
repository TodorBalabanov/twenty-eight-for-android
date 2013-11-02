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

public class gmUtil {
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

	public static int m_value_trans[];

	public static void ShuffleArray(int array, long n) {
		// TODO To be done by INFM032 F___39 Shterion Yanev ...
		// TODO To be done by INFM042 F___68 Georgi Srebrov ...
		// TODO To be done by INFM042 F___81 Marina Rangelova ...
	}

	public static String PrintLong(long cards) {
		// TODO To be done by INFM032 F___81 Marina Rangelova ...
		// TODO To be done by INFM042 F___68 Nikola Vushkov ...
		// TODO To be done by INFM032 F___06 Rosen Kaplanov ...

		return ("");
	}

	public static String PrintHands(long hands) {
		// TODO To be done by INFM032 F___39 Shterion Yanev ...
		// TODO To be done by INFM042 F___06 Rosen Kaplanov ...
		// TODO To be done by INFM032 F___47 Kostadin Bulakiev ...

		return ("");
	}

	public static String m_suits[];

	public static String m_values[];

	public static String m_short_locs[];

	public static String m_long_locs[];

	public static long m_suit_mask[];

	public static long m_suit_rs[];

	public static int m_points[];

	public static int m_total_points[];

	public static String m_short_teams[];

	public static int GetCardIndex(String text) {
		// TODO To be done by INFM032 F___68 Nikola Vushkov ...
		// TODO To be done by INFM042 F___56 Daniel Nikolov ...
		// TODO To be done by INFM032 F___48 Georgi Ivanov ...

		return (0);
	}

	public static boolean SetStatusText(final String text) {
		return (SetStatusText(text, 0));
	}

	public static boolean SetStatusText(final String text, int i) {
		// TODO To be done by INFM032 F___81 Marina Rangelova ...
		// TODO To be done by INFM032 F___06 Rosen Kaplanov ...
		// TODO To be done by INFM042 F___39 Shterion Yanev ...

		return (false);
	}

	public static int BitsSetTable256[];

	public static int LogTable256[];

	public static long CountBitsSet(long v) {
		// TODO To be done by INFM042 F___52 Mihail Stankov ...
		// TODO To be done by INFM042 F___93 Krasimir Chariyski ...
		// TODO To be done by INFM032 F___39 Shterion Yanev ...

		return (0);
	}

	public static long HighestBitSet(long v) {
		// TODO To be done by INFM042 F___68 Georgi Srebrov ...
		// TODO To be done by INFM042 F___05 Iliya Grozev ...
		// TODO To be done by INFM032 F___48 Georgi Ivanov ...

		return (0);
	}
}
