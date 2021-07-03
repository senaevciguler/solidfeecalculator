package com.grafanalabs.factory;

import com.grafanalabs.enums.ItemType;
import com.grafanalabs.enums.UserType;

import java.time.LocalDate;

public interface UserProcessor {

    int calculate(ItemType itemType, int itemPrice, LocalDate itemEndDate);

    UserType getType();
}
