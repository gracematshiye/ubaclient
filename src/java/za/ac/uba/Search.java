package za.ac.uba;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import za.ac.uba.model.ListBookViewModel;
import za.ac.uba.model.NewBookViewModel;
import za.ac.uba.model.UserViewModel;

/**
 * Created by gracem on 2017/10/28.
 */
public class Search {

    private Gson gson = new Gson();
    private String basicURL = "http://localhost:8080/api";

    public UserViewModel byIsbn (String key, String isbn) {

        Client restClient = Client.create();
        WebResource webResource = restClient.resource(basicURL + "/book/isbn");
        ClientResponse response = webResource.accept("application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", key)
                .header("isbn",isbn)
                .get(ClientResponse.class);

        System.out.println(response.getStatus());
        if (response.getStatus() != 200) {
//                System.out.println(response.getEntity(String.class));
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        UserViewModel userViewModel =  gson.fromJson(response.getEntity(String.class), UserViewModel.class);

        return userViewModel;


    }

    public ListBookViewModel byTitle (String key, String title) {

        Client restClient = Client.create();
        WebResource webResource = restClient.resource(basicURL + "/book/title");
        ClientResponse response = webResource.accept("application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", key)
                .header("title", title)
                .get(ClientResponse.class);

        System.out.println(response.getStatus());
        if (response.getStatus() != 200) {
//                System.out.println(response.getEntity(String.class));
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        ListBookViewModel listBookViewModel =  gson.fromJson(response.getEntity(String.class), ListBookViewModel.class);

        return listBookViewModel;


    }

    public ListBookViewModel byCategory (String key, String category) {

        Client restClient = Client.create();
        WebResource webResource = restClient.resource(basicURL + "/book/category");
        ClientResponse response = webResource.accept("application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", key)
                .header("category", category)
                .get(ClientResponse.class);

        System.out.println(response.getStatus());
        if (response.getStatus() != 200) {
//                System.out.println(response.getEntity(String.class));
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        ListBookViewModel listBookViewModel =  gson.fromJson(response.getEntity(String.class), ListBookViewModel.class);

        return listBookViewModel;


    }

    public NewBookViewModel byBookId (String key, Integer id) {

        Client restClient = Client.create();
        WebResource webResource = restClient.resource(basicURL + "/book/id");
        ClientResponse response = webResource.accept("application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", key)
                .header("book-id", id)
                .get(ClientResponse.class);

        System.out.println(response.getStatus());
        if (response.getStatus() != 200) {
//                System.out.println(response.getEntity(String.class));
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        NewBookViewModel newBookViewModel =  gson.fromJson(response.getEntity(String.class), NewBookViewModel.class);

        return newBookViewModel;


    }
}
