package com.test.repro;


import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewAccessScoped
public class MessagesView implements Serializable {

    @Inject
    LazyMessagesDataModel model;

    private List<Message> selectedMessages;

    private Message selectedMessage;


    public LazyMessagesDataModel getModel() {
        return model;
    }

    public List<Message> getSelectedMessages() {
        return selectedMessages;
    }

    public void setSelectedMessages(List<Message> selectedMessages) {
        this.selectedMessages = selectedMessages;
    }

    public Message getSelectedMessage() {
        return selectedMessage;
    }

    public void setSelectedMessage(Message selectedMessage) {
        this.selectedMessage = selectedMessage;
    }
}
