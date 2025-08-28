package com.github.gitnrg.javapractice.designpatterns.visitor;

public interface Visitor {
    void visit(PersonEntity personEntity);

    void visit(CompanyEntity companyEntity);
}
