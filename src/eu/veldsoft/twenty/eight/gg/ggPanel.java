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

import eu.veldsoft.twenty.eight.dummy.Globals;
import eu.veldsoft.twenty.eight.dummy.wxBitmap;
import eu.veldsoft.twenty.eight.dummy.wxColour;
import eu.veldsoft.twenty.eight.dummy.wxCoord;
import eu.veldsoft.twenty.eight.dummy.wxDC;
import eu.veldsoft.twenty.eight.dummy.wxFont;
import eu.veldsoft.twenty.eight.dummy.wxPaintEvent;
import eu.veldsoft.twenty.eight.dummy.wxPoint;
import eu.veldsoft.twenty.eight.dummy.wxRect;
import eu.veldsoft.twenty.eight.dummy.wxWindow;

public class ggPanel {
	private wxBitmap m_back;

	private wxBitmap m_work;

	private boolean m_f_invalid;

	private wxRect m_rect_diff;
	
	private wxRect m_rect_invalid;

	// Disallow copy finalructor/assignment operators
	private ggPanel(final ggPanel object) {
		//TODO To be done by INFM032 F___52 Mihail Stankov ...
		//TODO To be done by INFM032 F___14 Petya Atanasova ...
		//TODO To be done by INFM032 F___47 Kostadin Bulakiev ...
	}

	private ggPanel assign(final ggPanel object) {
		//TODO To be done by INFM032 F___93 Krasimir Chariyski ...
		//TODO To be done by INFM032 F___68 Nikola Vushkov ...
		//TODO To be done by INFM032 F___47 Kostadin Bulakiev ...
		
		return( this );
	}

	public ggPanel(final wxWindow parent) {
		//TODO To be done by INFM032 F___05 Iliya Grozev ...
		//TODO To be done by INFM032 F___47 Kostadin Bulakiev ...
		//TODO To be done by INFM042 F___27 Georgi Kostadinov ...
	}

	protected void finalize() {
		//TODO To be done by INFM032 F___39 Shterion Yanev ...
		//TODO To be done by INFM042 F___52 Mihail Stankov ...
		//TODO To be done by INFM032 F___27 Georgi Kostadinov ...
	}

	public boolean Size() {
		//TODO To be done by INFM032 F___56 Daniel Nikolov ...
		//TODO To be done by INFM032 F___06 Rosen Kaplanov ...
		//TODO To be done by INFM042 F___47 Kostadin Bulakiev ...
		
		return( false );
	}

	public boolean Paint() {
		//TODO To be done by INFM042 F___39 Shterion Yanev ...
		//TODO To be done by INFM032 F___52 Mihail Stankov ...
		//TODO To be done by INFM042 F___06 Rosen Kaplanov ...
		
		return( false );
	}

	public void OnPaint(wxPaintEvent event) {
		//TODO To be done by INFM032 F___47 Kostadin Bulakiev ...
		//TODO To be done by INFM042 F___68 Nikola Vushkov ...
		//TODO To be done by INFM042 F___81 Marina Rangelova ...
	}

	public boolean RefreshScreen() {
		//TODO To be done by INFM042 F___14 Petya Atanasova ...
		//TODO To be done by INFM042 F___68 Nikola Vushkov ...
		//TODO To be done by INFM042 F___93 Krasimir Chariyski ...
		
		return( false );
	}

	public boolean BlitToBack(wxCoord xdest, wxCoord ydest,
							  wxCoord width, wxCoord height, wxDC source, wxCoord xsrc,
							  wxCoord ysrc) {
		return( BlitToBack(xdest, ydest,
				  width, height, source, xsrc,
				  ysrc, Globals.wxCOPY, false,
				  null, null) );
	}

	public boolean BlitToBack(wxCoord xdest, wxCoord ydest,
							  wxCoord width, wxCoord height, wxDC source, wxCoord xsrc,
							  wxCoord ysrc, int logicalFunc) {
		return( BlitToBack(xdest, ydest,
				  width, height, source, xsrc,
				  ysrc, logicalFunc, false,
				  null, null) );
	}

	public boolean BlitToBack(wxCoord xdest, wxCoord ydest,
							  wxCoord width, wxCoord height, wxDC source, wxCoord xsrc,
							  wxCoord ysrc, int logicalFunc, boolean useMask
							  ) {
		return( BlitToBack(xdest, ydest,
				  width, height, source, xsrc,
				  ysrc, logicalFunc, useMask,
				  null, null) );
	}

	public boolean BlitToBack(wxCoord xdest, wxCoord ydest,
							  wxCoord width, wxCoord height, wxDC source, wxCoord xsrc,
							  wxCoord ysrc, int logicalFunc, boolean useMask,
							  wxCoord xsrcMask) {
		return( BlitToBack(xdest, ydest,
				  width, height, source, xsrc,
				  ysrc, logicalFunc, useMask,
				  xsrcMask, null) );
	}

	public boolean BlitToBack(wxCoord xdest, wxCoord ydest,
							  wxCoord width, wxCoord height, wxDC source, wxCoord xsrc,
							  wxCoord ysrc, int logicalFunc, boolean useMask,
							  wxCoord xsrcMask, wxCoord ysrcMask) {
		//TODO To be done by INFM042 F___06 Rosen Kaplanov ...
		//TODO To be done by INFM042 F___68 Georgi Srebrov ...
		//TODO To be done by INFM042 F___93 Krasimir Chariyski ...
		
		return( false );
	}

	public boolean BlitToFront(wxCoord xdest, wxCoord ydest,
							   wxCoord width, wxCoord height, wxDC source, wxCoord xsrc,
							   wxCoord ysrc) {
		return( BlitToFront(xdest, ydest,
				   width, height, source, xsrc,
				   ysrc, Globals.wxCOPY, false,
				   null, null) );
	}

	public boolean BlitToFront(wxCoord xdest, wxCoord ydest,
							   wxCoord width, wxCoord height, wxDC source, wxCoord xsrc,
							   wxCoord ysrc, int logicalFunc) {
		return( BlitToFront(xdest, ydest,
				   width, height, source, xsrc,
				   ysrc, logicalFunc, false,
				   null, null) );
	}

	public boolean BlitToFront(wxCoord xdest, wxCoord ydest,
							   wxCoord width, wxCoord height, wxDC source, wxCoord xsrc,
							   wxCoord ysrc, int logicalFunc, boolean useMask
							   ) {
		return( BlitToFront(xdest, ydest,
				   width, height, source, xsrc,
				   ysrc, logicalFunc, useMask,
				   null, null) );
	}

	public boolean BlitToFront(wxCoord xdest, wxCoord ydest,
							   wxCoord width, wxCoord height, wxDC source, wxCoord xsrc,
							   wxCoord ysrc, int logicalFunc, boolean useMask,
							   wxCoord xsrcMask) {
		return( BlitToFront(xdest, ydest,
				   width, height, source, xsrc,
				   ysrc, logicalFunc, useMask,
				   xsrcMask, null) );
	}

	public boolean BlitToFront(wxCoord xdest, wxCoord ydest,
							   wxCoord width, wxCoord height, wxDC source, wxCoord xsrc,
							   wxCoord ysrc, int logicalFunc, boolean useMask,
							   wxCoord xsrcMask, wxCoord ysrcMask) {
		//TODO To be done by INFM042 F___68 Georgi Srebrov ...
		//TODO To be done by INFM032 F___05 Iliya Grozev ...
		//TODO To be done by INFM032 F___06 Rosen Kaplanov ...
		
		return( false );
	}

	public boolean DrawTextOnBack(String text, wxPoint pt) {
		return( DrawTextOnBack(text, pt, Globals.wxNullColour, Globals.wxNullFont) );
	}

	public boolean DrawTextOnBack(String text, wxPoint pt, wxColour colour) {
		return( DrawTextOnBack(text, pt, colour, Globals.wxNullFont) );
	}

	public boolean DrawTextOnBack(String text, wxPoint pt, wxColour colour, wxFont font) {
		//TODO To be done by INFM042 F___27 Georgi Kostadinov ...
		//TODO To be done by INFM032 F___68 Georgi Srebrov ...
		//TODO To be done by INFM032 F___05 Iliya Grozev ...
		
		return( false );
	}

	public boolean ClearDifference() {
		//TODO To be done by INFM042 F___68 Georgi Srebrov ...
		//TODO To be done by INFM042 F___06 Rosen Kaplanov ...
		//TODO To be done by INFM032 F___93 Krasimir Chariyski ...
		
		return( false );
	}
}
