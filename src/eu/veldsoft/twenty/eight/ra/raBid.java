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

import eu.veldsoft.twenty.eight.dummy.wxBoxSizer;
import eu.veldsoft.twenty.eight.dummy.wxButton;
import eu.veldsoft.twenty.eight.dummy.wxCommandEvent;
import eu.veldsoft.twenty.eight.dummy.wxFont;
import eu.veldsoft.twenty.eight.dummy.wxGridSizer;
import eu.veldsoft.twenty.eight.dummy.wxPanel;
import eu.veldsoft.twenty.eight.dummy.wxStaticText;
import eu.veldsoft.twenty.eight.dummy.wxWindow;

public class raBid extends wxPanel {
	public static final int raBID_BTN_ROWS = 5;

	public static final int raBID_BTN_COLS = 3;

	public static final int raBID_TOTAL_BTNS = 15;

	public static final int raBID_BTN_ID_START = 100;

	public static final int raBID_BTN_ID_MAX = (raBID_BTN_ID_START
			+ raBID_TOTAL_BTNS - 1);

	public static final int raBID_BTN_ID_ALL = 150;

	public static final int raBID_BTN_ID_PASS = 151;

	public static final int raBID_MIN_BTN_WIDTH = 10;

	public static final int raBID_PNL_RELIEF = 2;

	private int m_min_bid;

	private wxPanel m_main_panel;

	private wxGridSizer m_main_sizer;

	private wxBoxSizer m_main_panel_sizer;

	private wxPanel m_head_panel;

	private wxGridSizer m_head_panel_sizer;

	private wxStaticText m_head_panel_text;

	private wxFont m_bold_font;

	private wxPanel m_bidbtn_panel;

	private wxGridSizer m_bidbtn_panel_sizer;

	private wxButton m_buttons[] = new wxButton[raBID_TOTAL_BTNS];

	private wxPanel m_btns_panel;

	private wxGridSizer m_btns_panel_sizer;

	private wxButton m_button_all;

	private wxButton m_button_pass;

	private raGamePanel m_game;

	// Disallow copy finalructor/assignment operators
	private raBid(final raBid object) {
		// TODO To be done by INFM042 F___48 Georgi Ivanov ...
		// TODO To be done by INFM042 F___39 Shterion Yanev ...
		// TODO To be done by INFM042 F___81 Marina Rangelova ...
	}

	/**
	 * 
	 * @param object
	 * @return
	 * 
	 * @author INFM042 F___39 Shterion Yanev
	 * @author INFM042 F___93 Krasimir Chariyski
	 * @author INFM042 F___81 Marina Rangelova
	 */
	private raBid assign(final raBid object) {
		return (this);
	}

	void OnButtonClick(wxCommandEvent event) {
		// TODO To be done by INFM032 F___68 Nikola Vushkov ...
		// TODO To be done by INFM042 F___47 Kostadin Bulakiev ...
		// TODO To be done by INFM042 F___27 Georgi Kostadinov ...
	}

	public raBid(final wxWindow parent) {
		// TODO To be done by INFM042 F___93 Krasimir Chariyski ...
		// TODO To be done by INFM042 F___14 Petya Atanasova ...
		// TODO To be done by INFM042 F___27 Georgi Kostadinov ...
	}

	protected void finalize() {
		// TODO To be done by INFM042 F___47 Kostadin Bulakiev ...
		// TODO To be done by INFM042 F___27 Georgi Kostadinov ...
		// TODO To be done by INFM042 F___52 Mihail Stankov ...
	}
	
	/**
	 * 
	 * @param game_panel
	 * @return
	 * 
	 * @author INFM032 F___05 Iliya Grozev
	 * @author INFM042 F___48 Georgi Ivanov
	 * @author INFM042 F___47 Kostadin Bulakiev
	 * 
	 */

	public boolean SetGamePanel(raGamePanel game_panel) {
		
		m_game = game_panel;
		return true; 
	}

	/**
	 * 
	 * @return
	 */
	public boolean SetPassable() {
		return (SetPassable(true));
	}

	/**
	 * 
	 * 
	 * @param passable
	 * @return
	 * 
	 * @author INFM032 F___06 Rosen Kaplanov
	 * @author INFM042 F___52 Mihail Stankov
	 * @author INFM032 F___48 Georgi Ivanov
	 * 
	 */
	public boolean SetPassable(boolean passable) {

		/*
		 * Enable/disable the pass button as per the input criteria
		 */

		m_button_pass.Enable(passable);

		return true;
	}

	public boolean SetMinimumBid(int min_bid) {
		// TODO To be done by INFM042 F___68 Nikola Vushkov ...
		// TODO To be done by INFM032 F___27 Georgi Kostadinov ...
		// TODO To be done by INFM042 F___14 Petya Atanasova ...

		return (false);
	}

}
