package com.github.gitnrg.javapractice.designpatterns.visitor;

public class CompanyEntity implements Entity {
    private final String companyName;

    public CompanyEntity(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "CompanyEntity{" +
                "companyName='" + companyName + '\'' +
                '}';
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
