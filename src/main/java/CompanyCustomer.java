public class CompanyCustomer extends Customer {
    public CompanyCustomer(String name, String surname, String email, CustomerType customerType, Account account) {
        super(name, surname, email, customerType, account);
    }

    public CompanyCustomer(String name, String email, Account account, double companyOverdraftDiscount) {
        super(name, email, account, companyOverdraftDiscount);
    }

    @Override
    void calculate(double sum, int kof) {
        if (super.account.getMoney() < 0) {
            // 50 percent discount for overdraft for premium account
            account.setMoney((account.getMoney() - sum) - sum * account.overdraftFee() * companyOverdraftDiscount / kof);
        } else {
            account.setMoney(account.getMoney() - sum);
        }
    }
}

/*
switch (customerType) {
            case COMPANY:
                extractedCompany(sum, i);
                break;
            case PERSON:
                extractPerson(sum);
                break;
        }
 */