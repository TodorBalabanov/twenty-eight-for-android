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

import eu.veldsoft.twenty.eight.dummy.wxBitmap;
import eu.veldsoft.twenty.eight.dummy.wxFont;
import eu.veldsoft.twenty.eight.dummy.wxMouseEvent;
import eu.veldsoft.twenty.eight.dummy.wxPoint;
import eu.veldsoft.twenty.eight.dummy.wxRect;
import eu.veldsoft.twenty.eight.dummy.wxSizeEvent;
import eu.veldsoft.twenty.eight.dummy.wxWindow;
import eu.veldsoft.twenty.eight.gg.ggCard;
import eu.veldsoft.twenty.eight.gm.gmEngine;
import eu.veldsoft.twenty.eight.gm.gmEngineData;
import eu.veldsoft.twenty.eight.gm.gmRules;
import eu.veldsoft.twenty.eight.gm.gmTrick;
import eu.veldsoft.twenty.eight.gm.gmUtil;

public class raGamePanel {
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

	private wxBitmap m_tile;

	// Disallow copy finalructor/assignment operators
	private raGamePanel(final raGamePanel object) {
		//TODO To be done by INFM042 F___56 Daniel Nikolov ...
		//TODO To be done by INFM042 F___84 Mariya Kostadinova ...
		//TODO To be done by INFM032 F___06 Rosen Kaplanov ...
	}

	private raGamePanel assign(final raGamePanel object) {
		//TODO To be done by INFM032 F___45 Valentin Popov ...
		//TODO To be done by INFM042 F___94 Aleksandar Milev ...
		//TODO To be done by INFM032 F___47 Kostadin Bulakiev ...

		return (this);
	}

	private wxBitmap m_card_faces[] = new wxBitmap[gmUtil.gmTOTAL_CARDS];

	private wxBitmap m_card_backs[] = new wxBitmap[raTOTAL_CARD_BACKS];

	private gmEngine m_engine;

	private raInfo m_info;

	private raBid m_bid;

	// Related to the display of hands
	private raHand m_hands[] = new raHand[gmUtil.gmTOTAL_PLAYERS];

	private wxRect m_hand_rects[] = new wxRect[gmUtil.gmTOTAL_PLAYERS];

	private wxRect m_hand_card_rects[][] = new wxRect[gmUtil.gmTOTAL_PLAYERS][raMAX_CARDS_PER_HAND];

	private int m_hand_rot;

	// Related to the display of cards played in a trick
	// int m_trick_cards[gmTOTAL_PLAYERS];
	private gmTrick m_trick;

	private wxRect m_trick_card_rects[] = new wxRect[gmUtil.gmTOTAL_PLAYERS];

	private boolean m_wait_trick;

	// To check whether the deal is still being played
	private boolean m_deal_ended;

	// Players
	private raPlayer m_players[] = new raPlayer[gmUtil.gmTOTAL_PLAYERS];

	// Game points and penalties
	private int m_game_pts[] = new int[gmUtil.gmTOTAL_TEAMS];

	private int m_pnlties[] = new int[gmUtil.gmTOTAL_PLAYERS];

	// Direction of play
	private boolean m_clockwise;

	// Font used to write text
	private wxFont m_font_bold;

	// Hand orientation
	private int m_orientation;

	// Prefereed card back
	private int m_pref_card_back;

	// Play card on single click
	private int m_play_card_on;

	// Auto play single choice
	private boolean m_auto_play;

	// Show bid bubbles
	private boolean m_show_bidbubbles;

	// Saved rules
	private gmRules m_saved_rules;

	// Saved auction history
	private String m_bid_history;

	// Bitmaps to be loaded from xpms

	private wxBitmap m_bmp_green_arrow_bottom;

	private wxBitmap m_bmp_green_arrow_top;

	private wxBitmap m_bmp_green_arrow_right;

	private wxBitmap m_bmp_green_arrow_left;

	private wxBitmap m_bmp_red_arrow_bottom;

	private wxBitmap m_bmp_red_arrow_top;

	private wxBitmap m_bmp_red_arrow_right;

	private wxBitmap m_bmp_red_arrow_left;

	private wxBitmap m_bmp_bubble_arrow_bottom;

	private wxBitmap m_bmp_bubble_arrow_left;

	private wxBitmap m_bmp_bubble_arrow_right;

	private wxBitmap m_bmp_bubble_arrow_top;

	private wxBitmap m_bmp_bubble_corner_ne;

	private wxBitmap m_bmp_bubble_corner_nw;

	private wxBitmap m_bmp_bubble_corner_se;

	private wxBitmap m_bmp_bubble_corner_sw;

	private wxBitmap m_bmp_bubble_edge_bottom;

	private wxBitmap m_bmp_bubble_edge_left;

	private wxBitmap m_bmp_bubble_edge_right;

	private wxBitmap m_bmp_bubble_edge_top;

	private void OnSize(wxSizeEvent event) {
		//TODO To be done by INFM032 F___56 Daniel Nikolov ...
		//TODO To be done by INFM042 F___90 Svetoslav Slavkov ...
		//TODO To be done by INFM042 F___05 Iliya Grozev ...
	}

	private boolean RedrawBack() {
		return (RedrawBack(null));
	}

	private boolean RedrawBack(raBackDrawInfo info) {
		//TODO To be done by INFM042 F___84 Mariya Kostadinova ...
		//TODO To be done by INFM042 F___39 Shterion Yanev ...
		//TODO To be done by INFM042 F___27 Georgi Kostadinov ...

		return (false);
	}

	private boolean DrawHand(int loc, int x, int y) {
		return (DrawHand(loc, x, y, raGamePanel.raHAND_HORIZONTAL));
	}

	private boolean DrawHand(int loc, int x, int y, int orientation) {
		//TODO To be done by INFM042 F___68 Nikola Vushkov ...
		//TODO To be done by INFM032 F___27 Georgi Kostadinov ...
		//TODO To be done by INFM032 F___67 Nevena Sirakova ...

		return (false);
	}

	private boolean DrawTrick() {
		//TODO To be done by INFM042 F___05 Iliya Grozev ...
		//TODO To be done by INFM032 F___67 Nevena Sirakova ...
		//TODO To be done by INFM032 F___14 Petya Atanasova ...

		return (false);
	}

	private boolean DrawTrump() {
		//TODO To be done by INFM032 F___56 Daniel Nikolov ...
		//TODO To be done by INFM032 F___67 Nevena Sirakova ...
		//TODO To be done by INFM042 F___06 Rosen Kaplanov ...

		return (false);
	}

	private void OnInfo(raInfoEvent event) {
		//TODO To be done by INFM032 F___39 Shterion Yanev ...
		//TODO To be done by INFM042 F___84 Mariya Kostadinova ...
		//TODO To be done by INFM042 F___81 Marina Rangelova ...
	}

	private void OnBid(raBidEvent event) {
		//TODO To be done by INFM032 F___48 Georgi Ivanov ...
		//TODO To be done by INFM042 F___68 Nikola Vushkov ...
		//TODO To be done by INFM032 F___93 Krasimir Chariyski ...
	}

	private void OnLeftDClick(wxMouseEvent event) {
		//TODO To be done by INFM032 F___45 Valentin Popov ...
		//TODO To be done by INFM032 F___88 Ivan Dankinov ...
		//TODO To be done by INFM042 F___14 Petya Atanasova ...
	}

	private void OnLeftUp(wxMouseEvent event) {
		//TODO To be done by INFM042 F___84 Mariya Kostadinova ...
		//TODO To be done by INFM032 F___81 Marina Rangelova ...
		//TODO To be done by INFM042 F___56 Daniel Nikolov ...
	}

	private int GetCardAtPos(wxPoint pt) {
		return (GetCardAtPos(pt, gmUtil.gmPLAYER_INVALID));
	}

	private int GetCardAtPos(wxPoint pt, int loc) {
		//TODO To be done by INFM032 F___45 Valentin Popov ...
		//TODO To be done by INFM042 F___93 Krasimir Chariyski ...
		//TODO To be done by INFM032 F___56 Daniel Nikolov ...

		return (0);
	}

	private int GetHandAtPos(wxPoint pt) {
		//TODO To be done by INFM032 F___27 Georgi Kostadinov ...
		//TODO To be done by INFM042 F___00 Tsvetelina Hristova ...
		//TODO To be done by INFM042 F___90 Svetoslav Slavkov ...

		return (0);
	}

	private boolean Continue() {
		//TODO To be done by INFM032 F___45 Valentin Popov ...
		//TODO To be done by INFM032 F___46 Nadya Nedyalkova ...
		//TODO To be done by INFM042 F___14 Petya Atanasova ...

		return (false);
	}

	private boolean ResetDeal() {
		//TODO To be done by INFM042 F___67 Nevena Sirakova ...
		//TODO To be done by INFM032 F___88 Ivan Dankinov ...
		//TODO To be done by INFM042 F___90 Svetoslav Slavkov ...

		return (false);
	}

	private boolean ResetGame() {
		//TODO To be done by INFM032 F___45 Valentin Popov ...
		//TODO To be done by INFM032 F___94 Aleksandar Milev ...
		//TODO To be done by INFM032 F___67 Nevena Sirakova ...

		return (false);
	}

	private boolean UpdateHands(long hands) {
		//TODO To be done by INFM042 F___45 Valentin Popov ...
		//TODO To be done by INFM032 F___84 Mariya Kostadinova ...
		//TODO To be done by INFM032 F___93 Krasimir Chariyski ...

		return (false);
	}

	private int PlayCard(int card) {
		return (PlayCard(card, gmUtil.gmPLAYER_INVALID));
	}

	private int PlayCard(int card, int loc) {
		//TODO To be done by INFM032 F___45 Valentin Popov ...
		//TODO To be done by INFM042 F___48 Georgi Ivanov ...
		//TODO To be done by INFM042 F___67 Nevena Sirakova ...

		return (0);
	}

	private int SetTrump(int card) {
		return (SetTrump(card, gmUtil.gmPLAYER_INVALID));
	}

	private int SetTrump(int card, int loc) {
		//TODO To be done by INFM032 F___47 Kostadin Bulakiev ...
		//TODO To be done by INFM042 F___46 Nadya Nedyalkova ...
		//TODO To be done by INFM032 F___81 Marina Rangelova ...

		return (0);
	}

	private int ShowTrump() {
		return (ShowTrump(gmUtil.gmPLAYER_INVALID));
	}

	private int ShowTrump(int loc) {
		//TODO To be done by INFM032 F___45 Valentin Popov ...
		//TODO To be done by INFM032 F___84 Mariya Kostadinova ...
		//TODO To be done by INFM042 F___47 Kostadin Bulakiev ...

		return (0);
	}

	private int MakeBid(int bid) {
		return (MakeBid(bid, gmUtil.gmPLAYER_INVALID));
	}

	private int MakeBid(int bid, int loc) {
		//TODO To be done by INFM032 F___39 Shterion Yanev ...
		//TODO To be done by INFM032 F___06 Rosen Kaplanov ...
		//TODO To be done by INFM042 F___90 Svetoslav Slavkov ...

		return (0);
	}

	private boolean UpdateDrawAndRefresh() {
		return (UpdateDrawAndRefresh(true, null));
	}

	private boolean UpdateDrawAndRefresh(boolean udpate) {
		return (UpdateDrawAndRefresh(udpate, null));
	}

	private boolean UpdateDrawAndRefresh(boolean udpate, raBackDrawInfo info) {
		//TODO To be done by INFM042 F___81 Marina Rangelova ...
		//TODO To be done by INFM042 F___05 Iliya Grozev ...
		//TODO To be done by INFM032 F___90 Svetoslav Slavkov ...

		return (false);
	}

	private boolean HideInfo(gmEngineData data, int player) {
		//TODO To be done by INFM042 F___06 Rosen Kaplanov ...
		//TODO To be done by INFM042 F___81 Marina Rangelova ...
		//TODO To be done by INFM042 F___90 Svetoslav Slavkov ...

		return (false);
	}

	private boolean HasDealEnded() {
		return (HasDealEnded(0));
	}

	private boolean HasDealEnded(int winner) {
		//TODO To be done by INFM042 F___52 Mihail Stankov ...
		//TODO To be done by INFM042 F___05 Iliya Grozev ...
		//TODO To be done by INFM032 F___90 Svetoslav Slavkov ...

		return (false);
	}

	private boolean EndDeal() {
		return (EndDeal(false));
	}

	private boolean EndDeal(boolean abandon) {
		//TODO To be done by INFM032 F___93 Krasimir Chariyski ...
		//TODO To be done by INFM042 F___68 Georgi Srebrov ...
		//TODO To be done by INFM042 F___14 Petya Atanasova ...

		return (false);
	}

	private boolean BeginBusyState() {
		// TODO To be done by ...

		return (false);
	}

	private boolean EndBusyState() {
		// TODO To be done by ...

		return (false);
	}

	private int CheckOppTrumps() {
		// TODO To be done by ...

		return (0);
	}

	private boolean OnCardClick(wxPoint pt) {
		// TODO To be done by ...

		return (false);
	}

	public raGamePanel(final wxWindow parent) {
		// TODO To be done by ...
	}

	protected void finalize() {
		// TODO To be done by ...
	}

	public boolean SetTile(wxBitmap tile) {
		// TODO To be done by ...

		return (false);
	}

	public boolean SetInfoPanel(raInfo info_panel) {
		// TODO To be done by ...

		return (false);
	}

	public boolean NewGame() {
		return (NewGame(gmUtil.gmPLAYER_INVALID, true));
	}

	public boolean NewGame(int dealer) {
		return (NewGame(dealer, true));
	}

	public boolean NewGame(int dealer, boolean immediate) {
		// TODO To be done by ...

		return (false);
	}

	public boolean NewDeal() {
		// TODO To be done by ...

		return (false);
	}

	public boolean SetClockwise(boolean flag) {
		// TODO To be done by ...

		return (false);
	}

	public boolean GetClockwise() {
		// TODO To be done by ...

		return (false);
	}

	public boolean ReloadFromConfig() {
		// TODO To be done by ...

		return (false);
	}

	public boolean ShowAuction() {
		// TODO To be done by ...

		return (false);
	}

	public boolean ShowLastTrick() {
		// TODO To be done by ...

		return (false);
	}
}
