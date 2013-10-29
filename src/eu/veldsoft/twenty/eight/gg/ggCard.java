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

package eu.veldsoft.twenty.eight.gg;

import eu.veldsoft.twenty.eight.dummy.Globals;
import eu.veldsoft.twenty.eight.dummy.wxBitmap;
import eu.veldsoft.twenty.eight.dummy.wxCoord;
import eu.veldsoft.twenty.eight.dummy.wxDC;
import eu.veldsoft.twenty.eight.dummy.wxMemoryDC;
import eu.veldsoft.twenty.eight.dummy.wxMutex;

public class ggCard {
	public static final int GG_CARD_CARD_COUNT = 52;

	public static final int GG_CARD_SPADES = 3;

	public static final int GG_CARD_HEARTS = 2;

	public static final int GG_CARD_DIAMONDS = 1;

	public static final int GG_CARD_CLUBS = 0;

	public static final int GG_CARD_ACE = 0;

	public static final int GG_CARD_TWO = 1;

	public static final int GG_CARD_THREE = 2;

	public static final int GG_CARD_FOUR = 3;

	public static final int GG_CARD_FIVE = 4;

	public static final int GG_CARD_SIX = 5;

	public static final int GG_CARD_SEVEN = 6;

	public static final int GG_CARD_EIGHT = 7;

	public static final int GG_CARD_NINE = 8;

	public static final int GG_CARD_TEN = 9;

	public static final int GG_CARD_JACK = 10;

	public static final int GG_CARD_QUEEN = 11;

	public static final int GG_CARD_KING = 12;

	public static final int GG_CARD_BACK_1 = 20;

	public static final int GG_CARD_BACK_2 = 21;

	public static final int GG_CARD_JOKER_1 = 30;

	public static final int GG_CARD_JOKER_2 = 31;

	public static final int GG_CARD_TOTAL_SUITS = 4;

	public static final int GG_CARD_TOTAL_VALUES = 13;

	public static final int GG_CARD_WIDTH = 71;

	public static final int GG_CARD_HEIGHT = 96;

	private static boolean s_init;

	private static wxMutex s_mutex;

	private static wxBitmap s_mask_bmp;

	// Disallow copy finalructor/assignment operators
	private ggCard(final ggCard object) {
		// TODO To be done by INFM042 F___88 Ivan Dankinov ...
		// TODO To be done by INFM032 F___90 Svetoslav Slavkov ...
		// TODO To be done by INFM032 F___81 Marina Rangelova ...
	}

	private boolean LoadFace(String res_name) {
		// TODO To be done by INFM032 F___81 Marina Rangelova ...
		// TODO To be done by INFM032 F___47 Kostadin Bulakiev ...
		// TODO To be done by INFM042 F___45 Valentin Popov ...

		return (false);
	}

	public ggCard() {
		// TODO To be done by INFM032 F___06 Rosen Kaplanov ...
		// TODO To be done by INFM032 F___68 Nikola Vushkov ...
		// TODO To be done by INFM032 F___84 Mariya Kostadinova ...
	}

	public ggCard(int suit, int value) {
		// TODO To be done by INFM042 F___05 Iliya Grozev ...
		// TODO To be done by INFM042 F___00 Tsvetelina Hristova ...
		// TODO To be done by INFM032 F___93 Krasimir Chariyski ...
	}

	public ggCard(int other) {
		// TODO To be done by INFM032 F___81 Marina Rangelova ...
		// TODO To be done by INFM042 F___67 Nevena Sirakova ...
		// TODO To be done by INFM032 F___05 Iliya Grozev ...
	}

	protected void finalize() {
		// TODO To be done by INFM042 F___48 Georgi Ivanov ...
		// TODO To be done by INFM042 F___05 Iliya Grozev ...
		// TODO To be done by INFM042 F___00 Tsvetelina Hristova ...
	}

	public wxBitmap m_face;

	public boolean BlitTo(wxDC dest, wxCoord xdest, wxCoord ydest) {
		return (BlitTo(dest, xdest, ydest, Globals.wxCOPY));
	}

	public boolean BlitTo(wxDC dest, wxCoord xdest, wxCoord ydest,
			int logicalFunc) {
		// TODO To be done by INFM032 F___93 Krasimir Chariyski ...
		// TODO To be done by INFM032 F___68 Georgi Srebrov ...
		// TODO To be done by INFM042 F___46 Nadya Nedyalkova ...

		return (false);
	}

	public wxBitmap GetFace() {
		// TODO To be done by INFM042 F___52 Mihail Stankov ...
		// TODO To be done by INFM042 F___05 Iliya Grozev ...
		// TODO To be done by INFM032 F___46 Nadya Nedyalkova ...

		return (null);
	}

	public void SelectToDC(wxMemoryDC mdc) {
		// TODO To be done by INFM032 F___84 Mariya Kostadinova ...
		// TODO To be done by INFM032 F___93 Krasimir Chariyski ...
		// TODO To be done by INFM032 F___39 Shterion Yanev ...
	}

	public ggCard assign(final ggCard object) {
		// TODO To be done by INFM042 F___05 Iliya Grozev ...
		// TODO To be done by INFM042 F___52 Mihail Stankov ...
		// TODO To be done by INFM032 F___00 Tsvetelina Hristova ...

		return (this);
	}
}
