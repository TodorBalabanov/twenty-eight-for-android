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

public class raPlayer {
	private aiAgent m_agent;

	private int m_loc;

	private int m_type;

	private int m_trump;

	public raPlayer() {
		// TODO To be done by Venci
	}

	protected void finalize() {
		// TODO To be done by ...
	}

	public void SetLocation(int loc) {
		// TODO To be done by Venci
	}
	public int GetLocation() {
		// TODO To be done by Venci

		return (0);
	}

	public int GetType() {
		// TODO To be done by Venci

		return (0);
	}

	public void SetType(int type) {
		// TODO To be done by Venci
	}

	public void SetRuleEngineData(gmEngineData data) {
		// TODO To be done by Venci
	}

	public boolean GetBid(int bid, int trump, int min, boolean force_bid) {
		// TODO To be done by Venci

		return (false);
	}

	public int GetTrump() {
		// TODO To be done by ...

		return (0);
	}

	public int GetPlay() {
		// TODO To be done by ...

		return (0);
	}

	public boolean PostPlayUpdate(gmEngineData data, int card) {
		// TODO To be done by ...

		return (false);
	}

	public boolean CheckAssumptions(gmEngineData data) {
		// TODO To be done by ...

		return (false);
	}

	public boolean Reset() {
		// TODO To be done by ...

		return (false);
	}

	public void SetRules() {
		SetRules(null);
	}

	public void SetRules(gmRules rules) {
		// TODO To be done by ...
	}

	public boolean SetClockwise(boolean flag) {
		// TODO To be done by ...

		return (false);
	}

	public boolean GetClockwise() {
		// TODO To be done by ...

		return (false);
	}

	public boolean AbandonGame(boolean flag) {
		// TODO To be done by ...

		return (false);
	}
}
