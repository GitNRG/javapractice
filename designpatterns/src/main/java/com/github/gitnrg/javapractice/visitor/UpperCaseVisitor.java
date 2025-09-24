package com.github.gitnrg.javapractice.visitor;

public class UpperCaseVisitor implements Visitor {
    @Override
    public void visit(PersonEntity personEntity) {
        System.out.println(personEntity.toString().toUpperCase());
    }

    @Override
    public void visit(CompanyEntity companyEntity) {
        System.out.println(companyEntity.toString().toUpperCase());
    }
}
