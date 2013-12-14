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
import eu.veldsoft.twenty.eight.dummy.wxDialog;
import eu.veldsoft.twenty.eight.dummy.wxInitDialogEvent;
import eu.veldsoft.twenty.eight.dummy.wxPoint;
import eu.veldsoft.twenty.eight.dummy.wxSize;
import eu.veldsoft.twenty.eight.dummy.wxWindow;
import eu.veldsoft.twenty.eight.dummy.wxWindowID;
import eu.veldsoft.twenty.eight.dummy.wxXmlResource;

public class raDlgPrefs extends wxDialog {
	/**
	 * Dummy values.
	 */
	private static final String __FILE__ = "";

	/**
	 * Dummy values.
	 */
	private static final int __LINE__ = 0;

	/**
	 * Dummy function from wxWidgets.
	 */
	private void Destroy() {
	}

	/**
	 * Disallow copy finalructor/assignment operators.
	 * 
	 * @author INFM042 F___00 Tsvetelina Hristova
	 * @author INFM042 F___93 Krasimir Chariyski
	 * @author INFM032 F___67 Nevena Sirakova
	 */
	private raDlgPrefs(final raDlgPrefs object) {
		/*
		 * Empty constructor.
		 */
	}
/**
 * 
 * @param object
 * @return
 * @author INFM032 F___00 Tsvetelina Hristova
 * @author INFM032 F___67 Nevena Sirakova
 * @author INFM032 F___52 Mihail Stankov
 */
	private raDlgPrefs assign(final raDlgPrefs object) {
		
		return (this);
	}

	/**
	 * 
	 * @author INFM032 F___00 Tsvetelina Hristova
	 * @author INFM032 F___67 Nevena Sirakova
	 * @author INFM032 F___56 Daniel Nikolov
	 */
	public raDlgPrefs() {
		/**
		 * This is empty constructor.
		 */
	}

	/**
	 * 
	 * @param parent
	 * @param id
	 * @param caption
	 * @param pos
	 * @param size
	 * @param style
	 * 
	 * @author INFM032 F___88 Ivan Dankinov ...
	 * @author INFM042 F___00 Tsvetelina Hristova ...
	 * @author INFM042 F___52 Mihail Stankov ...
	 */
	public raDlgPrefs(wxWindow parent, wxWindowID id, final String caption,
			final wxPoint pos, final wxSize size, long style) {
		SetParent(parent);

		if (!wxXmlResource.Get().LoadDialog(this, GetParent(), "raDlgPrefs")) {
			Globals.wxLogError("Missing wxXmlResource::Get()->Load() in OnInit()?");
		}

		if (GetSizer() != null) {
			GetSizer().SetSizeHints(this);
		}
	}

	/**
	 * 
	 * @param event
	 * @author INFM032 F___67 Nevena Sirakova ...
	 * @author INFM032 F___88 Ivan Dankinov ...
	 * @author INFM042 F___39 Shterion Yanev ...
	 */
	public void OnInitDialog(wxInitDialogEvent event) {
		wxComboBox combo_playcardon;
		wxComboBox combo_cardback;
		wxCheckBox check_autoplay;
		wxCheckBox check_bidbubbles;
		raConfData conf_data = null;

		raConfig.GetInstance().GetData(conf_data);
		combo_playcardon = (wxComboBox) Globals.XRCCTRL(this,
				"m_radlgprefs_playcardon", wxComboBox.class);
		switch (conf_data.prefs_data.play_card_on) {
		case Globals.raCONFIG_PREFS_PLAYCARDON_SCLICK:
			combo_playcardon.SetSelection(Globals.raPREFS_PLAYCARDON_SCLICK);
			break;
		case Globals.raCONFIG_PREFS_PLAYCARDON_DCLICK:
			combo_playcardon.SetSelection(Globals.raPREFS_PLAYCARDON_DCLICK);
			break;
		default:
			Globals.wxLogError("Unexpected value. %s:%d", __FILE__, __LINE__);
			break;
		}

		combo_cardback = (wxComboBox) Globals.XRCCTRL(this,
				"m_radlgprefs_cardback", wxComboBox.class);

		switch (conf_data.prefs_data.card_back) {
		case Globals.raCONFIG_PREFS_CARDBACK_BLUE:
			combo_cardback.SetSelection(Globals.raPREFS_CARDBACK_BLUE);
			break;
		case Globals.raCONFIG_PREFS_CARDBACK_RED:
			combo_cardback.SetSelection(Globals.raPREFS_CARDBACK_RED);
			break;
		default:
			Globals.wxLogError("Unexpected value. %s:%d", __FILE__, __LINE__);
			break;
		}

		check_autoplay = (wxCheckBox) Globals.XRCCTRL(this,
				"m_radlgprefs_playsingauto", wxCheckBox.class);
		check_autoplay.SetValue(conf_data.prefs_data.auto_play_single);
		check_bidbubbles = (wxCheckBox) Globals.XRCCTRL(this,
				"m_radlgprefs_showbidbubb", wxCheckBox.class);
		check_bidbubbles.SetValue(conf_data.prefs_data.show_bid_bubbles);

		event.Skip();
	}

	/**
	 * @param event
	 * 
	 * @author INFM032 F___00 Tsvetelina Hristova
	 * @author INFM032 F___93 Krasimir Chariyski
	 * @author INFM032 F___14 Petya Atanasova
	 */
	public void OnPrefsBtnApplyClick(wxCommandEvent event) {
		wxComboBox combo_playcardon;
		wxComboBox combo_cardback;
		wxCheckBox check_autoplay;
		wxCheckBox check_bidbubbles;

		raConfData new_conf = null;
		raConfig.GetInstance().GetData(new_conf);
		combo_playcardon = (wxComboBox) Globals.XRCCTRL(this,
				"m_radlgprefs_playcardon", wxComboBox.class);

		switch (combo_playcardon.GetSelection()) {
		case Globals.raPREFS_PLAYCARDON_SCLICK:
			new_conf.prefs_data.play_card_on = Globals.raCONFIG_PREFS_PLAYCARDON_SCLICK;
			break;
		case Globals.raPREFS_PLAYCARDON_DCLICK:
			new_conf.prefs_data.play_card_on = Globals.raCONFIG_PREFS_PLAYCARDON_DCLICK;
			break;
		default:
			Globals.wxLogError("Unexpected value. %s:%d", __FILE__, __LINE__);
			break;
		}

		combo_cardback = (wxComboBox) Globals.XRCCTRL(this,
				"m_radlgprefs_cardback", wxComboBox.class);

		switch (combo_cardback.GetSelection()) {
		case Globals.raPREFS_CARDBACK_BLUE:
			new_conf.prefs_data.card_back = Globals.raCONFIG_PREFS_CARDBACK_BLUE;
			break;
		case Globals.raPREFS_CARDBACK_RED:
			new_conf.prefs_data.card_back = Globals.raCONFIG_PREFS_CARDBACK_RED;
			break;
		default:
			Globals.wxLogError("Unexpected value. %s:%d", __FILE__, __LINE__);
			break;
		}

		check_autoplay = (wxCheckBox) Globals.XRCCTRL(this,
				"m_radlgprefs_playsingauto", wxCheckBox.class);
		new_conf.prefs_data.auto_play_single = check_autoplay.GetValue();
		check_bidbubbles = (wxCheckBox) Globals.XRCCTRL(this,
				"m_radlgprefs_showbidbubb", wxCheckBox.class);
		new_conf.prefs_data.show_bid_bubbles = check_bidbubbles.GetValue();

		raConfig.GetInstance().SetData(new_conf);
		event.Skip();

		Destroy();
	}
}
