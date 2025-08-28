package com.github.gitnrg.javapractice.designpatterns.visitor;

public class Main {
    public static void main(String[] args) {
        var person = new PersonEntity("John", "Smith");
        var company = new CompanyEntity("BigFish Corp.");

        var regularVisitor = new RegularVisitor();
        regularVisitor.visit(person); // PersonEntity{firstName='John', lastName='Smith'}
        regularVisitor.visit(company); // CompanyEntity{companyName='BigFish Corp.'}

        var upperCaseVisitor = new UpperCaseVisitor();
        upperCaseVisitor.visit(person); // PERSONENTITY{FIRSTNAME='JOHN', LASTNAME='SMITH'}
        upperCaseVisitor.visit(company); // COMPANYENTITY{COMPANYNAME='BIGFISH CORP.'}
    }
}
