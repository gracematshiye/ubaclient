package za.ac.uba;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import za.ac.uba.model.PaymentViewModel;

/**
 * Created by gracem on 2017/10/29.
 */
public class MakePayment {

    private Gson gson = new Gson();
    private String basicURL = "http://localhost:8080/api";

    public PaymentViewModel pay(String key, Integer id) {

        Client restClient = Client.create();
        WebResource webResource = restClient.resource(basicURL + "/pay/book");
        ClientResponse response = webResource//.accept("application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", key)
                .header("book-id", id)
                .get(ClientResponse.class);

        System.out.println(response.getStatus());
        if (response.getStatus() != 200) {
//                System.out.println(response.getEntity(String.class));
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        PaymentViewModel paymentViewModel =  gson.fromJson(response.getEntity(String.class), PaymentViewModel.class);

        return paymentViewModel;


    }
}
