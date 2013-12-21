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
import eu.veldsoft.twenty.eight.dummy.wxFrame;
import eu.veldsoft.twenty.eight.dummy.wxTheApp;

public class raUpdate {
	/**
	 * Dummy values.
	 */
	private static final String __FILE__ = "";

	/**
	 * Dummy values.
	 */
	private static final int __LINE__ = 0;

	/**
	 * 
	 * @return
	 */
	private int CheckForUpdate() {
		return (CheckForUpdate(null));
	} 

	private int CheckForUpdate(String new_ver) {
		// TODO To be done by ...

		return (0);
	} 

	// Disallow copy finalructor/assignment operators
	private raUpdate(final raUpdate object) {
		// TODO To be done by ...
	} 

	private raUpdate assign(final raUpdate object) {
		// TODO To be done by ...

		return (this);
	} 

	/**
	 * Empty constructor.
	 * 
	 * @author Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 01 Dec 2013
	 */
	public raUpdate() {
		/*
		 * Empty body of public constructor.
		 */
	} 

	/**
	 * Entry method which is checks for updates.
	 * 
	 * @author Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 05 Nov 2013
	 */
	public Object Entry() {
		String new_var = "";
		int ret_val = CheckForUpdate(new_var);
		assert (ret_val <= 2);

		if (ret_val < 0) {
			Globals.wxLogError("addr.GetError() returned error. %s:%d",
					__FILE__, __LINE__);
		}  else if (ret_val == 0) {
			Globals.wxLogMessage("Check for update done successfully");
		}  else if (ret_val > 0) {
			StringBuffer msg = new StringBuffer();
			msg.append("A new version ");
			if (new_var.isEmpty() == false) {
				msg.append(new_var);
				msg.append(" ");
			} 
			msg.append("is available");
			msg.append(".");
			msg.append("\n");
			msg.append("Please download from ");
			msg.append(Globals.ra_APP_URL);
			msg.append(".");

			wxFrame main_frame = (wxFrame) wxTheApp.GetTopWindow();
			if (main_frame != null) {
				raUpdateEvent update_event = new raUpdateEvent();
				update_event.SetMessage(msg.toString());
				Globals.wxLogMessage(update_event.GetMessage());
				main_frame.GetEventHandler().AddPendingEvent(update_event);
			}  else {
				Globals.wxLogError("main_frame is null. %s:%d", __FILE__,
						__LINE__);
			} 
		} 
		return (null);
	} 
} 
