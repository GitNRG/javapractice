package com.github.gitnrg.javapractice.visitor;

public interface Visitor {
    void visit(PersonEntity personEntity);

    void visit(CompanyEntity companyEntity);
}
