package com.xh.wechat.button;

import javax.swing.*;
import java.util.List;

public class Button {
    private List<AbstractButton> button;
    public List<AbstractButton> getButton() {
        return button;
    }

    public void setButton(List<AbstractButton>button) {
        this.button = button;
    }
}
