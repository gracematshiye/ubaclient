package za.ac.uba;

import za.ac.uba.model.*;

public class UbaMain {

    private static LoginAndLogout loginAndLogout = new LoginAndLogout();
    private static CreateAndView createAndView= new CreateAndView();
    private static Search search= new Search();
    private static MakePayment makePayment = new MakePayment();

    private static Book book = new Book("C#", "Thomas JR","ISBN-13: 978-0-596-52068-8","7th","lang","TPG",110.00,"additionalIno");

    public static void main(String[] args) {
        happyCases();
    }

    public static void happyCases() {
        String key = loginAndLogout.login(211108711, "pass01").getSessionKey();

        ListBookViewModel listofbooks = createAndView.viewAll(key);
        System.out.println("listofbooks : " + listofbooks.toString() + "\n");

        book.setIsbn("0-596-52068-9");
        NewBookViewModel created = createAndView.postBook(key, book);
        System.out.println("created :" + created.toString() + "\n");

        UserViewModel isbn = search.byIsbn(key, "ISBN-13: 978-0-596-52068-8");
        System.out.println("searchByIsbn :" + isbn.toString() + "\n");

        ListBookViewModel title = search.byTitle(key, book.getTitle());
        System.out.println("searchByTitle :" + title.toString() + "\n");

        ListBookViewModel category = search.byCategory(key, book.getCategory());
        System.out.println("searchByCategory :" + category.toString() + "\n");

        NewBookViewModel aBook = search.byBookId(key, 2);
        System.out.println("searchByBook :" + aBook.toString() + "\n");

        PaymentViewModel pay = makePayment.pay(key, 1);
        System.out.println("makePayment :" + pay.getMessage() + "\n");

        String logout = loginAndLogout.logout(key);
        System.out.println("logout >> : " + logout + "\n");

        System.out.println(">>>>> Completed the Project <<<<<");
    }

}
