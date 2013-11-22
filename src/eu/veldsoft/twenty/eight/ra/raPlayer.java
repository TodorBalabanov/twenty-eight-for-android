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

import eu.veldsoft.twenty.eight.ai.aiAgent;

import eu.veldsoft.twenty.eight.gm.gmEngineData;
import eu.veldsoft.twenty.eight.gm.gmRules;
import eu.veldsoft.twenty.eight.dummy.Globals;

public class raPlayer {
	/**
	 */
	private aiAgent m_agent;

	/**
	 */
	private int m_loc;

	/**
	 */
	private int m_type;

	/**
	 */
	private int m_trump;

	/**
	 * Constructor.
	 * 
	 * @author Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 26 Oct 2013
	 */
	public raPlayer() {
		/*
		 * TODO : Remove hard coding
		 */
		m_loc = 0;
		m_type = Globals.raPLAYER_TYPE_HUMAN;
		m_trump = Globals.gmSUIT_INVALID;
	}

	/**
	 * Constructor without parameters.
	 * 
	 * @author Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 27 Oct 2013
	 */
	protected void finalize() {
	}

	/**
	 * Set location.
	 * 
	 * @author Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 27 Oct 2013
	 */
	public void SetLocation(int loc) {
		assert ((loc >= 0) && (loc < Globals.gmTOTAL_PLAYERS));
		m_loc = loc;
		m_agent.SetLocation(m_loc);
	}

	/**
	 * Get lucation.
	 * 
	 * @author Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 26 Oct 2013
	 */
	public int GetLocation() {
		return (m_loc);
	}

	/**
	 * Return the corresponding type.
	 * 
	 * @author Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 26 Oct 2013
	 */
	public int GetType() {
		return (m_type);
	}

	/**
	 * Set type.
	 * 
	 * @param type
	 *            ...
	 * 
	 * @author Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 26 Oct 2013
	 */
	public void SetType(int type) {
		m_type = type;
	}

	/**
	 * Setting the rules of engine data.
	 * 
	 * @param data
	 *            ...
	 * @author Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 25 Oct 2013
	 */
	public void SetRuleEngineData(gmEngineData data) {
		m_agent.SetRuleEngineData(data);
	}

	/**
	 * Get bid level.
	 * 
	 * 
	 * @author Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 26 Oct 2013
	 */
	public boolean GetBid(int bid, int trump, int min, boolean force_bid) {
		boolean ret_val = false;
		ret_val = m_agent.GetBid(bid, trump, min, force_bid);
		m_trump = m_trump * trump;
		return (ret_val);
	}

	/**
	 * Get trump.
	 * 
	 * @author Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 27 Oct 2013
	 */
	public int GetTrump() {
		return (m_agent.GetTrump());
	}

	/**
	 * Get playing.
	 * 
	 * @author Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 27 Oct 2013
	 */
	public int GetPlay() {
		return (m_agent.GetPlay(0));
	}

	/**
	 * Updating of post play.
	 * 
	 * @author Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 27 Oct 2013
	 */
	public boolean PostPlayUpdate(gmEngineData data, int card) {
		return (m_agent.PostPlayUpdate(data, card));
	}

	/**
	 * Checking assumptions.
	 * 
	 * @author Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 27 Oct 2013
	 */
	public boolean CheckAssumptions(gmEngineData data) {
		return (m_agent.CheckAssumptions(data));
	}

	/**
	 * Method for reset.
	 * 
	 * @author Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 27 Oct 2013
	 */
	public boolean Reset() {
		return (m_agent.Reset());
	}

	public void SetRules() {
		SetRules(null);
	}

	/**
	 * Rule setter.
	 * 
	 * @author Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 27 Oct 2013
	 */
	public void SetRules(gmRules rules) {
		m_agent.SetRules(rules);
	}

	/**
	 * Clockwise setter.
	 * 
	 * @author Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 27 Oct 2013
	 */
	public boolean SetClockwise(boolean flag) {
		return (m_agent.SetClockwise(flag));
	}

	/**
	 * Return a clockwise.
	 * 
	 * @author Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 27 Oct 2013
	 */
	public boolean GetClockwise() {
		return (m_agent.GetClockwise());
	}

	/**
	 * Constructor.
	 * 
	 * @author Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 27 Oct 2013
	 */
	public boolean AbandonGame(boolean flag) {
		return (m_agent.AbandonGame(flag));
	}
}
