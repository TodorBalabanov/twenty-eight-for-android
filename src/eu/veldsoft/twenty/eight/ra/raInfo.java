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
import eu.veldsoft.twenty.eight.dummy.wxButton;
import eu.veldsoft.twenty.eight.dummy.wxCommandEvent;
import eu.veldsoft.twenty.eight.dummy.wxPanel;
import eu.veldsoft.twenty.eight.dummy.wxStaticText;
import eu.veldsoft.twenty.eight.dummy.wxWindow;
import eu.veldsoft.twenty.eight.gm.gmUtil;

public class raInfo extends wxPanel {
	public static final int raINFO_CMD_NONE = 1;

	public static final int raINFO_CMD_NEW_DEAL = 2;

	public static final int raINFO_CMD_SHOW_TRUMP = 3;

	private wxButton m_button;

	private wxStaticText m_dealno;

	private wxStaticText m_dealer;

	private wxStaticText m_bid;

	private wxStaticText m_trump;

	private wxStaticText m_nspts;

	private wxStaticText m_ewpts;

	private wxStaticText m_spnlty;

	private wxStaticText m_npnlty;

	private wxStaticText m_epnlty;

	private wxStaticText m_wpnlty;

	private wxStaticText m_instr;

	private int m_curr_cmd;

	private raGamePanel m_game;

	private raInfoDetails m_details;

	private String m_instruction;

	private String raINFO_SHOW_TRUMP_TEXT = "Show Trump";

	private String raINFO_DEAL_TEXT = "New Deal";

	/**
	 * Dummy values.
	 */
	private static final String __FILE__ = "";

	/**
	 * Dummy values.
	 */
	private static final int __LINE__ = 0;

	// Disallow copy finalructor/assignment operators
	private raInfo(final raInfo object) {
		// TODO To be done by INFM032 F___94 Aleksandar Milev ...
		// TODO To be done by INFM032 F___52 Mihail Stankov ...
		// TODO To be done by INFM042 F___67 Nevena Sirakova ...
	}

	/**
	 * 
	 * @param object
	 * @return
	 * @author INFM032 F___00 Tsvetelina Hristova
	 * @author INFM042 F___94 Aleksandar Milev
	 * @author INFM032 F___68 Georgi Srebrov
	 */
	private raInfo assign(final raInfo object) {

		return (this);
	}

	/**
	 * 
	 * @param event
	 * 
	 * @author INFM032 F___88 Ivan Dankinov ...
	 * @author INFM032 F___84 Mariya Kostadinova ...
	 * @author INFM032 F___39 Shterion Yanev ...
	 */
	private void OnButtonClick(wxCommandEvent event) {
		assert (m_game != null);
		assert (m_curr_cmd != raINFO_CMD_NONE);

		raInfoEvent new_event = new raInfoEvent();
		new_event.SetCommand(m_curr_cmd);
		m_game.AddPendingEvent(new_event);
	}

	public raInfo(wxWindow parent) {
		// TODO To be done by INFM042 F___94 Aleksandar Milev ...
		// TODO To be done by INFM042 F___67 Nevena Sirakova ...
		// TODO To be done by INFM042 F___47 Kostadin Bulakiev ...
	}

	/**
	 * @author INFM032 F___05 Iliya Grozev ...
	 * @author INFM032 F___88 Ivan Dankinov ...
	 * @author INFM032 F___84 Mariya Kostadinova ...
	 */
	protected void finalize() {
	}

	/**
	 * 
	 * @param details
	 * @return
	 * @author INFM032 F___67 Nevena Sirakova ...
	 * @author INFM042 F___27 Georgi Kostadinov ...
	 * @author INFM032 F___88 Ivan Dankinov ...
	 */
	public boolean SetDetails(raInfoDetails details) {
		/*
		 * Validate input data and set the deal number
		 */
		if (details.deal_no < 0) {
			Globals.wxLogError("Negative deal number passed. %s:%d", __FILE__,
					__LINE__);
			return false;
		}
		m_dealno.SetLabel(("%d"), details.deal_no);

		/*
		 * Validate input data and set the dealer
		 */
		if ((details.dealer < Globals.gmPLAYER_INVALID)
				|| (details.dealer > Globals.gmTOTAL_PLAYERS)) {
			Globals.wxLogError("Incorrect dealer. %s:%d", __FILE__, __LINE__);
			return false;
		}

		if (details.dealer == Globals.gmPLAYER_INVALID) {
			m_dealer.SetLabel("N/A");
		} else {
			m_dealer.SetLabel(("%s"), gmUtil.m_long_locs[details.dealer]);
		}

		/*
		 * Validate input data and set the bidder
		 */
		if ((details.bidder < Globals.gmPLAYER_INVALID)
				|| (details.bidder > Globals.gmTOTAL_PLAYERS)) {
			Globals.wxLogError("Incorrect bidder. %s:%d", __FILE__, __LINE__);
			return false;
		}

		if (details.bidder == Globals.gmPLAYER_INVALID) {
			m_bid.SetLabel("N/A");
		} else if (details.bid == Globals.gmBID_ALL) {
			m_bid.SetLabel("All by %s", gmUtil.m_long_locs[details.bidder]);
		} else {
			m_bid.SetLabel("%d by %s", details.bid,
					gmUtil.m_long_locs[details.bidder]);
		}

		/*
		 * Validate input data and set the trump
		 */
		if ((details.trump < Globals.gmSUIT_INVALID)
				|| (details.trump > Globals.gmTOTAL_SUITS)) {
			Globals.wxLogError("Incorrect trump suit. %s:%d", __FILE__,
					__LINE__);
			return false;
		}

		if (details.trump == Globals.gmSUIT_INVALID) {
			m_trump.SetLabel("Not Shown");
		} else {
			m_trump.SetLabel("%s", gmUtil.m_suits[details.trump]);
		}

		m_nspts.SetLabel("%d", details.points[0]);
		m_ewpts.SetLabel("%d", details.points[1]);

		m_spnlty.SetLabel("%s-%d", gmUtil.m_short_locs[0], details.pnlties[0]);
		m_wpnlty.SetLabel("%s-%d", gmUtil.m_short_locs[1], details.pnlties[1]);
		m_npnlty.SetLabel("%s-%d", gmUtil.m_short_locs[2], details.pnlties[2]);
		m_epnlty.SetLabel("%s-%d", gmUtil.m_short_locs[3], details.pnlties[3]);

		try {
			m_details = (raInfoDetails) details.clone();
		} catch (CloneNotSupportedException e) {
		}

		return true;
	}

	/**
	 * 
	 * @param details
	 * 
	 * @author INFM042 F___88 Ivan Dankinov ...
	 * @author INFM042 F___00 Tsvetelina Hristova ...
	 * @author INFM032 F___47 Kostadin Bulakiev ...
	 */
	public void GetDetails(raInfoDetails details) {
		try {
			details = (raInfoDetails) m_details.clone();
		} catch (CloneNotSupportedException e) {
		}
	}

	public boolean SetInstruction(String instruction) {
		return (SetInstruction(instruction, raInfo.raINFO_CMD_NONE));
	}

	/**
	 * 
	 * @param instruction
	 * @param cmd
	 * @return
	 * @author INFM042 F___88 Ivan Dankinov ...
	 * @author INFM042 F___00 Tsvetelina Hristova ...
	 * @author INFM042 F___56 Daniel Nikolov ...
	 */
	public boolean SetInstruction(String instruction, int cmd) {
		if ((cmd != m_curr_cmd) || (cmd == raINFO_CMD_NONE)) {
			m_instruction = instruction;

			/*
			 * Depending on the command id passed, enable/disable the command
			 * button and set it's text accordingly
			 */
			switch (cmd) {
			case raINFO_CMD_NONE:
				m_button.Show(false);
				break;
			case raINFO_CMD_NEW_DEAL:
				m_button.Show(true);
				m_button.SetLabel(raINFO_DEAL_TEXT);
				if (m_instruction != null && m_instruction.equals("")) {
					m_instruction = "Click on the button below to start a new Deal.";
				}
				break;
			case raINFO_CMD_SHOW_TRUMP:
				m_button.Show(true);
				m_button.SetLabel(raINFO_SHOW_TRUMP_TEXT);
				break;
			default:
				Globals.wxLogError(
						"Unexpected value in switch statement. %s:%d",
						__FILE__, __LINE__);
				return false;
			}
			m_curr_cmd = cmd;
		}

		/*
		 * Set the instuction text, wrap and fit
		 */
		m_instr.SetLabel(m_instruction);

		// TODO Remove hardcoding of 10.
		m_instr.Wrap(GetClientSize().Width() - (2 * 10));
		m_instr.Update();
		m_instr.Refresh();

		return true;
	}

	public boolean SetGamePanel(raGamePanel game_panel) {
		// TODO To be done by INFM042 F___56 Daniel Nikolov ...
		// TODO To be done by INFM042 F___67 Nevena Sirakova ...
		// TODO To be done by INFM032 F___00 Tsvetelina Hristova ...

		return (false);
	}

	public boolean ResetDetails() {
		return (ResetDetails(false));
	}

	/**
	 * 
	 * @param refresh
	 * 
	 * @return
	 * 
	 * @author INFM032 F___05 Iliya Grozev ...
	 * @author INFM032 F___67 Nevena Sirakova ...
	 * @author INFM042 F___88 Ivan Dankinov ...
	 */
	public boolean ResetDetails(boolean refresh) {
		m_details.bid = 0;
		m_details.bidder = Globals.gmPLAYER_INVALID;
		m_details.dealer = Globals.gmPLAYER_INVALID;
		m_details.deal_no = 1;

		for (int i = 0; i < Globals.gmTOTAL_TEAMS; i++) {
			m_details.points[i] = 5;
		}

		for (int i = 0; i < Globals.gmTOTAL_PLAYERS; i++) {
			m_details.pnlties[i] = 0;
		}

		m_details.trump = Globals.gmSUIT_INVALID;

		if (refresh == true) {
			SetDetails(m_details);
		}

		return true;
	}
}
