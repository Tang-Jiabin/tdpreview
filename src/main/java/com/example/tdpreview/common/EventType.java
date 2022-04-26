package com.example.tdpreview.common;

public enum EventType {

    NULL(0),
    LOGIN(1),
    REGISTER(2),
    SEND(3),
    MOVE(4);

    private final Integer val;

    EventType(Integer val) {
        this.val = val;
    }

    public static EventType getEnum(Integer type) {
        for (EventType value : EventType.values()) {
            if (value.val.equals(type)) {
                return value;
            }
        }
        return EventType.NULL;
    }
}
