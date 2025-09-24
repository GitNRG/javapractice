package com.github.gitnrg.javapractice.visitor;

public interface Entity {
    public void accept(Visitor visitor);
}
