/*******************************************************************************
 *                                                                             *
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

import eu.veldsoft.twenty.eight.dummy.Globals;

public class gmEngine {
	/**
	 * Initialization of the gmEngineData structure used by each gmEngine
	 * instance (m_data) is a costly affair because 1) the structure is huge 2)
	 * there are multiple loops to be run to initiate certian data elements. At
	 * one point of time, approx 30% of the entire run time was taken by
	 * gmEntine.Reset. To speed things up, a static m_init of type gmEngineData
	 * is created and is initiated manually when the first instance of gmEngine
	 * is called. Once this is done, all further initializations of this struct
	 * is done be a memcpy from m_init.
	 */
	public static gmEngineData m_init;

	public static boolean m_init_ok;

	private gmEngineData m_data;

	private void SetOutput(int output_type) {
		// TODO To be done by INFM032 F___46 Nadya Nedyalkova ...
		// TODO To be done by INFM032 F___56 Daniel Nikolov ...
		// TODO To be done by INFM032 F___47 Kostadin Bulakiev ...
	}

	/**
	 * 
	 * @param input_type
	 * 
	 * @author INFM032 F___14 Petya Atanasova
	 * @author INFM032 F___48 Georgi Ivanov
	 * @author INFM042 F___56 Daniel Nikolov
	 */
	private void SetInput(int input_type) {
		
		assert (m_data.output_pending);
		assert (m_data.input_pending);
		m_data.input_type = input_type;
		m_data.input_pending = true; 
	}

	private long GenerateMask() {
		return (GenerateMask(0));
	}

	/**
	 * 
	 * @param rules
	 * 
	 * @return
	 * 
	 * @author INFM042 F___06 Rosen Kaplanov
	 * @author INFM042 F___81 Marina Rangelova
	 * @author INFM042 F___05 Iliya Grozev
	 */
	private long GenerateMask(long rules) {
		long temp = 0;
		long mask = Globals.gmALL_CARDS;

		/*
		 * Rule 1 : If the first card to be played in the round and if trump is
		 * not shown, the player who set the trump cannot lead a trump.
		 */
		if (m_data.tricks[m_data.trick_round].count != 0
				&& m_data.trump_shown == false
				&& (((m_data.tricks[m_data.trick_round].lead_loc + (m_data.tricks[m_data.trick_round].count * m_data.rules.rot_addn)) % 4) == m_data.curr_max_bidder)) {
			assert (m_data.trump_suit != Globals.gmSUIT_INVALID);
			mask = ~(gmUtil.m_suit_mask[m_data.trump_suit]);
			temp |= Globals.gmRULE_1;
		}
		/*
		 * Rule 4 : If the max bidder asked for trump to be shown he/she must
		 * play the very same card
		 */
		else if (m_data.should_play_trump_card && (!m_data.rules.waive_rule_4)) {
			assert (m_data.trump_card != Globals.gmCARD_INVALID);
			mask = 1 << m_data.trump_card;
			temp |= Globals.gmRULE_4;
		}
		/*
		 * Rule 2 : If trump was asked to be shown, then trump must be played
		 */
		else if (m_data.should_trump) {
			assert (m_data.trump_suit != Globals.gmSUIT_INVALID);
			mask = gmUtil.m_suit_mask[m_data.trump_suit];
			temp |= Globals.gmRULE_2;
		}
		/*
		 * Rule 3 : Should follow suit
		 */
		else if (m_data.tricks[m_data.trick_round].count != 0) {
			assert (m_data.tricks[m_data.trick_round].lead_suit != Globals.gmSUIT_INVALID);
			mask = gmUtil.m_suit_mask[m_data.tricks[m_data.trick_round].lead_suit];
			temp |= Globals.gmRULE_3;
		}
		assert (mask != 0);

		/*
		 * Set the rules which were considered
		 */
		if (rules != 0) {
			rules = temp;
		}

		return mask;
	}

	/**
	 * @author INFM042 F___84 Mariya Kostadinova
	 * @author INFM032 F___93 Krasimir Chariyski
	 * @author INFM042 F___68 Georgi Srebrov
	 */
	private boolean SetDealEndOutput() {
		// Check whether there is a winner?
		if (m_data.pts[m_data.curr_max_bidder % 2] >= m_data.curr_max_bid) {
			m_data.out_deal_end_info.winner = m_data.curr_max_bidder % 2;
		} else if (m_data.pts[(m_data.curr_max_bidder + 1) % 2] > (28 - m_data.curr_max_bid)) {
			m_data.out_deal_end_info.winner = (m_data.curr_max_bidder + 1) % 2;
		} else {
			return false;
		}
		if (m_data.feedback) {
			SetOutput(Globals.gmOUTPUT_DEAL_END);
		}
		return true;

	}

	// Disallow copy finalructor/assignment operators
	private gmEngine(final gmEngine object) {
		// TODO To be done by INFM032 F___14 Petya Atanasova ...
		// TODO To be done by INFM032 F___90 Svetoslav Slavkov ...
		// TODO To be done by INFM032 F___47 Kostadin Bulakiev ...
	}

	/**
	 * 
	 * @param object
	 * @return
	 * @author INFM042 F___45 Valentin Popov ...
	 * @author INFM042 F___88 Ivan Dankinov ...
	 * @author INFM042 F___68 Nikola Vushkov ...
	 */
	private gmEngine assign(final gmEngine object) {
		return (this);
	}

	/**
	 * 
	 * @author INFM042 F___56 Daniel Nikolov
	 * @author INFM042 F___67 Nevena Sirakova 
	 * @author INFM042 F___90 Svetoslav Slavkov
	 */
	public static void InitCache() {
		int i;
		int j;
		
		Reset(m_init);
		
		gmEngine.m_init.status = Globals.gmSTATUS_NOT_STARTED;
		gmEngine.m_init.dealer = 0;

		// Filling m_shuffled with values for all the 32 cards
		for (i = 0; i < Globals.gmTOTAL_CARDS; i++) {
			gmEngine.m_init.shuffled[i] = i;
		}

		// Neither input or output is pending at the start
		gmEngine.m_init.input_pending = false;
		gmEngine.m_init.output_pending = false;

		// Reset the hands
		for (i = 0; i < Globals.gmTOTAL_PLAYERS; i++) {
			gmEngine.m_init.hands[i] = 0;
		}

		// Resetting variables related to bidding
		gmEngine.m_init.first_bid = true;
		gmEngine.m_init.curr_max_bid = 0;
		gmEngine.m_init.curr_max_bidder = Globals.gmPLAYER_INVALID;
		gmEngine.m_init.last_bidder = Globals.gmPLAYER_INVALID;
		for (i = 0; i < gmUtil.gmTOTAL_BID_ROUNDS; i++) {
			for (j = 0; j < Globals.gmTOTAL_PLAYERS; j++) {
				gmEngine.m_init.bid_hist[i][j] = false;
			}
		}
		gmEngine.m_init.passed_round1 = 0;

		// Resetting trump suit and card
		gmEngine.m_init.trump_card = Globals.gmCARD_INVALID;
		gmEngine.m_init.trump_suit = Globals.gmSUIT_INVALID;

		// Resetting variables related to tricks
		for (i = 0; i < Globals.gmTOTAL_TEAMS; i++) {
			gmEngine.m_init.pts[i] = 0;
		}

		for (i = 0; i < Globals.gmTOTAL_PLAYERS; i++) {
			gmEngine.m_init.played_cards[i] = 0;
		}

		gmEngine.m_init.trick_round = 0;
		gmEngine.m_init.should_trump = false;
		gmEngine.m_init.should_play_trump_card = false;
		gmEngine.m_init.trump_shown = false;

		for (i = 0; i < Globals.gmTOTAL_TRICKS; i++) {
			for (j = 0; j < Globals.gmTOTAL_PLAYERS; j++) {
				gmEngine.m_init.tricks[i].cards[j] = Globals.gmCARD_INVALID;
			}
			gmEngine.m_init.tricks[i].count = 0;
			gmEngine.m_init.tricks[i].lead_loc = Globals.gmPLAYER_INVALID;
			gmEngine.m_init.tricks[i].lead_suit = Globals.gmSUIT_INVALID;
			gmEngine.m_init.tricks[i].points = 0;
			gmEngine.m_init.tricks[i].trumped = false;
			m_init.tricks[i].winner = Globals.gmPLAYER_INVALID;
		}
	}

	/**
	 * 
	 * @author INFM032 F___46 Nadya Nedyalkova
	 * @author INFM042 F___06 Rosen Kaplanov
	 * @author INFM032 F___52 Mihail Stankov
	 */
	public gmEngine() {
		if (m_init_ok == false) {
			gmEngine.InitCache();
			m_init_ok = true;
		}

		m_data.ok = Reset(m_data);
		m_data.feedback = true;

		/*
		 * Set the rules.
		 */
		m_data.rules.rot_addn = 1;
		m_data.rules.min_bid_1 = 14;
		m_data.rules.min_bid_2 = 20;
		m_data.rules.min_bid_3 = 23;
		m_data.rules.waive_rule_4 = false;
		m_data.rules.sluff_jacks = true;
	}

	protected void finalize() {
		// TODO To be done by INFM032 F___90 Svetoslav Slavkov ...
		// TODO To be done by INFM042 F___56 Daniel Nikolov ...
		// TODO To be done by INFM032 F___94 Aleksandar Milev ...
	}

	/**
	 * 
	 * @return
	 * @author INFM032 F___68 Georgi Srebrov ...
	 * @author INFM042 F___46 Nadya Nedyalkova ...
	 * @author INFM042 F___88 Ivan Dankinov ...
	 */
	public boolean IsOk() {
		return m_data.ok;
	}

	/**
	 * @author INFM042 F___45 Valentin Popov
	 * @author INFM032 F___68 Georgi Srebrov
	 * @author INFM042 F___68 Nikola Vushkov
	 */

	public int GetStatus() {
		return m_data.status;
	}

	/**
	 * 
	 * @param data
	 * 
	 * @return
	 * 
	 * @author INFM042 F___06 Rosen Kaplanov
	 * @author INFM032 F___46 Nadya Nedyalkova
	 * @author INFM032 F___68 Nikola Vushkov
	 */
	public static boolean Reset(gmEngineData data) {

		boolean feedback;
		gmRules rules = null;
		feedback = data.feedback;
		try {
			rules = (gmRules) data.rules.clone();
		} catch (CloneNotSupportedException e) {

		}
		try {
			data = (gmEngineData) gmEngine.m_init.clone();
		} catch (CloneNotSupportedException e) {

		}
		data.feedback = feedback;
		try {
			data.rules = (gmRules) rules.clone();
		} catch (CloneNotSupportedException e) {

		}
		return true;
	}

	public boolean Reset() {
		// TODO To be done by INFM032 F___45 Valentin Popov ...
		// TODO To be done by INFM042 F___48 Georgi Ivanov ...
		// TODO To be done by INFM032 F___05 Iliya Grozev ...

		return (false);
	}

	public boolean Shuffle() {
		// TODO To be done by INFM042 F___46 Nadya Nedyalkova ...
		// TODO To be done by INFM042 F___27 Georgi Kostadinov ...
		// TODO To be done by INFM032 F___52 Mihail Stankov ...

		return (false);
	}

	public boolean Continue() {
		// TODO To be done by INFM042 F___45 Valentin Popov ...
		// TODO To be done by INFM032 F___14 Petya Atanasova ...
		// TODO To be done by INFM042 F___93 Krasimir Chariyski ...

		return (false);
	}

	public boolean GetOutput(int output_type, Object output) {
		// TODO To be done by INFM032 F___27 Georgi Kostadinov ...
		// TODO To be done by INFM032 F___46 Nadya Nedyalkova ...
		// TODO To be done by INFM032 F___68 Nikola Vushkov ...

		return (false);
	}

	public boolean IsOutputPending() {
		// TODO To be done by INFM042 F___93 Krasimir Chariyski ...
		// TODO To be done by INFM032 F___45 Valentin Popov ...
		// TODO To be done by INFM032 F___27 Georgi Kostadinov ...

		return (false);
	}

	public int GetPendingOutputType() {
		// TODO To be done by INFM042 F___45 Valentin Popov ...
		// TODO To be done by INFM032 F___27 Georgi Kostadinov ...
		// TODO To be done by INFM042 F___47 Kostadin Bulakiev ...

		return (0);
	}

	public boolean IsInputPending() {
		// TODO To be done by INFM042 F___90 Svetoslav Slavkov ...
		// TODO To be done by INFM032 F___81 Marina Rangelova ...
		// TODO To be done by INFM032 F___27 Georgi Kostadinov ...

		return (false);
	}

	/**
	 * 
	 * @return
	 * 
	 * @author INFM042 F___14 Petya Atanasova
	 * @author INFM032 F___93 Krasimir Chariyski
	 * @author INFM042 F___48 Georgi Ivanov
	 */
	public int GetPendingInputType() {
	// If no input is pending,return invalid type
		
		if(m_data.input_pending)
		return gmINPUT_INVALID;
		return m_data.input_type; 
	}

	public boolean GetPendingInputCriteria(Integer input_type, Object input) {
		// TODO To be done by INFM032 F___68 Nikola Vushkov ...
		// TODO To be done by INFM042 F___48 Georgi Ivanov ...
		// TODO To be done by INFM042 F___46 Nadya Nedyalkova ...

		return (false);
	}

	public int PostInputMessage(int input_type, Object input) {
		// TODO To be done by INFM042 F___14 Petya Atanasova ...
		// TODO To be done by INFM042 F___05 Iliya Grozev ...
		// TODO To be done by INFM032 F___27 Georgi Kostadinov ...

		return (0);
	}

	/**
	 * Get Feedback
	 * 
	 * @return boolean type
	 * 
	 * @author INFM042 F___05 Iliya Grozev
	 * @author INFM042 F___06 Rosen Kaplanov
	 * @author INFM042 F___93 Krasimir Chariyski
	 */
	public boolean GetFeedback() {
		return m_data.feedback;
	}

	/**
	 * Set Feedback
	 * 
	 * @param feedback
	 *            boolean type
	 * 
	 * @author INFM042 F___93 Krasimir Chariyski
	 * @author INFM042 F___56 Daniel Nikolov
	 * @author INFM032 F___14 Petya Atanasova
	 */
	public void SetFeedback(boolean feedback) {
		m_data.feedback = feedback;

		if (m_data.feedback == false) {
			m_data.output_pending = false;
		}
	}

	/**
	 * 
	 * @param rules
	 * 
	 * @author INFM042 F___81 Marina Rangelova
	 * @author INFM042 F___39 Shterion Yanev
	 * @author INFM042 F___47 Kostadin Bulakiev
	 */
	public void GetRules(gmRules rules) {
		try {
			rules = (gmRules) m_data.rules.clone();
		} catch (CloneNotSupportedException e) {
		}
	}

	/**
	 * 
	 * @param rules
	 * 
	 * @author INFM032 F___27 Georgi Kostadinov
	 * @author INFM032 F___81 Marina Rangelova
	 * @author INFM042 F___06 Rosen Kaplanov
	 */
	public void SetRules(gmRules rules) {
		try {
			m_data.rules = (gmRules) rules.clone();
		} catch (CloneNotSupportedException e) {
		}
	}

	public void GetHands(long hands[]) {
		// TODO To be done by INFM032 F___68 Nikola Vushkov ...
		// TODO To be done by INFM032 F___14 Petya Atanasova ...
		// TODO To be done by INFM032 F___56 Daniel Nikolov ...
	}

	/**
	 * 
	 * @param cards
	 * 
	 * @author INFM042 F___68 Georgi Srebrov
	 * @author INFM042 F___48 Georgi Ivanov
	 * @author INFM042 F___56 Daniel Nikolov
	 */

	public void GetCardsPlayed(long cards) {
		System.arraycopy(m_data.played_cards, 0, cards, 0,
				m_data.played_cards.length);
	}

	public void GetTrick(int trick_round, gmTrick trick) {
		// TODO To be done by INFM032 F___68 Nikola Vushkov ...
		// TODO To be done by INFM032 F___52 Mihail Stankov ...
		// TODO To be done by INFM042 F___39 Shterion Yanev ...

		// TODO Try to implement one method with trick_round as default
		// variable.
	}

	/**
	 * 
	 * @param trick
	 * 
	 * @author INFM042 F___81 Marina Rangelova
	 * @author INFM032 F___68 Georgi Srebrov
	 * @author INFM042 F___39 Shterion Yanev
	 */
	public void GetTrick(gmTrick trick) {
		GetTrick(m_data.trick_round, trick);
	}

	public int GetTrickRound() {
		// TODO To be done by INFM042 F___47 Kostadin Bulakiev ...
		// TODO To be done by INFM032 F___27 Georgi Kostadinov ...
		// TODO To be done by INFM042 F___52 Mihail Stankov ...

		return (0);
	}

	/**
	 * 
	 * @param team
	 * 
	 * @return
	 * 
	 * @author INFM032 F___48 Georgi Ivanov
	 * @author INFM032 F___06 Rosen Kaplanov
	 * @author INFM032 F___27 Georgi Kostadinov
	 */
	public int GetPoints(int team) {

		assert ((team >= 0) && (team < Globals.gmTOTAL_TEAMS));
		return m_data.pts[team];
	}

	public void GetPoints(int pts[]) {
		// TODO To be done by INFM042 F___68 Nikola Vushkov ...
		// TODO To be done by INFM032 F___48 Georgi Ivanov ...
		// TODO To be done by INFM032 F___05 Iliya Grozev ...
	}

	/**
	 * 
	 * @param trump
	 * 
	 * @return
	 *
	 * @author INFM042 F___47 Kostadin Bulakiev
	 * @author INFM042 F___81 Marina Rangelova
	 * @author INFM032 F___48 Georgi Ivanov
	 */
	
	public int GetTrump() {
		
		return m_data.trump_suit;
	}

	/**
	 * 
	 * @param card
	 * 
	 * @return
	 * 
	 * @author INFM042 F___27 Georgi Kostadinov
	 * @author INFM042 F___48 Georgi Ivanov
	 * @author INFM042 F___14 Petya Atanasova
	 	 */
	
	public int GetTrumpCard() {
		
		return m_data.trump_card;
	}

	public int GetDealer() {
		// TODO To be done by INFM042 F___52 Mihail Stankov ...
		// TODO To be done by INFM032 F___05 Iliya Grozev ...
		// TODO To be done by INFM042 F___56 Daniel Nikolov ...

		return (0);
	}

	/**
	 * 
	 * @param dealer
	 * 
	 * @author INFM032 F___39 Shterion Yanev
	 * @author INFM042 F___47 Kostadin Bulakiev
	 * @author INFM042 F___48 Georgi Ivanov
	 */
	public void SetDealer(int dealer) {
		assert ((dealer >= 0) && (dealer < Globals.gmTOTAL_PLAYERS));
		m_data.dealer = dealer;
	}

	/**
	 * @author INFM042 F___27 Georgi Kostadinov
	 * @author INFM042 F___14 Petya Atanasova
	 * @author INFM042 F___68 Georgi Srebrov
	 */
	public static void ResetTrick(gmTrick trick) {

		for (int j = 0; j < Globals.gmTOTAL_PLAYERS; j++) {
			trick.cards[j] = Globals.gmCARD_INVALID;
		}
		trick.count = 0;
		trick.lead_loc = Globals.gmPLAYER_INVALID;
		trick.lead_suit = Globals.gmSUIT_INVALID;
		trick.points = 0;
		trick.trumped = false;
		trick.winner = Globals.gmPLAYER_INVALID;
	}

	/**
	 * 
	 * @param data
	 * 
	 * @return
	 * 
	 * @author INFM032 F___68 Georgi Srebrov
	 * @author INFM032 F___39 Shterion Yanev
	 * @author INFM032 F___52 Mihail Stankov
	 */
	public boolean GetData(gmEngineData data) {
		try {
			data = (gmEngineData) m_data.clone();
		} catch (CloneNotSupportedException e) {
		}

		return (false);
	}

	public boolean SetData(gmEngineData data) {
		return (SetData(data, true));
	}

	public boolean SetData(gmEngineData data, boolean check) {
		// TODO To be done by INFM032 F___47 Kostadin Bulakiev ...
		// TODO To be done by INFM032 F___56 Daniel Nikolov ...
		// TODO To be done by INFM042 F___93 Krasimir Chariyski ...

		return (false);
	}

	public boolean GetMaxBid(Integer bid, int loc) {
		// TODO To be done by INFM042 F___68 Nikola Vushkov ...
		// TODO To be done by INFM032 F___93 Krasimir Chariyski ...
		// TODO To be done by INFM042 F___05 Iliya Grozev ...

		return (false);
	}

	/**
	 * @author INFM042 F___14 Petya Atanasova
	 * @author INFM032 F___68 Nikola Vushkov
	 * @author INFM042 F___68 Georgi Srebrov
	 */
	public String GetLoggable() {
		return PrintRuleEngineData(m_data);
	}

	public static String PrintRuleEngineData(gmEngineData data) {
		// TODO To be done by INFM042 F___56 Daniel Nikolov ...
		// TODO To be done by INFM042 F___27 Georgi Kostadinov ...
		// TODO To be done by INFM032 F___68 Nikola Vushkov ...

		return ("");
	}

	public boolean IsTrumpShown() {
		// TODO To be done by INFM032 F___52 Mihail Stankov ...
		// TODO To be done by INFM042 F___68 Nikola Vushkov ...
		// TODO To be done by INFM032 F___93 Krasimir Chariyski ...

		return (false);
	}

	/**
	 * 
	 * @author INFM032 F___14 Petya Atanasova
	 * @author INFM032 F___47 Kostadin Bulakiev
	 * @author INFM032 F___68 Georgi Srebrov
	 */

	public int GetTrickNextToPlay() {
		if (m_data.status != Globals.gmSTATUS_TRICKS)
			return Globals.gmPLAYER_INVALID;
		if (m_data.tricks[m_data.trick_round].count == Globals.gmTOTAL_PLAYERS)
			return Globals.gmPLAYER_INVALID;
		else {
			return gmTrickNext();
		}
	}

	private int gmTrickNext() {
		int next = (m_data.tricks[m_data.trick_round].lead_loc + (m_data.tricks[m_data.trick_round].count * m_data.rules.rot_addn)) % 4;
		return next;
	}

	public void SetMinBid(int round, int bid) {
		// TODO To be done by INFM042 F___56 Daniel Nikolov ...
		// TODO To be done by INFM042 F___81 Marina Rangelova ...
		// TODO To be done by INFM032 F___48 Georgi Ivanov ...
	}

	/**
	 * 
	 * @param flag
	 * 
	 * @author INFM042 F___81 Marina Rangelova
	 * @author INFM042 F___68 Georgi Srebrov
	 * @author INFM042 F___56 Daniel Nikolov
	 */

	public void SetWaiveRuleFour(boolean flag) {
		m_data.rules.waive_rule_4 = flag;
	}

	/**
	 * 
	 * @param flag
	 * 
	 * @author INFM032 F___68 Georgi Srebrov
	 * @author INFM042 F___47 Kostadin Bulakiev
	 * @author INFM032 F___68 Nikola Vushkov
	 */
	public void SetSluffJacks(boolean flag) {
		m_data.rules.sluff_jacks = flag;
	}
}
