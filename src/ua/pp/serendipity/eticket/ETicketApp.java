/******************************************************************************
 * Copyright (c) 2012 SerenDipity Corporation                                 *
 * All Rights Reserved.                                                       *
 * Author: Vinogradov Eugene                                                  *
 ******************************************************************************/

package ua.pp.serendipity.eticket;

import ua.pp.serendipity.eticket.parser.ETicketParser;
import ua.pp.serendipity.eticket.structure.Ticket;
import ua.pp.serendipity.eticket.ui.ClipboardContainer;

import java.io.IOException;

public class ETicketApp {

    public static void main(String[] args) throws IOException {
        ETicketParser etp = new ETicketParser();
        ClipboardContainer cntr = ClipboardContainer.createClipboardContainer();
        etp.loadFromClipboard(cntr);
        Ticket etTicket = new Ticket();
        etp.parsingData(etTicket);
        System.out.println("[" + etTicket.getDateOfSale() + "]");
        System.out.println("[" + etTicket.getFirstName() + "]");
        System.out.println("[" + etTicket.getPhone() + "]");

//		if(etp.loadFromFile("ETicketParser/res/1.txt") == -1) {
//			System.out.println("Error -1");
//        }

//        Iterator<StringBuilder> i = etp.getData().iterator();
//        int p = 0;
//        while (i.hasNext()) {
//            System.out.println("String [" + p + "]: " + i.next());
//            p++;
//        }

    }

}
