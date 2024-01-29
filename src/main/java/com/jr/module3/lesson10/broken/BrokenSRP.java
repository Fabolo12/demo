package com.jr.module3.lesson10.broken;

import java.util.Collections;
import java.util.List;

public class BrokenSRP {

    public void sendMessage() {
        getAllRecipients();
        buildBody();
        buildTitle();
        send();
    }


    private List<String> getAllRecipients() { // Change cause 1
        return Collections.emptyList();
    }

    private String buildBody() { // Change cause 2
        return "";
    }

    private String buildTitle() { // Change cause 2
        return "";
    }

    private void send() { // Change cause 3
        final BrokenOCP brokenOCP = new BrokenOCP();
        brokenOCP.sendSMS();
    }
}
