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
import eu.veldsoft.twenty.eight.dummy.wxCoord;
import eu.veldsoft.twenty.eight.dummy.wxEvent;
import eu.veldsoft.twenty.eight.dummy.wxFont;
import eu.veldsoft.twenty.eight.dummy.wxMemoryDC;
import eu.veldsoft.twenty.eight.dummy.wxMouseEvent;
import eu.veldsoft.twenty.eight.dummy.wxPoint;
import eu.veldsoft.twenty.eight.dummy.wxRect;
import eu.veldsoft.twenty.eight.dummy.wxSizeEvent;
import eu.veldsoft.twenty.eight.dummy.wxWindow;
import eu.veldsoft.twenty.eight.gg.ggCard;
import eu.veldsoft.twenty.eight.gg.ggPanel;
import eu.veldsoft.twenty.eight.gm.gmEngine;
import eu.veldsoft.twenty.eight.gm.gmEngineData;
import eu.veldsoft.twenty.eight.gm.gmInputBidInfo;
import eu.veldsoft.twenty.eight.gm.gmInputTrickInfo;
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

	private static final int gmCARD_INVALID = 0;

	private static final int raPLAYER_TYPE_AI = 0;

	/**
	 * Disallow copy finalructor/assignment operators.
	 * 
	 * @param object
	 * 
	 * @author INFM042 F___56 Daniel Nikolov
	 * @author INFM042 F___84 Mariya Kostadinova
	 * @author INFM032 F___06 Rosen Kaplanov
	 */
	private raGamePanel(final raGamePanel object) {
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

	private int raARROW_WIDTH = 16;

	private int raGAME_ARROW_RELIEF = 8;

	public static final int GG_CARD_WIDTH = 71;

	public static final int GG_CARD_HEIGHT = 96;

	private static final int raINFO_CMD_NEW_DEAL = 0;

	private static final int raINFO_CMD_SHOW_TRUMP = 0;

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

	/**
	 * 
	 * @author INFM042 F___68 Nikola Vushkov
	 * @author INFM032 F___27 Georgi Kostadinov
	 * @author INFM032 F___67 Nevena Sirakova
	 */
	private boolean DrawHand(int loc, int x, int y, int orientation) {

		int j;
		wxMemoryDC cfdc = new wxMemoryDC();
		wxMemoryDC cbdc = new wxMemoryDC();
		int player_type;
		assert ((orientation == Globals.raHAND_HORIZONTAL) || (orientation == Globals.raHAND_VERTICAL));

		player_type = m_players[loc].GetType();

		// /#if raGAME_HIDE_AI_HANDS
		if (player_type == raPLAYER_TYPE_AI) {
			cbdc.SelectObject(m_card_backs[m_pref_card_back]);
		}
		// /#endif

		if (orientation == Globals.raHAND_HORIZONTAL) {
			for (j = 0; j < m_hands[loc].count; j++) {
				// /#if raGAME_HIDE_AI_HANDS
				if (player_type == raPLAYER_TYPE_AI) {
					wxCoord w = new wxCoord();

					Globals.BlitToBack(x + (Globals.raCARD_HORZ_RELIEF * j), y,
							Globals.GG_CARD_WIDTH, Globals.GG_CARD_HEIGHT,
							cbdc, 0, 0, Globals.wxCOPY, true);
				} else {
					// /#endif
					cfdc.SelectObject(m_card_faces[m_hands[loc].card_indexes[j]]);
					Globals.BlitToBack(x + (Globals.raCARD_HORZ_RELIEF * j), y,
							Globals.GG_CARD_WIDTH, Globals.GG_CARD_HEIGHT,
							cfdc, 0, 0, Globals.wxCOPY, true);
					// /#if raGAME_HIDE_AI_HANDS
				}
				// /#endif

				// Update the position and dimensions of cards and hands
				m_hand_card_rects[loc][j] = new wxRect(x
						+ (Globals.raCARD_HORZ_RELIEF * j), y,
						Globals.GG_CARD_WIDTH, Globals.GG_CARD_HEIGHT);

				// TODO : Correction for overlapping
				m_hand_rects[loc].Union(m_hand_card_rects[loc][j]);
			}
		} else {
			for (j = 0; j < m_hands[loc].count; j++) {
				// /#if raGAME_HIDE_AI_HANDS
				if (player_type == raPLAYER_TYPE_AI) {
					Globals.BlitToBack(x, y + (Globals.raCARD_VERT_RELIEF * j),
							Globals.GG_CARD_WIDTH, Globals.GG_CARD_HEIGHT,
							cbdc, 0, 0, Globals.wxCOPY, true);
				} else {
					// /#endif
					cfdc.SelectObject(m_card_faces[m_hands[loc].card_indexes[j]]);
					Globals.BlitToBack(x, y + (Globals.raCARD_VERT_RELIEF * j),
							Globals.GG_CARD_WIDTH, Globals.GG_CARD_HEIGHT,
							cfdc, 0, 0, Globals.wxCOPY, true);
					// /#if raGAME_HIDE_AI_HANDS
				}
				// /#endif

				// Update the position and dimensions of cards and hands
				if (orientation == Globals.raHAND_HORIZONTAL) {
					m_hand_card_rects[loc][j] = new wxRect(x
							+ (Globals.raCARD_HORZ_RELIEF * j), y,
							Globals.GG_CARD_WIDTH, Globals.GG_CARD_HEIGHT);
				} else {
					m_hand_card_rects[loc][j] = new wxRect(x, y
							+ (Globals.raCARD_VERT_RELIEF * j),
							Globals.GG_CARD_WIDTH, Globals.GG_CARD_HEIGHT);
				}

				m_hand_rects[loc].Union(m_hand_card_rects[loc][j]);
			}
		}

		return true;
	}

	/**
	 * 
	 * @author INFM042 F___05 Iliya Grozev
	 * @author INFM032 F___67 Nevena Sirakova
	 * @author INFM032 F___14 Petya Atanasova
	 */
	private boolean DrawTrick() {
		int i;
		int loc;
		wxMemoryDC mdc = new wxMemoryDC();
		int rot_addn;

		if (m_clockwise) {
			rot_addn = 1;
		} else {
			rot_addn = 3;
		}

		for (i = 0; i < Globals.gmTOTAL_PLAYERS; i++) {
			m_trick_card_rects[i] = new wxRect(0, 0, 0, 0);
		}

		for (i = 0; i < m_trick.count; i++) {
			loc = (m_trick.lead_loc + (i * rot_addn)) % Globals.gmTOTAL_PLAYERS;
			mdc.SelectObject(m_card_faces[m_trick.cards[loc]]);
			switch (loc) {
			case 0:
				// Draw at the bottom
				m_trick_card_rects[0] = new wxRect(
						(GetClientSize().Width() - GG_CARD_WIDTH) / 2,
						((GetClientSize().Height() - GG_CARD_HEIGHT) / 2)
								+ (GG_CARD_HEIGHT / 4), GG_CARD_WIDTH,
						GG_CARD_HEIGHT);
				Globals.BlitToBack(m_trick_card_rects[0].x,
						m_trick_card_rects[0].y, Globals.GG_CARD_WIDTH,
						Globals.GG_CARD_HEIGHT, mdc, 0, 0, Globals.wxCOPY, true);
				break;
			case 1:
				m_trick_card_rects[1] = new wxRect(
						((GetClientSize().Width() - GG_CARD_WIDTH) / 2)
								- (GG_CARD_WIDTH / 4), (GetClientSize()
								.Height() - GG_CARD_HEIGHT) / 2, GG_CARD_WIDTH,
						GG_CARD_HEIGHT);
				Globals.BlitToBack(m_trick_card_rects[1].x,
						m_trick_card_rects[1].y, Globals.GG_CARD_WIDTH,
						Globals.GG_CARD_HEIGHT, mdc, 0, 0, Globals.wxCOPY, true);
				break;
			case 2:
				m_trick_card_rects[2] = new wxRect(
						(GetClientSize().Width() - GG_CARD_WIDTH) / 2,
						((GetClientSize().Height() - GG_CARD_HEIGHT) / 2)
								- (GG_CARD_HEIGHT / 4), GG_CARD_WIDTH,
						GG_CARD_HEIGHT);
				Globals.BlitToBack(m_trick_card_rects[2].x,
						m_trick_card_rects[2].y, Globals.GG_CARD_WIDTH,
						Globals.GG_CARD_HEIGHT, mdc, 0, 0, Globals.wxCOPY, true);
				break;
			case 3:
				m_trick_card_rects[3] = new wxRect(
						((GetClientSize().Width() - GG_CARD_WIDTH) / 2)
								+ (GG_CARD_WIDTH / 4), (GetClientSize()
								.Height() - GG_CARD_HEIGHT) / 2, GG_CARD_WIDTH,
						GG_CARD_HEIGHT);
				Globals.BlitToBack(m_trick_card_rects[3].x,
						m_trick_card_rects[3].y, Globals.GG_CARD_WIDTH,
						Globals.GG_CARD_HEIGHT, mdc, 0, 0, Globals.wxCOPY, true);
				break;
			}
		}

		// If the trick has ended, graphically indicate the winner
		// using the red arrow
		if (m_trick.count == Globals.gmTOTAL_PLAYERS) {
			int x = 0;
			int y = 0;

			switch (m_trick.winner) {
			case 0:
				mdc.SelectObject(m_bmp_red_arrow_bottom);
				x = (this.GetClientSize().Width() - raARROW_WIDTH) / 2;
				y = m_trick_card_rects[0].GetBottom() + raGAME_ARROW_RELIEF;
				break;
			case 1:
				mdc.SelectObject(m_bmp_red_arrow_left);
				x = m_trick_card_rects[1].GetLeft() - raARROW_WIDTH
						- raGAME_ARROW_RELIEF;
				y = (GetClientSize().Height() - raARROW_WIDTH) / 2;
				break;
			case 2:
				mdc.SelectObject(m_bmp_red_arrow_top);
				x = (GetClientSize().Width() - raARROW_WIDTH) / 2;
				y = m_trick_card_rects[2].GetTop() - raARROW_WIDTH
						- raGAME_ARROW_RELIEF;
				break;
			case 3:
				mdc.SelectObject(m_bmp_red_arrow_right);
				x = m_trick_card_rects[3].GetRight() + raGAME_ARROW_RELIEF;
				y = (GetClientSize().Height() - raARROW_WIDTH) / 2;
				break;
			default:
				break;
			}
			Globals.BlitToBack(x, y, raARROW_WIDTH, raARROW_WIDTH, mdc, 0, 0,
					Globals.wxCOPY, true);
		}

		return true;
	}

	/**
	 * 
	 * @return
	 * 
	 * @author INFM032 F___56 Daniel Nikolov
	 * @author INFM032 F___67 Nevena Sirakova
	 * @author INFM042 F___06 Rosen Kaplanov
	 */
	private boolean DrawTrump() {
		int trump_card = 0;
		int max_bidder = 0;
		int player_type = 0;
		wxMemoryDC mdc = new wxMemoryDC();
		if (!m_engine.GetMaxBid(null, max_bidder)) {
			Globals.wxLogError("GetMaxBid failed. %s:%d", __FILE__, __LINE__);
			return false;
		}
		assert ((max_bidder >= Globals.gmPLAYER_INVALID) && (max_bidder < Globals.gmTOTAL_PLAYERS));
		if (max_bidder == Globals.gmPLAYER_INVALID)
			return true;
		player_type = m_players[max_bidder].GetType();
		assert ((player_type >= Globals.raPLAYER_TYPE_INVALID) && (player_type <= Globals.raPLAYER_TYPE_AI));
		trump_card = m_engine.GetTrumpCard();
		assert ((trump_card >= Globals.gmCARD_INVALID) && (trump_card < Globals.gmTOTAL_CARDS));
		/*
		 * Draw the trump only if 1. There is a valid trump set 2. and if the
		 * trump is not shown yet.
		 */

		if ((trump_card != gmCARD_INVALID) && !m_engine.IsTrumpShown()) {
			if (Globals.raGAME_HIDE_AI_HANDS) {
				if (player_type == raPLAYER_TYPE_AI)
					mdc.SelectObject(m_card_backs[m_pref_card_back]);
				else
					mdc.SelectObject(m_card_faces[trump_card]);
			}
			mdc.SelectObject(m_card_faces[trump_card]);
			if (!Globals.BlitToBack(Globals.raCARD_PANEL_RELIEF,
					Globals.raCARD_PANEL_RELIEF, Globals.GG_CARD_WIDTH,
					Globals.GG_CARD_HEIGHT, mdc, 0, 0, Globals.wxCOPY, true)) {
				Globals.wxLogError("BlitToBack failed. %s:%d", __FILE__,
						__LINE__);
				return false;
			}
		}
		return true;
	}
/**
 * 
 * @param event
 * 
 * @author INFM032 F___39 Shterion Yanev 
 * @author INFM042 F___84 Mariya Kostadinova
 * @author INFM042 F___81 Marina Rangelova
 */
	private void OnInfo(raInfoEvent event) {
		
		int ret_val;
		
		switch(event.GetCommand())
		{
		case 1: raINFO_CMD_NEW_DEAL:
			if(!NewDeal())
			{
				Globals.wxLogError("NewDeal() failed. %s:%d", __FILE__, __LINE__);
			}
			break;
		case 2: raINFO_CMD_SHOW_TRUMP:
			if((ret_val = ShowTrump()) != 0)
			{
				Globals.wxMessageBox("Cannot ask for trump");
			}
			
			/*
			 *  Check whether the game needs to be abandoned
			 */
			if(CheckOppTrumps() == 1)
			{
				EndDeal(true);
				return;
			}
			while(Continue());
			break;
		default:
			Globals.wxLogError("Unrecognized info event received. %s:%d", __FILE__, __LINE__);
		}
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

	private int GetCardAtPos(wxPoint pt, int loc) {
		// TODO To be done by INFM032 F___45 Valentin Popov ...
		// TODO To be done by INFM042 F___93 Krasimir Chariyski ...
		// TODO To be done by INFM032 F___56 Daniel Nikolov ...

		return (0);
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

	/**
	 * 
	 * @author INFM032 F___45 Valentin Popov
	 * @author INFM042 F___48 Georgi Ivanov
	 * @author INFM042 F___67 Nevena Sirakova
	 */
	private int PlayCard(int card, int loc) {

		gmInputTrickInfo trick_info = new gmInputTrickInfo();
		int trick_round;
		int ret_val;
		// raInfoDetails info_details;
		gmEngineData pplay_data = new gmEngineData();
		gmEngineData re_data = new gmEngineData();
		int i;

		// Validate the input card
		assert ((card >= 0) && (card < Globals.gmTOTAL_CARDS));

		if (!m_engine.GetPendingInputCriteria(null, trick_info)) {
			Globals.wxLogError(String.format(
					"Failed to get pending input criteria. %s:%d", __FILE__,
					__LINE__));
			return -1;
		}

		// Check whether the card is valid as per the mask
		if ((trick_info.mask & (1 << card)) > 0) {
			assert (trick_info.rules != 0);
			return Globals.gmERR_TRICK_MASK_MISMATCH;
		}

		// Save the trick round
		trick_round = m_engine.GetTrickRound();

		m_engine.GetData(re_data);

		// Post the input and check for error
		trick_info.card = card;
		if ((ret_val = m_engine.PostInputMessage(Globals.gmINPUT_TRICK,
				trick_info)) != 0) {
			return ret_val;
		}

		Globals.wxLogMessage(String.format("%s plays %s%s",
				gmUtil.m_long_locs[trick_info.player],
				gmUtil.m_suits[gmGetSuit(card)],
				gmUtil.m_values[gmGetValue(card)]));

		// Update other players about the game play
		for (i = 0; i < Globals.gmTOTAL_PLAYERS; i++) {
			// Update only if the player is AI
			if ((m_players[i].GetType() == raPLAYER_TYPE_AI)
					&& (re_data.in_trick_info.player != i)) {
				// Hide information before sending
				System.arraycopy(re_data, 0, pplay_data, 0,
						Globals.gmTOTAL_PLAYERS);
				HideInfo(pplay_data, i);

				// Inferences could be made from the mask or
				// the rules and hence hide the same
				pplay_data.in_trick_info.mask = 0;
				pplay_data.in_trick_info.rules = 0;
				m_players[i].PostPlayUpdate(pplay_data, card);
				System.arraycopy(re_data, 0, pplay_data, 0,
						Globals.gmTOTAL_PLAYERS);
				m_players[i].CheckAssumptions(pplay_data);
			}
		}

		// If the card played was accepted by the engine,

		// Update the cards in the trick for the round saved
		// so that the same is reflected when the back buffer
		// is redrawn
		m_engine.GetTrick(trick_round, m_trick);

		// Update hands, redraw back buffer and refresh the screen
		if (!UpdateDrawAndRefresh()) {
			Globals.wxLogError(String.format(
					"UpdateDrawAndRefresh failed. %s:%d", __FILE__, __LINE__));
			return -1;
		}

		// If the trick that ended, need to wait for the user to accept the
		// trick
		if (m_trick.count == Globals.gmTOTAL_PLAYERS) {
			m_info.SetInstruction("Click on the cards to continue.",
					raInfo.raINFO_CMD_NONE);
			m_wait_trick = true;
			// Log details of the trick ended
			Globals.wxLogMessage(String.format("Trick %d won by %s",
					trick_round + 1, gmUtil.m_long_locs[m_trick.winner]));
		}

		return 0;
	}

	private int gmGetValue(int card) {
		return card & Globals.gmTOTAL_VALUES;
	}

	private int gmGetSuit(int card) {
		return card / Globals.gmTOTAL_VALUES;
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

	/**
	 * 
	 * @param bid
	 * @param loc
	 * @return
	 * 
	 * @author INFM032 F___39 Shterion Yanev
	 * @author INFM032 F___06 Rosen Kaplanov
	 * @author INFM042 F___90 Svetoslav Slavkov
	 * 
	 */
	private int MakeBid(int bid, int loc) {

		gmInputBidInfo bid_info = new gmInputBidInfo();
		int ret_val;
		raInfoDetails info_dtls = new raInfoDetails();
		raBackDrawInfo back_draw_info = new raBackDrawInfo();

		/*
		 * Check if the engine is waiting for a bid input
		 */
		if ((m_engine.IsInputPending())
				&& (m_engine.GetPendingInputType() == Globals.gmINPUT_BID)) {
			if (!m_engine.GetPendingInputCriteria(null, bid_info)) {
				Globals.wxLogError(
						"Failed to get pending input criteria. %s:%d",
						__FILE__, __LINE__);
				return -1;
			}

			/*
			 * Check if the bid is by the correct player
			 */
			if ((loc != Globals.gmPLAYER_INVALID) && (loc != bid_info.player)) {
				Globals.wxLogDebug("Bid by the wrong player. %s:%d", __FILE__,
						__LINE__);
				return Globals.gmERR_BID_BY_WRONG_PLAYER;
			}

			/*
			 * If the bid is a pass,
			 */
			if ((bid == Globals.gmBID_PASS) && (!bid_info.passable)) {
				Globals.wxLogDebug("Cannot pass. %s:%d", __FILE__, __LINE__);
				return Globals.gmERR_CANNOT_PASS;
			}

			/*
			 * If the bid is less than minimum
			 */
			if ((bid != Globals.gmBID_ALL) && (bid != Globals.gmBID_PASS)
					&& (bid < bid_info.min)) {
				Globals.wxLogDebug("Bid less than minimum allowed. %s:%d",
						__FILE__, __LINE__);
				return Globals.gmERR_BID_LESS_THAN_MIN;
			}

			bid_info.bid = bid;

			/*
			 * Post the input and check for error
			 */
			if ((ret_val = m_engine.PostInputMessage(Globals.gmINPUT_BID,
					bid_info)) != 0) {
				Globals.wxLogDebug("PostInputMessage failed. %s:%d", __FILE__,
						__LINE__);
				return ret_val;
			}

			/*
			 * Append to the auciton history
			 */
			if (bid != Globals.gmBID_PASS) {
				String temp = "";
				if (bid == Globals.gmBID_ALL) {
					temp += ("All Tricks");
				} else {
					temp += "%d" + bid_info.bid;
				}
				temp += " by " + gmUtil.m_long_locs[bid_info.player] + "\n";

				/*
				 * Log the bid
				 */
				Globals.wxLogMessage(temp.trim());

				m_bid_history += temp;
			}

		} else {
			Globals.wxLogDebug(
					"Cannot make a bid when one is not expected. %s:%d",
					__FILE__, __LINE__);
			return -1;
		}

		// Update Info panel
		if (bid != Globals.gmBID_PASS) {
			m_info.GetDetails(info_dtls);
			info_dtls.bid = bid;
			info_dtls.bidder = bid_info.player;
			m_info.SetDetails(info_dtls);
		}

		//
		// Show the bid graphically in a bubble
		//

		back_draw_info.draw_bid = true;
		back_draw_info.bid = bid_info.bid;
		back_draw_info.bid_loc = bid_info.player;

		if (m_show_bidbubbles && (bid != Globals.gmBID_PASS)) {
			// Hide the bid window
			m_bid.Show(false);

			/*
			 * Redraw the screen with bid bubble
			 */
			if (!UpdateDrawAndRefresh(false, back_draw_info)) {
				Globals.wxLogError("UpdateDrawAndRefresh failed. %s:%d",
						__FILE__, __LINE__);
			}

			/*
			 * Sleep for some time so that the user can read the information
			 */
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}

		/*
		 * Redraw the screen without bid bubble
		 */
		if (!UpdateDrawAndRefresh()) {
			Globals.wxLogError("UpdateDrawAndRefresh failed. %s:%d", __FILE__,
					__LINE__);
		}

		return 0;
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

	/**
	 * 
	 * @param abadon
	 * 
	 * @return boolean
	 * 
	 * @author INFM032 F___93 Krasimir Chariyski
	 * @author INFM042 F___68 Georgi Srebrov
	 * @author INFM042 F___14 Petya Atanasova
	 */
	private boolean EndDeal(boolean abandon) {
		int bid = 0;
		int loc = 0;
		raInfoDetails info_dtls = new raInfoDetails();
		int game_pts = 0;
		int winner = 0;
		String msg_deal = new String();
		String msg_pnlty = new String();
		int i = 0;
		int old_deal_no = 0;

		// If the game is not being abandoned,
		// show the detail of the deal that has ended.
		if (!abandon) {
			if (!HasDealEnded(winner)) {
				Globals.wxLogError("HasDealEnded failed. %s:%d", __FILE__,
						__LINE__);
				return false;
			}

			if (!m_engine.GetMaxBid(bid, loc)) {
				Globals.wxLogError("GetMaxBid failed. %s:%d", __FILE__,
						__LINE__);
				return false;
			}
		}

		m_info.GetDetails(info_dtls);

		if (!abandon) {
			// Calculate the game points to be awarded
			// and set it in the info details
			if (bid < 20) {
				game_pts = 1;
			} else if (bid < 23) {
				game_pts = 2;
			} else {
				game_pts = 3;
			}

			msg_pnlty = "";
			// If the max bidder is the winner and he has at least one
			// penalty, one will be deducted
			if (winner == gmGetTeam(loc)) {
				if (m_pnlties[loc] > 0) {
					m_pnlties[loc]--;
					StringBuffer msg = new StringBuffer();
					msg.append("One penalty deducted from ");
					msg.append(gmUtil.m_short_locs[loc]);
					msg.append(".");
					msg_pnlty = msg.toString();
				}
			} else {
				game_pts++;
			}

			m_game_pts[winner] += game_pts;
			m_game_pts[Globals.gmGetOpponent(winner)] -= game_pts;
			for (i = 0; i < Globals.gmTOTAL_TEAMS; i++) {
				if (m_game_pts[i] < 0) {
					m_pnlties[i]++;
					// TODO : Use raGetPartner
					m_pnlties[i + 2]++;
					// TODO : Remove hard coding
					m_game_pts[0] = 5;
					m_game_pts[1] = 5;

					// if msg_pnlty is not empty
					if (msg_pnlty != null && msg_pnlty.length() != 0) {
						StringBuffer msg = new StringBuffer();
						msg.append("\n");
						msg_pnlty = msg.toString();
					}
					StringBuffer msg = new StringBuffer();
					msg.append("Game points reset and penalties awarded to ");
					msg.append(gmUtil.m_short_teams[i]);
					msg.append(".");
					msg_pnlty = msg.toString();
					break;
				}
			}

			// Show a message box with details
			// as to who won the deal

			msg_deal = "";
			StringBuffer msg = new StringBuffer();
			msg.append(String.format("Game won by %s.",
					gmUtil.m_short_teams[winner]));
			msg.append(String.format("\n\nHighest bid was %d by %s.", bid,
					gmUtil.m_long_locs[loc]));
			msg.append(String.format("\n%s won %d points..",
					gmUtil.m_short_teams[0], m_engine.GetPoints(0)));
			msg.append(String.format("\n%s won %d points..",
					gmUtil.m_short_teams[1], m_engine.GetPoints(1)));
			msg.append(String.format("\n\n%d game point(s) awarded to %s.",
					game_pts, gmUtil.m_short_teams[winner]));
			msg_deal = msg.toString();

			// if msg_pnlty is not empty
			if (msg_pnlty != null && msg_pnlty.length() != 0) {
				StringBuffer msgDeal = new StringBuffer();
				msgDeal.append("\n\n");
				msgDeal.append(msg_pnlty);
				msg_deal = msgDeal.toString();
			}

			Globals.wxMessageBox(msg_deal, ("Deal completed"), Globals.wxOK
					| Globals.wxICON_INFORMATION);

		}

		// End the busy state
		EndBusyState();

		// Reset all players
		for (i = 0; i < Globals.gmTOTAL_PLAYERS; i++) {
			m_players[i].Reset();
			m_players[i].SetRules(m_saved_rules);
		}

		m_info.SetInstruction("", m_info.raINFO_CMD_NEW_DEAL);

		// Set the dealer for the next deal
		if (m_clockwise) {
			m_engine.SetDealer((m_engine.GetDealer() + 1)
					% Globals.gmTOTAL_PLAYERS);
		} else {
			m_engine.SetDealer((m_engine.GetDealer() + 3)
					% Globals.gmTOTAL_PLAYERS);
		}

		// Set the detail in the info panel
		old_deal_no = info_dtls.deal_no;
		m_info.ResetDetails();
		m_info.GetDetails(info_dtls);
		info_dtls.dealer = m_engine.GetDealer();
		info_dtls.deal_no = old_deal_no + 1;
		for (i = 0; i < Globals.gmTOTAL_TEAMS; i++) {
			info_dtls.points[i] = m_game_pts[i];
		}
		for (i = 0; i < Globals.gmTOTAL_PLAYERS; i++) {
			info_dtls.pnlties[i] = m_pnlties[i];
		}
		m_info.SetDetails(info_dtls);

		m_deal_ended = true;
		return true;
	}

	/**
	 * 
	 * @param loc
	 * 
	 * @return int
	 * 
	 * @author INFM032 F___93 Krasimir Chariyski
	 * @author INFM042 F___68 Georgi Srebrov
	 * @author INFM042 F___14 Petya Atanasova
	 */
	private int gmGetTeam(int loc) {
		int team = loc % Globals.gmTOTAL_TEAMS;
		return team;
	}

	private boolean BeginBusyState() {
		// TODO To be done by Venci ...

		return (false);
	}

	private boolean EndBusyState() {
		// TODO To be done by Venci ...

		return (false);
	}

	/**
	 * ...
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
