package com.test.repro;


import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewAccessScoped
public class MessagesView implements Serializable {

    @Inject
    LazyMessagesDataModel model;

    private Message[] selectedMessages;

    private Message selectedMessage;


    public LazyMessagesDataModel getModel() {
        return model;
    }

    public Message[] getSelectedMessages() {
        return selectedMessages;
    }

    public void setSelectedMessages(Message[] selectedMessages) {
        if (selectedMessages.length != 0 && selectedMessages[0] == null) {
            System.out.println("Array with null elements provided as selection!");
            return;
        }

        this.selectedMessages = selectedMessages;
    }

    public Message getSelectedMessage() {
        return selectedMessage;
    }

    public void setSelectedMessage(Message selectedMessage) {
        this.selectedMessage = selectedMessage;
    }
}
