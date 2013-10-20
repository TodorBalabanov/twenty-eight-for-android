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

import eu.veldsoft.twenty.eight.dummy.wxButton;
import eu.veldsoft.twenty.eight.dummy.wxCommandEvent;
import eu.veldsoft.twenty.eight.dummy.wxStaticText;
import eu.veldsoft.twenty.eight.dummy.wxWindow;

public class raInfo {
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
	
	// Disallow copy finalructor/assignment operators
	private raInfo(final raInfo object) {
		//TODO To be done by INFM032 F___94 Aleksandar Milev ...
		//TODO To be done by INFM032 F___52 Mihail Stankov ...
		//TODO To be done by INFM042 F___67 Nevena Sirakova ...
	}
	
	private raInfo  assign(final raInfo object) {
		//TODO To be done by INFM042 F___94 Aleksandar Milev ...
		//TODO To be done by INFM032 F___00 Tsvetelina Hristova ...
		//TODO To be done by INFM032 F___68 Georgi Srebrov ...
		
		return(this);
	}

	private void OnButtonClick(wxCommandEvent event) {
		//TODO To be done by INFM032 F___88 Ivan Dankinov ...
		//TODO To be done by INFM032 F___84 Mariya Kostadinova ...
		//TODO To be done by INFM032 F___39 Shterion Yanev ...
	}

	public raInfo(wxWindow parent) {
		//TODO To be done by INFM042 F___94 Aleksandar Milev ...
		//TODO To be done by INFM042 F___67 Nevena Sirakova ...
		//TODO To be done by INFM042 F___47 Kostadin Bulakiev ...
	}
	
	protected void finalize() {
		//TODO To be done by INFM032 F___05 Iliya Grozev ...
		//TODO To be done by INFM032 F___88 Ivan Dankinov ...
		//TODO To be done by INFM032 F___84 Mariya Kostadinova ...
	}
	
	public boolean SetDetails(raInfoDetails details) {
		//TODO To be done by INFM032 F___67 Nevena Sirakova ...
		//TODO To be done by INFM042 F___27 Georgi Kostadinov ...
		//TODO To be done by INFM032 F___88 Ivan Dankinov ...
		
		return(false);
	}
	
	public void GetDetails(raInfoDetails details) {
		//TODO To be done by INFM042 F___88 Ivan Dankinov ...
		//TODO To be done by INFM042 F___00 Tsvetelina Hristova ...
		//TODO To be done by INFM032 F___47 Kostadin Bulakiev ...
	}
	
	public boolean SetInstruction(String instruction) {
		return(SetInstruction(instruction, raInfo.raINFO_CMD_NONE));
	}
	
	public boolean SetInstruction(String instruction, int cmd) {
		//TODO To be done by INFM042 F___88 Ivan Dankinov ...
		//TODO To be done by INFM042 F___00 Tsvetelina Hristova ...
		//TODO To be done by INFM042 F___56 Daniel Nikolov ...
		
		return(false);
	}
	
	public boolean SetGamePanel(raGamePanel game_panel) {
		//TODO To be done by INFM042 F___56 Daniel Nikolov ...
		//TODO To be done by INFM042 F___67 Nevena Sirakova ...
		//TODO To be done by INFM032 F___00 Tsvetelina Hristova ...
		
		return(false);
	}
	
	public boolean ResetDetails() {
		return(ResetDetails(false));
	}
	
	public boolean ResetDetails(boolean refresh) {
		//TODO To be done by INFM032 F___05 Iliya Grozev ...
		//TODO To be done by INFM032 F___67 Nevena Sirakova ...
		//TODO To be done by INFM042 F___88 Ivan Dankinov ...
		
		return(false);
	}
}
