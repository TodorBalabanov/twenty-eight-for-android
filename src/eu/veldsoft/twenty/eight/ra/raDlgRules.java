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
import eu.veldsoft.twenty.eight.dummy.wxDialog;
import eu.veldsoft.twenty.eight.dummy.wxWindow;
import eu.veldsoft.twenty.eight.dummy.wxWindowID;
import eu.veldsoft.twenty.eight.dummy.wxXmlResource;

public class raDlgRules extends wxDialog {

	/**
	 * Dummy values.
	 */
	private static final String __FILE__ = "";

	/**
	 * Dummy values.
	 */
	private static final int __LINE__ = 0;

	/**
	 * Disallow copy finalructor/assignment operators.
	 * 
	 * @author INFM042 F___94 Aleksandar Milev
	 * @author INFM042 F___67 Nevena Sirakova
	 * @author INFM032 F___47 Kostadin Bulakiev
	 */
	private raDlgRules(final raDlgRules object) {
		/*
		 * Empty body of private constructor.
		 */
	}

	private raDlgRules assign(final raDlgRules object) {
		// TODO To be done by INFM032 F___94 Aleksandar Milev ...
		// TODO To be done by INFM032 F___46 Nadya Nedyalkova ...
		// TODO To be done by INFM032 F___14 Petya Atanasova ...

		return (this);
	}

	/**
	 * 
	 * @author INFM042 F___45 Valentin Popov
	 * @author INFM032 F___94 Aleksandar Milev
	 * @author INFM042 F___14 Petya Atanasova
	 */
	public raDlgRules() {
	}

	/**
	 * 
	 * @author INFM042 F___27 Georgi Kostadinov
	 * @author INFM042 F___67 Nevena Sirakova
	 * @author INFM032 F___90 Svetoslav Slavkov
	 */
	public raDlgRules(wxWindow parent, wxWindowID id, final String caption,
			final wxPoint pos, final wxSize size, long style) {

		SetParent(parent);
		if (!wxXmlResource.Get().LoadDialog(this, GetParent(), "raDlgRules")) {
			Globals.wxLogError("Missing wxXmlResource::Get()->Load() in OnInit()?");
		}
		if (GetSizer() != null) {
			GetSizer().SetSizeHints(this);
		}
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

	/**
	 * 
	 * @param event
	 * 
	 * @author INFM032 F___68 Nikola Vushkov
	 * @author INFM032 F___68 Georgi Srebrov
	 * @author INFM032 F___93 Krasimir Chariyski
	 */

	public void OnRulesBtnApplyClick(wxCommandEvent event) {
		wxRadioButton radio_clockwise;
		wxRadioButton radio_anticlockwise;
		wxComboBox combo_minbid3;
		wxCheckBox check_waiverule4;
		wxCheckBox check_sluffjacks;
		raConfData new_conf = new raConfData();

		raConfig.GetInstance().GetData(new_conf);

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

		if (radio_clockwise.GetValue()) {
			new_conf.game_data.clockwise = true;
		} else if (radio_anticlockwise.GetValue()) {
			new_conf.game_data.clockwise = false;
		} else {

			Globals.wxLogError("Unexpected value. %s:%d", __FILE__, __LINE__);
		}

		switch (combo_minbid3.GetSelection()) {
		case 0:
			new_conf.game_data.min_bid3 = 23;
			break;
		case 1:
			new_conf.game_data.min_bid3 = 24;
			break;
		default:
			Globals.wxLogError("Unexpected value. %s:%d", __FILE__, __LINE__);
			break;
		}

		// Check waiver of rule 4
		new_conf.game_data.waive_rule4 = !check_waiverule4.GetValue();
		new_conf.game_data.sluff_jacks = check_sluffjacks.GetValue();

		raConfig.GetInstance().SetData(new_conf);
		event.Skip();

	}
}
