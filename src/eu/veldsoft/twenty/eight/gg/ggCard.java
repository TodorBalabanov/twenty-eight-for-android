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

package eu.veldsoft.twenty.eight.gg;

import java.util.logging.Level;
import java.util.logging.Logger;

import eu.veldsoft.twenty.eight.dummy.Globals;
import eu.veldsoft.twenty.eight.dummy.wxBitmap;
import eu.veldsoft.twenty.eight.dummy.wxColour;
import eu.veldsoft.twenty.eight.dummy.wxCoord;
import eu.veldsoft.twenty.eight.dummy.wxDC;
import eu.veldsoft.twenty.eight.dummy.wxFileSystem;
import eu.veldsoft.twenty.eight.dummy.wxImage;
import eu.veldsoft.twenty.eight.dummy.wxMemoryDC;
import eu.veldsoft.twenty.eight.dummy.wxMutex;
import eu.veldsoft.twenty.eight.dummy.wxXPMHandler;
import eu.veldsoft.twenty.eight.dummy.wxXmlResource;
import eu.veldsoft.twenty.eight.dummy.wxZipFSHandler;

public class ggCard {
	/**
	 * Dummy values.
	 */
	private static final String __FILE__ = "";

	/**
	 * Dummy values.
	 */
	private static final int __LINE__ = 0;

	/**
	 * Logger for debug.
	 */
	private final static Logger LOGGER = Logger.getLogger(ggCard.class
			.getName());
	static {
		LOGGER.setLevel(Level.INFO);
	} 

	public static final int GG_CARD_CARD_COUNT = 52;

	public static final int GG_CARD_SPADES = 3;

	public static final int GG_CARD_HEARTS = 2;

	public static final int GG_CARD_DIAMONDS = 1;

	public static final int GG_CARD_CLUBS = 0;

	public static final int GG_CARD_ACE = 0;

	public static final int GG_CARD_TWO = 1;

	public static final int GG_CARD_THREE = 2;

	public static final int GG_CARD_FOUR = 3;

	public static final int GG_CARD_FIVE = 4;

	public static final int GG_CARD_SIX = 5;

	public static final int GG_CARD_SEVEN = 6;

	public static final int GG_CARD_EIGHT = 7;

	public static final int GG_CARD_NINE = 8;

	public static final int GG_CARD_TEN = 9;

	public static final int GG_CARD_JACK = 10;

	public static final int GG_CARD_QUEEN = 11;

	public static final int GG_CARD_KING = 12;

	public static final int GG_CARD_BACK_1 = 20;

	public static final int GG_CARD_BACK_2 = 21;

	public static final int GG_CARD_JOKER_1 = 30;

	public static final int GG_CARD_JOKER_2 = 31;

	public static final int GG_CARD_TOTAL_SUITS = 4;

	public static final int GG_CARD_TOTAL_VALUES = 13;

	public static final int GG_CARD_WIDTH = 71;

	public static final int GG_CARD_HEIGHT = 96;

	private static boolean s_init;

	private static wxMutex s_mutex;

	private static wxBitmap s_mask_bmp;

	public wxBitmap m_face;

	/**
	 * Disallow copy finalructor/assignment operators
	 * 
	 * @param object
	 * 
	 * @author INFM042 F___88 Ivan Dankinov
	 * @author INFM032 F___90 Svetoslav Slavkov
	 * @author INFM032 F___81 Marina Rangelova
	 */
	private ggCard(final ggCard object) {
	} 

	/**
	 * 
	 * @param res_name
	 * 
	 * @return
	 * 
	 * @author INFM032 F___81 Marina Rangelova
	 * @author INFM032 F___47 Kostadin Bulakiev
	 * @author INFM042 F___45 Valentin Popov
	 */
	private boolean LoadFace(String res_name) {
		wxBitmap bmp_temp1, bmp_temp2 = new wxBitmap();
		wxImage img_mask, img_face;
		wxMemoryDC mdc1 = new wxMemoryDC(), mdc2 = new wxMemoryDC();
		wxColour col_mask = new wxColour(Globals.wxWHITE);

		assert (res_name != null || res_name != "");

		/*
		 * Load the bitmap from the resource file
		 */
		bmp_temp1 = wxXmlResource.Get().LoadBitmap(res_name);
		if (!bmp_temp1.Ok()) {
			Globals.wxLogError("Failed to load resource %s. %s:%d", res_name,
					__FILE__, __LINE__);
			return false;
		} 

		/*
		 * The widths of mask and the xpm image are differt. Hence create a new
		 * bitmap with correct dimensions and copy the data to the same.
		 */
		if (!bmp_temp2.Create(GG_CARD_WIDTH, GG_CARD_HEIGHT, -1)) {
			Globals.wxLogError("Failed to create bitmap. %s:%d", __FILE__,
					__LINE__);
			return false;
		} 

		mdc1.SelectObject(bmp_temp1);
		mdc2.SelectObject(bmp_temp2);

		if (!mdc2.Blit(0, 0, GG_CARD_WIDTH, GG_CARD_HEIGHT, mdc1, 0, 0)) {
			Globals.wxLogError("Blit failed. %s:%d", __FILE__, __LINE__);
			return false;
		} 

		/*
		 * Create images of face and mask and set the mask for the face
		 */
		img_face = bmp_temp2.ConvertToImage();
		img_mask = s_mask_bmp.ConvertToImage();

		if (!img_face.SetMaskFromImage(img_mask, col_mask.Red(),
				col_mask.Green(), col_mask.Blue())) {
			Globals.wxLogError("Failed to set mask from image. %s:%d",
					__FILE__, __LINE__);
		} 

		/*
		 * And then finally create a bitmap from the masked image
		 */
		m_face = new wxBitmap(img_face, -1);
		if (m_face == null) {
			Globals.wxLogError("Creation of bitmap from image failed. %s:%d",
					__FILE__, __LINE__);
			return false;
		} 

		return true;
	} 

	/**
	 * 
	 * This is a constructor
	 * 
	 * @author INFM032 F___06 Rosen Kaplanov
	 * @author INFM032 F___68 Nikola Vushkov
	 * @author INFM032 F___84 Mariya Kostadinova
	 */
	public ggCard() {

		m_face = null;

		/*
		 * If the constructor is being called for the first time 1. Load the
		 * resources used by the library. 2. Load the mask image
		 */

		if (s_init) {
			return;
		} 
		wxMutex lock = new wxMutex(s_mutex);
		if (!s_init) {
			wxFileSystem.AddHandler(new wxZipFSHandler());
			wxImage.AddHandler(new wxXPMHandler());

			wxXmlResource.Get().InitAllHandlers();
			if (!wxXmlResource.Get().Load(Globals.GG_CARD_XRS)) {
				Globals.wxLogError("Failed to load xrs %s. %s:%d",
						Globals.GG_CARD_XRS, __FILE__, __LINE__);
				return;
			} 
			s_mask_bmp = wxXmlResource.Get().LoadBitmap("mask");
			if (!s_mask_bmp.Ok()) {
				Globals.wxLogError("Failed to load mask bitmap. %s:%d",
						__FILE__, __LINE__);
				return;
			} 
			s_init = true;
		} 
	} 

	/**
	 * This is a constructor.
	 * 
	 * @param suit
	 *            This is a card suit.
	 * @param value
	 *            This is the rank value.
	 * 
	 * @author INFM042 F___05 Iliya Grozev
	 * @author INFM042 F___00 Tsvetelina Hristova
	 * @author INFM032 F___93 Krasimir Chariyski
	 */
	public ggCard(int suit, int value) {
		this();

		assert ((suit >= 0) && (suit < GG_CARD_TOTAL_SUITS));
		assert ((value >= 0) && (suit < GG_CARD_TOTAL_VALUES));

		if (LoadFace("face_" + (suit * GG_CARD_TOTAL_VALUES + value)) == false) {
			LOGGER.info("LoadFace failed.");
		} 

		assert (m_face != null);
		return;
	} 

	public ggCard(int other) {
		// TODO To be done by INFM032 F___81 Marina Rangelova ...
		// TODO To be done by INFM042 F___67 Nevena Sirakova ...
		// TODO To be done by INFM032 F___05 Iliya Grozev ...
	} 

	/**
	 * 
	 * @author INFM042 F___00 Tsvetelina Hristova
	 * @author INFM042 F___05 Iliya Grozev
	 * @author INFM042 F___48 Georgi Ivanov
	 */
	protected void finalize() {
		if (m_face != null) {
			m_face = null;
		} 
	} 

	public boolean BlitTo(wxDC dest, wxCoord xdest, wxCoord ydest) {
		return (BlitTo(dest, xdest, ydest, Globals.wxCOPY));
	} 

	/**
	 * 
	 * @param dest
	 * @param xdest
	 * @param ydest
	 * @param logicalFunc
	 * 
	 * @return
	 * 
	 * @author INFM032 F___93 Krasimir Chariyski
	 * @author INFM032 F___68 Georgi Srebrov
	 * @author INFM042 F___46 Nadya Nedyalkova
	 */
	public boolean BlitTo(wxDC dest, wxCoord xdest, wxCoord ydest,
			int logicalFunc) {
		wxMemoryDC mdc = null;
		assert (dest != null);

		mdc.SelectObject(m_face);
		if (dest.Blit(xdest, ydest, GG_CARD_WIDTH, GG_CARD_HEIGHT, mdc, 0, 0,
				logicalFunc, true) != true) {
			Globals.wxLogError("Blit failed. %s:%d", __FILE__, __LINE__);
			return false;
		} 

		return true;
	} 

	public wxBitmap GetFace() {
		// TODO To be done by INFM042 F___52 Mihail Stankov ...
		// TODO To be done by INFM042 F___05 Iliya Grozev ...
		// TODO To be done by INFM032 F___46 Nadya Nedyalkova ...

		return (null);
	} 

	/**
	 * 
	 * @param mdc
	 * 
	 * @author INFM032 F___84 Mariya Kostadinova
	 * @author INFM032 F___93 Krasimir Chariyski
	 * @author INFM032 F___39 Shterion Yanev
	 */
	public void SelectToDC(wxMemoryDC mdc) {
		assert (mdc != null);
		mdc.SelectObject(m_face);
	} 

	/**
	 * 
	 * @param object
	 * @return
	 * @author INFM032 F___00 Tsvetelina Hristova
	 * @author INFM042 F___52 Mihail Stankov
	 * @author INFM042 F___05 Iliya Grozev
	 */
	public ggCard assign(final ggCard object) {

		return (this);
	} 
} 
