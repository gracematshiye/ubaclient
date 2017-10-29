package za.ac.uba;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import za.ac.uba.model.Book;
import za.ac.uba.model.ListBookViewModel;
import za.ac.uba.model.NewBookViewModel;

/**
 * Created by gracem on 2017/10/28.
 */
public class CreateAndView {

    private Gson gson = new Gson();
    private String basicURL = "http://localhost:8080/api";

    public ListBookViewModel viewAll(String key) {

            Client restClient = Client.create();
            WebResource webResource = restClient.resource(basicURL + "/books");
            ClientResponse response = webResource.accept("application/json")
                    .header("Content-Type", "application/json")
                    .header("Authorization", key)
                    .get(ClientResponse.class);

            System.out.println(response.getStatus());
            if (response.getStatus() != 200) {
//                System.out.println(response.getEntity(String.class));
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }

            ListBookViewModel listBookViewModel =  gson.fromJson(response.getEntity(String.class), ListBookViewModel.class);

            return listBookViewModel;


    }

    public NewBookViewModel postBook(String key, Book book) {

        try {
            String bookJson = gson.toJson(book);
            Client restClient = Client.create();
            WebResource webResource = restClient.resource(basicURL + "/add");
            ClientResponse response = webResource
                    .header("Content-Type", "application/json")
                    .header("Authorization", key)
                    .header("book", bookJson)
                    .post(ClientResponse.class);

            System.out.println(response.getStatus());
        if (response.getStatus() != 201) {
//                System.out.println(response.getEntity(String.class));
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

            NewBookViewModel listBookViewModel =  gson.fromJson(response.getEntity(String.class), NewBookViewModel.class);

            return listBookViewModel;

        } catch (RuntimeException e) {
            e.printStackTrace();
            return null;
        }

    }
}
