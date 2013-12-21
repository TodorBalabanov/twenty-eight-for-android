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

package eu.veldsoft.twenty.eight.gm;

public class gmEngineData implements Cloneable {
	public boolean ok;

	public boolean feedback;

	public gmRules rules;

	public int status;

	public int dealer;

	public int shuffled[] = new int[gmUtil.gmTOTAL_CARDS];

	// Variables related to messaging
	public boolean output_pending;

	public boolean input_pending;

	public int output_type;

	public int input_type;

	// Related to bidding
	public boolean first_bid;

	public int curr_max_bid;

	public int curr_max_bidder;

	public int last_bidder;

	public boolean bid_hist[][] = new boolean[gmUtil.gmTOTAL_BID_ROUNDS][gmUtil.gmTOTAL_PLAYERS];

	public long passed_round1;

	// Related to the trump card
	public int trump_suit;

	public int trump_card;

	// Cards held by players
	public long hands[] = new long[gmUtil.gmTOTAL_PLAYERS];

	// Related to tricks
	public int pts[] = new int[gmUtil.gmTOTAL_TEAMS];

	public int trick_round;

	public gmTrick tricks[] = new gmTrick[gmUtil.gmTOTAL_TRICKS];

	public long played_cards[] = new long[gmUtil.gmTOTAL_PLAYERS];

	public boolean should_trump;

	public boolean should_play_trump_card;

	public boolean trump_shown;

	// Related to output messages
	public gmOutputDealInfo out_deal_info;

	public gmOutputDealEndInfo out_deal_end_info;

	// Structures to hold data related to the pending input message
	public gmInputBidInfo in_bid_info;

	public gmInputTrumpselInfo in_trumpsel_info;

	public gmInputTrickInfo in_trick_info;

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
