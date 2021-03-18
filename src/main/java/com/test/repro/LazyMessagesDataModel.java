package com.test.repro;

import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

public class LazyMessagesDataModel extends LazyDataModel<Message> {

    List<Message> messages;

    @PostConstruct
    public void init(){
        messages = new ArrayList<>();
        IntStream.range(1, 20).forEach(i -> messages.add(generateMessage(i)));
        setRowCount(messages.size());
    }

    @Override
    public Message getRowData(String rowKey) {
        return messages.stream().filter(m -> m.getId().equals(Integer.parseInt(rowKey))).findAny().orElse(null);
    }

    @Override
    public String getRowKey(Message message) {
        return String.valueOf(message.getId());
    }

    @Override
    public List<Message> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
        return messages;
    }

    private Message generateMessage(int id) {
        Message msg = new Message();
        msg.setId(id);
        msg.setText(getRandomString());
        return msg;
    }

    private String getRandomString() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 20;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }

}
