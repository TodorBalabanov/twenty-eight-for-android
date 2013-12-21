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
import eu.veldsoft.twenty.eight.dummy.wxBitmap;
import eu.veldsoft.twenty.eight.dummy.wxEvent;
import eu.veldsoft.twenty.eight.dummy.wxFont;
import eu.veldsoft.twenty.eight.dummy.wxMouseEvent;
import eu.veldsoft.twenty.eight.dummy.wxPoint;
import eu.veldsoft.twenty.eight.dummy.wxRect;
import eu.veldsoft.twenty.eight.dummy.wxSizeEvent;
import eu.veldsoft.twenty.eight.dummy.wxWindow;
import eu.veldsoft.twenty.eight.gg.ggCard;
import eu.veldsoft.twenty.eight.gg.ggPanel;
import eu.veldsoft.twenty.eight.gm.gmEngine;
import eu.veldsoft.twenty.eight.gm.gmEngineData;
import eu.veldsoft.twenty.eight.gm.gmRules;
import eu.veldsoft.twenty.eight.gm.gmTrick;
import eu.veldsoft.twenty.eight.gm.gmUtil;
import eu.veldsoft.twenty.eight.dummy.Globals;

public class raGamePanel extends ggPanel {
	/**
	 * Dummy values.
	 */
	private static final String __FILE__ = "";

	/**
	 * Dummy values.
	 */
	private static final int __LINE__ = 0;

	private wxBitmap m_tile;

	private static final int raCONFIG_PREFS_PLAYCARDON_DCLICK = 1;

	// Disallow copy finalructor/assignment operators
	private raGamePanel(final raGamePanel object) {
		// TODO To be done by INFM042 F___56 Daniel Nikolov ...
		// TODO To be done by INFM042 F___84 Mariya Kostadinova ...
		// TODO To be done by INFM032 F___06 Rosen Kaplanov ...
	}

	private raGamePanel assign(final raGamePanel object) {
		// TODO To be done by INFM032 F___45 Valentin Popov ...
		// TODO To be done by INFM042 F___94 Aleksandar Milev ...
		// TODO To be done by INFM032 F___47 Kostadin Bulakiev ...

		return (this);
	}

	private wxBitmap m_card_faces[] = new wxBitmap[gmUtil.gmTOTAL_CARDS];

	private wxBitmap m_card_backs[] = new wxBitmap[Globals.raTOTAL_CARD_BACKS];

	private gmEngine m_engine;

	private raInfo m_info;

	private raBid m_bid;

	// Related to the display of hands
	private raHand m_hands[] = new raHand[gmUtil.gmTOTAL_PLAYERS];

	private wxRect m_hand_rects[] = new wxRect[gmUtil.gmTOTAL_PLAYERS];

	private wxRect m_hand_card_rects[][] = new wxRect[gmUtil.gmTOTAL_PLAYERS][Globals.raMAX_CARDS_PER_HAND];

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
		// TODO To be done by INFM032 F___56 Daniel Nikolov ...
		// TODO To be done by INFM042 F___90 Svetoslav Slavkov ...
		// TODO To be done by INFM042 F___05 Iliya Grozev ...
	}

	private boolean RedrawBack() {
		return (RedrawBack(null));
	}

	private boolean RedrawBack(raBackDrawInfo info) {
		// TODO To be done by INFM042 F___84 Mariya Kostadinova ...
		// TODO To be done by INFM042 F___39 Shterion Yanev ...
		// TODO To be done by INFM042 F___27 Georgi Kostadinov ...

		return (false);
	}

	private boolean DrawHand(int loc, int x, int y) {
		return (DrawHand(loc, x, y, Globals.raHAND_HORIZONTAL));
	}

	private boolean DrawHand(int loc, int x, int y, int orientation) {
		// TODO To be done by INFM042 F___68 Nikola Vushkov ...
		// TODO To be done by INFM032 F___27 Georgi Kostadinov ...
		// TODO To be done by INFM032 F___67 Nevena Sirakova ...

		return (false);
	}

	private boolean DrawTrick() {
		// TODO To be done by INFM042 F___05 Iliya Grozev ...
		// TODO To be done by INFM032 F___67 Nevena Sirakova ...
		// TODO To be done by INFM032 F___14 Petya Atanasova ...

		return (false);
	}

	private boolean DrawTrump() {
		// TODO To be done by INFM032 F___56 Daniel Nikolov ...
		// TODO To be done by INFM032 F___67 Nevena Sirakova ...
		// TODO To be done by INFM042 F___06 Rosen Kaplanov ...

		return (false);
	}

	private void OnInfo(raInfoEvent event) {
		// TODO To be done by INFM032 F___39 Shterion Yanev ...
		// TODO To be done by INFM042 F___84 Mariya Kostadinova ...
		// TODO To be done by INFM042 F___81 Marina Rangelova ...
	}

	private void OnBid(raBidEvent event) {
		// TODO To be done by INFM032 F___48 Georgi Ivanov ...
		// TODO To be done by INFM042 F___68 Nikola Vushkov ...
		// TODO To be done by INFM032 F___93 Krasimir Chariyski ...
	}

	/**
	 * 
	 * @param event
	 * @author INFM032 F___45 Valentin Popov ...
	 * @author INFM032 F___88 Ivan Dankinov ...
	 * @author INFM042 F___14 Petya Atanasova ...
	 */
	private void OnLeftDClick(wxMouseEvent event) {
		/**
		 * If card play and trump selection are on double click
		 */
		if (m_play_card_on == raCONFIG_PREFS_PLAYCARDON_DCLICK) {
			if (!OnCardClick(event.GetPosition())) {
				Globals.wxLogError("OnCardClick failed. %s:%d", __FILE__,
						__LINE__);
				return;
			}
		}
		return;
	}

	private void OnLeftUp(wxMouseEvent event) {
		// TODO To be done by INFM042 F___84 Mariya Kostadinova ...
		// TODO To be done by INFM032 F___81 Marina Rangelova ...
		// TODO To be done by INFM042 F___56 Daniel Nikolov ...
	}

	private int GetCardAtPos(wxPoint pt) {
		return (GetCardAtPos(pt, gmUtil.gmPLAYER_INVALID));
	}

	/**
	 * 
	 * @param pt
	 * @param loc
	 * @return
	 * 
	 * @author INFM032 F___45 Valentin Popov
	 * @author INFM042 F___93 Krasimir Chariyski
	 * @author INFM032 F___56 Daniel Nikolov
	 */
	private int GetCardAtPos(wxPoint pt, int loc) {
		if (loc == gmUtil.gmPLAYER_INVALID) {
			/*
			 * Check whether the position is inside any of the hands
			 */
			for (int i = 0; i < gmUtil.gmTOTAL_PLAYERS; i++) {
				/*
				 * If so, find the card.
				 */
				if (m_hand_rects[i].Contains(pt)) {
					/*
					 * Consider each of the cards in the hand. This is done in
					 * reverse order is because the dimension/position of each
					 * of the cards is calculated without considering the
					 * possibility of overlapping
					 */
					for (int j = m_hands[i].count - 1; j >= 0; j--) {
						if (m_hand_card_rects[i][j].Contains(pt)) {
							return m_hands[i].card_indexes[j];
						}
					}
				}
			}
		} else {
			assert ((loc >= 0) && (loc < gmUtil.gmTOTAL_PLAYERS));
			for (int i = m_hands[loc].count - 1; i >= 0; i--) {
				if (m_hand_card_rects[loc][i].Contains(pt)) {
					return m_hands[loc].card_indexes[i];
				}
			}
		}

		return gmUtil.gmCARD_INVALID;
	}

	private int GetHandAtPos(wxPoint pt) {
		// TODO To be done by INFM032 F___27 Georgi Kostadinov ...
		// TODO To be done by INFM042 F___00 Tsvetelina Hristova ...
		// TODO To be done by INFM042 F___90 Svetoslav Slavkov ...

		return (0);
	}

	private boolean Continue() {
		// TODO To be done by INFM032 F___45 Valentin Popov ...
		// TODO To be done by INFM032 F___46 Nadya Nedyalkova ...
		// TODO To be done by INFM042 F___14 Petya Atanasova ...

		return (false);
	}

	/**
	 * 
	 * @return
	 * 
	 * @author INFM042 F___90 Svetoslav Slavkov ...
	 * @author INFM042 F___67 Nevena Sirakova ...
	 * @author INFM032 F___88 Ivan Dankinov ...
	 */
	private boolean ResetDeal() {
		int i, j;

		if (!m_engine.Reset()) {
			Globals.wxLogError(
					"Attempt to reset the rule engine failed. %s:%d", __FILE__,
					__LINE__);
			return false;
		}

		m_wait_trick = false;
		m_deal_ended = false;

		/*
		 * Initialize the hand information to zeros
		 */
		for (raHand hand : m_hands) {
			hand.setToZeros();
		}

		/*
		 * Initialize the trick
		 */
		gmEngine.ResetTrick(m_trick);

		/*
		 * Initialize the position/dimentions of hands and the cards in the
		 * trick
		 */
		for (i = 0; i < Globals.gmTOTAL_PLAYERS; i++) {
			m_hand_rects[i] = new wxRect(0, 0, 0, 0);
			m_trick_card_rects[i] = new wxRect(0, 0, 0, 0);
		}

		/*
		 * Initialize card positions and dimensions
		 */
		for (i = 0; i < Globals.gmTOTAL_PLAYERS; i++)
			for (j = 0; j < Globals.raMAX_CARDS_PER_HAND; j++)
				m_hand_card_rects[i][j] = new wxRect(0, 0, 0, 0);

		/*
		 * Reset bid history
		 */
		m_bid_history = "";
		return true;
	}

	/**
	 * 
	 * @return
	 * 
	 * @author INFM032 F___45 Valentin Popov
	 * @author INFM032 F___94 Aleksandar Milev
	 * @author INFM032 F___67 Nevena Sirakova
	 */
	private boolean ResetGame() {
		int i;
		raConfData data = new raConfData();

		m_saved_rules.setToZeros();

		raConfig.GetInstance().GetData(data);

		m_orientation = Globals.raGAME_ORIENT_MIXED;

		ResetDeal();

		SetClockwise(data.game_data.clockwise);

		/*
		 * Update status bar with details.
		 */
		if (data.game_data.clockwise) {
			gmUtil.SetStatusText(Globals.raTEXT_CLOCKWISE,
					Globals.raSBARPOS_CLOCK);
		} else {
			gmUtil.SetStatusText(Globals.raTEXT_ANTICLOCKWISE,
					Globals.raSBARPOS_CLOCK);
		}

		m_engine.SetDealer(0);

		m_engine.SetMinBid(Globals.raBID_ROUND_3, data.game_data.min_bid3);
		m_engine.SetWaiveRuleFour(data.game_data.waive_rule4);
		m_engine.SetSluffJacks(data.game_data.sluff_jacks);

		/*
		 * Save the rules
		 */
		m_saved_rules.min_bid_3 = data.game_data.min_bid3;
		if (data.game_data.clockwise) {
			m_saved_rules.rot_addn = 1;
		} else {
			m_saved_rules.rot_addn = 3;
		}
		m_saved_rules.sluff_jacks = data.game_data.sluff_jacks;
		m_saved_rules.waive_rule_4 = data.game_data.waive_rule4;

		for (i = 0; i < Globals.gmTOTAL_TEAMS; i++) {
			m_game_pts[i] = 5;
		}

		for (i = 0; i < Globals.gmTOTAL_PLAYERS; i++) {
			m_pnlties[i] = 0;
			m_players[i].Reset();
			m_players[i].SetRules(m_saved_rules);
		}

		return true;
	}

	private boolean UpdateHands(long hands[]) {
		// TODO To be done by INFM042 F___45 Valentin Popov ...
		// TODO To be done by INFM032 F___84 Mariya Kostadinova ...
		// TODO To be done by INFM032 F___93 Krasimir Chariyski ...

		return (false);
	}

	private int PlayCard(int card) {
		return (PlayCard(card, gmUtil.gmPLAYER_INVALID));
	}

	private int PlayCard(int card, int loc) {
		// TODO To be done by INFM032 F___45 Valentin Popov ...
		// TODO To be done by INFM042 F___48 Georgi Ivanov ...
		// TODO To be done by INFM042 F___67 Nevena Sirakova ...

		return (0);
	}

	private int SetTrump(int card) {
		return (SetTrump(card, gmUtil.gmPLAYER_INVALID));
	}

	private int SetTrump(int card, int loc) {
		// TODO To be done by INFM032 F___47 Kostadin Bulakiev ...
		// TODO To be done by INFM042 F___46 Nadya Nedyalkova ...
		// TODO To be done by INFM032 F___81 Marina Rangelova ...

		return (0);
	}

	private int ShowTrump() {
		return (ShowTrump(gmUtil.gmPLAYER_INVALID));
	}

	private int ShowTrump(int loc) {
		// TODO To be done by INFM032 F___45 Valentin Popov ...
		// TODO To be done by INFM032 F___84 Mariya Kostadinova ...
		// TODO To be done by INFM042 F___47 Kostadin Bulakiev ...

		return (0);
	}

	private int MakeBid(int bid) {
		return (MakeBid(bid, gmUtil.gmPLAYER_INVALID));
	}

	private int MakeBid(int bid, int loc) {
		// TODO To be done by INFM032 F___39 Shterion Yanev ...
		// TODO To be done by INFM032 F___06 Rosen Kaplanov ...
		// TODO To be done by INFM042 F___90 Svetoslav Slavkov ...

		return (0);
	}

	private boolean UpdateDrawAndRefresh() {
		return (UpdateDrawAndRefresh(true, null));
	}

	private boolean UpdateDrawAndRefresh(boolean udpate) {
		return (UpdateDrawAndRefresh(udpate, null));
	}

	/**
	 * 
	 * @param udpate
	 * @param info
	 * 
	 * @return
	 * @author INFM042 F___81 Marina Rangelova
	 * @author INFM042 F___05 Iliya Grozev
	 * @author INFM032 F___90 Svetoslav Slavkov
	 */
	private boolean UpdateDrawAndRefresh(boolean update, raBackDrawInfo info) {

		long hands[] = new long[Globals.gmTOTAL_PLAYERS];

		if (update) {
			m_engine.GetHands(hands);

			/*
			 * Update hand/card positions and dimensions
			 */
			if (UpdateHands(hands) == false) {
				Globals.wxLogError(String
						.format("Call to UpdateHands failed. %s:%d", __FILE__,
								__LINE__));
				return false;
			}
		}

		/*
		 * Redraw back buffer and refrsh the screen to reflect the card play
		 */
		if (!RedrawBack(info)) {
			Globals.wxLogError(String.format("RedrawBack failed. %s:%d",
					__FILE__, __LINE__));
			return false;
		}
		if (RefreshScreen() == true) {
			Globals.wxLogError(String.format("RefreshScreen failed. %s:%d"),
					__FILE__, __LINE__);
			return false;
		}
		this.Update();
		return true;
	}

	/**
	 * 
	 * @param data
	 * @param player
	 * 
	 * @return
	 * 
	 * @author INFM042 F___06 Rosen Kaplanov
	 * @author INFM042 F___81 Marina Rangelova
	 * @author INFM042 F___90 Svetoslav Slavkov
	 */

	private boolean HideInfo(gmEngineData data, int player) {

		assert ((player != 0) && (player < Globals.gmTOTAL_PLAYERS));

		/*
		 * Hide information that is not known the player
		 */
		for (int i = 0; i < Globals.gmTOTAL_PLAYERS; i++) {
			if (i != player) {
				data.hands[i] = 0;
			}
		}

		if ((data.curr_max_bidder != player) && !data.trump_shown) {
			data.trump_card = Globals.gmCARD_INVALID;
			data.trump_suit = Globals.gmSUIT_INVALID;
		}

		return true;
	}

	private boolean HasDealEnded() {
		return (HasDealEnded(0));
	}

	private boolean HasDealEnded(int winner) {
		// TODO To be done by INFM042 F___52 Mihail Stankov ...
		// TODO To be done by INFM042 F___05 Iliya Grozev ...
		// TODO To be done by INFM032 F___90 Svetoslav Slavkov ...

		return (false);
	}

	private boolean EndDeal() {
		return (EndDeal(false));
	}

	private boolean EndDeal(boolean abandon) {
		// TODO To be done by INFM032 F___93 Krasimir Chariyski ...
		// TODO To be done by INFM042 F___68 Georgi Srebrov ...
		// TODO To be done by INFM042 F___14 Petya Atanasova ...

		return (false);
	}

	/**
	 * ...
	 * 
	 * @return
	 * 
	 * @author Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 14 Dec 2013
	 */
	private boolean BeginBusyState() {
		Globals.wxBeginBusyCursor();
		return (true);
	}

	/**
	 * ...
	 * 
	 * @return
	 * 
	 * @author Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 14 Dec 2013
	 */
	private boolean EndBusyState() {
		Globals.wxEndBusyCursor();
		return (true);
	}

	/**
	 * ...
	 * 
	 * @return
	 * 
	 * @author Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 01 Dec 2013
	 */
	private int CheckOppTrumps() {
		gmEngineData data = new gmEngineData();
		StringBuffer msg = new StringBuffer();

		if (m_engine.GetStatus() == Globals.gmSTATUS_TRICKS) {
			m_engine.GetData(data);
			assert ((data.curr_max_bidder >= 0) && (data.curr_max_bidder < Globals.gmTOTAL_PLAYERS));

			/*
			 * Combine the hands of opponents of the max bidder.
			 */
			int i = Globals.gmGetOpponentOne(data.curr_max_bidder);
			long opp_hands = data.hands[i] | data.played_cards[i];
			int j = Globals.gmGetOpponentTwo(data.curr_max_bidder);
			opp_hands |= data.hands[j] | data.played_cards[j];

			/*
			 * If the opponents of the max bidder does not a single trump card
			 * among them, abandon deal and show appropriate message.
			 */
			if ((opp_hands & gmUtil.m_suit_mask[data.trump_suit]) == 0) {
				msg = new StringBuffer();
				msg.append("The trump selected for the deal is ");
				msg.append(gmUtil.m_suits[data.trump_suit]);
				msg.append(("\n"));
				msg.append(("Team "));
				msg.append(gmUtil.m_short_teams[Globals
						.gmGetOpponent(data.curr_max_bidder)]);
				msg.append(" does not have any card of this suit");
				msg.append("\n\n");
				msg.append("This deal has been abandoned");
				Globals.wxMessageBox(msg.toString(), ("Deal abandoned"),
						Globals.wxOK | Globals.wxICON_INFORMATION);

				if (EndDeal(true) == false) {
					Globals.wxLogError("EndDeal failed. %s:%d", __FILE__,
							__LINE__);
					return (-1);
				}

				return (1);
			}
		}

		return (0);
	}

	private boolean OnCardClick(wxPoint pt) {
		// TODO To be done by ...

		return (false);
	}

	public raGamePanel(final wxWindow parent) {
		// TODO To be done by ...
	}

	/**
	 * 
	 * @author Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 13 Dec 2013
	 */
	protected void finalize() {
		/*
		 * Delete card faces.
		 */
		for (int i = 0; i < Globals.gmTOTAL_SUITS; i++) {
			for (int j = 0; j < Globals.gmTOTAL_VALUES; j++) {
				m_card_faces[(i * Globals.gmTOTAL_VALUES) + j] = null;
			}
		}

		/*
		 * Delete card backs
		 */
		for (int i = 0; i < Globals.raTOTAL_CARD_BACKS; i++) {
			m_card_backs[i] = null;
		}

		/*
		 * Delete the bitmaps created from xpms
		 */
		m_bmp_green_arrow_bottom = null;
		m_bmp_green_arrow_top = null;
		m_bmp_green_arrow_right = null;
		m_bmp_green_arrow_left = null;

		m_bmp_red_arrow_bottom = null;
		m_bmp_red_arrow_top = null;
		m_bmp_red_arrow_right = null;
		m_bmp_red_arrow_left = null;

		m_bmp_bubble_arrow_bottom = null;
		m_bmp_bubble_arrow_left = null;
		m_bmp_bubble_arrow_right = null;
		m_bmp_bubble_arrow_top = null;

		m_bmp_bubble_corner_ne = null;
		m_bmp_bubble_corner_nw = null;
		m_bmp_bubble_corner_se = null;
		m_bmp_bubble_corner_sw = null;

		m_bmp_bubble_edge_bottom = null;
		m_bmp_bubble_edge_left = null;
		m_bmp_bubble_edge_right = null;
		m_bmp_bubble_edge_top = null;

		/*
		 * Delete tile bitmap
		 */
		m_tile = null;
	}

	public boolean SetTile(wxBitmap tile) {
		// TODO To be done by Venci.

		return (false);
	}

	public boolean SetInfoPanel(raInfo info_panel) {
		// TODO To be done by Venci.

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
		// TODO To be done by Venci.

		return (false);
	}

	public boolean GetClockwise() {
		// TODO To be done by Venci.

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
