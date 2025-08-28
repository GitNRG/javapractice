package com.github.gitnrg.javapractice.designpatterns.visitor;

public interface Entity {
    public void accept(Visitor visitor);
}
