package com.github.gitnrg.javapractice.visitor;

public class RegularVisitor implements Visitor {
    @Override
    public void visit(PersonEntity personEntity) {
        System.out.println(personEntity.toString());
    }

    @Override
    public void visit(CompanyEntity companyEntity) {
        System.out.println(companyEntity.toString());
    }
}
