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

package eu.veldsoft.twenty.eight.ai;

import java.util.Arrays;

import eu.veldsoft.twenty.eight.dummy.Globals;
import eu.veldsoft.twenty.eight.gm.gmEngine;
import eu.veldsoft.twenty.eight.gm.gmEngineData;
import eu.veldsoft.twenty.eight.gm.gmInputTrickInfo;
import eu.veldsoft.twenty.eight.gm.gmRules;
import eu.veldsoft.twenty.eight.gm.gmUtil;

public class aiAgent {
	/**
	 * Dummy values.
	 */
	private static final String __FILE__ = "";

	/**
	 * Dummy values.
	 */
	private static final int __LINE__ = 0;

	public static final int aiBID_SAMPLE = 100;

	public static final int aiPLAY_SAMPLES = 30;

	public static final int aiMAX_MOVES = 20;

	public static final int aiGENMV_NOTRUMP = 1;

	public static final int aiGENMV_TRUMP = 2;

	public static final int aiGENMV_ALL = 3;

	public static final int aiPOS_INFTY = +10000;

	public static final int aiNEG_INFTY = -10000;

	private final static int s_depths[] = { 2, 3, 4, 6, 7, 8, 8, 8 };

	private gmEngine m_engine;

	private int m_loc;

	private long m_trump_cards;

	private long m_notrump_suspects;

	private long m_nulls[] = new long[gmUtil.gmTOTAL_PLAYERS];

	private long m_mb_null_susp;

	/**
	 * 
	 * @param elem1
	 * @param elem2
	 * @return
	 * 
	 * @author INFM042 F___00 Tsvetelina Hristova
	 * @author INFM032 F___45 Valentin Popov
	 * @author INFM042 F___48 Georgi Ivanov
	 */
	public static int CompareMoves(final Object elem1, final Object elem2) {
		aiMove move1, move2;
		move1 = (aiMove) elem1;
		move2 = (aiMove) elem2;
		if (move1.rank > move2.rank) {
			return -1;
		} else if (move1.rank == move2.rank) {
			return 0;
		} else {
			return 1;
		}
	}

	/**
	 * Disallow copy finalructor/assignment operators.
	 * 
	 * @param elem1
	 * @param elem2
	 * 
	 * @return
	 * 
	 * @author To be done by INFM032 F___90 Svetoslav Slavkov ...
	 * @author To be done by INFM042 F___88 Ivan Dankinov ...
	 * @author To be done by INFM042 F___81 Marina Rangelova ...
	 */
	private aiAgent(final aiAgent object) {
		/*
		 * Empty body of private constructor.
		 */
	}

	private boolean EstimateTricks(long[] hands, int trump, int[] trick_count_array) {
		// TODO To be done by INFM032 F___45 Valentin Popov ...
		// TODO To be done by INFM032 F___81 Marina Rangelova ...
		// TODO To be done by INFM042 F___90 Svetoslav Slavkov ...

		return (false);
	}

	/**
	 * 
	 * @param hands
	 * @param trump
	 * @param trick_count
	 * @param eval
	 * 
	 * @return
	 * 
	 * @author INFM032 F___46 Nadya Nedyalkova
	 * @author INFM042 F___47 Kostadin Bulakiev
	 * @author INFM032 F___05 Iliya Grozev
	 */
	private boolean EstimatePoints(long[] hands, int trump, int trick_count,
			int[] eval) {
		int trick_count_array[] = new int[2];
		long all_cards = 0;
		int total_pts;

		/*
		 * Set both ints in eval to 0.
		 */
		// TODO set each element of eval = 0;
		eval[0] = 0;
		eval[1] = 0;

		all_cards = hands[0] | hands[1] | hands[2] | hands[3];
		total_pts = Globals.gmTotalPoints(all_cards);

		EstimateTricks(hands, trump, trick_count_array);

		/*
		 * Share points according to the tricks estimated.
		 */
		eval[0] = (total_pts * trick_count_array[0]) / (8 - trick_count);
		eval[1] = (total_pts * trick_count_array[1]) / (8 - trick_count);
		if (Globals.raAI_LOG_ESTIMATE_POINTS) {
			Globals.wxLogDebug("Points expected before sharing - %d, %d",
					eval[0], eval[1]);
			Globals.wxLogDebug("Points shared- %d",
					(total_pts - eval[0] - eval[1]) / 4);
		}

		/*
		 * Share the half of the rest of the points equally
		 */
		eval[0] += (total_pts - eval[0] - eval[1]) / 4;
		eval[1] += (total_pts - eval[0] - eval[1]) / 4;

		if (Globals.raAI_LOG_ESTIMATE_POINTS) {
			Globals.wxLogDebug("Points expected (final) - %d, %d", eval[0],
					eval[1]);
		}

		return true;
	}

	private boolean GenerateMoves(gmEngine node, aiMove moves, int count) {
		GenerateMoves(node, moves, count, aiGENMV_ALL);

		return (false);
	}

	private boolean GenerateMoves(gmEngine node, aiMove moves, int count,
			int type) {
		// TODO To be done by INFM042 F___46 Nadya Nedyalkova ...
		// TODO To be done by INFM042 F___47 Kostadin Bulakiev ...
		// TODO To be done by INFM032 F___52 Mihail Stankov ...

		return (false);
	}

	/**
	 * 
	 * @param node
	 * @param moves
	 * @param count
	 * @return
	 * @author INFM032 F___00 Tsvetelina Hristova
	 * @author INFM042 F___45 Valentin Popov
	 * @author INFM032 F___05 Iliya Grozev
	 */
	private boolean OrderMoves(gmEngine node, aiMove moves[], int count) {
		gmEngineData data = new gmEngineData();
		node.GetData(data);

		/*
		 * Rank each move.
		 */
		for (int i = 0; i < count; i++) {
			RankMove(data, moves[i]);
		}

		Arrays.sort(moves);

		return true;
	}

	private boolean RankMove(gmEngineData data, aiMove move) {
		// TODO To be done by INFM042 F___90 Svetoslav Slavkov ...
		// TODO To be done by INFM032 F___14 Petya Atanasova ...
		// TODO To be done by INFM032 F___94 Aleksandar Milev ...

		return (false);
	}

	private int Evaluate(gmEngine node, int alpha, int beta, int depth,
			boolean ret_val) {
		// TODO To be done by INFM042 F___46 Nadya Nedyalkova ...
		// TODO To be done by INFM032 F___56 Daniel Nikolov ...
		// TODO To be done by INFM032 F___68 Georgi Srebrov ...

		return (0);
	}

	private int EstimateHeuristic(gmEngine state) {
		// TODO To be done by INFM042 F___52 Mihail Stankov ...
		// TODO To be done by INFM032 F___45 Valentin Popov ...
		// TODO To be done by INFM042 F___67 Nevena Sirakova ...

		return (0);
	}

	/**
	 * 
	 * @param node
	 * @param move
	 * 
	 * @return
	 * 
	 * @author INFM032 F___56 Daniel Nikolov
	 * @author INFM042 F___93 Krasimir Chariyski
	 * @author INFM032 F___46 Nadya Nedyalkova
	 */
	private boolean MakeMove(gmEngine node, aiMove move) {
		gmInputTrickInfo trick_info = new gmInputTrickInfo();

		/*
		 * s * Obtain the current input criteria and verify.
		 */
		if (node.GetPendingInputType() != Globals.gmINPUT_TRICK) {
			Globals.wxLogError("GetPendingInputCriteria failed. %s:%d",
					__FILE__, __LINE__);
			return false;
		}

		if (!node.GetPendingInputCriteria(null, trick_info)) {
			Globals.wxLogError("GetPendingInputCriteria failed. %s:%d",
					__FILE__, __LINE__);
			return false;
		}

		/*
		 * If trump needs to be asked for firstly, do that.
		 */
		if (move.ask_trump) {
			assert (trick_info.can_ask_trump);
			trick_info.ask_trump = true;
			if (node.PostInputMessage(Globals.gmINPUT_TRICK, trick_info) != 0) {
				Globals.wxLogError("PostInputMessage failed. %s:%d", __FILE__,
						__LINE__);
				return false;
			}
			while (node.Continue()) {
			}
			if (node.GetPendingInputType() != Globals.gmINPUT_TRICK) {
				Globals.wxLogError("GetPendingInputCriteria failed. %s:%d",
						__FILE__, __LINE__);
				return false;
			}
			if (!node.GetPendingInputCriteria(null, trick_info)) {
				Globals.wxLogError("GetPendingInputCriteria failed. %s:%d",
						__FILE__, __LINE__);
				return false;
			}
		}

		/*
		 * Make the move.
		 */
		trick_info.card = move.card;
		if (Globals.raAI_LOG_MAKEMOVE) {
			Globals.wxLogDebug("%s making a move %s%s. %s:%d",
					gmUtil.m_short_locs[trick_info.player],
					gmUtil.m_suits[Globals.gmGetSuit(move.card)],
					gmUtil.m_values[Globals.gmGetValue(move.card)], __FILE__,
					__LINE__);
		}

		if (node.PostInputMessage(Globals.gmINPUT_TRICK, trick_info) != 0) {
			node.PostInputMessage(Globals.gmINPUT_TRICK, trick_info);
			Globals.wxLogDebug("Player %s Card %s%s",
					gmUtil.m_short_locs[trick_info.player],
					gmUtil.m_suits[Globals.gmGetSuit(trick_info.card)],
					gmUtil.m_values[Globals.gmGetValue(trick_info.card)]);
			Globals.wxLogError("PostInputMessage failed. %s:%d", __FILE__,
					__LINE__);
			return false;
		}

		/*
		 * Continue the play.
		 */
		while (node.Continue()) {
		}

		return true;
	}
	
	/**
	 * 	@author F___68 Georgi Srebrov ...
	 *	@author F___90 Svetoslav Slavkov ...
	 *	@author2 F___81 Marina Rangelova ...
	 */
	private boolean MakeMoveAndEval(gmEngine node, aiMove move, int depth,
			int eval) {

		boolean eval_ret;
		int temp;

		assert(node!=null);
		assert(eval!=0);
		assert(move!=null);
		assert(depth > 0);

		if (!MakeMove(node, move))
		{
			Globals.wxLogError("MakeMove failed. %s:%d",
					__FILE__, __LINE__);
			Globals.wxLogError(node.GetLoggable());
			if (move.ask_trump)
			{
				Globals.wxLogError("Move attempted ?%s%s",gmUtil.m_suits[Globals.gmGetSuit(move.card)], gmUtil.m_values[Globals.gmGetValue(move.card)], __LINE__);
			}
			else
			{
				Globals.wxLogError("Move attempted ?%s%s",gmUtil.m_suits[Globals.gmGetSuit(move.card)], gmUtil.m_values[Globals.gmGetValue(move.card)], __LINE__);
			}
			return false;
		}

		eval_ret = false;
		temp = aiNEG_INFTY;
		temp = Evaluate(node, aiNEG_INFTY, aiPOS_INFTY, depth, eval_ret);
		assert(temp != aiNEG_INFTY);
		if (!eval_ret)
		{
			Globals.wxLogError("Evaluate failed. %s:%d",__FILE__, __LINE__);
			return false;
		}
		else {
			return true;
		}
	}

	protected void finalize() {
		// TODO To be done by INFM042 F___45 Valentin Popov ...
		// TODO To be done by INFM042 F___27 Georgi Kostadinov ...
		// TODO To be done by INFM032 F___14 Petya Atanasova ...
	}

	/**
	 * @author INFM032 F___06 Rosen Kaplanov
	 * @author INFM042 F___46 Nadya Nedyalkova
	 * @author INFM042 F___68 Georgi Srebrov
	 */
	public aiAgent() {
		// TODO : Remove hardcoding
		m_loc = 0;
		Reset();
	}

	/**
	 * Set location.
	 * 
	 * @param loc
	 * 
	 * @author INFM032 F___00 Tsvetelina Hristova
	 * @author INFM042 F___94 Aleksandar Milev
	 * @author INFM042 F___90 Svetoslav Slavkov
	 */
	public void SetLocation(int loc) {
		m_loc = loc;
	}

	public int GetLocation() {
		// TODO To be done by INFM032 F___52 Mihail Stankov ...
		// TODO To be done by INFM032 F___46 Nadya Nedyalkova ...
		// TODO To be done by INFM042 F___84 Mariya Kostadinova ...

		return (0);
	}

	public boolean GetBid(long cards, int bid, int trump, int min,
			boolean force_bid) {
		// TODO To be done by INFM032 F___93 Krasimir Chariyski ...
		// TODO To be done by INFM032 F___90 Svetoslav Slavkov ...
		// TODO To be done by INFM032 F___14 Petya Atanasova ...

		return (false);
	}

	/**
	 * 
	 * @param bid
	 * @param trump
	 * @param min
	 * @param force_bid
	 * 
	 * @return
	 * 
	 * @author INFM042 F___68 Nikola Vushkov
	 * @author INFM042 F___45 Valentin Popov
	 * @author INFM042 F___14 Petya Atanasova
	 */
	public boolean GetBid(int bid, int trump, int min, boolean force_bid) {
		int ret_trump = 0;
		int ret_bid = 0;
		long hands[] = new long[4];
		long cards = 0;
		int max_bidder = 0;
		int trump_card = 0;

		assert (bid != 0);
		assert (trump != 0);

		// TODO : Correct this check
		// Check if the current Rule Engine state is auction
		if (m_engine.GetStatus() == Globals.gmSTATUS_NOT_STARTED) {
			return false;
		}

		m_engine.GetHands(hands);

		if (Globals.raAI_LOG_GETBID) {
			Globals.wxLogDebug("Estimated bid for %d", m_loc);
			Globals.wxLogDebug(gmUtil.PrintLong(hands[m_loc]));
		}

		cards = hands[m_loc];
		assert (cards != 0);
		max_bidder = Globals.gmPLAYER_INVALID;
		m_engine.GetMaxBid(null, max_bidder);

		assert ((max_bidder >= Globals.gmPLAYER_INVALID) && (max_bidder < Globals.gmTOTAL_PLAYERS));

		if (max_bidder == m_loc) {
			trump_card = m_engine.GetTrumpCard();
			assert ((trump_card >= 0) && (trump_card < Globals.gmTOTAL_CARDS));
			cards |= (1 << trump_card);
		}

		assert (gmUtil.CountBitsSet(cards) <= 8);

		if (!GetBid(cards, ret_bid, ret_trump, min, force_bid)) {
			Globals.wxLogDebug("GetBid failed. File - %s Line - %d", __FILE__,
					__LINE__);
			return false;
		}

		assert ((ret_bid == Globals.gmBID_ALL)
				|| (ret_bid == Globals.gmBID_PASS) || (ret_bid >= min));

		bid = ret_bid;
		trump = ret_trump;

		return true;
	}

	public boolean SetRuleEngineData(gmEngineData data) {
		// TODO To be done by INFM042 F___39 Shterion Yanev ...
		// TODO To be done by INFM042 F___46 Nadya Nedyalkova ...
		// TODO To be done by INFM042 F___56 Daniel Nikolov ...

		return (false);
	}

	/**
	 * Get trump.
	 * 
	 * @author INFM032 INFM032 F___45 Valentin Popov
	 * @author INFM042 INFM042 F___94 Aleksandar Milev
	 * @author INFM042 INFM042 F___67 Nevena Sirakova
	 */
	public int GetTrump() {
		int bid = 0;
		int trump = 0;
		long[] hands = new long[Globals.gmTOTAL_PLAYERS];

		m_engine.GetHands(hands);
		GetBid(bid, trump, 14, true);

		return GetTrump(hands[m_loc], trump);
	}

	/**
	 * Function returns the card to be played(index) -1, for show trump -2 or
	 * other negative values in case of error
	 * 
	 * @param hand
	 * @param suit
	 * 
	 * @return
	 * 
	 * @author INFM032 F___81 Marina Rangelova
	 * @author INFM032 F___46 Nadya Nedyalkova
	 * @author INFM042 F___05 Iliya Grozev
	 */
	public static int GetTrump(long hand, int suit) {
		assert (hand != 0);
		assert ((suit > Globals.gmSUIT_INVALID) && (suit <= Globals.gmTOTAL_SUITS));

		int ret_val = Globals.gmCARD_INVALID;
		long trump_cards = (hand & gmUtil.m_suit_mask[suit]) >> gmUtil.m_suit_rs[suit];
		if ((gmUtil.CountBitsSet(trump_cards & 0x0000000F0)) >= 2) {
			for (int i = 4; i < 8; i++) {
				if ((trump_cards & (1 << i)) != 0) {
					ret_val = (suit * 8) + i;
					break;
				}
			}
		} else if (gmUtil.CountBitsSet(trump_cards & 0x0000000F) > 0) {
			ret_val = (int) ((suit * 8) + gmUtil
					.HighestBitSet(trump_cards & 0x0000000F));
		} else {
			ret_val = (int) ((suit * 8) + gmUtil.HighestBitSet(trump_cards));
		}

		assert ((hand & (1 << ret_val)) != 0);

		return ret_val;
	}

	public int GetPlay(long mask) {
		// TODO To be done by INFM032 F___48 Georgi Ivanov ...
		// TODO To be done by INFM032 F___90 Svetoslav Slavkov ...
		// TODO To be done by INFM032 F___68 Nikola Vushkov ...

		return (0);
	}

	/**
	 * Given the game engine data, generate the suit length problem. This suit
	 * length problem is later on solved to create random deals staisfying the
	 * existing constraints for Monte Carlo
	 * 
	 * @param data
	 * @param problem
	 * @param played
	 * @param trump
	 * @param add_trump
	 * @return
	 * 
	 * @author INFM032 F___27 Georgi Kostadinov
	 * @author INFM042 F___06 Rosen Kaplanov
	 * @author INFM042 F___45 Valentin Popov
	 */
	public boolean GenerateSLProblem(gmEngineData data, slProblem problem,
			int played[][], int trump, boolean add_trump) {
		long cards_played = 0;
		int i, j;
		int sum_hands = 0, sum_suits = 0;

		if (Globals.aiLOG_GENERATESLPROBLEM == true) {
			Globals.wxLogDebug("Inside GenerateSLProblem");
			Globals.wxLogDebug("m_loc - %s", gmUtil.m_short_locs[m_loc]);
		}

		assert (data != null);
		assert (problem != null);
		assert (played != null);

		add_trump = false;

		// TODO Provide an appropriate comment.
		if ((!data.trump_shown) && (data.curr_max_bidder != m_loc)) {
			assert (trump != Globals.gmSUIT_INVALID);
		}

		// TODO Provide an appropriate comment.
		if ((data.trump_shown) || (data.curr_max_bidder == m_loc)) {
			trump = data.trump_suit;
		}

		// TODO Implement the case where the opponents of the max bidder should
		// have at least one trump Initialize the problem. This will set all
		// slots vacant and would default hand and suit total lengths
		aiSuitLengthSolver.InitializeProblem(problem);
		aiSuitLengthSolver.InitializePlayed(played);

		/*
		 * Set the data for played
		 */
		for (i = 0; i < Globals.gmTOTAL_PLAYERS; i++) {
			for (j = 0; j < Globals.gmTOTAL_SUITS; j++) {
				played[i][j] = (int) gmUtil.CountBitsSet(data.played_cards[i]
						& gmUtil.m_suit_mask[j]);
			}
		}

		/*
		 * Set the hand lengths
		 */
		for (i = 0; i < Globals.gmTOTAL_PLAYERS; i++) {
			problem.hand_total_length[i] = (int) (8 - (gmUtil
					.CountBitsSet(data.played_cards[i])));
			sum_hands += problem.hand_total_length[i];
			cards_played |= data.played_cards[i];
		}

		/*
		 * Set suit lengths
		 */
		for (i = 0; i < Globals.gmTOTAL_SUITS; i++) {
			problem.suit_total_length[i] = (int) (8 - gmUtil
					.CountBitsSet(cards_played & gmUtil.m_suit_mask[i]));
			sum_suits += problem.suit_total_length[i];
		}

		/*
		 * This is applicable only if self is not the max bidder. If the trump
		 * is not shown, max bidder should have at least one trump. This is
		 * fixed. Hence remove this from the total suit length for the max
		 * bidder and the trump suit. The suit length should be incremented
		 * manually for all solutions for the slot [max bidder][trump].
		 */
		if ((!data.trump_shown) && (m_loc != data.curr_max_bidder)) {
			--(problem.hand_total_length[data.curr_max_bidder]);
			--(problem.suit_total_length[trump]);
			++(played[data.curr_max_bidder][trump]);
			add_trump = true;

		}

		/*
		 * This is applicable only if self is not the player who bid the
		 * contract (curr_max_bidder). If the trump is shown, but if the max
		 * bidder is yet to play the card that was set as the trump then, max
		 * bidder has at least one trump. This is fixed. Hence remove this from
		 * the total suit length for the max bidder and the trump suit. The suit
		 * length should be incremented manually for all solutions for the slot
		 * [max bidder][trump].
		 */
		if ((data.trump_shown) && (m_loc != data.curr_max_bidder)) {
			if ((data.played_cards[data.curr_max_bidder] & (1 << data.trump_card)) == 0) {
				--(problem.hand_total_length[data.curr_max_bidder]);
				--(problem.suit_total_length[trump]);
				++(played[data.curr_max_bidder][trump]);
				add_trump = true;
			}
		}

		/*
		 * Set the cases where the suit length is null
		 */
		for (i = 0; i < Globals.gmTOTAL_PLAYERS; i++) {
			for (j = 0; j < Globals.gmTOTAL_SUITS; j++) {
				if ((m_nulls[i] & (1 << j)) != 0) {
					problem.suit_length[i][j] = 0;
				}
			}
		}

		/*
		 * Set the cells for self
		 */
		for (i = 0; i < Globals.gmTOTAL_SUITS; i++) {
			problem.suit_length[m_loc][i] = (int) gmUtil
					.CountBitsSet(data.hands[m_loc] & gmUtil.m_suit_mask[i]);
		}

		/*
		 * If self is the max bidder and if trump is not shown, add one to the
		 * suit length to accommodate the card kept as trump
		 */
		if ((!data.trump_shown) && (m_loc == data.curr_max_bidder)) {
			++(problem.suit_length[m_loc][trump]);
		}

		/*
		 * All cards of self are known.
		 */
		problem.hand_total_length[m_loc] = 0;

		assert (sum_suits == sum_hands);

		if (Globals.aiLOG_GENERATESLPROBLEM == true) {
			for (i = 0; i < Globals.gmTOTAL_PLAYERS; i++) {
				String out = "";
				out += "" + gmUtil.m_short_locs[i] + " - ";
				for (j = 0; j < Globals.gmTOTAL_SUITS; j++)

				{
					if (problem.suit_length[i][j] == Globals.slVACANT) {
						out += "x ";
					} else {
						out += problem.suit_length[i][j] + " ";
					}

				}
				Globals.wxLogDebug(out);
			}
			Globals.wxLogDebug("Exiting GenerateSLProblem");
		}

		return (true);

	}

	public boolean GenerateDeals(gmEngineData data, long deals, int count) {
		GenerateDeals(data, deals, count, gmUtil.gmSUIT_INVALID);

		return (false);
	}

	public boolean GenerateDeals(gmEngineData data, long deals, int count,
			int trump) {
		// TODO To be done by INFM042 F___48 Georgi Ivanov ...
		// TODO To be done by INFM042 F___46 Nadya Nedyalkova ...
		// TODO To be done by INFM042 F___52 Mihail Stankov ...

		return (false);
	}

	/**
	 * 
	 * @param moves
	 * @param move_count
	 * 
	 * @return
	 * 
	 * @author INFM042 F___47 Kostadin Bulakiev ...
	 * @author INFM042 F___90 Svetoslav Slavkov ...
	 * @author INFM042 F___88 Ivan Dankinov ...
	 */
	public static String PrintMoves(aiMove moves[], int move_count) {
		assert (move_count >= 0);

		StringBuffer out = new StringBuffer();
		out.append("" + move_count + " moves - ");
		for (int i = 0; i < move_count; i++) {
			if (moves[i].ask_trump) {
				out.append("?"
						+ gmUtil.m_suits[Globals.gmGetSuit(moves[i].card)]
						+ gmUtil.m_values[Globals.gmGetValue(moves[i].card)]
						+ "(" + moves[i].rank + "),");
			} else {
				out.append(""
						+ gmUtil.m_suits[Globals.gmGetSuit(moves[i].card)]
						+ gmUtil.m_values[Globals.gmGetValue(moves[i].card)]
						+ "(" + moves[i].rank + "),");
			}
		}

		return out.toString();
	}

	public boolean PostPlayUpdate(gmEngineData data) {
		PostPlayUpdate(data, gmUtil.gmCARD_INVALID);

		return (false);
	}

	/**
	 * 
	 * @param data
	 * @param card
	 * 
	 * @return
	 * 
	 * @author INFM032 F___45 Valentin Popov
	 * @author INFM042 F___93 Krasimir Chariyski
	 * @author INFM032 F___39 Shterion Yanev
	 */
	public boolean PostPlayUpdate(gmEngineData data, int card) {
		assert (card != Globals.gmCARD_INVALID);
		assert (data.status == Globals.gmSTATUS_TRICKS);

		/*
		 * If the input card is valid
		 */
		if (card != Globals.gmCARD_INVALID) {
			int suit = Globals.gmGetSuit(card);

			/*
			 * If trump is not shown and if the player is the max bidder and if
			 * it is the first card in the trick then the suit is not trump,
			 * provided the max bidder has a choice of another suit
			 */
			if (!data.trump_shown
					&& (data.in_trick_info.player == data.curr_max_bidder)) {
				if (data.tricks[data.trick_round].count == 0) {

					/*
					 * Get the count of cards belonging to the suit already
					 * played
					 */
					int cards_left = 0;
					for (int i = 0; i < Globals.gmTOTAL_PLAYERS; i++) {
						cards_left += gmUtil.CountBitsSet(data.played_cards[i]
								& gmUtil.m_suit_mask[suit]);
					}

					/*
					 * Add to that the number of cards held by the AI player
					 * belonging to the suit
					 */
					cards_left += gmUtil.CountBitsSet(data.hands[m_loc]
							& gmUtil.m_suit_mask[suit]);

					/*
					 * Consider the card being played
					 */
					cards_left++;

					/*
					 * Check whether the number of cards left in the suit is
					 * less than the number of cards left in max bidders hand
					 * after the play (8 - data->trick_round) > (8 - cards_left)
					 */
					if (data.trick_round < cards_left) {

						/*
						 * wxLogDebug(wxString::Format("%s is not the trump",
						 * gmUtil::m_suits[suit].c_str()));
						 */
						m_trump_cards &= ~(1 << suit);
					} else {
						m_notrump_suspects |= (1 << suit);
					}
				}

				/*
				 * Check each of the suspects, if the max bidder has played a
				 * card which is not any of the suspects, the suspicion is valid
				 */
				if (m_notrump_suspects != 0) {
					for (int i = 0; i < Globals.gmTOTAL_SUITS; i++) {
						/*
						 * if((m_notrump_suspects & (1 << suit)) && (i != suit))
						 */
						if ((m_notrump_suspects & (1 << i)) != 0 && (i != suit)) {
							/*
							 * Remove the suit from the list of possible trump
							 * suits
							 */
							m_trump_cards &= ~(1 << i);
							/*
							 * Remove the suit from the list of suspects
							 */
							m_notrump_suspects &= ~(1 << i);
						}
					}
				}
			}

			assert (m_trump_cards != 0);

			/*
			 * Check the cases where a player is unable to follow suit
			 */
			if ((data.tricks[data.trick_round].count > 0)
					&& (data.tricks[data.trick_round].lead_suit != suit)) {
				/*
				 * If the current player is the max bidder we can safely assume
				 * that either the suit is the trump and the max bidder has only
				 * one card of the suit left and that is kept as the trump.
				 * Otherwise the suit length is zero. This can be confirmed only
				 * after the trump is shown
				 */
				if ((data.in_trick_info.player == data.curr_max_bidder)
						&& (!data.trump_shown)) {
					m_mb_null_susp |= (1 << data.tricks[data.trick_round].lead_suit);
				}
				/*
				 * If the player playing the card is not the max bidder we can
				 * safely assume that the suit length for the player
				 */
				else {
					m_nulls[data.in_trick_info.player] |= (1 << data.tricks[data.trick_round].lead_suit);
				}
			}
		}

		/*
		 * If trump is shown and if any of the null suspects is not the trump
		 * set the suit length in max bidders hand to zero for those
		 */
		if (data.trump_shown && (m_mb_null_susp != 0)) {
			for (int i = 0; i < Globals.gmTOTAL_SUITS; i++) {
				if ((m_mb_null_susp & (1 << i)) != 0 && (i != data.trump_suit)) {
					m_nulls[data.curr_max_bidder] |= (1 << i);
					/*
					 * Remove from the suspect list
					 */
					m_mb_null_susp &= ~(1 << i);
				}
			}
		}

		/*
		 * If self is not the max bidder and trump is not shown, For any suit if
		 * the sum of the cards played(including the the cards played in the
		 * current trick) and cards held by self is 8, then the suit is not the
		 * trump. This is because max bidder cannot have any card of the suit.
		 */
		if ((m_loc != data.curr_max_bidder) && (!data.trump_shown)) {
			long cards_played = 0;

			/*
			 * Add the card that is being played first
			 */
			if (card != Globals.gmCARD_INVALID) {
				cards_played |= (1 << card);
			}

			/*
			 * Add the cards played so far (previous tricks and the current one)
			 */
			for (int i = 0; i < Globals.gmTOTAL_PLAYERS; i++) {
				cards_played |= data.played_cards[i];
				if (data.tricks[data.trick_round].cards[i] != Globals.gmCARD_INVALID)
					cards_played |= (1 << data.tricks[data.trick_round].cards[i]);
			}

			for (int i = 0; i < Globals.gmTOTAL_SUITS; i++) {
				if (gmUtil.CountBitsSet((cards_played | data.hands[m_loc])
						& gmUtil.m_suit_mask[i]) >= Globals.gmTOTAL_VALUES) {
					m_trump_cards &= ~(1 << i);
				}
			}
		}

		return true;
	}

	/**
	 * 
	 * @param data
	 * @return
	 * @author INFM032 F___00 Tsvetelina Hristova
	 * @author INFM042 F___94 Aleksandar Milev
	 * @author INFM042 F___48 Georgi Ivanov
	 */
	public boolean CheckAssumptions(gmEngineData data) {
		if (Globals.raAI_LOG_CHECKASSUMPTIONS == true) {
		}

		for (int i = 0; i < Globals.gmTOTAL_SUITS; i++) {
			if ((m_trump_cards & (1 << i)) != 0) {
				continue;
			}

			if (data.trump_suit == i) {
				Globals.wxLogDebug("Dummy");
			}

			assert (data.trump_suit != i);
		}

		for (int j = 0; j < Globals.gmTOTAL_PLAYERS; j++) {
			for (int i = 0; i < Globals.gmTOTAL_SUITS; i++) {
				if ((m_nulls[j] & (1 << i)) == 0) {
					continue;
				}

				assert ((data.hands[j] & gmUtil.m_suit_mask[i]) == 0);
			}
		}

		return true;

	}

	/**
	 * @param moves
	 * @param move_count
	 * 
	 * @return
	 * 
	 * @author INFM032 F___88 Ivan Dankinov ...
	 * @author INFM032 F___46 Nadya Nedyalkova ...
	 * @author INFM042 F___68 Nikola Vushkov ...
	 */
	public boolean Reset() {
		m_engine.Reset();
		m_trump_cards = 0x0000000F;

		for (int i = 0; i < Globals.gmTOTAL_PLAYERS; i++) {
			m_nulls[i] = 0;
		}

		m_notrump_suspects = 0;
		m_mb_null_susp = 0;

		return true;
	}

	public void SetRules() {
		SetRules(null);
	}

	/**
	 * 
	 * @param gmRules
	 *            rules
	 * 
	 * @author INFM032 F___84 Mariya Kostadinova
	 * @author INFM042 F___94 Aleksandar Milev
	 * @author INFM032 F___90 Svetoslav Slavkov
	 */
	public void SetRules(gmRules rules) {
		gmEngineData data = new gmEngineData();
		if (rules != null) {
			m_engine.GetData(data);
			try {
				data.rules = (gmRules) rules.clone();
			} catch (CloneNotSupportedException e) {
			}
			m_engine.SetData(data, false);
		}
	}

	/**
	 * 
	 * @param flag
	 * @return
	 * @author INFM032 F___00 Tsvetelina Hristova
	 * @author INFM042 F___45 Valentin Popov
	 * @author INFM042 F___88 Ivan Dankinov
	 */
	public boolean SetClockwise(boolean flag) {
		gmEngineData data = new gmEngineData();
		m_engine.GetData(data);
		if (flag) {
			data.rules.rot_addn = 1;
		} else {
			data.rules.rot_addn = 3;
		}
		m_engine.SetData(data, false);

		return true;
	}

	/**
	 * 
	 * @return
	 * 
	 * @author INFM042 F___68 Georgi Srebrov
	 * @author INFM042 F___94 Aleksandar Milev
	 * @author INFM042 F___46 Nadya Nedyalkova
	 */
	public boolean GetClockwise() {
		gmEngineData data = new gmEngineData();
		m_engine.GetData(data);
		switch (data.rules.rot_addn) {
		case 1:
			return true;
		case 3:
			return false;
		default:
			return false;
		}
	}

	/**
	 * 
	 * @param flag
	 * 
	 * @return
	 * 
	 * @author INFM042 F___88 Ivan Dankinov ...
	 * @author INFM032 F___84 Mariya Kostadinova ...
	 * @author INFM042 F___90 Svetoslav Slavkov ...
	 */
	public boolean AbandonGame(boolean flag) {
		assert (flag);
		flag = true;
		return true;
	}
}
