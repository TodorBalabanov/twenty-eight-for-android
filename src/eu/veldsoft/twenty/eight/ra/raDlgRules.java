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
import eu.veldsoft.twenty.eight.dummy.wxCheckBox;
import eu.veldsoft.twenty.eight.dummy.wxComboBox;
import eu.veldsoft.twenty.eight.dummy.wxCommandEvent;
import eu.veldsoft.twenty.eight.dummy.wxInitDialogEvent;
import eu.veldsoft.twenty.eight.dummy.wxPoint;
import eu.veldsoft.twenty.eight.dummy.wxRadioButton;
import eu.veldsoft.twenty.eight.dummy.wxSize;
import eu.veldsoft.twenty.eight.dummy.wxWindow;
import eu.veldsoft.twenty.eight.dummy.wxWindowID;

public class raDlgRules {

	/**
	 * Dummy values.
	 */
	private static final String __FILE__ = "";

	/**
	 * Dummy values.
	 */
	private static final int __LINE__ = 0;

	// Disallow copy finalructor/assignment operators
	private raDlgRules(final raDlgRules object) {
		// TODO To be done by INFM042 F___94 Aleksandar Milev ...
		// TODO To be done by INFM042 F___67 Nevena Sirakova ...
		// TODO To be done by INFM032 F___47 Kostadin Bulakiev ...
	}

	private raDlgRules assign(final raDlgRules object) {
		// TODO To be done by INFM032 F___94 Aleksandar Milev ...
		// TODO To be done by INFM032 F___46 Nadya Nedyalkova ...
		// TODO To be done by INFM032 F___14 Petya Atanasova ...

		return (this);
	}

	public raDlgRules() {
		// TODO To be done by INFM042 F___45 Valentin Popov ...
		// TODO To be done by INFM032 F___94 Aleksandar Milev ...
		// TODO To be done by INFM042 F___14 Petya Atanasova ...
	}

	public raDlgRules(wxWindow parent, wxWindowID id, final String caption,
			final wxPoint pos, final wxSize size, long style) {
		// TODO To be done by INFM042 F___27 Georgi Kostadinov ...
		// TODO To be done by INFM042 F___67 Nevena Sirakova ...
		// TODO To be done by INFM032 F___90 Svetoslav Slavkov ...
	}

	/**
	 * 
	 * @param event
	 * @author INFM032 F___88 Ivan Dankinov ...
	 * @author INFM032 F___68 Georgi Srebrov ...
	 * @author INFM032 F___05 Iliya Grozev ...
	 */
	public void OnInitDialog(wxInitDialogEvent event) {
		wxRadioButton radio_clockwise;
		wxRadioButton radio_anticlockwise;
		wxComboBox combo_minbid3;
		wxCheckBox check_waiverule4;
		wxCheckBox check_sluffjacks;
		raConfData conf_data = null;

		raConfig.GetInstance().GetData(conf_data);
		radio_clockwise = (wxRadioButton) Globals.XRCCTRL(this,
				"m_radlgrules_clockwise", wxRadioButton.class);
		radio_anticlockwise = (wxRadioButton) Globals.XRCCTRL(this,
				"m_radlgrules_anticlockwise", wxRadioButton.class);
		combo_minbid3 = (wxComboBox) Globals.XRCCTRL(this,
				"m_radlgrules_minbidthird", wxComboBox.class);
		check_waiverule4 = (wxCheckBox) Globals.XRCCTRL(this,
				"m_radlgrules_waiverule4", wxCheckBox.class);
		check_sluffjacks = (wxCheckBox) Globals.XRCCTRL(this,
				"m_radlgrules_sluffjacks", wxCheckBox.class);

		if (conf_data.game_data.clockwise) {
			radio_clockwise.SetValue(true);
		} else {
			radio_anticlockwise.SetValue(true);
		}

		assert ((conf_data.game_data.min_bid3 == 23) || (conf_data.game_data.min_bid3 == 24));
		switch (conf_data.game_data.min_bid3) {
		case 23:
			combo_minbid3.SetSelection(0);
			break;
		case 24:
			combo_minbid3.SetSelection(1);
			break;
		default:
			Globals.wxLogError("Unexpected value. %s:%d", __FILE__, __LINE__);
			break;
		}

		check_waiverule4.SetValue(!conf_data.game_data.waive_rule4);
		check_sluffjacks.SetValue(conf_data.game_data.sluff_jacks);

		event.Skip();

	}

	public void OnRulesBtnApplyClick(wxCommandEvent event) {
		// TODO To be done by INFM032 F___68 Nikola Vushkov ...
		// TODO To be done by INFM032 F___68 Georgi Srebrov ...
		// TODO To be done by INFM032 F___93 Krasimir Chariyski ...
	}
}
